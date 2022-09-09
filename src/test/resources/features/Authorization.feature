@amazon
Feature: I want to authorize into the site

  Background:
    Given I log in

  Scenario: User log in
    Then I see on the started page greeting text "Hello, Amili"