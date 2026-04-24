package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By placeOrderButton = By.xpath("//span[contains(text(),'Place Order')]");
    private By removeButton = By.xpath("//div[contains(text(),'Remove')]");
    private By emptyCartMessage = By.xpath("//div[contains(text(),'Missing Cart items?')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        WaitUtil.waitForElementClickable(driver, placeOrderButton).click();
    }

    public void removeItem() {
        WaitUtil.waitForElementClickable(driver, removeButton).click();
        // second confirmation
        By popupRemove = By.xpath("//div[contains(@class,'nZz_ng')]//div[contains(text(),'Remove')]");
        WaitUtil.waitForElementClickable(driver, popupRemove).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(emptyCartMessage).size() > 0;
    }
}
