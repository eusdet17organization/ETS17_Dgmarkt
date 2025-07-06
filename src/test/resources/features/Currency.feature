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


  Scenario: Currency in Cart
    When User adds a product to cart
    Then "Successful: You have added ------- to your shopping cart!" message is displayed
    And  User clicks on cart icon
    Then User should see added product in cart
    Then User verifies correct currency of product in cart




