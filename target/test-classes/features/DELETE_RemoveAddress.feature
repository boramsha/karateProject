Feature: Address deleteion

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'
    * header Content-Type = 'application/json'
    * def AccessFeatureFile = call read('AccessToken.feature')

  Scenario: Address deleteion
    * def AccessToken = AccessFeatureFile.AccessToken
    * def AccessAddressFile = call read('GET_ListAllAddress.feature')
    * def AddId = AccessAddressFile.response.data[0].id
    * print AddId
    Given header Authorization = 'Bearer '+ AccessToken
    When path '/api/v2/storefront/account/addresses/' + AddId
    When method DELETE
    Then status 204
    * print "Address deleted "+ response
