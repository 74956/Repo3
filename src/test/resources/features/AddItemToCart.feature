@amazon
Feature: I want to check adding product to shopping cart

  Background:
    Given User is log in

  Scenario: check product image
    When User search for "iphone"
    When he clicks search button
    And click on the first phone that appears in the search result
    And he clicks on Add to cart button
    Then product image is displayed
    Then check msg "Added to Cart" is exist
    Then check the color of added icon is "rgba(6, 125, 98, 1)"
    Then check that cart has 1 item inside
    Then check that "Shopping Cart" is displayed
    Then check that cart is not empty
    Then delete item from cart