package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchButton;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public SearchResultsPage invokePageWithSearchResults(String searchText){
        searchButton.click();
        searchButton.sendKeys(searchText + "\n");
        return new SearchResultsPage(driver);
    }


    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
