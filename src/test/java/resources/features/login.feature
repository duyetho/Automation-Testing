Feature: Test transaction customer

  Scenario: Customer log in successfully
    Given customer is on login page
    And verify login page
    When customer clicks on the Customer login button
    And customer selects on <CustomerName> option
    And customer clicks on Login button

  Scenario: Customer log out successfully
    Given login successfully
    And customer clicks on the Logout button
    Then message display


  Scenario Outline: Customer Deposit
    Given login successfully
    And customer clicks on the Deposit button
    Then input valid data and invalid data in the "<amount>" field
    And clicks on the Deposit button
    Examples:
      | amount     |
      | 1          |
      |            |
      | 19999      |
      | 0          |
      | -1         |
      | -200000000 |

  Scenario Outline: Customer Withdraw
    Given login successfully
    And customer clicks on the Withdraw button
    Then withdraw valid data and invalid data in the "<amount>" field
    And clicks on the Withdraw button
    Examples:
      | amount     |
      | 1          |
      |            |
      | 19999      |
      | 0          |
      | -1         |
      | -200000000 |
    Scenario: Transaction
      Given login successfully
      And customer clicks on the Transaction button
      Then clicks on the DateTime the first time
      And clicks on the DateTime the second times
      When clicks on the Reset button
      And clicks on the Back button

    Scenario: Change account
      Given login successfully
      When customer clicks on the <AccountNumber> sections
      And choose any <AccountNumber>








