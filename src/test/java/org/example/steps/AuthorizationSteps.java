package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationSteps {

    private StartedPageService startedPageService = new StartedPageService();

    @Then("I see on the started page greeting text {string}")
    public void checkGreetingMsgOnTheStartedPageText(String greetingText) {
        assertThat(startedPageService.getAccountGreetingText(), Matchers.equalTo(greetingText));
    }
}
