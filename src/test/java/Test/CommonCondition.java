package Test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonCondition {

    protected final String SEARCH_FIELD_TEXT = "Google Cloud Platform Pricing Calculator";

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();

    }

}
