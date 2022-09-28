package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckLanguageSwitcherInHeaderSteps {

    private StartedPageService startedPageService = new StartedPageService();

    @Then("I choose {string} from switcher and compare actual language with {string}")
    public void isLanguageSwitched(String lang, String langResult) {
        startedPageService.switchLanguage(lang);
        assertThat("Language didn`t changed", startedPageService.getLanguageFromPageText(), Matchers.equalTo(langResult));
    }
}