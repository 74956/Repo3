@amazon
Feature: Check shop tab names

  Background:
    Given I log in

  Scenario: Verification of button names in the shop navigation panel
    Then I check list of actual button names with expected read from file by "buttonNames"