package Page.Google;

import Page.AbstractPage;
import model.ComputerEngine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;


public class PricingCalculatorLegacyPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/products/calculator-legacy";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//md-tab-item//span[text() = 'Compute Engine']")
    WebElement computerEngineTab;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement iframe1;

    @FindBy(id = "myFrame")
    private WebElement iframe2;

    @FindBy(id = "input_100")
    private WebElement numberOfInstance;
    @FindBy(id = "input_101")
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

    @FindBy(xpath = "//div[@class = 'cpc-cart-total']/h2/b")
    WebElement totalPriceOfEstimate;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @Override
    public PricingCalculatorLegacyPage openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;

    }

    public PricingCalculatorLegacyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PricingCalculatorLegacyPage chooseComputerEngineTab() {
        switchToFormFrame();
        computerEngineTab.click();
        return this;
    }

    private void switchToFormFrame() {

        driver.switchTo().frame(iframe1).switchTo().frame(iframe2);

    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public PricingCalculatorLegacyPage sendPriceToEmail(){
        switchToFormFrame();
        emailEstimateButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.id("input_620")))
                .sendKeys(Keys.CONTROL + "v");

        sendEmailButton.click();
        return this;
    }

    public PricingCalculatorLegacyPage fillComputerEngineForm(ComputerEngine computerEngine) {

        switchToFormFrame();
        computerEngineTab.click();

        numberOfInstance.sendKeys(computerEngine.getNumberOfInstance());

        selectOptionInDropDown(whatAreTheseInstancesFor, computerEngine.getWhatAreTheseInstancesFor());
        selectOptionInDropDown(operatingSystemSoftware, computerEngine.getOperatingSystemSoftware());
        selectOptionInDropDown(provisioningModel, computerEngine.getProvisioningModel());
        selectOptionInDropDown(series, computerEngine.getSeries());
        selectOptionInDropDown(machineType, computerEngine.getMachineType());

        addGPUsCheckbox.click();

        selectOptionInDropDown(GPUType, computerEngine.getGPUType());
        selectOptionInDropDown(numbersOfGPUs, computerEngine.getNumbersOfGPUs());

        selectOptionInDropDown(localSSD, computerEngine.getLocalSSD());


        selectOptionInDropDown(datacenterLocation, computerEngine.getDatacenterLocation());


        selectOptionInDropDown(committedUsage, computerEngine.getCommittedUsage());

        instancesAddToEstimateButton.click();

        logger.info("Created new Estimate: [" + computerEngine + "]");

        return this;
    }

    private void selectOptionInDropDown(WebElement dropDownElement, String option) {
        if (!option.isBlank()) {
            String optionXpath = String.format(" //div[contains(@id,'select_container') and @aria-hidden = 'false']//div[contains(text(),'%s')]", option);

            scrollPageTo(dropDownElement);

            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(dropDownElement))
                    .click();

            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)))
                    .click();
        }
    }

    public String getTotalPriceOfEstimate() {
        return totalPriceOfEstimate.getText();
    }
}
