package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna on 8/15/2020.
 */
public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'continue')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(), 'Enter your ')]")
    private WebElement errorMessageOfEmptySignInField;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public String getErrorMessageOfEmptySignInField() {
        return errorMessageOfEmptySignInField.getText();
    }
}
