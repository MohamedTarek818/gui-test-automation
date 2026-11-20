@dynamic
Feature: Dynamic Loading
  As a user of the-internet application
  I want to wait for dynamically rendered content
  So that I can verify it is displayed once loading finishes

  Scenario: Element rendered after the fact (Example 2)
    Given the user is on the home page
    When the user opens the Dynamic Loading page
    And the user opens Example 2
    And the user clicks the Start button
    And the user waits for the loading to finish
    Then the displayed text should be "Hello World!"
