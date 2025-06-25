Feature: Login Functionality

  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible

  Scenario: Positive Login Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed