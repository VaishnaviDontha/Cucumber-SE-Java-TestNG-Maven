Feature: Login Check

    Background: Launching the chrome browser
    Given Launch chrome browser

    Scenario Outline:  Verify login functionality in chrome
    And Enter "<Username>" and "<Password>"
    When Hit login button 
    Then User must see the text "<Text>"

    Examples:
        | Username | Password | Text | 
        | tomsmith | SuperSecretPassword!  | You logged into a secure area!|
        | user1 | password1 | Your username is invalid!|