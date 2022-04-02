Feature: Login to Jira and create a issue

  Scenario: Login to Jira to get the session id
    Given Add Login payload with "Soumya" and "simh@chary"
    When Hit the "LoginApi" with "Post" http request
    Then Verify the status code is 200
    And Parse the JSon to get sessionid

Scenario: Create issue
  Given Add input payload and cookie
  When Hit the "CreateIssue" with "Post" http request
  Then Verify the status code is 201
  And get the issue id