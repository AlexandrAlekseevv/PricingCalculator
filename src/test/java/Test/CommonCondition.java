package Test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class CommonCondition {

    protected final String SEARCH_FIELD_TEXT = "Google Cloud Pricing Calculator";
    protected final boolean IN_CURRENT_TAB = true;
    protected final boolean IN_NEW_TAB = false;

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();

    }

}
