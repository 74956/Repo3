@amazon
Feature: I want to check header on About Amazon page

  Background:
    Given I log in

  Scenario Outline: Check header on About Amazon page
    When I click on About Amazon button
    Then I see the new page is opened
    Then I see search field
    Then I see dropdowns in the header
    Then I check the entity of every dropdown by "<dropdownElements>" using dropdown name "<name>"
    Then I check if envelope icon displayed and the text of the button is "Subscribe"
    Then I check that info slider is displayed and not empty
    Examples:
      | dropdownElements | name          |
      | WhoWeAre         | Who We Are    |
      | WhatWeDo         | What We Do    |
      | OurWorkplace     | Our Workplace |
      | OurPlanet        | Our Planet    |