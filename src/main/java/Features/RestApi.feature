Feature: 
  Rest Assured

  Scenario: Task 1 Using https://jsonplaceholder.typicode.com/
    Given I test post using '/users'
    When I test get1 using '/users/1'
    Then I test get5 using '/users'
