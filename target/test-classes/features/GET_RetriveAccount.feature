Feature: Account retrival 

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'

  Scenario: Account retrival 
    # passing token to retrive user information
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    When path '/api/v2/storefront/account'
    When method GET
    Then status 200
    * print response
    * def jsonobject = response
    * print jsonobject
