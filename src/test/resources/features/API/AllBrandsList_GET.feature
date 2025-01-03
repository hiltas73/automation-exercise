Feature: API-3 GET All Brands List
  @apiBrands
  Scenario: GET All Brands List
    When send GET request to "/brandsList" endpoint
    Then status-code should be 200
    And get all brands list