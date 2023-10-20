Feature: Checkout aplikasi saucedemo
  Scenario: Fill all field in Your information checkout
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    And User is on products page
    And User pick one product
    And User click add to cart
    And Button change to remove
    And Click cart icon
    And Appear list your cart
    And Click button checkout
    And Appear form your information
    And input first name
    And input last name
    And input postal code
    And click continue
    Then Appear checkout overview
  Scenario: No Fill field last name in Your information checkout
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    And User is on products page
    And User pick one product
    And User click add to cart
    And Button change to remove
    And Click cart icon
    And Appear list your cart
    And Click button checkout
    And Appear form your information
    And input first name
    And input postal code
    And click continue
    Then Show error message