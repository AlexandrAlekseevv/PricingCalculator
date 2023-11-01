package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailGenerator extends AbstractPage{
    private final static String PAGE_URL ="https://yopmail.com/email-generator";

    @FindBy(id = "egen")
    WebElement FieldWithCreatedEmail;

    protected EmailGenerator(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    protected AbstractPage openPage(boolean isCurrentTab) {
        if (!isCurrentTab) {
            openNewTab();
        }
        driver.navigate().to(PAGE_URL);
        return this;
    }
}