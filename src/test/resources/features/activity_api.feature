Feature: Activity API

  Scenario: Get a random activity
    Given I have the Bored API base URI
    When I request a random activity
    Then The response status code is 200
    And The response contains an activity

  Scenario Outline: Get an activity filtered by type
    Given I have the Bored API base URI
    When I request an activity with type "<type>"
    Then The response status code is 200
    And The response contains an activity of type "<type>"

    Examples:
      | type    |
      | education|
      | recreation|
      | social  |
      | diy     |
      | charity |
      | cooking |
      | relaxation |
      | music   |

  Scenario Outline: Get an activity filtered by participants
    Given I have the Bored API base URI
    When I request an activity with <participants> participants
    Then The response status code is 200
    And The response contains an activity with <participants> participants

    Examples:
      | participants |
      | 1            |
      | 2            |
      | 3            |