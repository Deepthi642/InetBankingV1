Feature: Login into Application

Scenario: Positive test validating Login
Given initialize the browser with chrome
And navigate to baseurl site
And click on login link in home page to land on signin page
When user enters username and password and logsin 
Then verify that user is successfully logged in