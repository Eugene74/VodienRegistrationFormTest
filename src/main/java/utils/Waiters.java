package utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waiters {
    public static void appearElement(WebDriver driver,  WebElement element, int timeout){
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Methods.isPresentForWait(element);
            }
            public String toString() {
                return null;
            }
        });
    }

    public static void clickableElement(WebDriver driver, WebElement element){
        Wait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}





