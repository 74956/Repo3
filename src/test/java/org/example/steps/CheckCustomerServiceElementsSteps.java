package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.CustomerService;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckCustomerServiceElementsSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private CustomerService customerService = new CustomerService();

    @Then("I click on Customer Service button from started page")
    public void clickOnCustomerServiceButton() {
        startedPageService.clickOnCustomerServiceButton();
    }

    @Then("I check visibility of Customer Service and Home buttons on the second navigation header")
    public void checkVisibilityOfCustomerServiceAndHomeButtons() {
        assertThat("Check button text", customerService.getCustomServiceButtonText(), Matchers.equalTo("Customer Service"));
        assertThat("Check button text", customerService.getHomeButtonText(), Matchers.equalTo("Home"));
    }

    @Then("I check greeting msg and info msg at the page container")
    public void checkGreetingAndInfoMsgs() {
        assertThat("Msg text is wrong", customerService.getGreetingMsgText(), Matchers.equalTo("Welcome to Amazon Customer Service, Amili"));
        assertThat("Msg text is wrong", customerService.getInfoMsgText(), Matchers.equalTo("What would you like help with today? You can quickly take care of most things here, or connect with us when needed."));
    }

    @Then("I check visibility of card`s imgs")
    public void checkVisibilityOfCardSImgs() {
        assertThat("Card imgs are not displayed", customerService.isCardImgsDisplayed());
    }

    @Then("I check visibility of card`s text and compare with expected text {string}")
    public void checkVisibilityOfCardsText(String text) {
        List<String> expectedCardText = ReadDataFromFile.getDataFromProperties("src/test/resources/propertyOptions.properties", text);
        List<String> actualCardText = customerService.getListOfCardText();
        assertThat("List of cards are not equal", actualCardText, Matchers.equalTo(expectedCardText));
    }

    @Then("I check if Search field displayed")
    public void isSearchFieldDisplayed() {
        assertThat("Search field is not displayed", customerService.isSearchFieldDisplayed());
    }

    @Then("I check the text under the search field")
    public void checkTextUnderTheSearchField() {
        assertThat("Check the text under search field", customerService.getTextUnderSearchField(),
                Matchers.equalTo("Search our help library"));
    }

    @Then("I check that icon of loupe displayed")
    public void isIconOfLoupeDisplayed() {
        assertThat("Loupe img is not displayed", customerService.isLoupeImgInSearchDisplayed());
    }

    @Then("I check options {string} in the column All help topics")
    public void checkOptionsInTheColumnText(String text) {
        List<String> expectedHelpTopics = ReadDataFromFile.getDataFromProperties("src/test/resources/propertyOptions.properties", text);
        List<String> actualHelpTopics = customerService.getListOfHelpTopics();
        assertThat("Check Help topics options", actualHelpTopics, Matchers.equalTo(expectedHelpTopics));
    }

    @Then("I click on every help topic and check that it has addition cards with information")
    public void isHelpTopicHasAdditionalCardsWithInformation() {
        assertThat("Some of Help topic hasn`t cards with additional info ",
                customerService.isHelpTopicHasAdditionalCardWithInformation());
    }
}
