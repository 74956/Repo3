package org.example.service;

import org.example.pages.CartPage;

import java.util.logging.Logger;

public class CartPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(CartPageService.class.getName());
    private CartPage cartPage = new CartPage();

    public boolean isProductImageDisplayed() {
        boolean result = cartPage.isProductImageDisplayed();
        log.info("Product image displayed " + result);
        return result;
    }

    public String getMsgText() {
        log.info("Get msg text");
        return cartPage.getMsgText();
    }

    public String getColor() {
        log.info("Get icon color");
        return cartPage.getColor();
    }

    public ShoppingCartPageService clickOnGoToCartButton() {
        log.info("Click on 'Go to cart' button");
        cartPage.clickOnGoToCartButton();
        return new ShoppingCartPageService();
    }
}
