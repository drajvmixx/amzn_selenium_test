package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitAdapter;

/**
 * Created by Iryna on 8/15/2020.
 */
public class GiftCardPrintAtHomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'buy-box-atc')]")
    private WebElement addToCartItem;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement itemsAmountAtCart;

    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cartOpen;

    public GiftCardPrintAtHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartItem() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, addToCartItem);
        addToCartItem.click();
    }

    public String getItemsAmountAtCart() {
        return itemsAmountAtCart.getText();
    }

    public void clickOnCartOpen() {
        WaitAdapter.get().waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartOpen.click();
    }
}
