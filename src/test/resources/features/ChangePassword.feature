Feature: Change Password Functionality

  Background:  : First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible

  @wip
  Scenario: Change Password with valid credentials
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user enters the current password, sets a new password, and confirms it.
    Then  The user verifies that the password change was successful
