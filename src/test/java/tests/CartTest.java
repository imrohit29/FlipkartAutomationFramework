package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPopup;
import pages.ProductPage;
import pages.SearchPage;

public class CartTest extends BaseTest {

    @Test(description = "Verify add to cart and remove from cart functionality")
    public void addToCartTest() {
        new LoginPopup(driver).closePopupIfPresent();

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Headphones");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickFirstProduct();

        ProductPage productPage = new ProductPage(driver);
        productPage.switchToNewTab();
        
        String title = productPage.getProductTitle();
        Assert.assertNotNull(title, "Product title is null");

        productPage.clickAddToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.removeItem();
        
        // Assert cart is empty
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty after removal.");
    }
}
