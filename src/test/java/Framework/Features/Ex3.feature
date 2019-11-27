Feature: Exercise 3

  Scenario: Add to Cart, Pay and Confirm Order
    Given the User has logged in
    When the User searches for and adds 2 different items to the Cart
    Then the User is able to input their details
    And confirms the order and logs out