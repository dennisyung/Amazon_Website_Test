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

Feature: Wishlist operations
	Various use cases for wishlist on amazon website

Background: 
Given I am currently on the login page
And I attempt to sign in with correct username and correct password
And new wishlist is created

@sanity @experiment
Scenario Outline:  Search and add items to wishlist
When I search and add <number> items to wishlist
Then the items are saved to my wishlist
Examples:
    |number|
    |1|
    |5|

@sanity @experiment
Scenario:  Remove a single item from wishlist
When I navigate to wishlist
And remove a single item 
Then the removed item is no longer saved in wishlist




    