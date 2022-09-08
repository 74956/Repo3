package org.example.service;

import org.example.object.GamingMouseProduct;
import org.example.object.HeadsetProduct;
import org.example.object.PhoneProduct;
import org.example.pages.ShoppingCartPage;

import java.util.logging.Logger;

public class ShoppingCartPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ShoppingCartPageService.class.getName());
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public ShoppingCartPageService goToSoppingCartPage() {
        shoppingCartPage.goToSoppingCartPage();
        return this;
    }

    public boolean isShoppingCartDisplayed(String title) {
        boolean result = shoppingCartPage.getShoppingCartNameText().equals(title);
        log.info("Shopping cart is displayed - " + result);
        return result;
    }

    public boolean isListOfElementsInTheShoppingCartEmpty() {
        boolean result = shoppingCartPage.isListOfElementsInTheShoppingCartEmpty();
        log.info("List of elements in the shopping cart is empty - " + result);
        return result;
    }

    public String getItemNameText() {
        String name = shoppingCartPage.getItemsNameText();
        log.info("Get item name - " + name);
        return name;
    }

    public String getItemPriceText() {
        String price = shoppingCartPage.getItemsPriceText();
        log.info("Get item price - " + price);
        return price;
    }

    public String getProductFieldValueByFieldNameText(String fieldName) {
        String fieldValue = shoppingCartPage.getProductFieldValueByFieldNameText(fieldName);
        log.info("Get field value - " + fieldValue);
        return fieldValue;
    }

    public ShoppingCartPageService clickOnDeleteButton() {
        log.info("Click on 'Delete' button");
        shoppingCartPage.clickOnDeleteButton();
        return new ShoppingCartPageService();
    }

    public PhoneProduct getActualPhoneProduct() {
        PhoneProduct phoneProduct = new PhoneProduct();
        String productName = getItemNameText();
        phoneProduct.setName(productName);
        phoneProduct.setSize(getProductFieldValueByFieldNameText("Size"));
        phoneProduct.setColor(getProductFieldValueByFieldNameText("Color"));
        phoneProduct.setServiceProvider(getProductFieldValueByFieldNameText("Service Provider"));
        phoneProduct.setPrice(getItemPriceText());
        return phoneProduct;
    }

    public GamingMouseProduct getActualGamingMouseProduct() {
        GamingMouseProduct gamingMouseProduct = new GamingMouseProduct();
        String productName = getItemNameText().substring(0, 40);
        gamingMouseProduct.setName(productName);
        gamingMouseProduct.setColor(getProductFieldValueByFieldNameText("Color"));
        gamingMouseProduct.setPrice(getItemPriceText());
        return gamingMouseProduct;
    }

    public HeadsetProduct getActualHeadsetProduct() {
        HeadsetProduct headsetProduct = new HeadsetProduct();
        String productName = getItemNameText().substring(0, 40);
        headsetProduct.setName(productName);
        headsetProduct.setPrice(getItemPriceText());
        headsetProduct.setStyle(getProductFieldValueByFieldNameText("Style"));
        return headsetProduct;
    }
}
