package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Iryna on 8/19/2020.
 */
public class CartFunctionalityTests extends BaseTest {

    public static final String ITEMS_AMOUNT_AT_CART = "1";
    public static final String CART_IS_EMPTY_KEYWORD = "Cart is empty";

    @Test
    public void checkAddItemToCart() {
        getCartLayer().addToCartItem();
        assertEquals(getCartLayer().getItemsAmountAtCart(), ITEMS_AMOUNT_AT_CART);
    }

    @Test
    public void checkDeleteItemFromCart() {
        getCartLayer().addToCartAndDelete();
        assertTrue(getCartLayer().getNotificationAboutEmptyCart().contains(CART_IS_EMPTY_KEYWORD));
    }

    /*@Test
    public void checkPossibilityToAddToCartFromCategoriesList() {
        getCartLayer().addToCartFromCategoriesList();
        assertEquals(getCartLayer().isAddToCartButtonDisplayed(), true);
    }*/
}
