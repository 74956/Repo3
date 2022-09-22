package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFooterLogoAndHeaderSwitcherSteps {

    private StartedPageService startedPageService = new StartedPageService();

    @Then("I see logo in the footer")
    public void iSeeLogoInTheFooter() {
        assertThat("Logo in the footer is not present", startedPageService.isLogoFooterPresent());
    }

    @Then("I see language switcher in the header")
    public void isLanguageSwitcherInTheHeaderDisplayed() {
        assertThat("Language switcher is not displayed", startedPageService.isLangSwitcherDisplayed());
    }

    @Then("I see that English is default language")
    public void isEnglishIsDefaultLanguage() {
        assertThat("English is not default language", startedPageService.getLanguageFromPageText(), Matchers.equalTo("en-us"));
    }
}