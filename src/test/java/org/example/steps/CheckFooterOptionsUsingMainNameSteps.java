package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFooterOptionsUsingMainNameSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private List<String> expectedListOfOptions;
    private List<String> actualListOfOptions;

    @Then("I see footer options with {string} and compare them with data from file with {string}")
    public void iSeeFooterOptionsAndCompareThemWithDataFromFileWith(String columnName, String propertyKey) {
        expectedListOfOptions = ReadDataFromFile.getDataFromProperties("src/test/resources/footerOptions.properties", propertyKey);
        actualListOfOptions = startedPageService.getListOfFooterOptionsByName(columnName);
        assertThat("Lists of footer options are equal", actualListOfOptions, Matchers.equalTo(expectedListOfOptions));
    }
}