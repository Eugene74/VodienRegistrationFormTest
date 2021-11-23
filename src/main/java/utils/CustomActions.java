package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomActions {
    public static void moveToElement(WebDriver driver, WebElement elementTarget){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementTarget).perform();
    }

    public static void click(WebDriver driver, WebElement elementTarget){
        Actions actions = new Actions(driver);
        Waiters.clickableElement(driver,elementTarget);
        actions.clickAndHold(elementTarget).release(elementTarget)/*.build()*/.perform();
    }
}

