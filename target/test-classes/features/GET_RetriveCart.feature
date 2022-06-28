Feature: cart retrival 

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'

  Scenario: cart retrival 
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    # passing token to retrive cart information
    Given header Authorization = 'Bearer '+ AccessToken
    Given header X-Spree-Order-Token = 'XI87zaszhndtURB0RjPkwg1652450630746'
    When path '/api/v2/storefront/cart'
    When method GET
    Then status 200
    * print response
    * def jsonobject = response
    * print jsonobject