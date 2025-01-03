Feature: API-2 POST to All Product List
  @apiPOST
  Scenario: POST All Product List
    When send POST request to API
    Then status-code should be 200
    And response-code should be 405
    And response message should be "This request method is not supported."