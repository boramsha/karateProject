Feature: Creation of Auth Token
  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'

  Scenario: Creation of Auth Token
    # creating token
    Given path '/spree_oauth/token'
    And def requestbody = read('AccessToken.json')
    And request requestbody
    When method POST
    Then status 200
    And print response
    * def AccessToken = response.access_token
    * print AccessToken
   