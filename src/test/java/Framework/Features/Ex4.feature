Feature: Exercise 4
  Scenario: Verify Order History Test Case
    Given the User is on My Account Page
    When the User goes to Order History and Details Page
    Then the order details are displayed and correct
    And the User is able to download the Invoice and log out