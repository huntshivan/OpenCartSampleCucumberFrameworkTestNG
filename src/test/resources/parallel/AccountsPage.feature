Feature: Accounts Page Feature

Background:
Given User has already logged into the OpenCart site
|Username|Password|
|shivansharma07@gmail.com|Selenium@12345|

Scenario: Account Page Title
Given user is on accounts page
When user gets the title of the page
Then page title should be "My Account"

Scenario: Account Page Headers
Given user is on accounts page
When user get the accounts page header
Then accounts page headers are displayed
|My Account|
|My Orders|
|My Affiliate Account|
|Newsletter|
And account page headers are 4