package Test;

import Page.AbstractPage;
import Page.MainPage;
import Page.PricingCalculatorPage;
import Page.YopMailMain;
import Page.YopMailMain;
import model.ComputerEngine;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputerEngineCreator;

public class SearchFieldTest extends CommonCondition {

    @Test
    public void trueIsTrue() throws InterruptedException {

        ComputerEngine testComputer = ComputerEngineCreator.withCredentialsFromProperty();
        String nameOfClass = String.valueOf(new MainPage(driver).openPage(IN_CURRENT_TAB)
                .invokePageWithSearchResults(SEARCH_FIELD_TEXT)
                .openSearchedPage(SEARCH_FIELD_TEXT)
                .fillComputerEngineForm(testComputer));
        String nameOf2Class = String.valueOf(new YopMailMain(driver).openPage(IN_NEW_TAB));




        Assert.assertEquals(nameOfClass, "class Page.PricingCalculatorPage");
    }


}
