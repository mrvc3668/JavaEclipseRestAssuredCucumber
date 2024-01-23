
Feature: 
  Selenium

  
  Scenario: Task 1 Using http://www.way2automation.com/angularjs-protractor/banking/#/login
    Given I log in as a customer
    And I deposit the '10' amount
    When I validate the deposit is successful
    Then I log out 
    And I close driver

  