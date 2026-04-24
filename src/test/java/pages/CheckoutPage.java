package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtil;

public class CheckoutPage {

    private WebDriver driver;

    // Locators
    private By loginContinueButton = By.xpath("//button[contains(text(),'CONTINUE')]");
    private By newAddressRadioButton = By.xpath("//div[contains(text(), 'Add a new address')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinue() {
        WaitUtil.waitForElementClickable(driver, loginContinueButton).click();
    }

    public boolean isAddNewAddressAvailable() {
        return driver.findElements(newAddressRadioButton).size() > 0;
    }
}
