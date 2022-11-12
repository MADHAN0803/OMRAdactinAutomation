package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.*;

public class TC3_SelectHotelStep {

	PageObjectManager pageObjectManager = new PageObjectManager();

	@Then("User should select the particular hotel")
	public void userShouldSelectTheParticularHotel() {
		pageObjectManager.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify the next page text after Continue {string}")
	public void userShouldVerifyTheNextPageTextAfterContinue(String value) {
		String bookPageMessage = pageObjectManager.getSelectHotelPage().bookPage();

		System.out.println("Book A Page Success Message :" + bookPageMessage);
		Assert.assertEquals(bookPageMessage, value);
	}

	@Then("User should click the Continue button without select a hotel")
	public void userShouldClickTheContinueButtonWithoutSelectAHotel() {
		pageObjectManager.getSelectHotelPage().clickContinue();
	}

	@Then("User should verify the error message after Continue {string}")
	public void userShouldVerifyTheErrorMessageAfterContinue(String value) {
		String errorMessage = pageObjectManager.getSelectHotelPage().errorMessage();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, value);
	}

}
