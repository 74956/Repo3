@amazon
Feature: Want to check filter in result page and if cart is empty in the beginning of test

  Background:
    Given I log in
    When I search for "iphone"

  Scenario: check products
    And I see the list of elements is not empty
    And I see the cart has 0 items inside
    And I click on filter "Price: High to Low"
    And I check price sort from High to low prices
    And I see the "See more" button
    And I see the list of options name
    And I check the filter of OS with value "iOS" and check name contains "iPhone"