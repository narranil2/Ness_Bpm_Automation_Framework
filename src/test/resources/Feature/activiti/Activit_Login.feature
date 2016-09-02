#Author: anilkumarreddy.narreddi@ness.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

Feature: BPM Login Action

@EmployeeRoleTest 
Scenario: Successful Login with Valid Employee Credentials
	Given User is on Home Page of the application
	When User enters valid Employee role UserName and Password credentials
	Then Message displayed Login Successfully 
#Scenario: Successful LogOut
When User LogOut from the Application
Then Message displayed LogOut Successfully

@LeadRoleTest
Scenario: Successful Login with Valid Lead Credentials
  Given User is on Home Page of the application
	When User enters valid Lead role UserName and Password credentials
	Then Message displayed Login Successfully
	When User clicks on claim process 
	Then Business process is displayed to the lead to approve or reject	
	When User LogOut from the Application
	Then Message displayed LogOut Successfully
	
@ManagerRoleTest
Scenario: Successful Login with Valid Manager Credentials
  Given User is on Home Page of the application
	When User enters valid Manager role UserName and Password credentials
	Then Message displayed Login Successfully
	When User clicks on claim process 
	Then manager approval screen is displayed
	When User LogOut from the Application
  Then Message displayed LogOut Successfully
	
@InavalidLoginTest
	Scenario: Invalid Login with the Supplied Credentials
	Given User is on Home Page of the application
	When User enters In valid UserName and Password credentials
	Then Message displayed Login failed
	