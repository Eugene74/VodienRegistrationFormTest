package registrationformtest;

import actions.RegistrationPageActions;
import basepackage.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.RegistrationPage;

import java.io.File;
import java.io.IOException;

public class SetSpacesRequiredFields extends BaseTest {
    private static String URL_MATCH = "https://www.vodien.com.au/";


    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);   }


    @DataProvider(name = "newCustomerData_spaces_fields")
    public Object[][] testData3() {
        return new Object[][]{{"     ", "   ", "        ", "      ",
                "      ", "      ", "      ", "      ", "      ", false, "      ", "      "}};
    }

    @Test(dataProvider = "newCustomerData_spaces_fields")
    public void setSpacesRequiredFields(String firstName, String lastName, String address, String city,
                                        String postCode, String country, String state, String phone,
                                        String email, boolean checkBox, String userName, String password) {
        RegistrationPageActions.register_newCustomer(firstName, lastName, address, city, postCode, country, state, phone, email, checkBox, userName, password, registrationPage);
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(newUrl,"https://www.vodien.com.au/register");
    }

    @AfterMethod(enabled = false) //todo
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("D:\\test-output\\test1.PNG"));
        System.out.println("Screenshot of the test is taken");

    }
}
