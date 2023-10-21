Feature: Checkout Process on Saucedemo

  Scenario: Complete a successful checkout (Positive Case)
    Given I am on the Saucedemo shopping cart
    When I proceed to checkout
    And I enter shipping information
    And I enter payment information
    And I confirm the order
    Then I should see the order confirmation

  Scenario: Attempt to checkout with missing information (Negative Case)
    Given I am on the Saucedemo shopping cart
    When I proceed to checkout
    And I enter shipping information
    And I enter payment information with missing details
    And I confirm the order
    Then I should see an error message
