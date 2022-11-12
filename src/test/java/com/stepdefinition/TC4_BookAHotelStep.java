package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.*;

public class TC4_BookAHotelStep {

	PageObjectManager pageObjectManager = new PageObjectManager();

	@Then("User should verify the next page text after booking {string}")
	public void userShouldVerifyTheNextPageTextAfterBooking(String msg) {
		String confm = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getConfirmation());
		System.out.println("Successfully completed Booking Confirmation :" + confm);
		Assert.assertEquals(confm, msg);
	}

	@Then("User should Book A Hotel by {string}, {string} and {string}")
	public void userShouldBookAHotelByAnd(String FirstName, String LastName, String BillingAddress,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> table = dataTable.asMaps();
		pageObjectManager.getBookAHotelPage().bookAHotel(FirstName, LastName, BillingAddress, table.get(1).get("CCno"),
				table.get(1).get("CCType"), table.get(1).get("ExpMonth"), table.get(1).get("ExpYear"),
				table.get(1).get("Cvv"));
	}

	@Then("User should Book A Hotel by click the book now button")
	public void userShouldBookAHotelByClickTheBookNowButton() {
		pageObjectManager.getBookAHotelPage().bookAHotel();
	}

	@Then("User should verify the seven error messages {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyTheSevenErrorMessagesAnd(String msg1, String msg2, String msg3, String msg4,
			String msg5, String msg6, String msg7) {
		String firstName = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getFirstNameError());
		String lastName = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getLastNameError());
		String address = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getAddressError());
		String ccNumber = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getCcnumberError());
		String ccType = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getCcTypeError());
		String ccDate = pageObjectManager.getBookAHotelPage()
				.getText(pageObjectManager.getBookAHotelPage().getCcDateError());
		String cvv = pageObjectManager.getBookAHotelPage().getText(pageObjectManager.getBookAHotelPage().getCvvError());

		System.out.println(firstName);

		Assert.assertEquals(firstName, msg1);
		Assert.assertEquals(lastName, msg2);
		Assert.assertEquals(address, msg3);
		Assert.assertEquals(ccNumber, msg4);
		Assert.assertEquals(ccType, msg5);
		Assert.assertEquals(ccDate, msg6);
		Assert.assertEquals(cvv, msg7);
	}

}
