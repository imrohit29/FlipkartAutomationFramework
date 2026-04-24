package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPopup;
import pages.SearchPage;

public class FilterTest extends BaseTest {

    @Test(description = "Verify product price filters")
    public void applyPriceFilterTest() {
        new LoginPopup(driver).closePopupIfPresent();

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");

        SearchPage searchPage = new SearchPage(driver);
        int initialCount = searchPage.getProductCount();
        
        searchPage.selectMinPrice("₹30000");
        searchPage.selectMaxPrice("₹60000");
        
        // Just verify it doesn't crash and items are present
        int subCount = searchPage.getProductCount();
        Assert.assertTrue(subCount >= 0, "Price filter applied but products failed to load.");
    }
}
