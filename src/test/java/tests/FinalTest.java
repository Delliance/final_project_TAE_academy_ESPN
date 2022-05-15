package tests;

import dataproviders.PageDataProvider;
import dataproviders.pojos.PageRequiredData;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import util.pages.BasePage;
import util.tests.BaseTest;
import static org.testng.Assert.*;

public class FinalTest extends BaseTest {

    Logger logger = Logger.getLogger(FinalTest.class);

    @Test (description = "Test final project", dataProviderClass = PageDataProvider.class, dataProvider = "pageData")
    public void finalExamTest(PageRequiredData data) {
        logger.info("Checking that the logo of the home page is visible");
        assertEquals(homePage.getTextLogo(), data.getWebPageName(), "The text in the logo does not match, please check you're in the correct webpage");
        logger.info("Checking that you're not logged in");
        assertTrue(homePage.isLeftLoginMenuVisible(), "The left menu is not visible, check that you're logged out");
        homePage.hoverUserMenu();
        logger.info("Checking that the hover menu was opened correctly");
        assertTrue(homePage.checkIfUserHoverMenuIsVisible(), "The hover menu is not visible");
        BasePage loginSingUpIFrame = homePage.clickButtonUserMenuLogin();


//        logger.info("Checking that the logo of the home page is visible");
//        assertTrue(homePage.checkLogoIsVisible()); //TODO: change this locator it only works in spanish
//        logger.info("Sending the keys for the departure flight");
//        homePage.sendKeyFromFlight("LAS"); //TODO: change this into a data provider
//        homePage.clickFromLasVegas();
//        homePage.sendKeyToFlight("BOG"); //TODO: change this into a data provider
//        homePage.clickToBogota();
//        homePage.clickDepartureDate();
//        homePage.clickNextMonthInCalendar();
//        homePage.clickDepartureDay15OfCurrentMonthPlusTwo();
//        homePage.clickArrivalDate();
//        homePage.clickNextMonthInCalendar();
//        homePage.clickArrivalDay15OfCurrentMonthPlusFour();
//        homePage.clickPassengers();
//        homePage.clickAddAdult();
//        homePage.clickSubmitButton();
    }
}
