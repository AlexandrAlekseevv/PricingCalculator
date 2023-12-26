package Page.YopMail;

import Page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailMain extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Random Email generator']")
    private WebElement generateEmailButton;

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

    public EmailGenerator generateRandomlyEmail() {
        generateEmailButton.click();
        new ADSGoogleVignette(driver).closeADSVignette();
        return new EmailGenerator(driver);
    }





}
