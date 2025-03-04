Feature: Job Search on LexisNexis

  Scenario: Search for Automation Tester jobs
    Given I open the LexisNexis website
    When I navigate to the Careers page
    And I search for "<searchTerm>"
    Then I should see results matching "<expectResults>"

    Examples:
      | searchTerm        | expectResults |
      | automation tester | yes           |
      | notarealcareer    | no            |
      | exampleoffailure  | yes           |
