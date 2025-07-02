Feature: Access the cart from the "View Cart" button


  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible
    When User adds a product to cart
    And  User clicks on cart icon





    Scenario: Verify that the user should be able to access the cart from the view cart button
      When The User click the "View Cart" button
      Then  The user sees the "Shopping Cart" banner and accesses the cart

