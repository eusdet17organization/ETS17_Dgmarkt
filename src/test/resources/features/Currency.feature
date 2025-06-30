Feature: Currency Function

  Background: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed


  Scenario Outline: Product Currency Change
    When User navigate to "<product>" page
    And User click the Currency text
    And User click the any "<Currency>"
    Then User verifies "<Currency>" of product
    Examples:
      | product         | Currency         |
      | TELEVISIONS     | € Euro           |
      | Health & Beauty | £ Pound Sterling |
      | TV Accessories  | $ US Dollar      |
      | Networking      | € Euro           |






