package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends AbstractPage {


    @FindBy(xpath = "//input[@placeholder = 'Search' and @class ='catalog-filter-bar gc-analytics-event']")
    WebElement searchField;

    private final String PAGE_URL = "https://cloud.google.com/s/results";

    protected SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);

    }

    public PricingCalculatorPage openSearchedPage(String searchingText) {
        List<WebElement> resultsList = driver.findElements(By.xpath("//div[@class='gs-title']/a/b[ text() ='" + searchingText + "']"));
        resultsList.get(0).click();
        return new PricingCalculatorPage(driver);

    }

    @Override
    protected SearchResultsPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }


}
