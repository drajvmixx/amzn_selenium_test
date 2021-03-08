package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Iryna on 8/15/2020.
 */
public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class, 'a-size-base-plus')]")
    private List<WebElement> searchResultProductsTitles;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultProductsTitles() {
        return searchResultProductsTitles;
    }
}

