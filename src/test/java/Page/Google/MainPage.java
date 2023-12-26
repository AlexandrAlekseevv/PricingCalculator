package Page.Google;

import Page.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchButton;


    @Override
    public MainPage openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(BASE_URL);
        return this;

    }

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public SearchResultsPage invokePageWithSearchResults(String searchText){
        searchButton.sendKeys(searchText , Keys.ENTER);
        return new SearchResultsPage(driver);
    }



}
