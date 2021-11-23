package registrationformtest;


import basepackage.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.RegistrationPage;

import java.io.File;
import java.io.IOException;

public class SetEmptyRequiredFields extends BaseTest {

    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void setEmptyRequiredFields() {
        registrationPage.getContinueOrder().click();
        Assert.assertEquals(registrationPage.getEmptyRegisterFirstName().getText(),"Enter your first name");
        Assert.assertEquals(registrationPage.getEmptyRegisterLastName().getText(),"Enter your last name");
        Assert.assertEquals(registrationPage.getEmptyRegisterAddress().getText(),"Enter your current address");
        Assert.assertEquals(registrationPage.getEmptyRegisterCity().getText(),"City required");
        Assert.assertEquals(registrationPage.getEmptyRegisterPostCode().getText(),"Post Code required");
        Assert.assertEquals(registrationPage.getEmptyStateField().getText(),"Enter you state");
        Assert.assertEquals(registrationPage.getEmptyRegisterPhone().getText(),"Enter your phone or mobile number");
        Assert.assertEquals(registrationPage.getEmptyRegisterEmail().getText(),"Enter your email address");
        Assert.assertEquals(registrationPage.getEmptyRegisterUsername().getText(),"Choose a username for your account");
        Assert.assertEquals(registrationPage.getEmptyRegisterPassword().getText(),"Choose a password for your account");
    }

    @AfterMethod(enabled = false) //todo
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("D:\\test-output\\dontfill_required_fields.PNG"));
        System.out.println("Screenshot of the test is taken");

    }
}
