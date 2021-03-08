package tests;

import domain.*;
import org.testng.annotations.AfterMethod;
import utils.Driver;

/**
 * Created by Iryna on 8/14/2020.
 */
public class BaseTest {
    @AfterMethod
    public void tearDown() {
        Driver.cleanup();
    }

    public HomePageLayer getHomePageLayer() {
        return new HomePageLayer();
    }

    public SignInLayer getSignInLayer() {
        return new SignInLayer();
    }

    public CartLayer getCartLayer() {
        return new CartLayer();
    }
}
