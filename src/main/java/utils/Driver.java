package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
    private static final String AMAZON_URL = "https://www.amazon.com/";
    private static final long DEFAULT_TIMEOUT = 30L;
    private static WebDriver webDriver;

    private Driver() {
    }

    public static WebDriver get() {
        if (webDriver == null) {
            createDriver();
        }
        return webDriver;
    }

    public static void cleanup() {
        if (webDriver != null) {
            webDriver.close();
            webDriver = null;
        }
    }

    private static void createDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_PATH);

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(AMAZON_URL);
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }
}
