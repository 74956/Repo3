@amazon
Feature: I want to check adding product to shopping cart

  Background:
    Given I log in

  Scenario: check product image
    When I search for "iphone"
    Then I add the first product to the cart
    Then I see the product image
    Then I see the msg "Added to Cart"
    Then I see the color of added icon is "rgba(6, 125, 98, 1)"
    Then I see the cart has 1 item inside
    Then I see the "Shopping Cart" is displayed
    Then I see that cart is not empty
    Then I delete item from cart