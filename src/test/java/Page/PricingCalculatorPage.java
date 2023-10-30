package Page;

import Utils.XPathExtractor;
import model.ComputerEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.XPathExtractor.extractXPathFromWebElement;

public class PricingCalculatorPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/products/calculator";

    @FindBy(xpath = "//md-tab-item//span[text() = 'Compute Engine']")
    WebElement computerEngineTab;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement iframe1;

    @FindBy(id = "myFrame")
    private WebElement iframe2;

    @FindBy(id = "input_99")
    private WebElement numberOfInstance;
    @FindBy(id = "input_100")
    private WebElement whatAreTheseInstancesFor;
    @FindBy(xpath = "//label[text()= 'Operating System / Software']/following-sibling::md-select[@role='listbox']")
    private WebElement operatingSystemSoftware;
    @FindBy(xpath = "//label[text()= 'Provisioning model']/following-sibling::md-select[@role='listbox']")
    private WebElement provisioningModel;
    @FindBy(xpath = "//label[text()= 'Series']/following-sibling::md-select[@role='listbox']")
    private WebElement series;
    @FindBy(xpath = "//label[text()= 'Machine type']/following-sibling::md-select[@role='listbox']")
    private WebElement machineType;

    @FindBy(xpath = "(//div[contains(text(),'Add GPUs')])[1]")
    private WebElement addGPUsCheckbox;
    @FindBy(xpath = "//label[text()= 'GPU type']/following-sibling::md-select[@role='listbox']")
    private WebElement GPUType;
    @FindBy(xpath = "//label[text()= 'Number of GPUs']/following-sibling::md-select[@role='listbox']")
    private WebElement numbersOfGPUs;
    @FindBy(xpath = "//label[text()= 'Local SSD']/following-sibling::md-select[@role='listbox']")
    private WebElement localSSD;
    @FindBy(xpath = "//label[text()= 'Datacenter location']/following-sibling::md-select[@role='listbox']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//*[@id='input_131']")
    private WebElement datacenterInputField;
    @FindBy(xpath = "//label[text()= 'Committed usage']/following-sibling::md-select[@role='listbox']")
    private WebElement committedUsage;
    @FindBy(xpath = " //h2[contains(text(),'Instances')]/..//button[contains(text(),'Add to Estimate')]")
    private WebElement instancesAddToEstimateButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PricingCalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public PricingCalculatorPage chooseComputerEngineTab() {
        switchToFormFrame();
        computerEngineTab.click();
        return this;
    }

    private PricingCalculatorPage switchToFormFrame() {

        driver.switchTo().frame(iframe1).switchTo().frame(iframe2);

        return this;
    }

    public PricingCalculatorPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }


    public PricingCalculatorPage fillComputerEngineForm(ComputerEngine computerEngine) throws InterruptedException {

        switchToFormFrame();

        numberOfInstance.sendKeys(computerEngine.getNumberOfInstance());

        selectOption(whatAreTheseInstancesFor, computerEngine.getWhatAreTheseInstancesFor());
        selectOption(operatingSystemSoftware, computerEngine.getOperatingSystemSoftware());
        selectOption(provisioningModel, computerEngine.getProvisioningModel());
        selectOption(series, computerEngine.getSeries());
        selectOption(machineType, computerEngine.getMachineType());

        addGPUsCheckbox.click();

        selectOption(GPUType, computerEngine.getGPUType());
        selectOption(numbersOfGPUs,computerEngine.getNumbersOfGPUs());
//        numbersOfGPUs.sendKeys(computerEngine.getNumbersOfGPUs());
        selectOption(localSSD, computerEngine.getLocalSSD());


        selectOption(datacenterLocation, computerEngine.getDatacenterLocation());




        selectOption(committedUsage, computerEngine.getCommittedUsage());

        instancesAddToEstimateButton.click();


        return this;
    }

    private void selectOption(WebElement webElement, String option) {
        if (!option.isBlank()) {

            String optionXpath = String.format(" //div[contains(@id,'select_container') and @aria-hidden = 'false']//div[contains(text(),'%s')]", option);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", webElement);

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(webElement))
                    .click();

            WebElement optionElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));

            System.out.println(optionElement.isDisplayed() + " : " + option);
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", optionElement);

//            System.out.println("\n" + extractXPathFromWebElement(webElement) + "/*" + String.format("//md-option[@role='option']/*[contains(text(),'%s')]", option) + "\n");

            optionElement.click();


        }


    }
}
