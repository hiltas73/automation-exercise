Feature: Search Product
  @wip
  Scenario: Verify search product page is displayed
    Given I am on the homepage
    When user click on the "Products" page button
    Then user is navigated to "All Products" page successfully
    When enter product name "hat"
    Then verify "SEARCHED PRODUCTS" is visible
    And Verify all the products related to search are visible

