package com.taeacademy;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Driver {

    private EventFiringWebDriver driver;

    public Driver(String browser) {
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new EventFiringWebDriver(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new EventFiringWebDriver(new FirefoxDriver());
                break;

            default:
                throw new NotFoundException("That driver does not exist, check if it it was written correctly or install it");
        }
    }

    public EventFiringWebDriver getDriver() {
        return driver;
    }
}