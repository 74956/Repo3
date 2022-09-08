package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.service.CartPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemToCartSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService = new ResultPageService();
    private ProductPageService productPageService = new ProductPageService();
    private CartPageService cartPageService = new CartPageService();
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    @When("User search for {string}")
    public void userSearchFor(String product) {
        startedPageService.fillSearchField(product);
    }

    @When("he clicks search button")
    public void clickOnSearchButton() {
        resultPageService.clickOnSearchButton();
    }

    @When("click on the first phone that appears in the search result")
    public void clickOnTheFirstPhoneThatAppearsInTheSearchResult() {
        resultPageService.clickOnFirstElementInListOfItems();
    }

    @When("he clicks on Add to cart button")
    public void heClicksOnAddToCartButton() {
        productPageService.clickAddCartButton();
    }

    @Then("product image is displayed")
    public void isProductImageIsDisplayed() {
        assertThat("The image of added item is displayed", cartPageService.isProductImageDisplayed());
    }

    @Then("check msg {string} is exist")
    public void checkMsgIsExist(String msg) {
        assertThat("Check added msg", cartPageService.getMsgText(), Matchers.equalTo(msg));
    }

    @Then("check the color of added icon is {string}")
    public void checkTheColorOfAddedIconIs(String color) {
        assertThat("Color is not green", cartPageService.getColor(), Matchers.equalTo(color));
    }

    @Then("check that cart has {int} item inside")
    public void checkThatCartHasItemInside(int itemQuantity) {
        assertThat("Cart is empty or has more than 1 item", productPageService.getQuantityOfItemsInTheCart(),
                Matchers.equalTo(itemQuantity));
    }

    @Then("check that {string} is displayed")
    public void checkThatShoppingCartDisplayed(String title) {
        cartPageService.clickOnGoToCartButton();
        assertThat("Shopping cart isn`t displayed", shoppingCartPageService.isShoppingCartDisplayed(title));
    }

    @Then("check that cart is not empty")
    public void checkThatCartIsNotEmpty() {
        assertThat("Shopping cart is empty", !shoppingCartPageService.isListOfElementsInTheShoppingCartEmpty());
    }

    @Then("delete item from cart")
    public void deleteItemFromCart() {
        startedPageService.clickOnCartButton();
        shoppingCartPageService.clickOnDeleteButton();
    }
}
