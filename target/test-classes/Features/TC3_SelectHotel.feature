@SelectHotel
Feature: Verifying Adactin Select Hotel Page Details

  Scenario Outline: Verifying Adactin Select Hotel Page by selecting the hotel
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel "<Location>","<Hotel>","<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User should verify the next page text after search "Select Hotel"
    And User should select the particular hotel
    Then User should verify the next page text after Continue "Book A Hotel"

    Examples: 
      | UserName  | Password    | Location | Hotel       | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | zaddhu111 | Sathees@123 | Sydney   | Hotel Creek | Standard | 1 - One   | 19/07/2022  | 20/07/2022   | 1 - One       | 0 - None        |
	
  Scenario Outline: Verifying Adactin Select Hotel Page without selecting hotel
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel "<Location>","<Hotel>","<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User should verify the next page text after search "Select Hotel"
    And User should click the Continue button without select a hotel
    Then User should verify the error message after Continue "Please Select a Hotel"

    Examples: 
      | UserName  | Password    | Location | Hotel       | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom |
      | zaddhu111 | Sathees@123 | Sydney   | Hotel Creek | Standard | 1 - One   | 19/07/2022  | 20/07/2022   | 1 - One       | 0 - None        |
