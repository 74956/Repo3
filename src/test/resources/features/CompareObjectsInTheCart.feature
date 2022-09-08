@amazon
Feature: Compare actual object with expected

  Background:
    Given User is log in

  Scenario Outline:
    When User reads property by <Key> and compare with created model
    Examples:
      | Key |
      | 3   |
