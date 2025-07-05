Feature: Wist List
  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible

  Scenario: Add To Wist List
    Then  user clicks from category to television
    When  User hovers over the product and clicks the wish list button
    Then  User wish list sees added pop-ups
    Then  User confirms that the product has been added to the wish list



    Scenario:wish listen product deletion
      Then  user clicks from category to television
      When  User hovers over the product and clicks the wish list button
      Then  User wish list sees added pop-ups
      Then  User confirms that the product has been added to the wish list
      Then user confirms that the base has been deleted
      Then user  " Success: You have modified your wish list! " sees your message

   Scenario:wish list add products to cart
     Then  user clicks from category to television
     When  User hovers over the product and clicks the wish list button
     Then  User wish list sees added pop-ups
     Then  User confirms that the product has been added to the wish list
     Then User adds the product in the wist list to the cart
     Then User add to cart sees added pop-ups
     Then User confirms that the product has been added to the cart

   Scenario:add wish list products without user login
     Then  user clicks on category and television
     When  User hovers over the product and clicks the wish list button
     Then  User wish list sees added pop-ups clicks to login
     Then  user logs in  clicks to wish list button
     Then  User confirms that the product has been added to the wish list


   Scenario: wish listen product deletion
     Then  user clicks on category and television
     When  User hovers over the product and clicks the wish list button
     Then  User wish list sees added pop-ups clicks to login
     Then  user logs in  clicks to wish list button
     Then  User confirms that the product has been added to the wish list
     Then user confirms that the base has been deleted
     Then user  " Success: You have modified your wish list! " sees your message
  @wip
  Scenario:wish list add products to cart
    Then  user clicks on category and television
    When  User hovers over the product and clicks the wish list button
    Then  User wish list sees added pop-ups clicks to login
    Then  user logs in  clicks to wish list button
    Then  User confirms that the product has been added to the wish list
    Then User adds the product in the wist list to the cart
    Then User add to cart sees added pop-ups
    Then User confirms that the product has been added to the cart

