@amazon
Feature: I want to check language dropdown in the header on About Amazon page

  Background:
    Given I log in
    When I click on About Amazon button
    Then I see the new page is opened

  Scenario Outline: Check header on About Amazon page
    Then I see lang box with navigation to international sites
    Then I click on lang box and see new pop-up with title "International sites" and with choices "<Sites>" using "<Country>"
    Examples:
      | Sites        | Country       |
      | AsiaPacific  | Asia Pacific  |
      | Europe       | Europe        |
      | NorthAmerica | North America |