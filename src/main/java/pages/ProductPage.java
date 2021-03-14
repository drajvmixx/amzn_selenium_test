package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitAdapter;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[@title = 'Add to Shopping Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id = 'buy-now-button']")
    private WebElement buyNowButton;

    @FindBy(xpath = "//div[@id='selectQuantity']//span[contains(@class, 'a-button-text a-declarative')]")
    private WebElement productQuantityExtendButton;

    @FindBy(xpath = "//li[@id = 'lastQuantityOption']/a")
    private WebElement moreThanThreeItemsAddToCart;

    @FindBy(xpath = "//div[contains(@class,'a-popover-inner') and contains(@id, 'a-popover-content')]/a")
    private WebElement amazonBusinessAccountNotification;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, addToCartButton);
        return addToCartButton;
    }

    public void clickOnBuyNowButton() {
        buyNowButton.click();
    }

    public void clickOnProductQuantityExtendButton() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, productQuantityExtendButton);
        productQuantityExtendButton.sendKeys(Keys.RETURN);
        productQuantityExtendButton.click();
    }

    public void clickOnMoreThanThreeItemsAddToCart() {
        moreThanThreeItemsAddToCart.click();
    }

    public String getAmazonBusinessAccountNotification() {
        WaitAdapter.get().waitForPageLoadComplete(DEFAULT_TIMEOUT);
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, amazonBusinessAccountNotification);
        return amazonBusinessAccountNotification.getText();
    }
}
