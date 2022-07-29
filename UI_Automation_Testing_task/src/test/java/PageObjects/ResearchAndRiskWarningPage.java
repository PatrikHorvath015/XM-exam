package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object file for the Research and risk warning
 *
 * @author Patrik_Horvath
 */
public class ResearchAndRiskWarningPage extends PageObject {
    /**
     * Locator declarations
     */
    @FindBy(xpath = "//div[@class=\"container mt-350\"]/h2[text()='Notification on Non-Independent Investment Research and Risk Warning']")
    private WebElement title;
    @FindBy(xpath = "//a[@href=\"/assets/pdf/new/docs/XM-Risk-Disclosures-for-Financial-Instruments.pdf?v5\"]")
    private WebElement btnHere;

    /**
     * @param driver does the automation by imitating the user events
     */
    public ResearchAndRiskWarningPage(WebDriver driver) {
        super(driver);
    }

    /**
     * @return the title of the page
     */
    public boolean isInitialized() {
        return title.isDisplayed();
    }

    /**
     * Scroll until it finds the Here button
     * Then clicks on it
     */
    public void clickToTheHereButton() throws InterruptedException {//TODO
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnHere);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -100)", ""); //The scrollIntoView() scrolls over the Here button
        Thread.sleep(2000);//TODO
        btnHere.click();
    }
}
