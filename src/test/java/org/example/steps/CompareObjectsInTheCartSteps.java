package org.example.steps;

import io.cucumber.java.en.When;
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

public class CompareObjectsInTheCartSteps {

    private ProductPageService productPageService;
    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;
    private CartPageService cartPageService;
    private ShoppingCartPageService shoppingCartPageService;
    private List<String> list;

    @When("User reads property by {int} and compare with created model")
    public void userReadsPropertyByAndCompareWithCreatedModel(int key) {
        list = ReadDataFromFile.getDataFromProperties(String.valueOf(key));
        PhoneProduct expectedPhone = new PhoneProduct(list);
        resultPageService = startedPageService.fillSearchField(expectedPhone.getName());
        resultPageService.clickOnSearchButton();
        productPageService = resultPageService.clickOnElementInTheList((expectedPhone.getName()));
        cartPageService = productPageService.clickAddCartButton();
        shoppingCartPageService = cartPageService.clickOnGoToCartButton();

        assertThat("These objects are not equal", shoppingCartPageService.getActualPhoneProduct(),
                Matchers.equalTo(expectedPhone));
    }
}
