package org.example.service;

import org.example.pages.AboutAmazonPage;

import java.util.List;

public class AboutAmazonPageService extends BasePageService {

    AboutAmazonPage aboutAmazonPage = new AboutAmazonPage();

    public boolean isLogoDisplayed() {
        boolean result = aboutAmazonPage.isLogoDisplayed();
        log.info("If logo displayed on the page 'About Amazon' - " + result);
        return result;
    }

    public boolean isSearchFieldDisplayed() {
        boolean result = aboutAmazonPage.isSearchFieldDisplayed();
        log.info("If Search field displayed on the page 'About Amazon' - " + result);
        return result;
    }

    public List<String> headerDropdownText() {
        List<String> headerNames = aboutAmazonPage.getHeaderDropdownText();
        log.info("Get header dropdown names: " + headerNames);
        return headerNames;
    }

    public List<String> getDropdownElements(String title) {
        log.info("Check dropdown elements");
        return aboutAmazonPage.navigateToDropdownElementAndCheckElements(title);
    }

    public List<String> getDropdownColumnsElementsOfOurImpact(String title, String columnName) {
        log.info("Check dropdown 'Our Impact' column elements");
        return aboutAmazonPage.navigateToOurImpactDropdownElementAndCheckColumnEntity(title, columnName);
    }

    public List<String> getDropdownColumnsElementsOfFollowUs(String title, String columnName) {
        log.info("Check dropdown 'Follow Us' column elements");
        return aboutAmazonPage.navigateToFollowUSDropdownElementAndCheckColumnEntity(title, columnName);
    }

    public boolean isEnvelopeIconDisplayed() {
        boolean result = aboutAmazonPage.isEnvelopeIconDisplayed();
        log.info("Is envelope icon displayed - " + result);
        return result;
    }

    public String getSubscribeButtonText() {
        String text = aboutAmazonPage.getSubscribeButtonText();
        log.info("'Subscribe button' text is - " + text);
        return text;
    }

    public boolean isLangNavBoxDisplayed() {
        boolean result = aboutAmazonPage.isLangNavBoxDisplayed();
        log.info("Is Lang navigation box to international sites displayed - " + result);
        return result;
    }

    public void clickOnLangNavBox() {
        log.info("Click on Lang navigation box to international sites ");
        aboutAmazonPage.clickOnLangNavBox();
    }

    public boolean isLangNavBoxIconDisplayed() {
        boolean result = aboutAmazonPage.isLangNavBoxIconDisplayed();
        log.info("Is Lang navigation box to international sites icon displayed - " + result);
        return result;
    }

    public boolean isLangNavBoxPopUpDisplayed() {
        boolean result = aboutAmazonPage.isLangNavBoxPopUpDisplayed();
        log.info("Is Lang navigation box to international sites pop up displayed - " + result);
        return result;
    }

    public String getLangNavBoxTitleText() {
        String text = aboutAmazonPage.getLangNavBoxTitleText();
        log.info("Lang box pop up title text is - " + text);
        return text;
    }

    public List<String> getListOfCountries(String country) {
        List<String> countries = aboutAmazonPage.getListOfCountries(country);
        log.info("Get list of countries: " + country + ":  " + countries);
        return countries;
    }

    public boolean isInfoSliderDisplayed() {
        boolean result = aboutAmazonPage.isInfoSliderDisplayed();
        log.info("Is Info slider displayed - " + result);
        return result;
    }

    public boolean isSliderHasEmptyString() {
        boolean result = aboutAmazonPage.isSliderHasEmptyString();
        log.info("Slider has not empty String - " + result);
        return result;
    }
}
