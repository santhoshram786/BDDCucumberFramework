
@SetUpConfig @SetUpDriver
Feature: Login to HRM2 Application

  @Testing2
  Scenario: Login with valid credentials - Feature 2, Scenario -2

    Given User is on Home page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login sucessfully