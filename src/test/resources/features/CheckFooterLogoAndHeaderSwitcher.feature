@amazon
Feature: I want to check logo in the footer

  Background:
    Given I log in

  Scenario: check footer logo
    Then I see logo in the footer
    Then I see language switcher in the header
    Then I see that English is default language