package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class WishlistPage {

    private WebDriver driver;

    private By myWishlistHeader = By.xpath("//span[contains(text(),'My Wishlist')]");
    private By deleteIcon = By.xpath("//img[contains(@class,'_3bziIX')]");

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnWishlistPage() {
        return WaitUtil.waitForElementVisible(driver, myWishlistHeader).isDisplayed();
    }

    public void removeFirstItem() {
        WaitUtil.waitForElementClickable(driver, deleteIcon).click();
    }
}
