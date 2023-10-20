Feature: Login Page Aplikasi Sauce Demo
  Scenario: Success Login
    Given Halaman login sauce demo
    When Input Username
    And Input Password
    And Click login button
    Then User is on products page
  Scenario: Failed Login
    Given Halaman login sauce demo
    When Input Username
    And Input Invalid Password
    And Click login button
    Then User get error message