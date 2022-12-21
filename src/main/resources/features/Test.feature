Feature: Testig feature

  Background:
    Given Run before every scenario


  @Test1
  Scenario: Testing Santhosh Test1 Scenario
    Given user given a test
    When user writes the test
    Then test should pass

  @Test2
  Scenario Outline: Test scenario outline
    Given test scenrio outline
    Then test is <user> and <username>
    Examples:
      | user  | username |
      | user1 | ram      |
      | user2 | santhosh |

