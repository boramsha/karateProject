Feature: Update Account

  Background: 
    * url 'https://demo.spreecommerce.org'
    * header Accept = 'application/json'
    * header Content-Type = ' application/vnd.api+json'

  Scenario: Update Account
    # passing token to update user information
    * def AccessFeatureFile = call read('AccessToken.feature')
    * def AccessToken = AccessFeatureFile.AccessToken
    Given header Authorization = 'Bearer '+ AccessToken
    When path '/api/v2/storefront/account'
    And request
      """
      {
      "user": {
      "email": "mayuri66@spree.com",
      "first_name": "mayuri",
      "last_name": "B",
      "bill_address_id": "1",
      "ship_address_id": "1",
      "password": "mayuri66",
      "password_confirmation": "mayuri66"
      }
      }

      """
    When method PATCH
    Then status 200
    * print response
    * def jsonobject = response
    * print jsonobject
