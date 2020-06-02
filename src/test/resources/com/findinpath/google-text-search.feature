Feature: Google text search

  Scenario: user can search any keyword

    Given an open browser with google.com
    When a keyword "findinpath.com" is entered in input field
    Then at least top 1 matches should be shown
    And the first one should contain "findinpath.com"

  @Proxy
  Scenario: user can search any keyword

    Given an open browser with google.com
    When a keyword "findinpath.com" is entered in input field
    Then at least top 1 matches should be shown
    And 1 request containing "findinpath.com" query field should be triggered
