package org.example.steps;

import io.cucumber.java.en.When;
import org.example.service.AboutAmazonPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class FollowUsAboutAmazonSteps {

    private AboutAmazonPageService aboutAmazonPageService = new AboutAmazonPageService();

    @When("I navigate on dropdown {string}  and I check columns entity {string} using {string}")
    public void checkColumnsEntityOfFollowUsDropdown(String title, String columnKey, String columnName) {
        List<String> expectedDropdownEntity = ReadDataFromFile.
                getDataFromProperties("src/test/resources/dropdownEntity.properties", columnKey);
        List<String> actualDropdownEntity = aboutAmazonPageService.getDropdownColumnsElementsOfFollowUs(title, columnName);
        assertThat("Dropdown elements are not equal", actualDropdownEntity, Matchers.equalTo(expectedDropdownEntity));
    }
}
