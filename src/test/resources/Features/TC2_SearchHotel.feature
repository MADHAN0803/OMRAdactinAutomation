@SearchHotel
Feature: Verifying Adactin Search Hotels Page Details

  Scenario Outline: Verifying Adactin Search Hotel Page by select all fields and verify Select Hotels
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel "<Location>","<Hotel>","<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User should verify the next page text after search "Select Hotel"

    Examples: 
      | UserName  | Password    | Location | Hotel       | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | zaddhu111 | Sathees@123 | Sydney   | Hotel Creek | Standard | 1 - One   | 05/08/2022  | 06/08/2022   | 1 - One       | 0 - None        |

  Scenario Outline: Verifying Adactin Search Hotel Page by select only mandatory fields and verify Select Hotels
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel "<Location>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>" and "<AdultsPerRoom>"
    Then User should verify the next page text after search "Select Hotel"

    Examples: 
      | UserName  | Password    | Location | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom |
      | zaddhu111 | Sathees@123 | Sydney   | 1 - One   | 05/08/2022  | 06/08/2022   | 1 - One       |

  @search
  Scenario Outline: Verifying Adactin Search Hotel Page by select only mandatory fields and verify date checking contains error messages
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel with wrong date format "<Location>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>" and "<AdultsPerRoom>"
    Then User should verify date error message after search "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | UserName  | Password    | Location | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom |
      | zaddhu111 | Sathees@123 | Sydney   | 1 - One   | 06/08/2023  | 07/08/2022   | 1 - One       |

  Scenario Outline: Verifying Adactin Search Hotel Page by without enter any fields click search and verify the contains error message
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel by click search button
    Then User should verify error message after search "Please Select a Location"

    Examples: 
      | UserName  | Password    |
      | zaddhu111 | Sathees@123 |
