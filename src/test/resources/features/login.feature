Feature: Login Scenarios

  Scenario: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible