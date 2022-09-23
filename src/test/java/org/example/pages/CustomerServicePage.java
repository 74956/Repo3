package org.example.pages;

import org.example.util.CommonMethodsForList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerServicePage extends BasePage {

    public List<WebElement> getCardImg() {
        return driver.findElements(By.xpath("//div[@class='fs-match-card']//img[contains(@src,'images')]"));
    }

    public WebElement getCustomServiceButton() {
        return driver.findElement(By.xpath("//div[@class='cs-title']/a"));
    }

    public WebElement getHomeButton() {
        return driver.findElement(By.xpath("//div[@class='nav-item active']/a"));
    }

    public WebElement getGreetingMsg() {
        return driver.findElement(By.xpath("//div[@class='page-container']/h1"));
    }

    public WebElement getInfoMsg() {
        return driver.findElement(By.xpath("//p[contains(@class,'header-subtext')]"));
    }

    public List<WebElement> getCardText() {
        return driver.findElements(By.xpath("//div[@class='issue-card-container']//div[contains(@class,'card-title')]"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("//div[@class='help-search-bar']"));
    }

    public WebElement getTextUnderSearchField() {
        return driver.findElement(By.xpath("(//div[@class='page-container']//h2)[1]"));
    }

    public WebElement getLoupeImg() {
        return driver.findElement(By.xpath("//img[@class='help-search-image']"));
    }

    public List<WebElement> getListOfHelpTopics() {
        return driver.findElements(By.xpath("//*[text()='All help topics']/parent::div//ul/li/label"));
    }

    public List<WebElement> getCardHelpInformation() {
        return driver.findElements(By.xpath("//div[@class='fs-match-card-detail']"));
    }

    public boolean isCardImgsDisplayed() {
        for (int i = 0; i < getCardImg().size(); i++) {
            if (getCardImg().get(i).isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public String getCustomServiceButtonText() {
        return getCustomServiceButton().getText();
    }

    public String getHomeButtonText() {
        return getHomeButton().getText();
    }

    public String getGreetingMsgText() {
        return getGreetingMsg().getText();
    }

    public String getInfoMsgText() {
        return getInfoMsg().getText();
    }

    public List<String> getListOfCardText() {
        return CommonMethodsForList.getItemsNamesText(getCardText());
    }

    public boolean isSearchFieldDisplayed() {
        return getSearchField().isDisplayed();
    }

    public String textUnderSearchField() {
        return getTextUnderSearchField().getText();
    }

    public boolean isLoupeImgDisplayed() {
        return getLoupeImg().isDisplayed();
    }

    public List<String> getListOfTopics() {
        return CommonMethodsForList.getItemsNamesText(getListOfHelpTopics());
    }

    public List<WebElement> listOfHelpTopics() {
        return getListOfHelpTopics();
    }

    public List<WebElement> listOfCardHelpInformation() {
        return getCardHelpInformation();
    }
}
