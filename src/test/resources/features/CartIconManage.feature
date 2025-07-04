Feature: Cart Button Management


  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible


  Scenario: Display empty cart
    Given User clicks on cart icon
    Then "Your shopping cart is empty!" must see your message


  Scenario: Display products added to cart
    When User adds a product to cart
    Then "Successful: You have added ------- to your shopping cart!" message is displayed
    And  User clicks on cart icon
    Then User should see added product in cart
    And  Product name, price and quantity should be displayed correctly


  Scenario: Removing products from the cart
    Given User adds a product to cart
    And  User clicks on cart icon
    Then User should see added product in cart
    Then User clicks the “Remove” button
    Then "Your shopping cart is empty!" must see your message









