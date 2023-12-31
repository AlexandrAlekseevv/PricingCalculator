package Page.YopMail;

import Page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ADSGoogleVignette extends AbstractPage {
    private final static String PAGE_URL = "https://yopmail.com/#google_vignette";

    @FindBy(xpath = "/html/ins/div/iframe")
    private WebElement iframe1;

    @FindBy(id = "ad_iframe")
    private WebElement iframe2;

    @FindBy(id ="dismiss-button")
    private WebElement closeADButton;

    public ADSGoogleVignette(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ADSGoogleVignette openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public void closeADSVignette() {
        try {
            driver.switchTo().frame(iframe1).switchTo().frame(iframe2);

            closeADButton.click();
        }catch(Exception e){
            System.err.println(e);
        }

    }
}
