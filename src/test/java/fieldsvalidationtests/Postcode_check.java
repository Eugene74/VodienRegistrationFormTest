package fieldsvalidationtests;

import actions.EnterValue_toField;
import basepackage.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.RegistrationPage;
import utils.GenerationField;

import java.io.File;
import java.io.IOException;

import static utils.Methods.colorBord_Text;
import static utils.Methods.isPresentForWait;

public class Postcode_check  extends BaseTest {

    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);   }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }
    @DataProvider(name = "check_Name_field_positive")
    public Object[][] testData_positive() {
        return new Object[][]{{"ABCDE", true},{"123214", true}};
    }
    @DataProvider(name = "check_Name_field_negative")
    public Object[][] testData_negative() {
        return new Object[][]{{"h", false, "length<2"},{"Aa!@#$%^&*()-_+=`~/\\,.?><|b /ыйієж", false, "special character"},{ new GenerationField().generateField(100), false, "length100"},{"検査", false,"japanese"},{"فحص", false, "arabic"},{"abc_12_def 12, kv 123",false, "???"}};
    }
    @Test(dataProvider = "check_Name_field_positive"/*, priority = 0*/)
    public void checkNameField_positive(String value, boolean isPresentExpected) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterPostCode(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterPostCode());
        Assert.assertNotEquals(isPresentActual, isPresentExpected);
    }
    @Test(dataProvider = "check_Name_field_negative"/*, priority = 0*/)
    public void checkNameField_negative(String value, boolean isPresentExpected, String  sort_of_check) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterPostCode(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterPostCode());
        if(isPresentActual) {
            Assert.assertNotEquals(isPresentActual, isPresentExpected);
            String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
            System.out.println("1 errormessage: " +errormessage + " value: "+ value);
        }else {
            String  nametext="";
            String error_message = "some error message";
            try {
                String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
                System.out.println("2 errormessage: " +errormessage + " value: "+ value);
                nametext = registrationPage.getPostCodeNameTitleText().getAttribute("data-label");
                System.out.println("text "+ nametext);
                String [] color = colorBord_Text(registrationPage, nametext);
                String  border_error_expected="the field border is highlighted in red";
                String  border_error_actual="not red";
                if(color[0].equals("rgba(220, 23, 17, 1)")&& color[1].equals("rgba(215, 25, 32, 1)")){
                    border_error_actual = "the field border is highlighted in red" ;
                }
                Assert.assertEquals(border_error_actual, border_error_expected);
            } catch (NoSuchElementException e) {
                error_message = "3 no error message: "+  sort_of_check;
                Assert.assertEquals(error_message,"some error message" + " value: "+ value);

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
