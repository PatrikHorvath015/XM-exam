package PageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object file for the home page
 *
 * @author Patrik_Horvath
 */
public class WelcomePage extends PageObject {
    public WebDriver driver;
    /**
     * Locator declaration
     */
    @FindBy(xpath = "//button[@aria-label=\"Close\"]")
    private WebElement btnAcceptCookies;
    @FindBy(css = "button.toggleLeftNav")
    private WebElement btnMenu;
    @FindBy(id = "hero-content")
    private WebElement banner;
    @FindBy(css = "#main-nav > li.main_nav_research")
    private WebElement btnResearchAndEducation;
    @FindBy(xpath = "//a[@aria-controls=\"researchMenu\"]")
    private WebElement btnResearchAndEducationInMenu;

    /**
     * @param driver initializing the driver
     */
    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * @return the visibility status of the page
     */
    public boolean isInitialized() {
        return banner.isDisplayed();
    }

    /**
     * Clicks on the accept cookies button on the Cookie Popup window
     */
    public void clickOnAcceptCookiesButton() {
        btnAcceptCookies.click();
    }

    /**
     * Based on the resolution size of the browser
     * Clicks on the Research and education button
     */
    public void clickOnResearchAndEducation(Dimension dimension) {
        if (dimension.width <= 1000) {
            btnMenu.click();
            btnResearchAndEducationInMenu.click();
        } else {
            btnResearchAndEducation.click();
        }
    }
}
