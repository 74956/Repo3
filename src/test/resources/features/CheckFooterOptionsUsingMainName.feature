@amazon
Feature: I want to check footer vertical columns options

  Background:
    Given I log in

  Scenario Outline: Check columns options using column names
    Then I see footer options with "<columnName>" and compare them with data from file with "<Key>"
    Examples:
      | columnName              | Key                   |
      | Get to Know Us          | GetToKnowUs           |
      | Make Money with Us      | MakeMoneyWithUs       |
      | Amazon Payment Products | AmazonPaymentProducts |
      | Let Us Help You         | LetUsHelpYou          |