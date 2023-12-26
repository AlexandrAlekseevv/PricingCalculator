package Utils;

import driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public  class BrowserNavigation {
    private static BrowserNavigation instance;
    private WebDriver driver;
    private int currentTabIndex;

    private BrowserNavigation() {
        this.driver = DriverSingleton.getDriver();
        this.currentTabIndex = 0;
    }

    public static  BrowserNavigation getInstance() {
        if (instance == null) {
            instance = new BrowserNavigation();
        }
        return instance;
    }


    public void switchToTab(int tabIndex) {
        Object[] handles = driver.getWindowHandles().toArray();
        if (tabIndex >= 0 && tabIndex < handles.length) {
            driver.switchTo().window(handles[tabIndex].toString());
            currentTabIndex = tabIndex;
        } else {
            System.out.println("Неверный индекс вкладки: " + tabIndex);
        }
    }


    public void switchToPreviousTab() {
        switchToTab(currentTabIndex - 1);
    }


    public void switchToLastTab() {
        Object[] handles = driver.getWindowHandles().toArray();
        driver.switchTo().window(handles[handles.length - 1].toString());
        currentTabIndex = handles.length - 1;
    }


    public void closeCurrentTab() {
        driver.close();
        switchToLastTab();
    }








}

