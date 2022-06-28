Feature: Create cart

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'aaplication/json'
    * header Content-Type = ' application/vnd.api+json'

  Scenario: Create cart

    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    Given path '/api/v2/storefront/cart'
    And def requestbody = read('POST_CreateCart.json')
    And request requestbody
    When method POST
    Then status 201
    And print response
    Given header Authorization = 'Bearer '+ AccessToken
    When path '/api/v2/storefront/cart'
    When method GET
    Then status 200
    * print response
    * def jsonobject = response
    * print jsonobject
