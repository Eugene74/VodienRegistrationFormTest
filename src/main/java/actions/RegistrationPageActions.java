package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.RegistrationPage;
import utils.CustomActions;

public class RegistrationPageActions {
     public static void register_newCustomer(String firstName, String lastName, String address, String city, String postCode,
                                      String country, String state, String phone, String email, boolean checkBox,
                                      String userName, String password, RegistrationPage page) {
         page.getRegisterFirstName().clear();
         page.getRegisterFirstName().sendKeys(firstName);
         page.getRegisterLastName().clear();
         page.getRegisterLastName().sendKeys(lastName);
         page.getRegisterCity().clear();
         page.getRegisterAddress().sendKeys(address);
         page.getRegisterCity().clear();
         page.getRegisterCity().sendKeys(city);
         page.getRegisterPostCode().clear();
         page.getRegisterPostCode().sendKeys(postCode);

         //page. getCountry_name().sendKeys(country);
         WebElement counry = page.getCountryName();
         Select select = new Select(counry);
         select.selectByVisibleText("Ukraine");

         page.getStateField().sendKeys(state);
         page.getPhoneNumber().clear();
         page.getPhoneNumber().sendKeys(phone);
         page.getRegisterEmail().clear();
         page.getRegisterEmail().sendKeys(email);
         new CustomActions().click(page.getDriver(), page.getContactPermission());
        if (checkBox) {
            page.getCheckBox().click();
        }

         page.getRegisterUsername().sendKeys(userName);
         page.getPass().clear();
         page.getPass().sendKeys(password);
         page.getContinueOrder().submit();

    }

    @Deprecated
    public static  RegistrationPage  setPhoneNumber(String phone, RegistrationPage page) {
        page.getPhoneNumber().clear();
        page.getPhoneNumber().sendKeys(phone);
        //new CustomActions().click(page.getDriver(), page.getRegister_email());
        page.getPhoneNumber().sendKeys(Keys.TAB);
        return new RegistrationPage(page.getDriver());
    }
    @Deprecated
    public static  RegistrationPage  setEmail(String email, RegistrationPage page) {
        page.getRegisterEmail().sendKeys(email);
        new CustomActions().click(page.getDriver(), page.getRegisterUsername());
        return new RegistrationPage(page.getDriver());
    }
    @Deprecated
    public static  RegistrationPage  setPassword(String password, RegistrationPage page) {
        page.getPass().sendKeys(password);
        new CustomActions().click(page.getDriver(), page.getRegisterUsername());
        return new RegistrationPage(page.getDriver());
    }
}
