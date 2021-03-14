package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitAdapter;

/**
 * Created by Iryna on 8/19/2020.
 */
public class SellerCentralPage extends BasePage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//div[@class='a-box-inner a-alert-container']/div")
    private WebElement errorMessageIncorrectSignUpCredentials;

    public SellerCentralPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailFieldInput(final String keyword) {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, emailInputField);
        emailInputField.sendKeys(keyword, Keys.ENTER);
    }

    public void setPasswordFieldInput(final String keyword) {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, passwordInputField);
        passwordInputField.sendKeys(keyword, Keys.ENTER);
        WaitAdapter.get().pause(DEFAULT_PAUSE);
    }

    public String getErrorMessageIncorrectSignUpCredentials() {
        return errorMessageIncorrectSignUpCredentials.getText();
    }
}
