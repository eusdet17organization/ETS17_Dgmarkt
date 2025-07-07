Feature: Cart Button Management


  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible



  Scenario: User adds a product to cart with "Add To Cart" button
    Then The user Login with MyAccount page
    When User adds a product to cart with "Add To Cart" button
    Then User copmlete the order steps
    Then  The user completes the order and goes to the page with the message "Your order has been placed!"



  Scenario: User adds a product to cart with "Search" button
    Then User click the search icon
    Then User searches for the product in the search bar
    And  User click the product and "Add To Cart" button












