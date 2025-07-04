Feature: Login Scenarios

  Background:
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible

  @wip
  Scenario Outline: SubCategory Selection
    When  The user clicks on the "<subcategory>" subcategory.
    Then  The user verifies that the "<subcategory>" subcategory page is displayed.
    Examples:
      | subcategory     |
      | Televisions     |
      | Health & Beauty |
      | TV Accessories  |
      | Networking      |

  @wip
  Scenario Outline: SubCategory Selection with hover
    When  The user clicks on the "<subcategory>" subcategory with hover.
    Then  The user verifies that the "<subcategory>" subcategory page is displayed with hover.
    Examples:
      | subcategory     |
      | Televisions     |
      | Health & Beauty |
      | TV Accessories  |
      | Networking      |



