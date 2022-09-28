package org.example.steps;

import io.cucumber.java.en.When;
import org.example.service.AboutAmazonPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class OurImpactAboutAmazonSteps {
    private AboutAmazonPageService aboutAmazonPageService = new AboutAmazonPageService();

    @When("I navigate on dropdown {string} I check columns entity {string} using {string}")
    public void iNavigateOnDropdownICheckColumnsEntity(String dropdownName, String columnKey, String columnName) {
        List<String> expectedDropdownEntity = ReadDataFromFile.
                getDataFromProperties("src/test/resources/dropdownEntity.properties", columnKey);
        List<String> actualDropdownEntity = aboutAmazonPageService.getDropdownColumnsElementsOfOurImpact(dropdownName, columnName);
        assertThat("Dropdown elements are not equal", actualDropdownEntity, Matchers.equalTo(expectedDropdownEntity));
    }
}