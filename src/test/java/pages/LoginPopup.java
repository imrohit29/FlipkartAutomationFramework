package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtil;

public class LoginPopup {

    private WebDriver driver;

    // Locators
    private By closePopupButton = By.xpath("//button[contains(text(),'✕') or contains(@class,'_30XB9F')]");
    private By emailInput = By.xpath("//input[@class='_2IX_2- VJZDxU' or contains(@type,'text')]");
    private By requestOtpButton = By.xpath("//button[contains(text(),'Request OTP')]");

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Attempts to close the login popup if it appears.
     */
    public void closePopupIfPresent() {
        try {
            WebElement closeBtn = WaitUtil.waitForElementClickable(driver, closePopupButton);
            if (closeBtn != null && closeBtn.isDisplayed()) {
                closeBtn.click();
            }
        } catch (TimeoutException e) {
            // Popup not present, move on
        }
    }

    /**
     * Enters login info to proceed via OTP mock flow
     * @param phone Phone number
     */
    public void enterLoginPhone(String phone) {
        WebElement input = WaitUtil.waitForElementVisible(driver, emailInput);
        input.clear();
        input.sendKeys(phone);
    }

    public void clickRequestOtp() {
        WaitUtil.waitForElementClickable(driver, requestOtpButton).click();
    }
}
