package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna on 8/19/2020.
 */
public class SellerPage extends BasePage {

    @FindBy(xpath = "//a[ contains(@class, 'link  button button-type-primary font-size-regular')]")
    private WebElement signUpButton;

    public SellerPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }
}
