package tests;

import domain.BaseLayer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Created by Iryna on 8/19/2020.
 */
public class AuthenticationTests extends BaseTest {
    public static final String ERROR_MESSAGE_OF_EMPTY_SIGN_IN_FIELD = "Enter your email or mobile phone number";
    public static final String REGISTRATION_PAGE_URL = "/ap/register";
    public static final String EMAIL_FIELD_INPUT = "Drajvmixxdfhdhsdmail.com";
    public static final String PASSWORD_FIELD_INPUT = "Qwfdghhgderty123";
    public static final String ERROR_MESSAGE_WRONG_SIGNUP_CREDENTIALS = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below";

    @Test(description = "Check Error Message If Sign In With Empty Field. TC_ID=C1")
    public void checkErrorMessageIfSignInWithEmptyField() {
        getSignInLayer().signInWithEmptyField();
        assertEquals(getSignInLayer().getErrorMessageOfEmptySignInField(), ERROR_MESSAGE_OF_EMPTY_SIGN_IN_FIELD);
    }

    @Test
    public void checkUserCanBeRedirectedToAmazonRegistrationPageFromSigInForm() {
        getHomePageLayer().goToRegistrationPage();
        assertTrue(BaseLayer.getPageUrl().contains(REGISTRATION_PAGE_URL));
    }

    @Test
    public void checkImpossibilitySignUpAsSellerWithWrongCredentials() {
        getSignInLayer().goToSignUpForm();
        getSignInLayer().populateSignUpForm(EMAIL_FIELD_INPUT, PASSWORD_FIELD_INPUT);
        assertTrue(getSignInLayer().getErrorMessageIncorrectSignUpCredentials().contains(ERROR_MESSAGE_WRONG_SIGNUP_CREDENTIALS));
    }
}
