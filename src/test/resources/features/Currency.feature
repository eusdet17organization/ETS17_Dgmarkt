
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


  Scenario Outline: Change in the amount of money according to the exchange rate
    When User navigate to "<product>" page
    And User click the Currency text
    And User click the any "<Currency>"
    Then The user verifies that the product price has changed numerically.
    Examples:
      | product         | Currency         |
      | TELEVISIONS     | € Euro           |
      | Health & Beauty | £ Pound Sterling |
      | TV Accessories  | $ US Dollar      |
      | Networking      | € Euro           |


  Scenario Outline: Currency dropdown name change
    When User click the Currency text
    And User click the any "<Currency>"
    Then User verifies that the currency has changed in the menu
    Examples:
      | Currency         |
      | £ Pound Sterling |
      | $ US Dollar      |
      | € Euro           |



  Scenario Outline: Currency when the shopping is completed
    When User navigate to "<product>" page
    And User click the Currency text
    And User click the any "<Currency>"
    Then User adds product to cart
    When User click viewCart icon
    When User click checkout button
    When User complete the order in checkout page
    Then User verifies that the product in the checkout page with correct "<Currency>"
    Examples:
      | product         | Currency         |
      | TELEVISIONS     | € Euro           |
      | Health & Beauty | £ Pound Sterling |
      | TV Accessories  | $ US Dollar      |
      | Networking      | € Euro           |


  Scenario Outline: Currency Control in Cart
    When User navigate to "<product>" page
    And User click the Currency text
    And User click the any "<Currency>"
    Then User adds product to cart
    When User click viewCart icon
    Then User verifies that the product in the cart with correct "<Currency>"
    Examples:
      | product         | Currency         |
      | TELEVISIONS     | € Euro           |
      | Health & Beauty | £ Pound Sterling |
      | TV Accessories  | $ US Dollar      |
      | Networking      | € Euro           |



















