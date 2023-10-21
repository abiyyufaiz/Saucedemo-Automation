Feature: Product Check on Saucedemo

  Scenario: View product details
    Given I am on the Saucedemo product page
    When I select a product
    Then I should see the product details

  Scenario: Attempt to access an unavailable product
    Given I am on the Saucedemo product page
    When I select an unavailable product
    Then I should see a message indicating unavailability
