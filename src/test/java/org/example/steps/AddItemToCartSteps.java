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

    @When("I search for {string}")
    public void searchProduct(String product) {
        startedPageService.fillSearchField(product);
    }

    @When("I click search button")
    public void clickOnSearchButton() {
        resultPageService.clickOnSearchButton();
    }

    @When("I click on the first phone that appears in the search result")
    public void clickOnTheFirstPhoneThatAppearsInTheSearchResult() {
        resultPageService.clickOnFirstElementInListOfItems();
    }

    @When("I click on Add to cart button")
    public void clickOnAddToCartButton() {
        productPageService.clickAddCartButton();
    }

    @Then("I see the product image")
    public void isProductImageIsDisplayed() {
        assertThat("The image of added item is displayed", cartPageService.isProductImageDisplayed());
    }

    @Then("I see the msg {string}")
    public void isMsgAddedToCartDisplayed(String msg) {
        assertThat("Check added msg", cartPageService.getMsgText(), Matchers.equalTo(msg));
    }

    @Then("I see the color of added icon is {string}")
    public void checkTheColorOfProductIconAfterAddingToTheCart(String color) {
        assertThat("Color is not green", cartPageService.getColor(), Matchers.equalTo(color));
    }

    @Then("I see the cart has {int} item inside")
    public void checkThatCartHasOneItemInside(int itemQuantity) {
        assertThat("Cart is empty or has more than 1 item", productPageService.getQuantityOfItemsInTheCart(),
                Matchers.equalTo(itemQuantity));
    }

    @Then("I see the {string} is displayed")
    public void isShoppingCartDisplayed(String title) {
        cartPageService.clickOnGoToCartButton();
        assertThat("Shopping cart isn`t displayed", shoppingCartPageService.isShoppingCartDisplayed(title));
    }

    @Then("I see that cart is not empty")
    public void isCartNotEmpty() {
        assertThat("Shopping cart is empty", !shoppingCartPageService.isListOfElementsInTheShoppingCartEmpty());
    }

    @Then("I delete item from cart")
    public void deleteItemFromCart() {
        startedPageService.clickOnCartButton();
        shoppingCartPageService.clickOnDeleteButton();
    }
}
