package PageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object class for the Economic Calendar page
 *
 * @author Patrik_Horvath
 */
public class EconomicCalendarPage extends PageObject {
    /**
     * Locator declarations
     */
    @FindBy(css = "#economicCalendarForm")
    private WebElement economicCalendarForm;

    @FindBy(id = "timeFrame_yesterday")
    private WebElement btnYesterday;
    @FindBy(id = "timeFrame_today")
    private WebElement btnToday;

    @FindBy(id = "timeFrame_tomorrow")
    private WebElement btnTomorrow;

    @FindBy(id = "timeFrame_thisWeek")
    private WebElement btnThisWeek;

    @FindBy(id = "widgetField")
    private WebElement fieldDateRange;

    @FindBy(xpath = "//a[@href=\"/research/risk_warning\"]")
    private WebElement btnHere;
    @FindBy(css = "#timeselector > li.saveSpace")
    private WebElement timeSelector;

    /**
     * @param driver initialiting the driver which imitating the user events
     */
    public EconomicCalendarPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Switch the current frame to the Economic Calendar
     */
    public void stepIntoTheFrame() {
        driver.switchTo().frame(0);
    }

    /**
     * Leaves the frame of the Economic Calendar
     */
    public void leaveTheFrame() {
        driver.switchTo().parentFrame();
    }

    /**
     * @return Visibility status of the Economic Calendar form
     */
    public boolean isInitialized() {
        return economicCalendarForm.isDisplayed();
    }

    /**
     * If the width of the application is lower, the buttons are present in a dropdown
     */
    public void clickToYesterdayButton(Dimension dimension) {
        if (dimension.width <= 1300) { //TODO
            timeSelector.click();
        }
        btnYesterday.click();
    }

    /**
     * If the width of the application is lower, the buttons are present in a dropdown
     */
    public void clickToTodayButton(Dimension dimension) {
        if (dimension.width <= 1300) { //TODO
            timeSelector.click();
        }
        btnToday.click();
    }

    /**
     * If the width of the application is lower, the buttons are present in a dropdown
     */
    public void clickToTomorrowButton(Dimension dimension) {
        if (dimension.width <= 1300) { //TODO
            timeSelector.click();
        }
        btnTomorrow.click();
    }

    /**
     * If the width of the application is lower, the buttons are present in a dropdown
     */
    public void clickToThisWeekButton(Dimension dimension) {
        if (dimension.width <= 1300) { //TODO
            timeSelector.click();
        }
        btnThisWeek.click();
    }

    /**
     * @return date of the date input
     */
    public String getEconomicCalendarDate() {
        return fieldDateRange.getText();
    }

    /**
     * Scrolls down until it finds the Here button
     * Then clicks on it
     */
    public void clickToTheHereButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnHere);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100)", "");
        btnHere.click();
    }
}
