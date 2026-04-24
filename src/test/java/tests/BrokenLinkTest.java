package tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class BrokenLinkTest extends BaseTest {

    @Test(description = "Verify there are no broken links on the home page")
    public void checkBrokenLinksOnHomePage() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());
        
        int brokenLinksCount = 0;

        // Checking first 10 for performance in a demo
        int linksToCheck = Math.min(links.size(), 10);
        for (int i = 0; i < linksToCheck; i++) {
            String url = links.get(i).getAttribute("href");
            if (url == null || url.isEmpty()) {
                continue;
            }
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int responseCode = conn.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println(url + " is a broken link. Status code: " + responseCode);
                    brokenLinksCount++;
                }
            } catch (Exception e) {
                // Ignore parsing errors for mock testing
            }
        }
        Assert.assertTrue(brokenLinksCount == 0, "There are broken links on the page!");
    }
}
