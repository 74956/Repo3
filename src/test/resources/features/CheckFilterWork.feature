@amazon
Feature: Want to check filter in result page and if cart is empty in the beginning of test

  Background:
    Given User is log in
    When User search for "iphone"
    When he clicks search button

  Scenario: check products
    And User checks that list of elements is not empty
    And User checks that cart has 0 items inside
    And Users clicks on filter "Price: High to Low"
    And User checks price sort from High to low prices
    And User checks visibility of "See more" button
    And User checks visibility of list of options name
    And User checks filter of OS with value "iOS" and check name contains "iPhone"



