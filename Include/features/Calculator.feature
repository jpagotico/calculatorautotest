Feature: Test Basic Calculator

  Scenario Outline: Verify Basic Calculator is working as expected
    Given I access the basic calculator web
    When I selects build as <build> in the dropdown list
    And I enters <fnum> in the first number field
    And I enters <snum> in the second number field
    And I selects operation <operation> in the dropdown list
    And I click calculate button
    Then I verify the answer

    Examples: 
      | build     | fnum | snum | operation   |
      | Prototype |    3 |    3 | Add         |
      |         1 |    3 |    3 | Subtract    |
      |         2 |    3 |    3 | Divide      |
      |         3 |    3 |    3 | Multiply    |
      |         4 |    3 |    3 | Concatenate |
