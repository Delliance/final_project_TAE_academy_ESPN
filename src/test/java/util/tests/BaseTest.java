package util.tests;

import com.taeacademy.Driver;
import dataproviders.PageDataProvider;
import listeners.EventReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {

    /** Web page firing driver */
    private EventFiringWebDriver driver;

    /** Starting page, Home page*/
    protected HomePage homePage;

    /** Logger */
    public Logger logger;

    /**
     * Constructor method for the base test
     *
     * @author Daniel.Gonzalez
     */
    public BaseTest() {
        this.logger = Logger.getLogger(BaseTest.class);
    }

    /**
     * Before test method to set up driver and web page
     *
     * @param browser browser driver to use
     * @param webPage starting web page for the test
     */
    @BeforeTest
    @Parameters({"browser", "webPage"})
    public void setUp(String browser, String webPage) {
        driver = new Driver(browser).getDriver();
        driver.register(new EventReporter());
        goHome(webPage);
        logger.info(driver.getTitle());
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    /**
     * Loading method to reload the main page before each method
     *
     * @param webPage starting web page for the test
     */
    @BeforeMethod
    @Parameters({"webPage"})
    public void goHome(String webPage) {
        driver.get(webPage);
    }

    /**
     * Quit driver method to close the test
     */
    @AfterTest
    public void quit() {
        driver.quit();
    }
}
