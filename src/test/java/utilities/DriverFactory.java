package utilities;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    
    // ThreadLocal to support parallel execution safely
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver based on browser name.
     * @param browser Name of the browser (chrome, firefox, edge)
     * @return WebDriver instance
     */
    public static WebDriver initDriver(String browser) {
        logger.info("Initializing browser: " + browser);

        if (browser == null) {
            browser = ConfigReader.getProperty("browser");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                logger.error("Invalid browser specified: " + browser);
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        
        long implicitWait = Long.parseLong(ConfigReader.getProperty("implicitWait"));
        long pageLoadTimeout = Long.parseLong(ConfigReader.getProperty("pageLoadTimeout"));
        
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        logger.info("Browser initialized successfully.");
        return getDriver();
    }

    /**
     * Returns the WebDriver instance for the current thread.
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quits the WebDriver instance and removes it from ThreadLocal.
     */
    public static void quitDriver() {
        if (getDriver() != null) {
            logger.info("Quitting the browser.");
            getDriver().quit();
            driver.remove();
        }
    }
}
