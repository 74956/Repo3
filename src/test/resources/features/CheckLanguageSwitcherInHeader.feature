@amazon
Feature: I want to check language switcher in the header

  Background:
    Given I log in

  Scenario Outline: check language switcher
    Then I choose "<language>" from switcher and compare actual language with "<expected>"
    Examples:
      | language | expected |
      | es_US    | es-us    |
      | ar_AE    | ar-ae    |
      | de_DE    | de-de    |
      | he_IL    | he-il    |
      | ko_KR    | ko-kr    |
      | pt_BR    | pt-br    |
      | zh_CN    | zh-cn    |
      | zh_TW    | zh-tw    |
      | en_US    | en-us    |