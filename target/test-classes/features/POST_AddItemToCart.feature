
Feature: Add item to cart

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'aaplication/json'
    * header Content-Type = ' application/vnd.api+json'
   
Scenario: Add item to cart
 		* def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    Given header X-Spree-Order-Token = 'XI87zaszhndtURB0RjPkwg1652450630746'
    Given path '/api/v2/storefront/cart/add_item'
    And def requestbody = read('POST_AddItemToCart.json')
    And request requestbody
    When method POST
    Then status 200
    And print response