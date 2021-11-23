package fieldsvalidationtests;

import actions.EnterValue_toField;
import actions.RegistrationPageActions;
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

public class Email_check extends BaseTest {

    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);   }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }

    @DataProvider(name = "if_email_alreadyTaken")
    public Object[][] testData1() {
        return new Object[][]{{"Ivan", "Pupko", "Obolonskaya 6, 89", "Kiev",
                "420154", "Ukraine", "Kievskaya", "0931545285", "wq1@ukr.net", true, "vanpupko9", "Qwerty_129", "Email is Already taken", false}};
    }

    @DataProvider(name = "check_Name_field_positive")
    public Object[][] testData_positive() {
        return new Object[][]{{"qw@ukr.net", true},{"QW@UKR.NET", true},{"qlu12w@ukr.net",true},
                {"qw@123ukr4.net",true},{"q-w@ukr.net",true},{"qw@uk-r.net",true},{"q_w@ukr.net",true},{"q_w@ukr.net",true},{"qw@u.kr.net.ua",true},
                {"q.w@ukr.net",true}};
    }
    @DataProvider(name = "check_Name_field_negative")
    public Object[][] testData_negative() {
        return new Object[][]{{"qw@ukrnet", false, "no dots domain part"},{"qwukr.net", false, "absence of @"},
                { new GenerationField().generateField(321)+"@ukr.net", false, "length321"},{"q  w@ukr.net", false, "spaces in account part"},
                {"qw@uk r.net", false, "spaces in domain part"},{"@ukr.net",false, "without account name"},
                {"qw@.net",false, "without domain part"}, { "qw@ukr."+new GenerationField().generateField(614), false, "length164"}};
    }
    @Test(dataProvider = "check_Name_field_positive"/*, priority = 0*/)
    public void checkNameField_positive(String value, boolean isPresentExpected) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterEmail(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterEmail());
        try {
          // todo boolean isPresentActual2 = isPresentForWait(driver.findElement(By.xpath("//span[@class='mailcheck_message']")));
            System.out.println("warning: " + driver.findElement(By.xpath("//span[@class='mailcheck_message']")).getText());
        } catch (NoSuchElementException e) {}
        Assert.assertNotEquals(isPresentActual, isPresentExpected);
    }
    @Test(dataProvider = "check_Name_field_negative"/*, priority = 0*/)
    public void checkNameField_negative(String value, boolean isPresentExpected, String  sort_of_check) throws InterruptedException {
        registrationPage = EnterValue_toField.enterValue_toField(value, registrationPage.getRegisterEmail(), registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getInvalidRegisterEmail());
        if(isPresentActual) {
            Assert.assertNotEquals(isPresentActual, isPresentExpected);
            String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
            System.out.println("1 errormessage: " +errormessage + " value: "+ value);
        }else {
            //todo
            String  nametext="";
            String error_message = "some error message";
            try {

                String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
                System.out.println("2 errormessage: " +errormessage + " value: "+ value);
                nametext = registrationPage.getEmailNameTitleText().getAttribute("data-label");
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
    // todo Email is already taken
    @Test(dataProvider = "if_email_alreadyTaken")
    public void checkUsername_alreadyTaken(String firstName, String lastName, String address, String city,
                                           String postCode, String country, String state, String phone,
                                           String email, boolean checkBox, String userName, String password, String  sort_of_check, boolean isPresentExpected) throws InterruptedException {
        RegistrationPageActions.register_newCustomer(firstName, lastName, address, city, postCode, country, state, phone, email, checkBox, userName, password, registrationPage);
        Thread.sleep(100);
        boolean isPresentActual= isPresentForWait(registrationPage.getIsAlreadyTakenRegisterUsername());
        if(isPresentActual) {
            Assert.assertNotEquals(isPresentActual, isPresentExpected);
            String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
            System.out.println("1 errormessage: " +errormessage + " , value: "+ userName);
        }else {
            //todo
            String  nametext="";
            String error_message = "some error message";
            try {
                String errormessage = driver.findElement(By.xpath("//span[@class='requiredField']")).getText();
                System.out.println("2 errormessage: " +errormessage+ " , value: "+ userName);
                nametext = registrationPage.getUsernameNameTitleText().getAttribute("data-label");
                System.out.println("text "+ nametext);
                String [] color = colorBord_Text(registrationPage, nametext);
                String  border_error_expected="the field border is highlighted in red";
                String  border_error_actual="not red";
                if(color[0].equals("rgba(220, 23, 17, 1)")&& color[1].equals("rgba(215, 25, 32, 1)")){
                    border_error_actual = "the field border is highlighted in red" ;
                }
                Assert.assertEquals(border_error_actual, border_error_expected);
            } catch (NoSuchElementException e) {
                error_message = "3 no error message: "+  sort_of_check ;
                Assert.assertEquals(error_message,"some error message" + " , value: " + userName);

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
