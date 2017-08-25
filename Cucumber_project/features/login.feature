Feature: Login Features

  @Case-1 @regression
  Scenario Outline: Login with valid credentials
    Given I am on login page for signIn using "<url>"
    When I enter my login credentials "<username>" and "<password>"
    Then I will see my homepage

    Examples: 
      | url | username | password |
      | Url | Username | Password |

  @Case-2 @regression
  Scenario Outline: Login with invalid userId
    Given I am on login page for signIn using "<url>"
    When I am authenticating with a wrong userid
    Then i should be displayed with the error message

    Examples: 
      | url |
      | Url |

  #done for the data table
  @Case-3 @regression
  Scenario Outline: Login with valid credentials
    Given I am on login page for signIn using "<url>"
    When I enter my login credentials
      | username                  | password   |
      | gautam.rawat123@gmail.com | Gautam@123 |
    Then I will see my homepage

    Examples: 
      | url |
      | Url |
      
      
@Case-4 @regression
  Scenario Outline: All the hyperlinked text should be accessible in the Gmail sign in page.
    Given I am on login page for signIn using "<url>"
    When I get all the links on the page

    Examples: 
      | url |
      | Url |
      
@Case-5 @comitTest
  Scenario Outline: All the hyperlinked text should be accessible in the Gmail sign in page.
    Given I am on login page for signIn using "<url>"
    When I get all the links on the page

    Examples: 
      | url |
      | Url |      