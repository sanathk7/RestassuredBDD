Feature: Create User API
  As a client
  I want to create a new user
  So that I can verify the API response
Background:
Given the API endpoint is "/users/"


  Scenario: Create a user successfully
    And I have valid user data from "userData.json"
    When I send a "POST" request
    Then the response status should be 201
  
  Scenario: Get a user successfully
    When I send a "GET" request
    Then the response status should be 201

   Scenario: Update a user successfully
    When I send a "PUT" request
    Then the response status should be 200
    
    Scenario: Delete a user successfully
    When I send a "get" request
    Then the response status should be 200
    
   
   
  