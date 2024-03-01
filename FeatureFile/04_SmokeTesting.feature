Feature: SmokeTesting

  @Smoke
  Scenario: Testing the basic features of each module
    Given user search the WebDevelopment courses
    When user click on the webDevelopment Skill in the Filter
    And user search the Language Learning
    And user Click on the Language Learning  in Filter
    Then user navigate to the Form
