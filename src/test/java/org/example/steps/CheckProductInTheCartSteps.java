package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.object.PhoneProduct;
import org.example.service.CartPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckProductInTheCartSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService;
    private PhoneProduct expectedPhone;

    @Then("I get expected phone from the property file by key {int}")
    public void getExpectedPhoneCharacteristicsFromFile(int key) {
        List<String> list = ReadDataFromFile.getDataFromProperties("src/test/resources/product.properties", String.valueOf(key));
        expectedPhone = new PhoneProduct(list);
    }

    @Then("I search for iphone by name {string}")
    public void searchPhoneByName(String phoneName) {
        resultPageService = startedPageService.fillSearchField(phoneName);
        resultPageService.clickOnSearchButton();
    }

    @Then("I add the phone {string} to the cart")
    public void addThePhoneToTheCart(String phoneName) {
        ProductPageService productPageService = resultPageService.clickOnElementInTheList(phoneName);
        cartPageService = productPageService.clickAddCartButton();
    }

    @Then("I open the cart")
    public void goToTheCart() {
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();
    }

    @Then("I compare actual phone characteristics with expected phone")
    public void compareActualPhoneCharacteristicsWithExpected() {
        assertThat("These phones are not equal", shoppingCartPageService.getActualPhoneProduct(),
                Matchers.equalTo(expectedPhone));
    }

    @Then("I delete added product from the cart")
    public void deleteProductFromTheCart() {
        startedPageService.clickOnCartButton();
        shoppingCartPageService.clickOnDeleteButton();
    }
}