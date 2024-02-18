Feature:Error validations
  Background:
    Given launched on ecomerce app
  Scenario Outline:
    Given usrname <username> ang <password>
    Then i recived message "Incorrect email or password." message is displayed



    Examples:
      | username         | password |
      | azache@gmail.com | 13131    |