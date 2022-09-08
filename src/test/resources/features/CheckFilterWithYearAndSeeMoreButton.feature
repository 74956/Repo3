@amazon
Feature: check year filter and See more button

  Background:
    Given User is log in
    When User is searching for "iphone"
    When User clicks search button
    And User checks that list of elements is not empty
    And User checks that cart has 0 items inside
    And Users clicks on filter "Price: High to Low"
    And User checks price sort from High to low prices
    And User checks visibility of "See more" button

  Scenario Outline:
    Then User checks if "<button>" button still displayed after using filter with "<year>"
    Examples:
      | button   | year |
      | See more | 2018 |
      | See more | 2022 |