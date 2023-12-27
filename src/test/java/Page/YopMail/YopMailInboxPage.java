package Page.YopMail;

import Page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailInboxPage extends AbstractPage {

    private static final String  PAGE_URL = "https://yopmail.com/wm";

    @FindBy(xpath = "(//table//h3)[2]")
    WebElement totalEstimatedMonthlyCost;

    @FindBy(id = "ifmail")
    WebElement cloudFrame;

    public YopMailInboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public YopMailInboxPage openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getTotalMonthlyCost(){
        driver.switchTo().frame(cloudFrame);
        return totalEstimatedMonthlyCost.getText();
    }
}
