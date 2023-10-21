Feature: Add Product to Cart on Saucedemo

  Scenario: Add a product to the cart (Positive Case)
    Given I am on the Saucedemo product page
    When I select a product
    And I add the product to the cart
    Then the product should be added to the cart

  Scenario: Attempt to add an unavailable product to the cart (Negative Case)
    Given I am on the Saucedemo product page
    When I select an unavailable product
    And I add the product to the cart
    Then I should see an error message
