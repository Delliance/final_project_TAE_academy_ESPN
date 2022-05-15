package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.pages.BasePage;

import java.util.List;

public class WatchPage extends BasePage {

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "Carousel")
    private List<WebElement> carouselList;

    @FindBy(className = "MediaPlaceholder")
    private List<WebElement> allCarouselCardList;

    @FindBy(className = "WatchTile__Title")
    private List<WebElement> allCardTitleList;

    @FindBy(className = "WatchTile__Meta")
    private List<WebElement> allCardDescriptionList;

    @FindBy(css = "#fittPageContainer div:first-child section.Carousel li:nth-child(2) .MediaPlaceholder")
    private WebElement firstCarouselSecondCard;

    @FindBy(className = "lightbox__contentBox")
    private WebElement containerBox;

    @FindBy(css = ".lightbox__contentBox .icon--color")
    private WebElement buttonCloseContainerBox;

    public boolean checkThatAtLeastOneCarouselIsPresent() {
        return checkThatAtLeastOneElementExistsInList(carouselList);
    }

    public boolean checkNumberOfCardsMatchesNumberOfCardTitles() {
        return numberOfWebElementsMatchesOtherWebElements(allCarouselCardList, allCardTitleList);
    }

    public boolean checkNumberOfCardsMatchesNumberOfCardDescriptions() {
        return numberOfWebElementsMatchesOtherWebElements(allCarouselCardList, allCardDescriptionList);
    }

    public void clickFirstCarouselSecondCard() {
        click(firstCarouselSecondCard);
    }

    public boolean checkThatContainerBoxIsDisplayed() {
        return checkIfElementIsDisplayed(containerBox);
    }

    public boolean checkThatContainerBoxCloseButtonIsDisplayed() {
        return checkIfElementIsEnabled(buttonCloseContainerBox);
    }

    public void clickContainerBoxCloseButton() {
        click(buttonCloseContainerBox);
    }

    public boolean checkThatContainerBoxIsClosed() {
        return !checkThatElementExistsInPage(containerBox);
    }

    public HomePage goBackToHomePage() {
        return goBackToPage(new HomePage(driver));
    }
}
