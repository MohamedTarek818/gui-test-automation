@upload
Feature: File Upload
  As a user of the-internet application
  I want to upload an image file
  So that I can confirm it was received by the server

  Scenario Outline: Upload a small image file successfully
    Given the user is on the home page
    When the user opens the File Upload page
    And the user selects the file "<fileName>"
    And the user submits the file
    Then the upload confirmation message should be "<confirmationMessage>"
    And the uploaded file name should be "<fileName>"

    Examples:
      | fileName         | confirmationMessage |
      | sample-image.png | File Uploaded!      |
