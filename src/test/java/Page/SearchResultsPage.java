package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/s/results";
    protected SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
