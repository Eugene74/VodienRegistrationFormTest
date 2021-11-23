package utils;

import org.openqa.selenium.*;
import pages.RegistrationPage;

public class Methods {
    public static boolean isPresentForWait(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    public static String [] colorBord_Text(RegistrationPage registrationPage,  String nametext) {
        String color_border = registrationPage.getDriver().findElement(By.xpath("//input[@name = " + "'"+ nametext+ "'" + "]/ancestor::div[@class='input-box-mask']")).getCssValue("border-bottom-color");
        String color_text = registrationPage.getDriver().findElement(By.xpath("//div[@data-label=" + "'"+ nametext+ "'" + "]")).getCssValue("color");
        return new String[]{color_border,color_text};
    }
}


