Feature: Login Check

    Background: Launching the chrome browser
    Given Launch chrome browser

    Scenario:  Verify login functionality in chrome
    When Enter username and password 
        | username | password | 
        | tomsmith | SuperSecretPassword! |
        | username | password | 
    Then Hit login button 
    

