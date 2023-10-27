package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorPage extends AbstractPage{

    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-tab-item//span[text() = 'Compute Engine']")
    WebElement computerEngineTab;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public PricingCalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
