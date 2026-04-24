package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtil;

public class SearchPage {

    private WebDriver driver;

    // Locators
    private By minPriceDropdown = By.xpath("//div[@class='_1YAKP4']/select[@class='_2YxCDZ']");
    private By maxPriceDropdown = By.xpath("//div[@class='_3uDYxP']/select[@class='_2YxCDZ']");
    private By productTitles = By.xpath("//div[contains(@class, 'KzDlHZ') or contains(@class, 's1Q9rs')]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMinPrice(String price) {
        WebElement minDropdown = WaitUtil.waitForElementClickable(driver, minPriceDropdown);
        minDropdown.sendKeys(price); // Simplified simulate select
    }

    public void selectMaxPrice(String price) {
        WebElement maxDropdown = WaitUtil.waitForElementClickable(driver, maxPriceDropdown);
        maxDropdown.sendKeys(price);
    }

    public void clickFirstProduct() {
        List<WebElement> products = driver.findElements(productTitles);
        if (!products.isEmpty()) {
            products.get(0).click();
        }
    }
    
    public int getProductCount() {
        return driver.findElements(productTitles).size();
    }
}
