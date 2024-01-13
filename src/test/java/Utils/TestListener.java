package Utils;

import driver.DriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        Allure.getLifecycle().addAttachment("Скриншот после успешного прохождения теста", "image/png", "png",
                ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES));

        Allure.addAttachment("Логи после успешного прохождения теста: ",String.valueOf(DriverSingleton.getDriver().manage().logs().get(LogType.BROWSER).getAll()));

        WebDriverManager.chromedriver().quit();
        DriverSingleton.getDriver().quit();
    }





    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        Allure.getLifecycle().addAttachment("Скриншот на месте падения теста", "image/png", "png",
                ((TakesScreenshot)DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES));

        Allure.addAttachment("Логи после падения теста: ",String.valueOf(DriverSingleton.getDriver().manage().logs().get(LogType.BROWSER).getAll()));

        WebDriverManager.chromedriver().quit();
        DriverSingleton.getDriver().quit();
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}