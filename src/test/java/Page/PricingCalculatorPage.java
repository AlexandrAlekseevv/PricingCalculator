package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorPage extends AbstractPage{

    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

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
