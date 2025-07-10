Feature: Change Password Functionality

  Background:  : First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible


  Scenario: Change Password with valid credentials
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user enters the current password, sets a new password, and confirms it.
    Then  The user verifies that the password change was successful

  Scenario: Negative Test – Change Password by filling only the password field
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user wants to change the password by filling in only the password field.
    Then  It is verified that the user is unable to change the password.


  Scenario: Negative Test2 – Change Password by filling only the confirm password field
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user wants to change the password by filling in only the confirm password field.
    Then  It is confirmed that the password change was unsuccessful.


  Scenario: Negative Test3 – Change Password with no fields filled.
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user tries to change the password without filling any fields.
    Then  It is confirmed that the password change was unsuccessful.

  Scenario: Password change using the current password.
    When  The user logs into the account
    And   The user navigates to the change password page
    And   The user attempts to change the password by entering the same passwords.
    Then  The user verifies that the password change was successful
