package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckNamesOfShopContainerSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private List<String> expectedListOfOptions;
    private List<String> actualListOfOptions;

    @Then("I check list of actual button names with expected read from file by {string}")
    public void checkButtonsName(String propertyKey) {
        expectedListOfOptions = ReadDataFromFile.getDataFromProperties("src/test/resources/propertyOptions.properties", propertyKey);
        actualListOfOptions = startedPageService.getListOfContentTabNames();
        assertThat("Lists of button names are not equal", actualListOfOptions, Matchers.equalTo(expectedListOfOptions));
    }
}
