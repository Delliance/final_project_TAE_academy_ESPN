package util.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import  util.CustomWait;

public class BasePage {

    private WebDriver driver;

    private Actions actions;

    private CustomWait wait;

    private Logger logger;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new CustomWait(driver);
        this.logger = Logger.getLogger(BasePage.class);
    }

    protected void goBack() {
        driver.navigate().back();
    }

    protected void scrollDown(int timesToScroll) {
        logger.info("Scrolling down " + timesToScroll + " times");
        int scrolledTimes = 0;
        while (scrolledTimes < timesToScroll) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            scrolledTimes++;
        }
    }

    protected void scrollUp(int timesToScroll) {
        logger.info("Scrolling up " + timesToScroll + " times");
        int scrolledTimes = 0;
        while (scrolledTimes < timesToScroll) {
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            scrolledTimes++;
        }
    }

    protected void scrollToElement(WebElement element) {
        //TODO check if this method works
        try {
            logger.info("Scrolling down to: " + element.getText());
        }
        catch (Exception e) {
            logger.info("Scrolling down to: " + element.getTagName());
        }
        try {
            wait.minWait(element);
            element.isDisplayed();
        }
        catch (NoSuchElementException e) {
            actions.moveToElement(element).perform();
        }
    }

    protected void click(WebElement element) {
        wait.mediumWait(element);
        element.click();
    }

    protected BasePage clickChangePage(WebElement element, BasePage page) {
        wait.shortWait(element);
        element.click();
        return page;
    }

    protected void sendKeys(WebElement element, String key) {
        wait.mediumWait(element);
        element.sendKeys(key);
    }

    protected String getText(WebElement element) {
        wait.shortWait(element);
        wait.waitForTextToAppear(element);
        return element.getText();
    }

    protected boolean checkIfElementIsDisplayed(WebElement element) {
        wait.shortWait(element);
        return element.isDisplayed();
    }

    protected void hover(WebElement element) {
        wait.shortWait(element);
        actions.moveToElement(element).build().perform();
    }

}
