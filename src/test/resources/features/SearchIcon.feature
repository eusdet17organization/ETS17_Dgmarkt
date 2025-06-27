Feature: Positive Search Icon Function

  Background: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible
    When User click the search icon


  Scenario Outline:  Search Product – Exact Match
    And User enter "<product>" and search
    Then User verifies "<product>" results
    Examples:
      | product       |
      | cable         |
      | cab           |
      | CABLE         |
      | cAbLe         |
      | capsule plate |


