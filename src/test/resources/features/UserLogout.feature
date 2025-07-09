Feature: Logout Functionality

  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible


  Scenario: Logout Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    When The user clicks on My Account button and clicks on Logout button
    Then The user closes the Account Logout popup by clicking continue


  Scenario: Logout Negative Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    And The user clicks on My Account button
    Then The user verifies that they are unable to log out by clicking the My Account button from the opened dropdown


  Scenario: Logout Negative Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    And The user clicks on My Account button
    Then The user verifies that they are unable to log out by clicking the Order History button from the opened dropdown


  Scenario: Logout Negative Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    And The user clicks on My Account button
    Then The user verifies that they are unable to log out by clicking the Transactions button from the opened dropdown


  Scenario: Logout Negative Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    And The user clicks on My Account button
    Then The user verifies that they are unable to log out by clicking the Downloads button from the opened dropdown


    Scenario: Logout “Back” button
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    When The user clicks on My Account button and clicks on Logout button
    Then The user clicks on the browser “Back” button
    Then The user closes the Sign Up Newsletter pop up
    Then The user verifies that they are on the main page