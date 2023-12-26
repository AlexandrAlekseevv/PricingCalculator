package Page;

import Utils.BrowserNavigation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected abstract AbstractPage openPage(boolean isCurrentTab);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;

    }

    protected void scrollPageTo(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center'});", webElement);
    }
    public <T extends AbstractPage> T newWebsitePage(T page) {
        return page;
    }


    protected void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");

        String firstTab = driver.getWindowHandle();
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(firstTab))
                .findFirst()
                .orElse(firstTab);

        driver.switchTo().window(newTab);

    }

    protected void switchToPreviousTab() {
        String currentTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

}
