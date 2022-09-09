@amazon
Feature: Compare actual object with expected

  Background:
    Given I log in

  Scenario Outline:
    When I read property file by key <Key> and compare with created model
    Examples:
      | Key |
      | 3   |
