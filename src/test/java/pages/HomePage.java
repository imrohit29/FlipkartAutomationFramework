package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By searchInput = By.name("q");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By cartIcon = By.xpath("//a[contains(@href, 'cart')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Search for a product query.
     * @param productName name of the product
     */
    public void searchProduct(String productName) {
        WaitUtil.waitForElementVisible(driver, searchInput).sendKeys(productName);
        WaitUtil.waitForElementClickable(driver, searchButton).click();
    }

    public void navigateToCart() {
        WaitUtil.waitForElementClickable(driver, cartIcon).click();
    }
}
