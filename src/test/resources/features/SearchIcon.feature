
Feature: Positive Search Icon Function

  Background: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible



  Scenario Outline:  Search Product – Exact Match
    When User click the search icon
    And User enter "<product>" and search
    Then User verifies "<product>" results
    Examples:
      | product       |
      | cable         |
      | cab           |
      | CABLE         |
      | cAbLe         |
      | capsule plate |

  Scenario: Search Product with Trim
    When User click the search icon
    And User enter " cable " and search
    Then User verifies " cable " results



  Scenario Outline: Search Product -Exact Match With UserLogin
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    When User click the search icon
    And User enter "<product>" and search
    Then User verifies "<product>" results
    Examples:
      | product       |
      | cable         |
      | cab           |
      | CABLE         |
      | cAbLe         |
      | capsule plate |


  Scenario: Search Product with Trim - With UserLogin
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed
    When User click the search icon
    And User enter " cable " and search
    Then User verifies " cable " results
