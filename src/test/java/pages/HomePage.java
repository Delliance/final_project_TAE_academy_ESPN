package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.iframes.LoginSingUpIFrame;
import util.pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.container h1 a")
    private WebElement logo;

    @FindBy(id = "sideLogin-left-rail")
    private WebElement sideLoginMenu;

    @FindBy(id = "global-user-trigger")
    private WebElement userMenu;

    @FindBy(css = "#header-wrapper div.global-user-container li:nth-child(7) a")
    private WebElement buttonUserMenuLogIn;

    @FindBy(id = "oneid-iframe")
    private WebElement iFrameLogIn;

    private WebElement headerUserMenuWelcomeMessage;

    private WebElement buttonUserMenuLogOut;

    public String getTextLogo() {
        return getText(logo);
    }

    public boolean isLeftLoginMenuVisible() {
        return checkAttributeOfElement(sideLoginMenu, "style", "display: block;");
    }

    public void hoverUserMenu() {
        hover(userMenu);
    }

    public boolean checkIfUserHoverMenuIsVisible() {
        return checkIfElementIsDisplayed(userMenu);
    }

    public BasePage clickButtonUserMenuLogin() {
        return clickOpenIFrame(buttonUserMenuLogIn, iFrameLogIn, new LoginSingUpIFrame(driver));
    }

}
