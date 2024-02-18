Feature: Purchase the Order from ecommerce
  Background:
    Given I launched on Ecomerce page
  @Regression
  Scenario Outline: Positive test of submitting order
    Given Logged in with User Name <name> and password <password>
    When I add the product <product> to cart
    And Checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page


    Examples:
      |name             |  password |product|
      |azacher@gmail.com|1234567@Aza|ADIDAS ORIGINAL|