Feature: Wist List
  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible
@wip
  Scenario: Add To Wist List
    Then  user clicks from category to television
    When  User hovers over the product and clicks the wish list button
    Then  User wish list sees added pop-ups
    Then  User confirms that the product has been added to the wish list


    Scenario:wish listen product deletion
      When the user clicks the close button on the top right of the product
      Then user confirms that the base has been deleted
      Then user  " Success: You have modified your wish list! " sees your message