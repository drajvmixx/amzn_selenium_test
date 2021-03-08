package domain;

import java.nio.charset.Charset;

public class CartLayer extends BaseLayer {
    public void addToCartItem() {
        getHomePage().clickOnGiftCardsLink();
        getGiftCardsPage().clickOnPrintAtHomeGiftCardsCategory();
        getGiftCardPrintAtHomePage().clickOnAddToCartItem();
    }

    public String getItemsAmountAtCart() {
        return getGiftCardPrintAtHomePage().getItemsAmountAtCart();
    }

    public void addToCartAndDelete() {
        addToCartItem();
        getGiftCardPrintAtHomePage().clickOnCartOpen();
        getCartPage().clickOnDeleteItemFromCartLink();
    }

    public String getNotificationAboutEmptyCart() {
        return getCartPage().getNotificationAboutEmptyCart();
    }

    public void addToCartFromCategoriesList() {
        getHomePage().clickOnListOfCategoriesLink();
        getHomePage().clickOnCategoryFromList();
        getHomePage().clickOnCategoriesListSubcategory();
    }

    public boolean isAddToCartButtonDisplayed() {
        return getProductPage().getAddToCartButton().isDisplayed();
    }
}
