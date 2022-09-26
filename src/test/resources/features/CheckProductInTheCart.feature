@amazon
Feature: Compare actual object with expected

  Background:
    Given I log in

  Scenario:
    Then I get expected phone from the property file by key 3
    Then I search for iphone by name "Apple iPhone 12, 64GB, Green - Fully Unlocked (Renewed)"
    Then I add the phone "Apple iPhone 12, 64GB, Green - Fully Unlocked (Renewed)" to the cart
    Then I open the cart
    Then I compare actual phone characteristics with expected phone
    Then I delete added product from the cart