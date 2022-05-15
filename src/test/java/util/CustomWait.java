package util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CustomWait {

    private final int MIN_WAIT_SECONDS = 1;

    private final int SHORT_WAIT_SECONDS = 5;

    private final int NORMAL_WAIT_SECONDS = 15;

    private final int MEDIUM_WAIT_SECONDS = 30;

    private final int LONG_WAIT_SECONDS = 60;

    private WebDriverWait wait;

    private Wait<WebDriver> fluentWait;

    private WebDriver driver;

    public CustomWait(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 1 second wait
     *
     * @author Daniel.Gonzalez
     *
     * @param element WebElement
     */
    public void minWait(WebElement element) {
        wait = new WebDriverWait(driver, MIN_WAIT_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 5 second wait
     *
     * @author Daniel.Gonzalez
     *
     * @param element WebElement
     */
    public void shortWait(WebElement element) {
        wait = new WebDriverWait(driver, SHORT_WAIT_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 15 second wait
     *
     * @author Daniel.Gonzalez
     *
     * @param element WebElement
     */
    public void normalWait(WebElement element) {
        wait = new WebDriverWait(driver, NORMAL_WAIT_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 30 second wait
     *
     * @author Daniel.Gonzalez
     *
     * @param element WebElement
     */
    public void mediumWait(WebElement element) {
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(MEDIUM_WAIT_SECONDS))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * 60 second wait
     *
     * @author Daniel.Gonzalez
     *
     * @param element WebElement
     */
    public void LongWait(WebElement element) {
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(LONG_WAIT_SECONDS))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait until text has any number of letter > 0
     *
     * @author Daniel.Gonzalez
     *
     * @param element
     */
    public void waitForTextToAppear(WebElement element) {
        //TODO check if this method works
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.getText().length() != 0;
            }
        });
    }

    /**
     * Wait until the parameter of an element is the specified one
     *
     * @author Daniel.Gonzalez
     *
     * @param element element to check attribute of
     * @param attribute attribute of the element
     * @param attributeValue value of the attribute
     */
    public void expectedCondition(WebElement element, String attribute, String attributeValue) {
        wait = new WebDriverWait(driver, SHORT_WAIT_SECONDS);
        wait.until(ExpectedConditions.attributeToBe(element, attribute, attributeValue));
    }

}
