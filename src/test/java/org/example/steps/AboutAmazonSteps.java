package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.service.AboutAmazonPageService;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AboutAmazonSteps {
    private StartedPageService startedPageService = new StartedPageService();
    private AboutAmazonPageService aboutAmazonPageService = new AboutAmazonPageService();

    @When("I click on About Amazon button")
    public void clickAboutAmazonButtonDisplayed() {
        startedPageService.clickOnAboutAmazonButton();
    }

    @Then("I see the new page is opened")
    public void isAboutAmazonPageOpened() {
        assertThat("Logo is not displayed", aboutAmazonPageService.isLogoDisplayed());
    }

    @Then("I see search field")
    public void isSearchFieldDisplayed() {
        assertThat("Search field is not displayed", aboutAmazonPageService.isSearchFieldDisplayed());
    }

    @Then("I see dropdowns in the header")
    public void areHeaderElementsDisplayed() {
        List<String> expectedDropdownTitles = ReadDataFromFile.
                getDataFromProperties("src/test/resources/dropdownEntity.properties", "dropdown");
        List<String> actualDropdownTitles = aboutAmazonPageService.headerDropdownText();
        assertThat("Dropdown names are not equal", actualDropdownTitles, Matchers.equalTo(expectedDropdownTitles));
    }

    @Then("I check the entity of every dropdown by {string} using dropdown name {string}")
    public void isEntityOfEveryDropdownDisplayed(String dropdownKey, String dropdownName) {
        List<String> expectedDropdownEntity = ReadDataFromFile.
                getDataFromProperties("src/test/resources/dropdownEntity.properties", dropdownKey);
        List<String> actualDropdownEntity = aboutAmazonPageService.getDropdownElements(dropdownName);
        assertThat("Dropdown elements are not equal", actualDropdownEntity, Matchers.equalTo(expectedDropdownEntity));
    }

    @Then("I check if envelope icon displayed and the text of the button is {string}")
    public void checkSubscribeButton(String text) {
        assertThat("Envelope icon is not displayed", aboutAmazonPageService.isEnvelopeIconDisplayed());
        assertThat("Text of the button is not equal", aboutAmazonPageService.getSubscribeButtonText(), Matchers.equalTo(text));
    }

    @Then("I check that info slider is displayed and not empty")
    public void checkInfoSlider() {
        assertThat("Info slider is not displayed", aboutAmazonPageService.isInfoSliderDisplayed());
        assertThat("Slider could contain empty info links", aboutAmazonPageService.isSliderHasEmptyString());
    }
}
