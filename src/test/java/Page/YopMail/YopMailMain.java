package Page.YopMail;

import Page.AbstractPage;
import Page.Google.PricingCalculatorLegacyPage;
import Utils.BrowserNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailMain extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Random Email generator']")
    private WebElement generateEmailButton;

    @FindBy(id ="cprnd")
    private WebElement copyToClipboardButton;

    @FindBy(xpath = "//button/*[contains(text(),'Check Inbox')]")
    private WebElement checkInboxButton;



//    @FindBy(xpath = "//*[@id='dismiss-button']")
//    private WebElement closeADButton;
//    @FindBy(xpath = "/html/ins/div/iframe")
//    private WebElement iframe1;
//
//    @FindBy(id = "ad_iframe")
//    private WebElement iframe2;


    private final static String PAGE_URL = "https://yopmail.com/";

    public YopMailMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public YopMailMain openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;

    }

    public PricingCalculatorLegacyPage generateRandomlyEmail() {
        BrowserNavigation browserNavigation = BrowserNavigation.getInstance();
        generateEmailButton.click();
        new ADSGoogleVignette(driver).closeADSVignette();
        copyToClipboardButton.click();
        browserNavigation.switchToTab(1);
        return new PricingCalculatorLegacyPage(driver);
    }

    public YopMailInboxPage checkInbox(){
        checkInboxButton.click();
        return new YopMailInboxPage(driver);
    }




}
