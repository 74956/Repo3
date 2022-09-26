@amazon
Feature: Check Customer Service elements

  Background:
    Given I log in

  Scenario: I check 'Customer Service' elements
    Then I click on Customer Service button from started page
    Then I check visibility of Customer Service and Home buttons on the second navigation header
    Then I check greeting msg and info msg at the page container
    Then I check visibility of card`s imgs
    Then I check if Search field displayed
    Then I check the text under the search field
    Then I check that icon of loupe displayed
    Then I click on every help topic and check that it has addition cards with information
    Then I check visibility of card`s text and compare with expected text "text"
    Then I check options "options" in the column All help topics