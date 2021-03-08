package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Iryna on 8/19/2020.
 */
public class OrderFunctionalityTests extends BaseTest {

    public static final String SIGNIN_URL = "/ap/signin";

//    @Test
//    public void checkImpossibilityToMakeOrderWithoutSignIn() {
//        NavigationCategoryLayer.extendSubcategory();
//        getProductPage().clickOnBuyNowButton();
//        assertTrue(getBasePage().getPageUrl().contains(SIGNIN_URL));
//    }
//
//    @Test
//    public void checkImpossibilityOfOrderingMoreThanThreeItemsWithoutBusinessAccount() {
//        NavigationCategoryLayer.extendSubcategory();
//        getProductPage().clickOnProductQuantityExtendButton();
//        getProductPage().clickOnMoreThanThreeItemsAddToCart();
//        assertTrue(getProductPage().getAmazonBusinessAccountNotification().contains("Amazon Business"));
//    }
}
