package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.ResultPageService;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFilterWithYearAndSeeMoreButtonSteps {

    private ResultPageService resultPageService = new ResultPageService();

    @Then("I see {string} button still displayed after using filter with {string}")
    public void isSeeMoreButtonDisplayed(String buttonName, String year) {
        resultPageService.clickOnFilterInput(year);
        resultPageService.clickOnRandomColor();
        assertThat("'See more' button is displayed ", !resultPageService.isButtonDisplayedInTheYearFilter(buttonName));
    }
}
