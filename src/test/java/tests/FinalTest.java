package tests;

import dataproviders.PageDataProvider;
import dataproviders.pojos.PageRequiredData;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WatchPage;
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
        assertTrue(homePage.isLeftLoginMenuVisible(), "The side menu is not visible, check that you're logged out");
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
        assertTrue(homePageAccountCreated.isLeftLoginMenuNotVisible(), "The side menu is visible, check that you correctly logged in");
        //start of step 5
        WatchPage watchPage = homePageAccountCreated.clickButtonWatch();
        logger.info("Checking that you correctly entered the Watch page");
        assertTrue(watchPage.checkThatAtLeastOneCarouselIsPresent(), "There are not Carousels in the page, check that you correctly entered the Watch page");
        assertTrue(watchPage.checkNumberOfCardsMatchesNumberOfCardTitles(), "The number of cards does not match the number of titles");
        assertTrue(watchPage.checkNumberOfCardsMatchesNumberOfCardDescriptions(), "The number of cards does not match the number of descriptions");
        //end of step 5
        //start of step 6
        watchPage.clickFirstCarouselSecondCard();
        logger.info("Checking that the container box is displayed");
        assertTrue(watchPage.checkThatContainerBoxIsDisplayed(), "The container box is not displayed, please check that the card was correctly clicked");
        assertTrue(watchPage.checkThatContainerBoxCloseButtonIsDisplayed(), "The close container box button is not displayed, please check that the card was correctly clicked");
        //end of step 6
        //start of step 7
        watchPage.clickContainerBoxCloseButton();
        //end of step 7
        logger.info("Checking that the container box is not displayed");
        assertTrue(watchPage.checkThatContainerBoxIsClosed());
        //start of step 8
        HomePage homePageBackFromWatch = watchPage.goBackToHomePage();
        logger.info("Waiting for the home page to load");
        assertEquals(homePageBackFromWatch.getTextLogo(), data.getWebPageName(), "The text in the logo does not match, please check you're in the correct webpage");
        logger.info("Checking that you're back at the home page while logged in");
        assertTrue(homePageBackFromWatch.isLeftLoginMenuNotVisible(), "The side menu is visible, check that you correctly logged in");
        //end of step 8
        //start of step 9
        logger.info("Checking that the user name in the webpage matches the input first name " + data.getUser().getFirstName());
        homePageBackFromWatch.hoverUserMenu();
        logger.info("Checking that the hover menu was opened correctly");
        assertTrue(homePageBackFromWatch.checkIfUserHoverMenuIsVisible(), "The hover menu is not visible");
        assertEquals(homePageBackFromWatch.getHeaderUserMenuText(), data.getUserMenuHeaderLoggedIn(), "The welcome message does not have the name of the user, check that you properly logged in");
        //end of step 9
        //start of step 10
        HomePage homePageLoggedOut = homePageBackFromWatch.clickButtonUserMenuLogOut();
        logger.info("Waiting for the home page to load");
        assertEquals(homePageLoggedOut.getTextLogo(), data.getWebPageName(), "The text in the logo does not match, please check you're in the correct webpage");
        logger.info("Checking that you're back to the home page logged out");
        assertTrue(homePageLoggedOut.isLeftLoginMenuVisible(), "The side menu is not visible, check that you're logged out");
        homePageLoggedOut.hoverUserMenu();
        logger.info("Checking that the hover menu was opened correctly");
        assertTrue(homePageLoggedOut.checkIfUserHoverMenuIsVisible());
        assertEquals(homePageLoggedOut.getHeaderUserMenuText(), data.getUserMenuHeaderLoggedOut(), "The welcome message does not match, check that you properly logged out");
        //end of step 10
        logger.info("Congratulations! The test finished successfully");
    }
}
