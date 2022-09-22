package org.example.pages;

import org.example.driver.Driver;
import org.example.util.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    public boolean isLogoFooterPresent() {
        return getFooterLogo().isDisplayed();
    }

    public boolean isLangSwitcherDisplayed() {
        return getHeaderLangSwitcher().isDisplayed();
    }

    public void switchLanguage(String lang) {
        Actions actions = new Actions(driver);
        waiters.fluentWaitVisibilityOfElement(navigateOnLangSwitcher());
        actions.moveToElement(navigateOnLangSwitcher()).build().perform();
        waiters.fluentWaitVisibilityOfElement(getLangDropDown());
        WebElement el = driver.findElement(By.xpath(String.format("//a[contains(@href,'%s')]//i", lang)));
        actions.click(el).build().perform();
    }

    public String getLanguageFromPageText() {
        waiters.fluentWaitElementInvisible(getLangDropDown());
        return getLanguageFromPage().getAttribute("lang");
    }
}
