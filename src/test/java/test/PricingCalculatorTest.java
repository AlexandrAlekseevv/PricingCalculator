package test;

import Page.Google.GoogleMainPage;
import Page.Google.PricingCalculatorPage;
import Page.YopMail.EmailGenerator;
import Page.YopMail.YopMailMain;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import model.ComputerEngine;

import org.testng.Assert;
import org.testng.annotations.Test;
import service.ComputerEngineCreator;

@Feature(value = "Pricing Calculator")
public class PricingCalculatorTest extends CommonCondition {



    @Test(description = "Smoke Test: Открыть главную страницу и выполнить поиск")
    @Owner(value = "Alexandr Alekseev")
    public void openMainPageAndSearch() {
        String searchingPageClass = String.valueOf( new GoogleMainPage(driver)
        .openPage(false)
                .invokePageWithSearchResults("Google Cloud Pricing Calculator")
                .openSearchedPage(SEARCH_FIELD_TEXT)
                .getClass());

        Assert.assertEquals(searchingPageClass, PricingCalculatorPage.class.toString(),"The resulting page is not an instance of PricingCalculatorPage.");
    }



    @Test(description = "MAT test: Check the total monthly cost", dependsOnMethods = "openMainPageAndSearch")
    @Owner(value = "Alexandr Alekseev")
    @Issue(value = "this could be your ad")
    @Description("check that the Total Estimated Monthly Cost in the email-message matches what is displayed in the calculator")
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

        //waiting for the e-mail to arrive.
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
