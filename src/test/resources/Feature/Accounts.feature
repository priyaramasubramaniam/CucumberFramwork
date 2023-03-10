Feature: Account page feature
  Background:
    Given User has already login to the Application
      | Username        | Password  |
      | priya@gmail.com | 123456789 |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      |ADD MY FIRST ADDRESS|
      |ORDER HISTORY AND DETAILS|
      |MY CREDIT SLIPS|
      |MY ADDRESSES|
      |MY PERSONAL INFORMATION|
      |Home|
    And accounts section count should be 5