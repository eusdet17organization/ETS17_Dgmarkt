Feature: Negative User Register Functionality

  Background: First Login
    Given User is on the login page
    When  User enters valid credentials
    Then  User verifies that main page is visible
    Given User navigate the register account page


  Scenario Outline: Incomplete data entry
    When User fills in mandatory field "<First Name>","<Last Name>","<E-Mail>","<Telephone>","<Password>","<Password Confirm>"
    Then The warning message under "<field>" should contain "<message>"
    Examples:
      | First Name                            | Last Name                             | E-Mail           | Telephone                                          | Password  | Password Confirm | field     | message                                         |
      |                                       | abcd                                  | a1@gmail.com     | 123852658                                          | 123456789 | 123456789        | firstname | First Name must be between 1 and 32 characters! |
      | abcd                                  |                                       | a3@gmail.com     | 123852658                                          | 123456789 | 123456789        | lastname  | Last Name must be between 1 and 32 characters!  |
      | abcd                                  | abcd                                  |                  | 123852658                                          | 123456789 | 123456789        | email     | E-Mail Address does not appear to be valid!     |
      | asdf                                  | adsf                                  | a3@gmail.com     |                                                    | 123456789 | 123456789        | telephone | Telephone must be between 3 and 32 characters!  |
      | asdf                                  | asdf                                  | a4@gmail.com     | 123852658                                          |           | 123456789        | password  | Password must be between 4 and 20 characters!   |
      | asdfg                                 | asdfg                                 | a5@gmail.com     | 123852658                                          | 123456789 |                  | confirm   | Password confirmation does not match password!  |
      | asdfg                                 | asdfg                                 | a5.com           | 123852658                                          | 123456789 | 123456789        | email     | E-Mail Address does not appear to be valid!     |
      | asdfg                                 | asdfg                                 | a6@gmail.com     | 123852658                                          | 123456789 | 12345            | confirm   | Password confirmation does not match password!  |
      | asdfgasdfgasdfgasdfgasdfgasdfgasdfgas | asdfg                                 | a123@gmail.com   | 123852658                                          | 123456789 | 12345            | firstname | First Name must be between 1 and 32 characters! |
      | asdf                                  | asdfgasdfgasdfgasdfgasdfgasdfgasdfgas | a1234@gmail.com  | 123852658                                          | 123456789 | 12345            | lastname  | Last Name must be between 1 and 32 characters!  |
      | asdf                                  | asdfg                                 | a12345@gmail.com | 123852658                                          |           |                  | password  | Password must be between 4 and 20 characters!   |
      | asdf                                  | asdfg                                 | a12345@gmail.com | 123852658                                          | 123       | 123              | password  | Password must be between 4 and 20 characters!   |
      | asdf                                  | asdfgas                               | a12345@gmail.com | 11111111111111111111111111111111111111111111111111 | 123456    | 123456           | telephone | Telephone must be between 3 and 32 characters!  |

      | 12345                                 | asdfg                                 | a77@gmail.com     | 123852658                                          | 123456789 | 123456789        | firstname | First Name is not valid!                        |
      | asdfg                                 | 12345                                 | a170@gmail.com    | 123852658                                          | 123456789 | 123456789        | lastname  | Last Name is not valid!                         |
      | asdfg                                 | asdfg                                 | a121@gmail.com    | abcdefgh                                           | 123456789 | 123456789        | telephone | Telephone is not valid!                         |


  Scenario: Privacy Policy checkbox
    When User click the continue button
    Then The warning message should contain "Warning: You must agree to the Privacy Policy!"


