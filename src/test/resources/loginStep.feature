Feature: Form automation
  As a user i want to navigate to e-shop, choose an item, add to cart, checkout and confirm my order.

  Background:
    Given user logs in with values "adam4@adam.com" and  "passwordadam4"

  Scenario:
    When go to WomenDept, select random clothing and add to cart
    And proceed to checkout twice
    And check delivery and billing address
    And proceed to checkout
    And agree with terms proceed to checkout
    And select pay by check
    And confirm order
    Then verify order is submitted
    And back to orders
    And verify you have one order and total price is right
    And log out
