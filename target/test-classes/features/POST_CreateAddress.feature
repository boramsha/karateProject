Feature: Address Creation

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'aaplication/json'
    * header Content-Type = ' application/vnd.api+json'
   

  Scenario: Address Creation
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    Given path '/api/v2/storefront/account/addresses'
    And def requestbody = read('POST_CreateAddress.json')
    And request requestbody
    When method POST
    Then status 200
    And print response
    * def AddressId = response.data.id
    And print AddressId
