#Author: girija.panda@nokia.com
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

#Sample Feature Definition Template
@tag
Feature: Amazon_LoginPage
    This is the Login Page feature for amazon.
	

@deprecatedTest
Scenario: I want to do something that is not supported anymore
Given I want to write a step with precondition
When I complete action
Then I validate the outcomes

@sanity
Scenario Outline: Visit login page via <method>
Given I am not currently on the login page
When I access the login page URL via <method>
Then the login page should be loaded correctly

Examples:
    | method  |
    | directURL  |
    | navigate_from_top_menu |

@sanity
Scenario: Sign into the website from the login page with no credentials
Given I am currently on the login page
When I attempt to sign in with no username or password entered
Then the sign in should fail with appropriate error message

@sanity
Scenario: Sign into the website from the login page with incorrect username
Given I am currently on the login page
When I attempt to sign in with incorrect username
Then the sign in should fail with appropriate error message

@sanity @experiment
Scenario: Sign into the website from the login page with correct username but incorrect password
Given I am currently on the login page
When I attempt to sign in with correct username but incorrect password
Then the sign in should fail with appropriate error message

@sanity @experiment
Scenario: Sign into the website from the login page with correct username and correct password
Given I am currently on the login page
When I attempt to sign in with correct username and correct password
Then the sign in should be successful


