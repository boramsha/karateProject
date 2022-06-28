Feature: Account creation 

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'aaplication/json'
    
@Before
Scenario: create account
    Given path '/api/v2/storefront/account'
    And def requestbody = read('POST_CreateAccount.json')
    And request requestbody
    When method POST
    Then status 200
    And print response
    