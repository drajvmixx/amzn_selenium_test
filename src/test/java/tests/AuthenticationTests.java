package tests;

import domain.BaseLayer;
import domain.signin.EmptySignInFormStrategy;
import domain.signin.IncorrectLoginDataSignInFormStrategy;
import domain.signin.NegativeSignInStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Created by Iryna on 8/19/2020.
 */
public class AuthenticationTests extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTests.class);
    public static final String REGISTRATION_PAGE_URL = "/ap/register";

    @DataProvider(name = "testSignInStrategies")
    public static Object[] testSignInStrategies() {
        return new Object[] {new EmptySignInFormStrategy(),new IncorrectLoginDataSignInFormStrategy()};
    }

    @Test
    public void checkUserCanBeRedirectedToAmazonRegistrationPageFromSigInForm() {
        getHomePageLayer().goToRegistrationPage();
        assertTrue(BaseLayer.getPageUrl().contains(REGISTRATION_PAGE_URL));
    }

    @Test(dataProvider ="testSignInStrategies", description = "Check Error Message If Sign In With Empty Field. TC_ID=C1")
    public void checkNegativeSignInCases(NegativeSignInStrategy negativeSignInStrategy) {
        negativeSignInStrategy.fillData();
        assertTrue(negativeSignInStrategy.isErrorShown());
    }
}
