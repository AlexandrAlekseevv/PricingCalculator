package Test;

import Page.AbstractPage;
import Page.MainPage;
import Page.PricingCalculatorPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFieldTest extends CommonCondition {

    @Test
    public void trueIsTrue(){


        String nameOfClass = String.valueOf(new MainPage(driver)
                .openPage()
                .invokePageWithSearchResults(SEARCH_FIELD_TEXT)
                .openSearchedPage(SEARCH_FIELD_TEXT).getClass());
        Assert.assertEquals(nameOfClass, "class Page.PricingCalculatorPage");
    }


}
