package util.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import  util.CustomWait;

public class BasePage {

    /** Driver */
    protected WebDriver driver;

    /** Web page actions */
    private Actions actions;

    /** Custom waits */
    private CustomWait wait;

    /** Logger */
    private Logger logger;

    /**
     * Constructor method for standard web page objects.
     *
     * @author Daniel.Gonzalez
     *
     * @param driver
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new CustomWait(driver);
        this.logger = Logger.getLogger(BasePage.class);
    }

    /**
     * Go back to previous screen.
     *
     * @author Daniel.Gonzalez
     */
    protected void goBack() {
        driver.navigate().back();
    }

    /**
     * Scroll down a specific number of times
     *
     * @author Daniel.Gonzalez
     *
     * @param timesToScroll number of times to scroll down
     */
    protected void scrollDown(int timesToScroll) {
        logger.info("Scrolling down " + timesToScroll + " times");
        int scrolledTimes = 0;
        while (scrolledTimes < timesToScroll) {
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();
            scrolledTimes++;
        }
    }

    /**
     * Scroll up a specific number of times
     *
     * @author Daniel.Gonzalez
     *
     * @param timesToScroll number of times to scroll down
     */
    protected void scrollUp(int timesToScroll) {
        logger.info("Scrolling up " + timesToScroll + " times");
        int scrolledTimes = 0;
        while (scrolledTimes < timesToScroll) {
            actions.sendKeys(Keys.PAGE_UP).build().perform();
            scrolledTimes++;
        }
    }

    /**
     * Scroll to element
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to scroll to
     */
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

    /**
     * Click on element
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to be clicked
     */
    protected void click(WebElement element) {
        wait.mediumWait(element);
        element.click();
    }

    /**
     * Click on element and open a new page
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to be clicked
     * @param page page you change after click
     * @return the page you change after click
     */
    protected BasePage clickOpenNewPage(WebElement element, BasePage page) {
        wait.shortWait(element);
        element.click();
        return page;
    }

    /**
     * Click on element and opena an IFrame
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to be clicked
     * @param iFrameElement IFrame web element to be displayed
     * @param iFrame IFrame page
     * @return IFrame
     */
    protected BasePage clickOpenIFrame(WebElement element, WebElement iFrameElement, BasePage iFrame) {
        wait.shortWait(element);
        element.click();
        driver.switchTo().frame(iFrameElement);
        return iFrame;
    }

    /**
     * Send keys to a Web element that allows it
     *
     * @author Daniel.Gonzalez
     *
     * @param element Web element to send the keys
     * @param key Text that you want to send to the element
     */
    protected void sendKeys(WebElement element, String key) {
        wait.mediumWait(element);
        element.sendKeys(key);
    }

    /**
     * Get text from a Web element
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to get text from
     * @return text contained in the element
     */
    protected String getText(WebElement element) {
        wait.shortWait(element);
        wait.waitForTextToAppear(element);
        return element.getText();
    }

    /**
     * Check if an element is displayed
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to be checked
     * @return if the element is displayed it will be true
     */
    protected boolean checkIfElementIsDisplayed(WebElement element) {
        wait.shortWait(element);
        return element.isDisplayed();
    }

    /**
     * Hover over a web element
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to be hovered on
     */
    protected void hover(WebElement element) {
        wait.shortWait(element);
        actions.moveToElement(element).build().perform();
    }


    protected boolean checkAttributeOfElement(WebElement element, String attribute, String attributeValue) {
        wait.shortWait(element);
        try {
            wait.expectedCondition(element, attribute, attributeValue);
            return true;
        }
        catch (TimeoutException e) {
            return false;
        }
    }

}
