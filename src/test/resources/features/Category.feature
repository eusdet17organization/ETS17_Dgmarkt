Feature: Login Scenarios

  Background:
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible
  @wip
  Scenario: SubCategory Selection
    When  The user clicks on the Television subcategory.
    Then  The user verifies that the Television subcategory page is displayed.
    When  The user clicks on the Health & Beauty subcategory.
    Then  The user verifies that the Health & Beauty subcategory page is displayed.
    When  The user clicks on the TV Accessories subcategory.
    Then  The user verifies that the TV Accessories subcategory page is displayed.
    When  The user clicks on the Networking subcategory.
    Then  The user verifies that the Networking subcategory page is displayed.



