package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPopup;

public class CrossBrowserTest extends BaseTest {

    @Test(description = "Validate homepage loads correctly across different browsers")
    public void crossBrowserVerificationTest() {
        // Driver gets injected via TestNG parameter or defaulting to Chrome
        new LoginPopup(driver).closePopupIfPresent();

        String title = driver.getTitle();
        System.out.println("Running test in browser. Title fetched: " + title);
        
        Assert.assertTrue(title.contains("Online Shopping"), "Homepage title validation failed in cross browser run.");
    }
}
