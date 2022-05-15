package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement logo;

    private WebElement buttonUserHoverLogIn;

    private WebElement buttonUserHoverSingUp;

    private WebElement headerUserHoverWelcomeMessage;

    private WebElement buttonUserHoverLogOut;

}
