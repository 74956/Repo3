package org.example.pages;

import org.example.driver.Driver;
import org.example.util.CommonMethodsForList;
import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BasePage {

    Waiters waiters = new Waiters();
    protected WebDriver driver;

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public WebElement getFooterLogo() {
        return driver.findElement(By.xpath("//a[contains(@href,'footer_logo')]/div"));
    }

    public WebElement getHeaderLangSwitcher() {
        return driver.findElement(By.xpath("//a[contains(@href,'topnav_lang')]"));
    }

    public WebElement getLanguageFromPage() {
        return driver.findElement(By.xpath("//html[@lang]"));
    }

    public WebElement navigateOnLangSwitcher() {
        return driver.findElement(By.xpath("//a[contains(@href,'topnav_lang')]"));
    }

    public WebElement getLangDropDown() {
        return driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//div[contains(@class,'nav-tpl-itemList')]"));
    }

    public List<WebElement> getShopContainerNames() {
        return driver.findElements(By.xpath("//div[@id='nav-xshop']/a[contains(@class,'nav-a')]"));
    }

    public WebElement getCustomerServiceButton() {
        return driver.findElement(By.xpath("//a[contains(@href,'nav_cs_help')]"));
    }

    public boolean isLogoFooterPresent() {
        return getFooterLogo().isDisplayed();
    }

    public boolean isLangSwitcherDisplayed() {
        return getHeaderLangSwitcher().isDisplayed();
    }

    public void switchLanguage(String lang) {
        Actions actions = new Actions(driver);
        waiters.waitForVisibilityOfElement(navigateOnLangSwitcher());
        actions.moveToElement(navigateOnLangSwitcher()).build().perform();
        waiters.waitForVisibilityOfElement(getLangDropDown());
        WebElement el = driver.findElement(By.xpath(String.format("//a[contains(@href,'%s')]//i", lang)));
        actions.click(el).build().perform();
    }

    public String getLanguageFromPageText() {
        waiters.waitForInvisibilityOfElement(getLangDropDown());
        return getLanguageFromPage().getAttribute("lang");
    }

    public List<String> getListOfContentTabNames() {
        return CommonMethodsForList.getTextFromElements(getShopContainerNames());
    }

    public void clickOnCustomerServiceButton() {
        getCustomerServiceButton().click();
    }
}