Feature: Login Scenarios

  Background:
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible


  Scenario Outline: SubCategory Selection
    When  The user clicks on the "<subcategory>" subcategory.
    Then  The user verifies that the "<subcategory>" subcategory page is displayed.
    Examples:
      | subcategory     |
      | Televisions     |
      | Health & Beauty |
      | TV Accessories  |
      | Networking      |



