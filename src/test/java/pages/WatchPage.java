package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.pages.BasePage;

import java.util.List;

public class WatchPage extends BasePage {

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> carouselList;

    private WebElement buttonCloseSecondCard;
}
