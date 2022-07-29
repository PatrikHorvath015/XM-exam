package TestScripts;

import PageObjects.*;
import Utils.Utils;
import org.junit.Test;
import org.openqa.selenium.Dimension;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EconomicCalendarTest extends FunctionalTest {
    /**
     * Opens up the homepage of the application
     * Then navigating to the Economic Calendar Page
     * On this page, trying to change the selected time interval
     * After that its opening up the risk page and the pdf
     *
     * @author Patrik_Horvath
     * */
    @Test
    public void CheckTimestampButtonsDateSelectorAndTheRiskPage() throws InterruptedException {
        driver.get(Utils.URL);

        WelcomePage welcomePage = new WelcomePage(driver);
        Dimension dimension = new Dimension(Utils.SCREEN_WIDTH, Utils.SCREEN_HEIGHT);
        driver.manage().window().setSize(dimension);

        welcomePage.clickOnAcceptCookiesButton();
        assertTrue("Welcome page did not open up", welcomePage.isInitialized());

        welcomePage.clickOnResearchAndEducation(dimension);
        ResearchAndEducationPage researchAndEducationPage = new ResearchAndEducationPage(driver);
        assertTrue("Research and Education page did not open up", researchAndEducationPage.isInitialized(dimension));

        researchAndEducationPage.clickOnEconomicCalendar();
        EconomicCalendarPage economicCalendarPage = new EconomicCalendarPage(driver);
        economicCalendarPage.stepIntoTheFrame();
        assertTrue("Economic calendar page did not open up", economicCalendarPage.isInitialized());

        long todayDateInMills = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - dd/MM/yyyy");

        economicCalendarPage.clickToYesterdayButton(dimension);
        Thread.sleep(3000); //Neccesery, sometimes the date is not refreshing instantly
        assertEquals("Yesterday's date is incorrect", formatter.format(new Date(todayDateInMills - Utils.ONE_DAY_IN_MILLS)), economicCalendarPage.getEconomicCalendarDate());

        economicCalendarPage.clickToTodayButton(dimension);
        Thread.sleep(3000); //Neccesery, sometimes the date is not refreshing instantly
        assertEquals("Today's date is incorrect", formatter.format(new Date(todayDateInMills)), economicCalendarPage.getEconomicCalendarDate());

        economicCalendarPage.clickToTomorrowButton(dimension);
        Thread.sleep(3000); //Neccesery, sometimes the date is not refreshing instantly
        assertEquals("Tomorrow's date is incorrect", formatter.format(new Date(todayDateInMills + Utils.ONE_DAY_IN_MILLS)), economicCalendarPage.getEconomicCalendarDate());

        economicCalendarPage.clickToThisWeekButton(dimension);
        Thread.sleep(3000); //Neccesery, sometimes the date is not refreshing instantly
        //assertEquals(formatter.format(new Date()), economicCalendarPage.getEconomicCalendarDate());//TODO;

        economicCalendarPage.leaveTheFrame();
        economicCalendarPage.clickToTheHereButton();

        ResearchAndRiskWarningPage researchAndRiskWarningPage = new ResearchAndRiskWarningPage(driver);
        assertTrue("Research and Risk Warning page did not open up", researchAndRiskWarningPage.isInitialized());

        researchAndRiskWarningPage.clickToTheHereButton();
        RiskDisclosuresPage riskDisclosuresPage = new RiskDisclosuresPage(driver);
        assertEquals("Titles are not matching", "Economic Calendar", riskDisclosuresPage.getTitle());
    }
}
