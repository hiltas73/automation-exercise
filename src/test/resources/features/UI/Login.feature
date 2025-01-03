Feature: Login to app

  Background: All scenarios will use below step
    Given user is on the login page

  @ui
  Scenario: Login with valid credentials
    When user fill in username
    And user fill in password
    And user click on the "Login" button
    Then user should be redirected to the home page

  @ui
  Scenario Outline: Login with invalid email and password
    When user fill in "<invalid_email>" as email
    And user fill in "<invalid_password>" as password
    And user click on the "Login" button
    Then user should see an error message

    Examples:
      | invalid_email       | invalid_password |
      | invalid@example.com | wrongPassword123 |
      | user@invalid.com    | 123456           |
      | invalid@example.com | !+               |
      | invalid@example.com | validPassword    |
      | invalid@example.com | validPassword    |