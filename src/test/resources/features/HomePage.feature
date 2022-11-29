Feature: Home Page Validations

  Background:
    Given I go to application login page
    When I fill username 'geethanjali53@gmail.com' and password 'Adore53$' fields on login Page
    And I click Login button
    Then I 'should' be on the application home page


  @HomePage
  Scenario: Check feed tab is default page to be loaded on HomePage
    Given I am on application home page
    Then I 'should' see 'Feed' tab as current tab on the home page

 #All Home page scenarios can be continued here without logging in



