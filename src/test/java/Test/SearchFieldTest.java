package Test;

import Page.AbstractPage;
import Page.MainPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFieldTest extends CommonCondition {

    @Test
    public void trueIsTrue(){


        MainPage mp = new MainPage(driver);
        mp.openPage().invokePageWithSearchResults(SEARCH_FIELD_TEXT);
    }


}
