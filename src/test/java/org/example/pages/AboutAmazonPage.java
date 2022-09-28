package org.example.pages;

import org.example.util.CommonMethodsForList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AboutAmazonPage extends BasePage {

    private final String DROPDOWN_IN_THE_HEADER = "//div[@class='Page-header-main-navigation']";
    private final String SUBSCRIBE_BUTTON = "//a[@class='Link signupLink']";
    private final String LANGUAGE_NAV_BOX_SITES = "(//div[@class='LanguagesMenu-toggle'])[2]";
    private final String LANGUAGE_NAV_BOX_POPUP = "//div[@class='LanguagesMenu-dropdown-content']";
    private final String INFO_SLIDER = "//*[@class='ListFastFacts-wrapper']";

    public WebElement getAboutPageLogo() {
        return driver.findElement(By.xpath("//img[contains(@src,'amazon-logo-inverse')]"));
    }

    public WebElement getSearchForm() {
        return driver.findElement(By.xpath("//form[@class='Page-header-search-form']"));
    }

    public List<WebElement> getListOfHeaderElements() {
        return driver.findElements(By.xpath(DROPDOWN_IN_THE_HEADER + "//a[@class='NavigationItem-text-link']"));
    }

    public String getHeaderElement() {
        return DROPDOWN_IN_THE_HEADER + "//a[@class='NavigationItem-text-link' and text()='%s']";
    }

    public String getDropdownElement() {
        return "(//a[text()='%s']/ancestor::div[@class='NavigationSubnav-content'])[2]/ul//ul/li/a";
    }

    public String dropdownContent() {
        return "(//div[@class='NavigationSubnav-text']/a[text()='%s']/ancestor::div[@class='NavigationSubnav-wrapper'])[2]";
    }

    public String getDropdownColumnEntity() {
        return "(//div[@class='NavigationSubnavItem-subtitle' and contains(text(),'%s')])[2]/parent::div/ul/li";
    }

    public String getDropdownContentWithColumns() {
        return "(//div[@class='NavigationSubnavItem-subtitle' and contains(text(),'%s')]/ancestor::div[@class='NavigationSubnav-content'])[2]";
    }

    public String getFollowUsDropDownEntity() {
        return "(//*[@data-social-service='%s'])[2]/parent::div/ul/li/a";
    }

    public WebElement envelopIcon() {
        return driver.findElement(By.xpath(SUBSCRIBE_BUTTON + "/*[@class='icon icon-mailto']"));
    }

    public WebElement subscribeButtonText() {
        return driver.findElement(By.xpath(SUBSCRIBE_BUTTON + "/span"));
    }

    public WebElement getLangNavigationBox() {
        return driver.findElement(By.xpath(LANGUAGE_NAV_BOX_SITES));
    }

    public WebElement getLangNavigationBoxButton() {
        return driver.findElement(By.xpath(LANGUAGE_NAV_BOX_SITES + "/button"));
    }

    public WebElement langNavigationBoxIcon() {
        return driver.findElement(By.xpath(LANGUAGE_NAV_BOX_SITES + "/div"));
    }

    public WebElement langNavBoxPopUp() {
        return driver.findElement(By.xpath(LANGUAGE_NAV_BOX_POPUP));
    }

    public WebElement langNavBoxTitle() {
        return driver.findElement(By.xpath(LANGUAGE_NAV_BOX_POPUP + "/div[contains(@class,'title')]"));
    }

    public String getPopUpCountriesText() {
        return "//span[text()='%s']/ancestor::div[@class='LanguageMenuList']//a[@class='LanguagesMenuItem-link']/span";
    }

    public WebElement getInfoSlider() {
        return driver.findElement(By.xpath(INFO_SLIDER));
    }

    public WebElement sliderEntity() {
        return driver.findElement(By.xpath(INFO_SLIDER + "//li//span"));
    }

    public WebElement infoSlideCounter() {
        return driver.findElement(By.xpath("//div[@class='flickity-counter']"));
    }

    public WebElement previousClickButtonForInfoSlide() {
        return driver.findElement(By.xpath("//button[@aria-label='Previous']"));
    }

    public WebElement nextClickButtonForInfoSlide() {
        return driver.findElement(By.xpath("//button[@aria-label='Next']"));
    }

    public boolean isLogoDisplayed() {
        return getAboutPageLogo().isDisplayed();
    }

    public boolean isSearchFieldDisplayed() {
        return getSearchForm().isDisplayed();
    }

    public List<String> getHeaderDropdownText() {
        return CommonMethodsForList.getTextFromElements(getListOfHeaderElements());
    }

    public List<String> navigateToDropdownElementAndCheckElements(String title) {
        navigateToElement(getHeaderElement(), title);
        return getDropdownValue(getDropdownElement(), title, dropdownContent());
    }

    public List<String> navigateToOurImpactDropdownElementAndCheckColumnEntity(String title, String columnName) {
        navigateToElement(getHeaderElement(), title);
        return getDropdownValue(getDropdownColumnEntity(), columnName, getDropdownContentWithColumns());
    }

    public List<String> navigateToFollowUSDropdownElementAndCheckColumnEntity(String title, String columnName) {
        navigateToElement("(//div[@class='NavigationItem-wrapper' and text()='Follow Us'])[2]", title);
        return getDropdownValue(getFollowUsDropDownEntity(), columnName, getDropdownContentWithColumns());
    }

    private void navigateToElement(String element, String title) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(element, title)))).build().perform();
    }

    private List<String> getDropdownValue(String dropdownEntity, String dropdownName, String dropdownContent) {
        List<WebElement> values = driver.findElements(By.xpath(String.format(dropdownEntity, dropdownName)));
        waiters.waitForVisibilityOfElement(driver.findElement(By.xpath(String.format(dropdownContent, dropdownName))));
        return CommonMethodsForList.getTextFromElements(values);
    }

    public boolean isEnvelopeIconDisplayed() {
        return envelopIcon().isDisplayed();
    }

    public String getSubscribeButtonText() {
        return subscribeButtonText().getText();
    }

    public boolean isLangNavBoxDisplayed() {
        return getLangNavigationBox().isDisplayed();
    }

    public void clickOnLangNavBox() {
        getLangNavigationBoxButton().click();
    }

    public boolean isLangNavBoxIconDisplayed() {
        return langNavigationBoxIcon().isDisplayed();
    }

    public boolean isLangNavBoxPopUpDisplayed() {
        return langNavBoxPopUp().isDisplayed();
    }

    public String getLangNavBoxTitleText() {
        return langNavBoxTitle().getText();
    }

    public List<String> getListOfCountries(String country) {
        List<WebElement> values = driver.findElements(By.xpath(String.format(getPopUpCountriesText(), country)));
        return CommonMethodsForList.getTextFromElements(values);
    }

    public boolean isInfoSliderDisplayed() {
        return getInfoSlider().isDisplayed();
    }

    public boolean isSliderHasEmptyString() {
        String sliderText = sliderEntity().getText();
        if (!infoSlideCounter().getText().equals("1 / 10")) {
            do {
                previousClickButtonForInfoSlide().click();
            } while (previousClickButtonForInfoSlide().isEnabled());
        }
        boolean result;
        do {
            nextClickButtonForInfoSlide().click();
            result = !sliderText.isEmpty();
        } while (nextClickButtonForInfoSlide().isEnabled());
        return result;
    }
}
