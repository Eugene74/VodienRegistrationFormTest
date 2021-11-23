package fieldsvalidationtests;

import actions.EnterValue_toField;
import basepackage.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.RegistrationPage;
import utils.GenerationField;

import java.io.File;
import java.io.IOException;

import static utils.Methods.colorBord_Text;
import static utils.Methods.isPresentForWait;

public class Address_check extends BaseTest {
    final Logger logger = LoggerFactory.getLogger(Address_check.class);
    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);   }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }
    @DataProvider(name = "testDataPositive")
    public Object[][] testDataPositive() {
        return new Object[][]{{"Ivan", true},{"abc_12_def 12, kv 123", true}};
    }
    @DataProvider(name = "testDataNegative")
    public Object[][] testDataNegative() {
        return new Object[][]{{"h", false, "length<2"},{"Aa!@#$%^&*()-_+=`~/\\,.?><|b /ыйієж", false, "special character"},
                { new GenerationField().generateField(100), false, "length100"},{"検査", false,"japanese"},{"فحص", false, "arabic"}};
    }
    @Test(dataProvider = "testDataPositive"/*, priority = 0*/, enabled = true)
    public void checkNameFieldPositive(String value, boolean isPresentExpected) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterAddress(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterAddress());
        Assert.assertNotEquals(isPresentActual, isPresentExpected);
        logger.info("checkNameField_positive: {}." +isPresentActual + " , value: "+ value);
    }
    @Test(dataProvider = "testDataNegative"/*, priority = 0*/, enabled = true)
    public void checkNameFieldNegative(String value, boolean isPresentExpected, String  sort_of_check) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterAddress(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterAddress());
        if(isPresentActual) {
            Assert.assertNotEquals(isPresentActual, isPresentExpected);
            String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
           // System.out.println("1 errormessage: " +errormessage + " , value: "+ value);
           // logger.info("1 errormessage: " +errormessage + " , value: "+ value);
            logger.info("find errormessage: {}." +errormessage + " , value: "+ value);
        }else {
            String  nametext="";
            String errorMessage = "some error message";
            try {
                String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
               // System.out.println("2 errormessage: " +errormessage + " , value: "+ value);
               // logger.info("find errormessage: " +errormessage + " , value: "+ value);
                logger.info("find errormessage: {}." +errormessage + " , value: "+ value);
                nametext = registrationPage.getAddressNameTitleText().getAttribute("data-label");
             //   System.out.println("text: "+ nametext);
            //    logger.info("text: "+ nametext);
                logger.info("text: {}.", " " + nametext);
                String [] color = colorBord_Text(registrationPage, nametext);
                String  borderErrorExpected="the field border is highlighted in red";
                String  borderErrorActual="not red";
                if(color[0].equals("rgba(220, 23, 17, 1)")&& color[1].equals("rgba(215, 25, 32, 1)")){
                    borderErrorActual = "the field border is highlighted in red" ;
                }
             //   logger.info("borderErrorActual {}.","borderErrorExpected {}.", borderErrorActual, borderErrorExpected);

                Assert.assertEquals(borderErrorActual, borderErrorExpected);
            } catch (NoSuchElementException e) {
                errorMessage = "3 no error message: " + sort_of_check;
              //  logger.info("3 some error message" + " , value: "+ value);
                logger.info("was expecting an error message {}.", "because not valid field value: " + value);
                Assert.assertEquals(errorMessage,"no some error message" + " , value: "+ value);

            }
        }
    }
    @AfterMethod(enabled = false) //todo
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("D:\\test-output\\correct_all_fields.PNG"));
        System.out.println("Screenshot of the test is taken");

    }

}
