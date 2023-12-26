package Page.Google;

import Page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage extends AbstractPage {

    private static final String PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div[2]/div[1]/div/div[2]/div/button")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/div[5]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div/div/span[2]/a")
    private WebElement pricingCalculatorLegacyLink;

    @FindBy(xpath = "//*[@id=\"apiproxyb3f8403c17d5ee084afb36cc24c18a2f1153179b0.2648869927\"]")
    private WebElement formFrame;

    protected PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected AbstractPage openPage(boolean currentTab) {
        if (!currentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;

    }

    public PricingCalculatorPage addToEstimate() {

        addToEstimateButton.click();
        return this;
    }



    public PricingCalculatorLegacyPage switchToPricingCalculatorLegacyPage() {

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pricingCalculatorLegacyLink))
                .click();

        java.util.Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
        }



        return new PricingCalculatorLegacyPage(driver);

    }
}
