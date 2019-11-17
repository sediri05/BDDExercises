Feature: Exercise 1

  Scenario: User Registration
    Given User is on the Registration Page
    When The user enters their details on the registration page
    Then The User is able to register
    And Validate the details
    And Logout