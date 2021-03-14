package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAdapter {
    private static WaitAdapter wait;

    private WaitAdapter() {
    }

    public static WaitAdapter get() {
        if (wait == null) {
            wait = new WaitAdapter();
        }
        return wait;
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(Driver.get(), timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pause(long pause) {
        new Actions(Driver.get()).pause(pause).perform();
    }
}
