package org.example.steps;

import io.cucumber.java.en.And;
import org.example.enums.OptionName;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.util.CommonMethodsForList;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFilterWorkSteps {

    private ResultPageService resultPageService = new ResultPageService();
    private ProductPageService productPageService = new ProductPageService();

    @And("I see the list of elements is not empty")
    public void isListOfElementsNotEmpty() {
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }

    @And("I see the cart has {int} items inside")
    public void isCartHasItemsInside(int itemQuantity) {
        assertThat("Cart is not empty by default", productPageService.getQuantityOfItemsInTheCart(), Matchers.equalTo(itemQuantity));
    }

    @And("I click on filter {string}")
    public void clickOnFilter(String priceFilter) {
        resultPageService.clickOnPriceSortingFilter();
        resultPageService.clickOnDropdownWithFilter(priceFilter);
    }

    @And("I check price sort from High to low prices")
    public void checkPriceSortFromHighToLowPrices() {
        List<Integer> actualResultProductList = resultPageService.listOfProductPrice();
        List<Integer> newList = new ArrayList<>(actualResultProductList);
        List<Integer> sortedNaturalOrderList = newList.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> expectedResultProductList = sortedNaturalOrderList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        assertThat("Price is sorted wrong", actualResultProductList, Matchers.equalTo(expectedResultProductList));
    }

    @And("I see the {string} button")
    public void checkVisibilityOfButton(String buttonName) {
        assertThat("The 'See more' button isn`t displayed", resultPageService.isButtonDisplayedInTheYearFilter(buttonName));
    }

    @And("I check the filter of OS with value {string} and check name contains {string}")
    public void checkFilterOfOSWithValueAndSearchingNameContain(String os, String compareValue) {
        resultPageService.clickOnFilterInput(os);
        List<String> listOfResult = resultPageService.getListOfItemsNames();
        assertThat("List of items not contain iOS product", CommonMethodsForList.isListContainsString(listOfResult, compareValue));
    }

    @And("I see the list of options name")
    public void isOptionsNameDisplayed() {
        List<String> actualListOfOptionsNames = resultPageService.getListOfOptionsNameFromFilter();
        List<String> expectedListOfOptionsNames = Arrays.asList(OptionName.CONDITION.getOptionName(),
                OptionName.CLIMATE_PLEDGE_FRIENDLY.getOptionName(), OptionName.DEPARTMENT.getOptionName(),
                OptionName.CUSTOMER_REVIEWS.getOptionName(), OptionName.BRAND.getOptionName(), OptionName.CELL_PHONE_PRICE.getOptionName(),
                OptionName.CELL_PHONE_CARRIER.getOptionName(), OptionName.ELECTRONICS_DEVICE_MODEL_YEAR.getOptionName(),
                OptionName.PHONE_COLOR.getOptionName(), OptionName.CELL_PHONE_INTERNAL_STORAGE_MEMORY.getOptionName(),
                OptionName.CELL_PHONE_DISPLAY_SIZE.getOptionName(), OptionName.CELL_PHONE_ASPECT_RATIO.getOptionName(),
                OptionName.CELL_PHONE_OPERATION_SYSTEM.getOptionName(), OptionName.CELLULAR_PHONE_FORM_FACTOR.getOptionName(),
                OptionName.CELLULAR_PHONE_SIM_CARD_SIZE.getOptionName(), OptionName.CELL_PHONE_CONNECTIVITY_TECHNOLOGY.getOptionName(),
                OptionName.CELL_PHONE_FEATURES.getOptionName(), OptionName.CELL_PHONE_DISPLAY_TYPE.getOptionName(),
                OptionName.CELL_PHONE_CAMERA_RESOLUTION.getOptionName(), OptionName.CELL_PHONE_SHOOTING_MODES.getOptionName(),
                OptionName.CELLULAR_PHONE_BIOMETRIC_SECURITY_FEATURE.getOptionName(), OptionName.CELL_PHONE_HUMAN_INTERFACE_INPUT.getOptionName(),
                OptionName.CELLULAR_PHONE_SIM_CARD_SLOT_COUNT.getOptionName(), OptionName.CELL_PHONE_CONNECTOR_TYPE.getOptionName(),
                OptionName.CELL_PHONE_RESOLUTION.getOptionName(), OptionName.WATER_RESISTANCE_LEVEL.getOptionName(),
                OptionName.CELLULAR_PHONE_VIDEO_CAPTURE_RESOLUTION.getOptionName(), OptionName.CELLULAR_PHONE_AVERAGE_LIFE.getOptionName(),
                OptionName.CELLULAR_PHONE_CELLULAR_TECHNOLOGY.getOptionName(), OptionName.FROM_OUR_BRANDS.getOptionName(), OptionName.AVAILABILITY.getOptionName());
        assertThat("Check the names of filter options ", actualListOfOptionsNames, Matchers.equalTo(expectedListOfOptionsNames));
    }
}