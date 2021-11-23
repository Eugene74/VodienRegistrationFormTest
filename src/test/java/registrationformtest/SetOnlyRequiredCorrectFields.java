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

public class SetOnlyRequiredCorrectFields extends BaseTest {
    private static String URL_MATCH = "https://www.vodien.com.au/";

    @BeforeTest
    public void setupRegistrationPage() { registrationPage = new RegistrationPage(driver);   }

    @DataProvider(name = "newCustomerData_required_fields")
    public Object[][] testData2() {
        return new Object[][]{{"Ivan", "Pupko", "Obolonskaya 6, 89", "Kiev",
                "420154", "Ukraine", "Kievskaya", "0931545285", "wq1@ukr.net", false, "vanpupko15", "Qwerty13"}};
    }

    @Test(dataProvider = "newCustomerData_required_fields")
    public void setOnlyRequiredCorrectFields(String firstName, String lastName, String address, String city,
                                             String postCode, String country, String state, String phone,
                                             String email, boolean checkBox, String userName, String password) {
        RegistrationPageActions.register_newCustomer(firstName, lastName, address, city, postCode, country, state, phone, email, checkBox, userName, password, registrationPage);
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(newUrl, URL_MATCH);
    }

    @AfterMethod(enabled = false) //todo
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("D:\\test-output\\required_only.PNG"));
        System.out.println("Screenshot of the test is taken");

    }
}
