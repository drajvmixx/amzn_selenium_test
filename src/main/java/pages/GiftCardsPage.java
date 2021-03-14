package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Iryna on 8/15/2020.
 */
public class GiftCardsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@aria-label, 'Print-at-Home')]")
    private WebElement printAtHomeGiftCardsCategory;

    public GiftCardsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPrintAtHomeGiftCardsCategory() {
        printAtHomeGiftCardsCategory.click();
    }
}
