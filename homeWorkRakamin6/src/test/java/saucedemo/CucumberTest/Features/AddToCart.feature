Feature: Add To Cart aplikasi saucedemo
  Scenario: Add product to cart
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    And User is on products page
    And User pick one product
    And User click add to cart
    Then Button change to remove
  Scenario: Remove product from cart
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    And User is on products page
    And User pick one product
    And User click add to cart
    And Button change to remove
    And User Click button remove
    Then Button change to add to cart