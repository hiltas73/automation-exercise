Feature: Login to app

  Scenario: Login with valid credentials
    Given user is on the login page
    When user fill in username
    And user fill in password
    And user click on the "Login" button
    Then user should be redirected to the home page

  @wip
  Scenario Outline: Login with invalid email and password
    Given user is on the login page
    When user fill in "<invalid_email>" as email
    And user fill in "<invalid_password>" as password
    And user click on the "Login" button
    Then user should see an error message

    Examples:
      | invalid_email       | invalid_password |
      | invalid@example.com | wrongPassword123 |
      | user@invalid.com    | 123456           |
      | invalid@example.com | ""               |
      | invalid@example.com | short            |

#      | ""                  | wrongPassword123 |
#      | userwithoutatsymbol | wrongPassword123 |