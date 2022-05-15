package pages.iframes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.pages.BasePage;

public class LoginSingUpIFrame extends BasePage {

    public LoginSingUpIFrame(WebDriver driver) {
        super(driver);
    }

    private WebElement buttonLogin;

    private WebElement buttonSingUp;

    private WebElement titleSingUp;

    private WebElement inputFirstName;

    private WebElement inputLastName;

    private WebElement inputEmail;

    private WebElement inputPassword;

    private WebElement buttonConfirmSingUp;

    private WebElement buttonClose;
}
