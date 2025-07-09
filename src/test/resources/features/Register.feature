
Feature: Positive User Register Functionality

  Background: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible
    Given User navigate the register account page


  Scenario: Positive User Register
    When User fills in mandatory fields
    Then User verifies that the message "Thank you for registering with Your Store!" appears


  Scenario: Privacy Policy Information
    When User click the Privacy Policy Text
    Then User verifies that opened Privacy Policy pop-up


  Scenario: Placeholder and Textbox Similarity Comparison
    Then User verifies placeholder and textbox equal
      | First Name       |
      | Last Name        |
      | E-Mail           |
      | Telephone        |
      | Password         |
      | Password Confirm |

    Scenario: Masked Password and Password Confirm
      When User fills password and password confirm field
      Then User verifies that password and password confirm are masked

