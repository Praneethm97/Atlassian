Feature: Edit Issue

  Scenario: Add comment
    Given Add the input Payload with body:
           """
           This issue is a showstopper
           it should be resole in UAT-1.24.32
           @soumya communicate with rajesh to solve this issue
           """
    When Hit the "AddCommentApi" with "POST" http request
    Then Verify the status code is 201
    And Parse the Json to get the commentId

  Scenario: Add attachment to the issue
    Given Add input payload with file "C://Users//Praneeth//Downloads//Screenshot 2022-02-07 213200.png"
    When  Hit the "AddAttachmentApi" with "POST" http request
    Then Verify the status code is 200

