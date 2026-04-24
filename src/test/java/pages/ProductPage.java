package pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class ProductPage {

    private WebDriver driver;

    // Locators
    private By addToCartButton = By.xpath("//button[contains(@class, 'QqFHMw') or text()='ADD TO CART']");
    private By priceElement = By.xpath("//div[contains(@class, 'Nx9bqj')]");
    private By titleElement = By.xpath("//span[@class='VU-Tz5']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void clickAddToCart() {
        WaitUtil.waitForElementClickable(driver, addToCartButton).click();
    }

    public String getProductTitle() {
        return WaitUtil.waitForElementVisible(driver, titleElement).getText();
    }

    public String getProductPrice() {
        return WaitUtil.waitForElementVisible(driver, priceElement).getText();
    }
}
