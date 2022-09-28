package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.AboutAmazonPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class LangSiteNavigatorAboutAmazonSteps {
    private AboutAmazonPageService aboutAmazonPageService = new AboutAmazonPageService();

    @Then("I see lang box with navigation to international sites")
    public void checkLangNavigationBox() {
        assertThat("Lang navigation box to international sites is not displayed",
                aboutAmazonPageService.isLangNavBoxDisplayed());
        assertThat("Lang navigation box to international sites icon is not displayed",
                aboutAmazonPageService.isLangNavBoxIconDisplayed());
    }

    @Then("I click on lang box and see new pop-up with title {string} and with choices {string} using {string}")
    public void iClickOnLangBoxAndSeeNewPopUpWithChoices(String popupTitle, String countryKey, String country) {
        aboutAmazonPageService.clickOnLangNavBox();
        assertThat("Lang sites pop up is not displayed", aboutAmazonPageService.isLangNavBoxPopUpDisplayed());
        assertThat("Pop up title is not equal", aboutAmazonPageService.getLangNavBoxTitleText(), Matchers.equalTo(popupTitle));
        List<String> expectedCountries = ReadDataFromFile.
                getDataFromProperties("src/test/resources/country.properties", countryKey);
        List<String> actualCountries = aboutAmazonPageService.getListOfCountries(country);
        assertThat("List of countries is equal", actualCountries, Matchers.equalTo(expectedCountries));
    }
}
