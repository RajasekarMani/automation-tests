Feature: Login

  @complete @login_logout
  Scenario: Login - Valid
    Given i login with valid credentials
    Then i should be able to login successfully
    Then i should see the booking details