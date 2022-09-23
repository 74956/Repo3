package org.example.service;

import org.example.pages.BasePage;

import java.util.List;
import java.util.logging.Logger;

public class BasePageService {

    public static final Logger log = Logger.getLogger(BasePageService.class.getName());

    private BasePage basePage = new BasePage();

    public boolean isLogoFooterPresent() {
        boolean result = basePage.isLogoFooterPresent();
        log.info("Is logo present - " + result);
        return result;
    }

    public boolean isLangSwitcherDisplayed() {
        boolean result = basePage.isLangSwitcherDisplayed();
        log.info("Is Language switcher displayed - " + result);
        return result;
    }

    public void switchLanguage(String lang) {
        log.info("Switch language on - " + lang);
        basePage.switchLanguage(lang);
    }

    public String getLanguageFromPageText() {
        log.info("Get actual language from page");
        return basePage.getLanguageFromPageText();
    }

    public List<String> getListOfContentTabNames() {
        List<String> listOfNames = basePage.getListOfContentTabNames();
        log.info("Get actual list of names - " + listOfNames);
        return listOfNames;
    }

    public void clickOnCustomerServiceButton() {
        log.info("Click on 'Customer Service' button");
        basePage.clickOnCustomerServiceButton();
    }
}
