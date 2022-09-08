package org.example.pages;

import org.example.util.CommonMethodsForList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ResultPage extends BasePage {

    public List<WebElement> getListOfItems() {
        return driver.findElements(By.xpath("//a[@class='a-link-normal s-no-outline']"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
    }

    public WebElement getDropdownWithFilter() {
        return driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
    }

    public List<WebElement> getProductPrice() {
        return driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    }

    public List<WebElement> getOptionsNameFromFilter() {
        return driver.findElements(By.xpath("//span[contains(@class,'puis-bold-weight-text')]"));
    }

    public List<WebElement> getListOfColors() {
        return driver.findElements(By.xpath("//div[@class='colorsprite aok-float-left']"));
    }

    public List<WebElement> getListOfYearsInFilter() {
        return driver.findElements(By.xpath("//ul[@aria-labelledby='p_n_feature_nine_browse-bin-title']/li[@class='a-spacing-micro']//a/span"));
    }

    public List<WebElement> getListOfItemsName() {
        return driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
    }

    public List<String> getListOfItemsNamesText() {
        return CommonMethodsForList.getItemsNamesText(getListOfItems());
    }

    public void clickOnFirstElementInListOfItems() {
        CommonMethodsForList.clickOnFirstElementInListOfItems(getListOfItems());
    }

    public void clickOnElement(String element) {
        String nameOfElementInTheResultList = "//a[contains(@class,'s-underline-link-text')]//span[text()='%s']";
        driver.findElement(By.xpath(String.format(nameOfElementInTheResultList, element))).click();
    }

    public void clickOnSearchButton() {
        if (getSearchButton().isDisplayed()) {
            getSearchButton().click();
        } else {
            waiters.fluentWaitVisibilityOfElement(getSearchButton());
            getSearchButton().click();
        }
    }

    public void clickOnFilterInput(String inputName) {
        String filterInputButton = "//span[@class='a-size-base a-color-base' and text()='%s']/parent::a/div//i";
        driver.findElement(By.xpath(String.format(filterInputButton, inputName))).click();
    }

    public WebElement clickOnClearButton(){
        return driver.findElement(By.xpath("//a[contains(@class,'s-navigation-clear-link')]/span[2]"));
    }

    public void clickOnDropdownWithFilter(String fieldText) {
        Select selectListBoxOption = new Select(getDropdownWithFilter());
        selectListBoxOption.selectByVisibleText(fieldText);
    }

    public List<Integer> getListOfProductPrices() {
        return CommonMethodsForList.convertElementsIntoInteger(getProductPrice());
    }

    public List<String> getListOfOptionsNameFromFilter() {
        return CommonMethodsForList.getItemsNamesText(getOptionsNameFromFilter());
    }

    public void clickOnRandomColor() {
        int randomIndex = CommonMethodsForList.getRandomIndexInList(getListOfColors());
        getListOfColors().get(randomIndex).click();
    }

    public boolean isButtonDisplayedInTheYearFilter(String str) {
        List<String> collectionOfElementsOfYearFilter = CommonMethodsForList.getItemsNamesText(getListOfYearsInFilter());
        return CommonMethodsForList.isListContainsString(collectionOfElementsOfYearFilter, str);
    }

    public List<String> getListOfItemsNames() {
        return CommonMethodsForList.getItemsNamesText(getListOfItemsName());
    }
}
