Feature: Exercise 2

  Scenario: Contact Us test case
    Given the User is on the Sign In Page
    When the User goes to the Contact Page
    And inputs the details with an attachment included
    Then the User is able to successfully submit the query
    And logs out