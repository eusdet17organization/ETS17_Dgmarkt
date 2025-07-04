Feature: Checkout page and completion of payment

  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible
    When User adds a product to cart
    And  User clicks on cart icon



@wip
  Scenario: Go to the checkout page from the cart icon and complete the checkout process
    When  User clicks the "Checkout" button
    Then  The user fills in the "Billing Details" page and clicks "Continue" button.
    Then  In the "Delivery Details" section, the user selects "I want to use an existing address" and clicks the "Continue" button
    Then  Select "I have read and accept the Terms and Conditions" on the "Delivery Method" page and click on the "Continue" button.
    Then  The user selects the "Payment Method" as cash and clicks on the "I have read and accept the Terms and Conditions" box without leaving a comment and clicks on the "Continue" button
    Then  The user checks the product in the "Confirm Order" section and clicks the "Confirm Order" button
    Then  The user completes the order and goes to the page with the message "Your order has been placed!"






