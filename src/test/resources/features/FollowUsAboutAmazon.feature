@amazon
Feature: Check 'Follow us' dropdown

  Background:
    Given I log in
    When I click on About Amazon button
    Then I see the new page is opened
    Then I see search field
    Then I see dropdowns in the header

  Scenario Outline: I check dropdown 'Follow us'
    When I navigate on dropdown "Follow us"  and I check columns entity "<columns>" using "<columnName>"
    Examples:
      | columns           | columnName           |
      | Twitter           | Twitter              |
      | Linkedin          | Linkedin             |
      | Instagram         | Instagram            |
      | Facebook          | Facebook             |
      | YouTube           | YouTube              |
      | BlogsAndNewsSites | Blogs and news sites |