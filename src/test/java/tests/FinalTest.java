package tests;

import dataproviders.PageDataProvider;
import dataproviders.pojos.PageRequiredData;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.iframes.LoginSingUpIFrame;
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
        //start of step 2 of the project
        LoginSingUpIFrame singUpIFrame = homePage.clickButtonUserMenuLogin();
        logger.info("Checking that the IFrame was opened correctly");
        assertEquals(singUpIFrame.getTextLogo(), data.getIFrameLogoName(), "The text in the logo does not match, check that the Iframe was correctly opened");
        assertTrue(singUpIFrame.checkButtonLoginIsDisplayed(), "The login button is not displayed, check that the Iframe was correctly opened");
        assertTrue(singUpIFrame.checkButtonSingUpIsDisplayed(), "The sing up button is not displayed, check that the Iframe was correctly opened");
        //end of step 2 of the project
        //start of step 3 of the project
        singUpIFrame.clickSingUp();
        logger.info("Checking that the Sing up options appeared");
        assertEquals(singUpIFrame.getTextSingUpTitle(), data.getSingUpTitle(), "The text in the Sing up title does not match, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkInputFirstNameIsDisplayed(), "The input is not displayed, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkInputLastNameIsDisplayed(), "The input is not displayed, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkInputEmailIsDisplayed(), "The input is not displayed, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkInputPasswordIsDisplayed(), "The input is not displayed, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkIfButtonConfirmSingUpIsEnabled(), "The button is not enabled, please check if the sing up menu is visible");
        assertTrue(singUpIFrame.checkIfButtonCloseIsEnabled(), "The button is not enabled, please check if the sing up menu is visible");
        //end of step 3
        //start of step 4
        logger.info("Creating a new user:\n" + data.getUser().toString());
        singUpIFrame.setInputFirstName(data.getUser().getFirstName());
        singUpIFrame.setInputLastName(data.getUser().getLastName());
        singUpIFrame.setInputEmail(data.getUser().getEmail());
        singUpIFrame.setInputPassword(data.getUser().getPassword());
        HomePage homePageAccountCreated = singUpIFrame.clickButtonConfirmSingUp();
        //end of step 4
        logger.info("Waiting for the home page to load");
        assertEquals(homePageAccountCreated.getTextLogo(), data.getWebPageName(), "The text in the logo does not match, please check you're in the correct webpage");
        logger.info("Checking that you're logged in");
        assertTrue(homePageAccountCreated.isLeftLoginMenuNotVisible());


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
