Feature: Your Cart aplikasi saucedemo
  Scenario: Get List your cart
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    And User is on products page
    And User pick one product
    And User click add to cart
    And Button change to remove
    And Click cart icon
    Then Appear list your cart