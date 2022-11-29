Feature:  Login Functionality

  @Login
  Scenario Outline: Check Error thrown for <scenario>
    Given I go to application login page
    When I fill username '<username>' and password '<password>' fields on login Page
    And I click Login button
    Then I should see following error message '<Error>' thrown on login page


    Examples:
      | scenario         | username                | password | Error                                           |
      | invalid username | geethanjali53gmail.com  | Adore53$ | We didn't recognize that email and/or password. |
      | invalid password | geethanjali53@gmail.com | secret   | We didn't recognize that email and/or password. |

  @Login
  Scenario: Check whether user logout successfully
    Given I go to application login page
    When I fill username 'geethanjali53@gmail.com' and password 'Adore53$' fields on login Page
    And I click Login button
    Then I 'should' be on the application home page
    When I logout from account
    Then I 'should' be on a Public page

  @Login
  Scenario Outline: Check Login Functionality
    Given I go to application login page
    When I fill username '<username>' and password '<password>' fields on login Page
    And I click Login button
    Then I '<condn>' be on the application home page


    Examples:
      | username                | password | condn      |
      | geethanjali53@gmail.com | Adore53$ | should     |
      | geethanjali53@gmail.com | secret   | should not |

