package Page.YopMail;

import Page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailGenerator extends AbstractPage {
    private final static String PAGE_URL ="https://yopmail.com/email-generator";

    @FindBy(id = "egen")
    WebElement fieldWithCreatedEmail;
    @FindBy(id = "cprnd")
    WebElement copyToClipoardButton;
    @FindBy(xpath = "//button[@onclick='egengo();']")
    WebElement checkInboxButton;

    public EmailGenerator(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public AbstractPage openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
