Feature: Deletion of cart items

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'

  Scenario: Deletion of cart items
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    Given header X-Spree-Order-Token = 'XI87zaszhndtURB0RjPkwg1652450630746'
    When path '/api/v2/storefront/cart'
    When method DELETE
    Then status 204
    * print "cart deleted "+ response
