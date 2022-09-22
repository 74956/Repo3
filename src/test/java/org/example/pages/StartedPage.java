package org.example.pages;

import org.example.util.CommonMethodsForList;
import org.example.util.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class StartedPage extends BasePage {

    public WebElement getAccountName() {
        return driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.xpath("//a[@id='nav-cart']"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("//input[@name='field-keywords']"));
    }

    public WebElement getSignInMenu() {
        return driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']"));
    }

    public StartedPage goToMainPage() {
        driver.navigate().to(GetProperties.getProperties("config", "logoUrl"));
        return this;
    }

    public List<WebElement> getFooterOptionsByMainName(String mainName) {
        return driver.findElements(By.xpath(String.format("//div[@class='navFooterColHead' and text()='%s']/parent::div/ul/li", mainName)));
    }

    public void clickOnSignInMenu() {
        waiters.fluentWaitVisibilityOfElement(getSignInMenu()).click();
    }

    public String getAccountGreetingText() {
        return getAccountName().getText();
    }

    public StartedPage fillSearchField(String text) {
        getSearchField().clear();
        getSearchField().sendKeys(text);
        return this;
    }

    public void clickOnCartButton() {
        getCartButton().click();
    }

    public List<String> getListOfFooterOptionsByName(String columnName) {
        List<String> list = CommonMethodsForList.getItemsNamesText(getFooterOptionsByMainName(columnName));
        return list.stream().map(el -> el.replaceAll("›", "")).collect(Collectors.toList());
    }
}
