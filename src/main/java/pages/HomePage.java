package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitAdapter;

/**
 * Created by Iryna on 8/14/2020.
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@data-nav-role, 'signin')]/span[contains(@class, 'nav-line-2')]")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@id = 'twotabsearchtextbox']")
    private WebElement searchFieldInput;

    @FindBy(xpath = "//a[contains(@href, 'gift-cards')]")
    private WebElement giftCardsLink;

    @FindBy(xpath = "//a[@id = 'nav-hamburger-menu']")
    private WebElement listOfCategoriesLink;

    @FindBy(xpath = "//a[@class = 'hmenu-item' and @data-menu-id = '6']")
    private WebElement categoryFromList;

    @FindBy(xpath = "(//ul[@class = 'hmenu hmenu-visible hmenu-translateX' ]//li/a[@class = 'hmenu-item'])[1]")
    private WebElement categoriesListSubcategory;

    @FindBy(xpath = "//a[contains(@class, 'a-declarative')]")
    private WebElement deliveryConfigurationLink;

    @FindBy(xpath = "//input[@data-action = 'GLUXPostalInputAction']")
    private WebElement usZipCodeInputField;

    @FindBy(xpath = "//div[@class = 'a-popover-footer']//input[@id = 'GLUXConfirmClose']")
    private WebElement continueButtonOfDeliveryConfigurationPopup;

    @FindBy(xpath = "//a[contains(@class, 'nav-a nav-a-2 a-popover-trigger a-declarative') ]")
    private WebElement deliveryConfigurationLinkWithSetZipCode;

    @FindBy(xpath = "//span[@id='glow-ingress-line2']")
    private WebElement configuredDeliveryInfo;

    @FindBy(xpath = "//a[@id = 'createAccountSubmit']")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Sell') and contains(@class, 'nav-a  ')]")
    private WebElement sellLinkAtTopMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public void clickOnSearchField() {
        searchFieldInput.click();
    }

    public void typeIntoSearchField(final String keyword) {
        searchFieldInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnGiftCardsLink() {
        giftCardsLink.click();
    }

    public void clickOnListOfCategoriesLink() {
        listOfCategoriesLink.click();
    }

    public void clickOnCategoryFromList() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, categoryFromList);
        categoryFromList.click();
    }

    public void clickOnCategoriesListSubcategory() {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, categoriesListSubcategory);
        categoriesListSubcategory.click();
    }

    public void clickOnDeliveryConfigurationLink() {
        deliveryConfigurationLink.click();
    }

    public void setUsZipCodeInputField(final String keyword) {
        WaitAdapter.get().waitVisibilityOfElement(DEFAULT_TIMEOUT, usZipCodeInputField);
        usZipCodeInputField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnContinueButtonOfDeliveryConfigurationPopup() {
        continueButtonOfDeliveryConfigurationPopup.click();
        WaitAdapter.get().pause(DEFAULT_PAUSE);
    }

    public String getConfiguredDeliveryInfo() {
        return configuredDeliveryInfo.getText();
    }

    public void clickOnCreateNewAccountButton() {
        createNewAccountButton.click();
    }

    public void clickOnSellLinkAtTopMenu() {
        sellLinkAtTopMenu.click();
    }


}
