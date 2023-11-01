package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopMailMain extends AbstractPage {

    @FindBy(xpath = "//h3[text()='Random Email generator']")
    WebElement generateEmailButton;



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

    public EmailGenerator createEmail(){
        generateEmailButton.click();

        return new EmailGenerator(driver);


    }

}
