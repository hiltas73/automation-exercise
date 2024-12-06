Feature: Register User
@wip
  Scenario: Register User with valid credentials (Happy Path Scenario)
    Given I am on the homepage
    When I click on SignupLogin button
    And I see New User Signup page
    And I enter 'John Doe' into the name field
    And I enter email address into the email field
    And I click on Signup button
    Then I see account information page
    When I enter necessary information
    Then I see ACCOUNT CREATED! is visible
    And I click Continue button
    Then I see Logged in as username is visible
    And I click on Delete Account button
    Then I see ACCOUNT DELETED! is visible