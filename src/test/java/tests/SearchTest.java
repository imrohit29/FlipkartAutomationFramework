package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPopup;
import pages.SearchPage;
import utilities.ExcelUtil;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        // Read data using ExcelUtil for Data-Driven Testing
        Object[][] data = ExcelUtil.getTestData("Search");
        // Fallback mockup if Excel is missing
        if (data == null) {
            return new Object[][]{ {"MacBook Pro"}, {"iPhone 15"} };
        }
        return data;
    }

    @Test(dataProvider = "searchData", description = "Verify search functionality for various products")
    public void productSearchTest(String product) {
        new LoginPopup(driver).closePopupIfPresent();

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct(product);

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.getProductCount() > 0, "No products found for: " + product);
    }
}
