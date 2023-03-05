Feature:
  @error
  Scenario: ERROR
    Given A list of stations
    And I perform POST without API Key
    Then I get error response
  @valid
  Scenario: REGISTER
    Given A list of stations
    And I register First new stations
  @valid
  Scenario: REGISTER
    Given A list of stations
    And I register Second new stations
  @verify
  Scenario: GET
    Given A list of stations
    And I Perform get all stations and verify