package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitAdapter;

/**
 * Created by Iryna on 8/16/2020.
 */
public class CartPage extends BasePage {

    @FindBy(xpath = "//span[contains(@data-action, 'delete')]//input[contains(@data-action, 'delete')]")
    private WebElement deleteItemFromCartLink;

    @FindBy(xpath = "//div[contains(@class, 'a-row sc-your-amazon-cart-is-empty')]/h2")
    private WebElement notificationAboutEmptyCart;

    @FindBy(xpath = "//p[@class = 'a-spacing-small']/span")
    private WebElement productPriceFromCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDeleteItemFromCartLink() {
        WaitAdapter.get().waitForPageLoadComplete(DEFAULT_TIMEOUT);
        deleteItemFromCartLink.click();
    }

    public String getNotificationAboutEmptyCart() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, notificationAboutEmptyCart);
        return notificationAboutEmptyCart.getText();
    }
}
