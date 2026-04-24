package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPopup;
import pages.ProductPage;
import pages.SearchPage;

public class PriceMonitorTest extends BaseTest {

    @Test(description = "Validate price changes for a specific item over time / or just extraction validation")
    public void monitorItemPrice() {
        new LoginPopup(driver).closePopupIfPresent();
        
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Samsung Galaxy S24");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.switchToNewTab();

        String priceStr = productPage.getProductPrice();
        System.out.println("Current Price Monitored: " + priceStr);
        Assert.assertNotNull(priceStr, "Price was extracted for monitoring.");
    }
}
