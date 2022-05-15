package pages.iframes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import util.pages.BasePage;

public class LoginSingUpIFrame extends BasePage {

    public LoginSingUpIFrame(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "logo")
    private WebElement logo;

    @FindBy(id = "BtnSubmit")
    private WebElement buttonLogin;

    @FindBy(id = "BtnCreateAccount")
    private WebElement buttonSingUp;

    @FindBy(css = "#Title span")
    private WebElement titleSingUp;

    @FindBy(id = "InputFirstName")
    private WebElement inputFirstName;

    @FindBy(id = "InputLastName")
    private WebElement inputLastName;

    @FindBy(id = "InputEmail")
    private WebElement inputEmail;

    @FindBy(id = "password-new")
    private WebElement inputPassword;

    @FindBy(id = "BtnSubmit")
    private WebElement buttonConfirmSingUp;

    @FindBy(id = "close")
    private WebElement buttonClose;

    public String getTextLogo() {
        return getText(logo);
    }

    public boolean checkButtonLoginIsDisplayed() {
        return checkIfElementIsDisplayed(buttonLogin);
    }

    public boolean checkButtonSingUpIsDisplayed() {
        return checkIfElementIsDisplayed(buttonSingUp);
    }

    public void clickSingUp() {
        click(buttonSingUp);
    }

    public String getTextSingUpTitle() {
        return getText(titleSingUp);
    }

    public boolean checkInputFirstNameIsDisplayed() {
        return checkIfElementIsDisplayed(inputFirstName);
    }

    public boolean checkInputLastNameIsDisplayed() {
        return checkIfElementIsDisplayed(inputLastName);
    }

    public boolean checkInputEmailIsDisplayed() {
        return checkIfElementIsDisplayed(inputEmail);
    }

    public boolean checkInputPasswordIsDisplayed() {
        return checkIfElementIsDisplayed(inputPassword);
    }

    public boolean checkIfButtonConfirmSingUpIsEnabled() {
        return checkIfElementIsEnabled(buttonConfirmSingUp);
    }

    public boolean checkIfButtonCloseIsEnabled() {
        return checkIfElementIsEnabled(buttonClose);
    }

    public void setInputFirstName(String firstName) {
        sendKeys(inputFirstName, firstName);
    }

    public void setInputLastName(String lastName) {
        sendKeys(inputLastName, lastName);
    }

    public void setInputEmail(String email) {
        sendKeys(inputEmail, email);
    }

    public void setInputPassword(String password) {
        sendKeys(inputPassword, password);
    }

    public HomePage clickButtonConfirmSingUp() {
        return clickCloseIFrameAndOpenNewPage(buttonConfirmSingUp, new HomePage(driver));
    }



}
