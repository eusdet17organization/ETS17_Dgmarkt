Feature: Login Functionality

  Background:
    Given User is on the login page
    Given User enters valid credentials
    Given User verifies that main page is visible


  Scenario: Positive Login Test
    When The user clicks on My Account button and clicks on Login button after enters valid credentials
    Then The user verifies that welcome message is displayed


  Scenario Outline: Positive Login Test with Different Credentials
    When The user clicks on My Account button and clicks on Login button after enters "<E-Mail Address>" and "<Password>"
    Then The user verifies that welcome message is displayed
    Examples:
      | E-Mail Address                                                  | Password                    |
      | test.test01@test.com                                            | Asdf.%&*+                   |
      | test.test02@test.com                                            | Asdf.%&* +                  |
      | test.test06@test.com                                            | Asdf.%&*+ 123               |
      | testtesttest@test.com                                           | abcdefgh                    |
      | 123456789@test.com                                              | 123456789                   |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com     | aaaaaaaaaaaaaaaaaaaaaa      |
      | 123456789123456789123456789123456789123456789123456789@test.com | 123456789123456789123456789 |


  Scenario Outline: Negative Login Test
    When The user clicks on My Account button and clicks on Login button after enters "<E-Mail Address>" and "<Password>"
    Then The user verifies that error message is displayed
    Examples:
      | E-Mail Address                                                                                                | Password                                                                                             |
      | test.test@test.com                                                                                            |                                                                                                      |
      |                                                                                                               | Asdf.123                                                                                             |
      | test.test@                                                                                                    | Asdf.123                                                                                             |
      | test.test@test.com                                                                                            | Asdf.987654321                                                                                       |
      | test987654321@test.com                                                                                        | Asdf.123                                                                                             |
      | qwerty987654321@test.com                                                                                      | qwerty987654321%&?*                                                                                  |
      | 123456                                                                                                        | 123456                                                                                               |
      | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
      | 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111@test.com           | aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa |
      | test.%&*+@test.com                                                                                            | Asdf.123                                                                                             |
      | test. test@test.com                                                                                           | Asdf.123                                                                                             |

  @wip
  Scenario Outline: Forgotten Password Test
    When The user clicks on My Account button and clicks on Login button
    Then The user clicks on Forgotten Password Button
    Then The user verifies Forgotten Password Text
    Then The user enters "<E-Mail Address>" in the E-Mail Address field
    And The user clicks on Continue Button
    Then The user verifies that confirmation message is displayed
    Examples:
      | E-Mail Address     |
      | test.test@test.com |
    