package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.*;

public class TC2_SearchHotelStep {

	PageObjectManager pageObjectManager = new PageObjectManager();

	@Then("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String Location, String Hotel, String RoomType, String NoOfRooms,
			String CheckInDate, String CheckOutDate, String AdultsPerRoom, String ChildrenPerRoom) throws InterruptedException {
		pageObjectManager.getSearchHotelPage().searchHotels(Location, Hotel, RoomType, NoOfRooms, CheckInDate,
				CheckOutDate, AdultsPerRoom, ChildrenPerRoom);
	}

	@Then("User should verify the next page text after search {string}")
	public void userShouldVerifyTheNextPageTextAfterSearch(String value) {
		String successMessage = pageObjectManager.getSearchHotelPage().successMessage();
		System.out.println("Succcessfully completed Search page :"+successMessage);		
		Assert.assertEquals(successMessage, value);
	}

	@Then("User should search hotel {string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String Location, String NoOfRooms, String CheckInDate, String CheckOutDate,
			String AdultsPerRoom) throws InterruptedException {
		pageObjectManager.getSearchHotelPage().searchHotels(Location, NoOfRooms, CheckInDate, CheckOutDate,
				AdultsPerRoom);
	}

	@Then("User should search hotel with wrong date format {string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelWithWrongDateFormatAnd(String Location, String NoOfRooms, String CheckInDate,
			String CheckOutDate, String AdultsPerRoom) throws InterruptedException {
		
		pageObjectManager.getSearchHotelPage().searchHotels(Location, NoOfRooms, CheckInDate, CheckOutDate,
				AdultsPerRoom);
	}

	@Then("User should verify date error message after search {string} and {string}")
	public void userShouldVerifyDateErrorMessageAfterSearchAnd(String err1, String err2) {

		String checkInError = pageObjectManager.getSearchHotelPage().checkInError();
		String checkOutError = pageObjectManager.getSearchHotelPage().checkOutError();
		System.out.println(checkInError);
		System.out.println(checkOutError);
		Assert.assertEquals(checkInError, err1);
		Assert.assertEquals(checkOutError, err2);
	}

	@Then("User should search hotel by click search button")
	public void userShouldSearchHotelByClickSearchButton() {
		pageObjectManager.getSearchHotelPage().searchHotels();
	}

	@Then("User should verify error message after search {string}")
	public void userShouldVerifyErrorMessageAfterSearch(String value) {

		String locationErrorMessage = pageObjectManager.getSearchHotelPage().locationErrorMessage();

		Assert.assertEquals(locationErrorMessage, value);

	}
}
