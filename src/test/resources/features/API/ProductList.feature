Feature: API-1 GET All Product List
  @api
  Scenario: GET All Product List
    When send GET request to "/productsList" endpoint
    Then status-code should be 200
    And get all product list