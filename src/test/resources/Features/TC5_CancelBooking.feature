@CancelBooking
Feature: Verifying Adactin Cancel Booking Hotel Page Details

  Scenario Outline: Verifying Adactin Book A Hotel Page by selecting all fields
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should search hotel "<Location>","<Hotel>","<RoomType>","<NoOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerRoom>"
    Then User should verify the next page text after search "Select Hotel"
    And User should select the particular hotel
    Then User should verify the next page text after Continue "Book A Hotel"
    And User should Book A Hotel by "<FirstName>", "<LastName>" and "<BillingAddress>"
      | CCno             | CCType           | ExpMonth | ExpYear | Cvv |
      | 1234567890123456 | American Express | January  |    2022 | 123 |
      | 1234567890123457 | VISA             | February |    2022 | 456 |
      | 1234567890123458 | Master Card      | March    |    2022 | 789 |
      | 1234567890123459 | Other            | April    |    2022 | 012 |
    Then User should verify the next page text after booking "Booking Confirmation"
    And User should cancel the order id
    Then User should verify the cancel booking succcess message "The booking has been cancelled."

    Examples: 
      | UserName  | Password    | Location | Hotel       | RoomType | NoOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerRoom | FirstName    | LastName | BillingAddress |
      | zaddhu111 | Sathees@123 | Sydney   | Hotel Creek | Standard | 1 - One   | 19/07/2022  | 20/07/2022   | 1 - One       | 0 - None        | SatheesKumar | Murugan  | Sellur,Madurai |
	
  Scenario Outline: Verifying Adactin Booked Itenary page by cancelling the existing order id
    Given User is on the Adactin Page
    When User should Login "<UserName>" and "<Password>"
    Then User should verify success message after Login "Hello zaddhu111!"
    And User should cancel existing booking id "<OrderId>"
    Then User should verify the cancel booking succcess message "The booking has been cancelled."

    Examples: 
      | UserName  | Password    | OrderId    |
      | zaddhu111 | Sathees@123 | OMD79018VJ |
