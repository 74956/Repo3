@amazon
Feature: check year filter and See more button

  Background:
    Given I log in
    When I search for "iphone"
    And I see the list of elements is not empty
    And I see the cart has 0 items inside
    And I click on filter "Price: High to Low"
    And I check price sort from High to low prices
    And I see the "See more" button

  Scenario Outline:
    Then I see "<button>" button still displayed after using filter with "<year>"
    Examples:
      | button   | year |
      | See more | 2018 |
      | See more | 2022 |