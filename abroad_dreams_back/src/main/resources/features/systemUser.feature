Feature: SystemUser
  Scenario Outline: Fetching User Scenario
    Given getAll SystemUser
    And getById SystemUser
#    Then can Login to System

    Examples:
      | userId | email | firstName | lastName | password | role |
      | 1 | ashmita@gmail.com | Ashmita | Bishwakarma | $2a$10$h8d7WrgMnIlmK8TxYHxTeuYk0DLs0EAgp5y/ZJrFgjOhFFbxnu6qW | Customer |

  Scenario Outline: Register User Scenario
    Given save SystemUser
    And Verify Id
    Then Verify Email


    Examples:
      | email | firstName | lastName | password
      | ashmita@gmail.com | Ashmita |Bishwakarma|Test@123