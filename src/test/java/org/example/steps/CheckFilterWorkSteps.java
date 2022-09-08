package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.service.CartPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.util.CommonMethodsForList;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFilterWorkSteps {

    private StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService = new ResultPageService();
    private ProductPageService productPageService = new ProductPageService();
    private CartPageService cartPageService = new CartPageService();
    private ShoppingCartPageService shoppingCartPageService = new ShoppingCartPageService();

    @When("User is searching for {string}")
    public void userIsSearchingFor(String product) {
        startedPageService.fillSearchField(product);
    }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        resultPageService.clickOnSearchButton();
    }

    @And("User checks that list of elements is not empty")
    public void userChecksThatListOfElementsIsNotEmpty() {
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }

    @And("User checks that cart has {int} items inside")
    public void userChecksThatCartHasItemsInside(int itemQuantity) {
        assertThat("Cart is not empty by default", productPageService.getQuantityOfItemsInTheCart(), Matchers.equalTo(itemQuantity));
    }

    @And("Users clicks on filter {string}")
    public void usersClicksOnFilter(String priceFilter) {
        resultPageService.clickOnDropdownWithFilter(priceFilter);
    }

    @And("User checks price sort from High to low prices")
    public void userChecksPriceSortFromHighToLowPrices() {
        List<Integer> actualResultProductList = resultPageService.listOfProductPrice();
        List<Integer> newList = new ArrayList<>(actualResultProductList);
        List<Integer> sortedNaturalOrderList = newList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> expectedResultProductList = sortedNaturalOrderList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        assertThat("Price is sorted wrong", actualResultProductList, Matchers.equalTo(expectedResultProductList));
    }

    @And("User checks visibility of {string} button")
    public void userChecksVisibilityOfButton(String buttonName) {
        assertThat("The 'See more' button isn`t displayed", resultPageService.isButtonDisplayedInTheYearFilter(buttonName));
    }

    @And("User checks filter of OS with value {string} and check name contains {string}")
    public void userChecksFilterOfOSWithValueAndCheckNameContains(String os, String compareValue) {
        resultPageService.clickOnFilterInput(os);
        List<String> listOfResult = resultPageService.getListOfItemsNames();
        assertThat("List of items not contain iOS product", CommonMethodsForList.isListContainsString(listOfResult, compareValue));
    }

    @And("User checks visibility of list of options name")
    public void userChecksVisibilityOfListOfOptionsName() {
        List<String> actualListOfOptionsNames = resultPageService.getListOfOptionsNameFromFilter();
        List<String> expectedListOfOptionsNames = Arrays.asList("Condition", "Climate Pledge Friendly", "Department",
                "Customer Reviews", "Brand", "Cell Phone Price", "Cell Phone Carrier", "Electronics Device Model Year",
                "Phone Color", "Cell Phone Internal Storage Memory", "Cell Phone Display Size", "Cell Phone Aspect Ratio",
                "Cellular Technology", "Cell Phone Operating System", "Cellular Phone Form Factor", "Cellular Phone SIM Card Size",
                "Cell Phone Connectivity Technology", "Cell Phone Features", "Cell Phone Display Type", "Cell Phone Camera Resolution",
                "Cell Phone Shooting Modes", "Cellular Phone Biometric Security Feature", "Cell Phone Human Interface Input",
                "Cellular Phone SIM Card Slot Count", "Cell Phone Connector Type", "Cell Phone Resolution", "Water Resistance Level", "Availability");

        assertThat("Check the names of filter options ", actualListOfOptionsNames, Matchers.equalTo(expectedListOfOptionsNames));
    }
}
