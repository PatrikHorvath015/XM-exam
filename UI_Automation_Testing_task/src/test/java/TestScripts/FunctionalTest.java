package TestScripts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/**
 * Class for additional hooks
 *
 * @author Patrik_Horvath
 * */
public class FunctionalTest {
    protected static WebDriver driver;
    /**
     * Runs before every test
     * Setup the driver and initializing the implicit wait
     * */
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    /**
     * Runs after every test
     * Closes the driver
     * */
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    /**
     * Deletes the cookies
     * */
    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
