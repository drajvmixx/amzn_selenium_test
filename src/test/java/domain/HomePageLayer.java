package domain;

import utils.WaitAdapter;

import static pages.BasePage.DEFAULT_TIMEOUT;

public class HomePageLayer extends BaseLayer {

    public void goToRegistrationPage() {
        getHomePage().clickOnSignInLink();
        getHomePage().clickOnCreateNewAccountButton();
        WaitAdapter.get().waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    public void editZipCodeInDeliveryConfiguration(String zipCode) {
        getHomePage().clickOnDeliveryConfigurationLink();
        getHomePage().setUsZipCodeInputField(zipCode);
        getHomePage().clickOnContinueButtonOfDeliveryConfigurationPopup();
    }

    public String getConfiguredDeliveryInfo() {
        return getHomePage().getConfiguredDeliveryInfo();
    }
}
