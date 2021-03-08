package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iryna on 8/14/2020.
 */
public abstract class BasePage {
    public static final long DEFAULT_TIMEOUT = 30L;
    protected static final long DEFAULT_PAUSE = 2000;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}