
@Login
Feature: Verifying Adactin Login Page Details

  Scenario Outline: Verifying Adactin Login with valid credentials
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"

    Examples: 
      | UserName  | Password    |
      | zaddhu111 | Sathees@123 |

  Scenario Outline: Verifying Adactin Login using Enter Key with valid credentials
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>" using Enter Key
    Then User should verify success message after Login "Hello zaddhu111!"

    Examples: 
      | UserName  | Password    |
      | zaddhu111 | Sathees@123 |

  Scenario Outline: Verifying Adactin Login with invalid credentials
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify error message contains after Login "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | UserName  | Password    |
      | zaddhu110 | Zaddhu@123  |
