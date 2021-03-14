package domain;

public class SignInLayer extends BaseLayer {
    public void signInWithEmptyField() {
        getHomePage().clickOnSignInLink();
        getSignInPage().clickOnContinueButton();
    }

    public void goToSignUpForm() {
        getHomePage().clickOnSellLinkAtTopMenu();
        getSellerPage().clickOnSignUpButton();
    }

    public void populateSignUpForm(String emailFieldInput, String passwordFieldInput) {
        getSellerCentralPage().setEmailFieldInput(emailFieldInput);
        getSellerCentralPage().setPasswordFieldInput(passwordFieldInput);
    }

    public String getErrorMessageOfEmptySignInField() {
        return getSignInPage().getErrorMessageOfEmptySignInField();
    }

    public String getErrorMessageIncorrectSignUpCredentials() {
        return getSellerCentralPage().getErrorMessageIncorrectSignUpCredentials();
    }
}
