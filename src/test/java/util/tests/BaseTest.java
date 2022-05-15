package util.tests;

import com.taeacademy.Driver;
import dataproviders.PageDataProvider;
import listeners.EventReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {

    private EventFiringWebDriver driver;

    protected HomePage homePage;

    private PageDataProvider pageDataProvider; //TODO check if this is necessary here

    public Logger logger;

    public BaseTest() {
        this.pageDataProvider = new PageDataProvider();
        this.logger = Logger.getLogger(BaseTest.class);
    }

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

    @BeforeMethod
    @Parameters({"webPage"})
    public void goHome(String webPage) {
        driver.get(webPage);
    }

//    @AfterTest
    public void quit() {
        driver.quit();
    }
}
