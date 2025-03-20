Feature: Amazon Search

Scenario: Search a product
    Given I have a Search field in Amazon
    When I search for a product "Samsung S23 Ultra" and Price 1000
    Then Product with "Samsung S23 Ultra" should be displayed

  