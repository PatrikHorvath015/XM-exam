package PageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object class for the Research and education page
 *
 * @author Patrik_Horvath
 */
public class ResearchAndEducationPage extends PageObject {
    /**
     * Page locators
     */
    @FindBy(css = "#main-nav > li.main_nav_research.selected")
    private WebElement researchAndEducationButton;
    @FindBy(xpath = "//a[@href=\"https://www.xm.com/research/economicCalendar\"]")
    private WebElement economicCalendar;
    @FindBy(id = "researchMenu")
    private WebElement researchMenu;

    /**
     * @param driver does the automation by imitating the user events
     */
    public ResearchAndEducationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @param dimension an object which contains the size of the screen
     *                  Return the visibility state of the page
     */
    public boolean isInitialized(Dimension dimension) {
        if (dimension.width <= 900) {
            return researchMenu.getAttribute("aria-expanded").equals("true");
        } else {
            return researchAndEducationButton.isDisplayed();
        }
    }

    /**
     * Scrolls to the economic calendar, then clicking on it
     */
    public void clickOnEconomicCalendar() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", economicCalendar);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100)", "");//Necessary, the scrollIntoView scrolling over
        economicCalendar.click();
    }
}
