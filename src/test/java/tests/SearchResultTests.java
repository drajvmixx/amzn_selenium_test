package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Iryna on 8/14/2020.
 */
public class SearchResultTests extends BaseTest {

    public static final String SEARCH_FIELD_KEYWORD = "LEGO";

//    @Test
//    public void checkSearchResultPageContainsSearchedItems() {
//        getHomePageLayer().clickOnSearchField();
//        getHomePageLayer().typeIntoSearchField(SEARCH_FIELD_KEYWORD);
//        List<WebElement> productsTitles = getSearchResultPage().getSearchResultProductsTitles();
//        int searchedProductsAmount = 0;
//        for (WebElement productTitle : productsTitles) {
//            if (productTitle.getText().toUpperCase().contains(SEARCH_FIELD_KEYWORD.toUpperCase())) {
//                searchedProductsAmount++;
//            }
//        }
//        assertTrue(searchedProductsAmount > 0);
//    }

}

