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



  Scenario Outline: User adds a product to cart with "Search" button
    Given User click the search icon
    When User searches for the "<product>" in the search bar
    And User click the product and "Add To Cart" button
    Examples:
      | product                                          |
      | Cello C4020G 40 Smart LED TV                     |
      | Daewoo D24RTSDVD 24 Smart LED TV With DVD        |















