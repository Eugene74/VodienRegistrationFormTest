package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;

public class EnterValue_toField {
    public static RegistrationPage enterValue_toField(String firstName, WebElement webElement, RegistrationPage page) {
        webElement.clear();
        webElement.sendKeys(firstName);
        webElement.sendKeys(Keys.TAB);

        return new RegistrationPage(page.getDriver());
    }
}