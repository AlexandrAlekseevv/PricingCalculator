package Test;

import Page.Google.MainPage;
import Page.Google.PricingCalculatorLegacyPage;
import Page.YopMail.YopMailMain;
import model.ComputerEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputerEngineCreator;

public class SearchFieldTest extends CommonCondition {

    @Test
    public void trueIsTrue() {

        ComputerEngine testComputer = ComputerEngineCreator.withCredentialsFromProperty();

        String nameOfClass = String.valueOf(new MainPage(driver).openPage(IN_CURRENT_TAB)
                .invokePageWithSearchResults(SEARCH_FIELD_TEXT)
                .openSearchedPage(SEARCH_FIELD_TEXT)
                .addToEstimate()
                .switchToPricingCalculatorLegacyPage()
                .fillComputerEngineForm(testComputer)
                .newWebsitePage(new YopMailMain(driver))
                .openPage(IN_NEW_TAB)
                .generateRandomlyEmail());


        Assert.assertEquals(nameOfClass, "class Page.PricingCalculatorPage");
    }


}
