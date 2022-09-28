@amazon
Feature: Check 'Our Impact' dropdown

  Background:
    Given I log in
    When I click on About Amazon button
    Then I see the new page is opened
    Then I see search field
    Then I see dropdowns in the header

  Scenario Outline: Navigate to 'Our Impact' and check columns in the dropdown
    When I navigate on dropdown "Our Impact" I check columns entity "<columns>" using "<columnName>"
    Examples:
      | columns         | columnName       |
      | EconomicImpact  | Economic Impact  |
      | Empowerment     | Empowerment      |
      | CommunityImpact | Community Impact |