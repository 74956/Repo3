package org.example.pages;

import org.example.util.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage goToSoppingCartPage() {
        driver.navigate().to(GetProperties.getProperties("config", "shoppingCartUrl"));
        return this;
    }

    public WebElement getShoppingCartText() {
        return driver.findElement(By.xpath("//div[contains(@class,'sc-compact-bottom')]/div[1]"));
    }

    public List<WebElement> getListOfElementsInTheShoppingCart() {
        return driver.findElements(By.xpath("//img[@class='sc-product-image']"));
    }

    public WebElement getItemsName() {
        return waiters.waitForVisibilityOfElement(driver.findElement(By.xpath("//div//span[@class='a-truncate-cut']")));
    }

    public WebElement getItemsPrice() {
        return driver.findElement(By.xpath("//span[contains(@id,'activecart')]//span[contains(@class,'sc-price')]"));
    }

    public WebElement getDeleteProductButton() {
        return driver.findElement(By.xpath("//input[@value='Delete']"));
    }

    public String getShoppingCartNameText() {
        return waiters.waitForVisibilityOfElement(getShoppingCartText()).getText();
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        waiters.waitForVisibilityOfElements(getListOfElementsInTheShoppingCart());
        return getListOfElementsInTheShoppingCart().isEmpty();
    }

    public String getItemsNameText() {
        return getItemsName().getText();
    }

    public String getItemsPriceText() {
        return getItemsPrice().getText();
    }

    public String getProductFieldValueByFieldNameText(String fieldName) {
        String itemFields = "//span[@class='a-size-small a-text-bold' and contains(text(),'%s')]/following-sibling::span";
        return driver.findElement(By.xpath(String.format(itemFields, fieldName))).getText();
    }

    public void clickOnDeleteButton() {
        getDeleteProductButton().click();
    }
}