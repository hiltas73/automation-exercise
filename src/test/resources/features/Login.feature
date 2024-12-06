Feature: Login to app
  @wip
  Scenario: Login with valid credentials
    Given user is on the login page
    When user fill in username
    And user fill in password
    And user click on the Login button
    Then user should be redirected to the home page