package domain;

import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Driver;

public abstract class BaseLayer {

    public WebDriver getDriver() {
        return Driver.get();
    }

    public static String getPageUrl() {
        return Driver.get().getCurrentUrl();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SignInPage getSignInPage() {
        return new SignInPage(getDriver());
    }

    public GiftCardsPage getGiftCardsPage() {
        return new GiftCardsPage(getDriver());
    }

    public GiftCardPrintAtHomePage getGiftCardPrintAtHomePage() {
        return new GiftCardPrintAtHomePage(getDriver());
    }

    public CartPage getCartPage() {
        return new CartPage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

    public SellerPage getSellerPage() {
        return new SellerPage(getDriver());
    }

    public SellerCentralPage getSellerCentralPage() {
        return new SellerCentralPage(getDriver());
    }
}
