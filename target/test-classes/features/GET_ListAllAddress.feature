Feature: List all address 

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'

  Scenario: List all address
    # passing token to retrive all address
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    When path '/api/v2/storefront/account/addresses'
    When method GET
    Then status 200
    * print response
    * def jsonobject = response
    * print jsonobject
