package Test;

import Page.AbstractPage;
import Page.MainPage;
import Page.PricingCalculatorPage;
import model.ComputerEngine;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputerEngineCreator;

public class SearchFieldTest extends CommonCondition {

    @Test
    public void trueIsTrue() throws InterruptedException {

        ComputerEngine testComputer = ComputerEngineCreator.withCredentialsFromProperty();
        String nameOfClass = String.valueOf(new PricingCalculatorPage(driver).openPage()
//                .openPage()
//                .invokePageWithSearchResults(SEARCH_FIELD_TEXT)
//                .openSearchedPage(SEARCH_FIELD_TEXT)
                .fillComputerEngineForm(testComputer))
                .getClass()
                .toString();

        Assert.assertEquals(nameOfClass, "class Page.PricingCalculatorPage");
    }


}
