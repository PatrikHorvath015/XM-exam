package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object pattern class
 *
 * @author Patrik_Horvath
 */
public abstract class PageObject {
    protected WebDriver driver;

    /**
     * @param driver does the automation by imitating the events
     *               Initializing the page factory, which let us declaring with the @FindBy
     */
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}