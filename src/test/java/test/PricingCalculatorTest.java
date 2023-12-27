package test;

import Page.Google.GoogleMainPage;
import Page.Google.PricingCalculatorPage;
import Page.YopMail.EmailGenerator;

import Page.YopMail.YopMailMain;
import model.ComputerEngine;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputerEngineCreator;

public class PricingCalculatorTest extends CommonCondition {



    @Test(description = "Smoke Test: Открыть главную страницу и выполнить поиск")
    public void openMainPageAndSearch() {
        String searchingPageClass = String.valueOf( new GoogleMainPage(driver)
        .openPage(false)
                .invokePageWithSearchResults("Google Cloud Pricing Calculator")
                .openSearchedPage(SEARCH_FIELD_TEXT)
                .getClass());

        Assert.assertEquals(searchingPageClass, PricingCalculatorPage.class.toString(),"The resulting page is not an instance of PricingCalculatorPage.");
    }



    @Test(description = "MAT test: Проверить общую ежемесячную стоимость")
    public void verifyTotalEstimatedMonthlyCost() {

        ComputerEngine testComputer = ComputerEngineCreator.withCredentialsFromProperty();

        String priceOnCalculatorPage = new GoogleMainPage(driver).openPage(IN_CURRENT_TAB)
                .invokePageWithSearchResults(SEARCH_FIELD_TEXT)
                .openSearchedPage(SEARCH_FIELD_TEXT)
                .addToEstimate()
                .switchToPricingCalculatorLegacyPage()
                .fillComputerEngineForm(testComputer)
                .newWebsitePage(new YopMailMain(driver))
                .openPage(IN_NEW_TAB)
                .generateRandomlyEmail()
                .sendPriceToEmail().getTotalPriceOfEstimate();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String priceInInbox = new EmailGenerator(driver)
                .openPage(IN_CURRENT_TAB)
                .switchToInbox()
                .openPage(IN_CURRENT_TAB)
                .getTotalMonthlyCost();


        Assert.assertTrue(priceOnCalculatorPage.contains(priceInInbox));
    }


}
