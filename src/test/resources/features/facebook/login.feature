@ALL @fblogin
Feature: FB - login
  As a user
  I want to perform login on facebook
  but I can't see my news feed due to FB restiction

  Scenario: User has failed to login FB
    Given I open facebook login page
    When I input email and password
    And I click button login
    Then I can't see my news feed
    But I see FB has disabled my account
