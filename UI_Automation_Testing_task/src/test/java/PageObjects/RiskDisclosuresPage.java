package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Page Object file for the RiskDisclosures pdf
 *
 * @author Patrik_Horvath
 */
public class RiskDisclosuresPage extends PageObject {
    /**
     * @param driver does the automation by imitating the user events
     */
    public RiskDisclosuresPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @return Title of the page
     */
    public String getTitle() {
        return driver.getTitle();
    }
}
