package driver;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton  {
    private static WebDriver driver;

    private DriverSingleton() {
    }


    public static WebDriver getDriver() {

        if(null==driver){
            switch (System.getProperty("browser").toLowerCase()){
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
//                case "yandex" :
//                    ChromeOptions options = new ChromeOptions();
//                    options.setBinary("C:\\Users\\Sundr\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe").setBrowserVersion("116.0.5845.931");
//                    driver = new ChromeDriver(options);
//                    break;
                default:
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();

        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }



}
