package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Iryna on 8/19/2020.
 */
public class DeliveryConfigurationTests extends BaseTest {

    public static final String US_ZIP_CODE_INPUT_VALUE = "43006";

    @Test
    public void checkDeliveryConfigurationByUsZipCode() {
        getHomePageLayer().editZipCodeInDeliveryConfiguration(US_ZIP_CODE_INPUT_VALUE);
        assertTrue(getHomePageLayer().getConfiguredDeliveryInfo().contains(US_ZIP_CODE_INPUT_VALUE));
    }
}
