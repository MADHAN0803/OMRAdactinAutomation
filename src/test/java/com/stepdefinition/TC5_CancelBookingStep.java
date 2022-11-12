package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.*;

public class TC5_CancelBookingStep {
	PageObjectManager pageObjectManager = new PageObjectManager();


	@Then("User should cancel the order id")
	public void userShouldCancelTheOrderId() throws InterruptedException {

		String OrderId = pageObjectManager.getBookingConfirmationPage().orderId();
		pageObjectManager.getCancelBookingPage().cancelBooking(OrderId);
		
	}
	
	@Then("User should verify the cancel booking succcess message {string}")
	public void userShouldVerifyTheCancelBookingSucccessMessage(String msg) {
		String text = pageObjectManager.getCancelBookingPage().getText(pageObjectManager.getCancelBookingPage().getTxtMessage());
		System.out.println("Cancellation success page : "+text);
		
		Assert.assertEquals(text, msg);
		}

	@Then("User should cancel existing booking id {string}")
	public void userShouldCancelExistingBookingId(String OrderId) throws InterruptedException {
		pageObjectManager.getCancelBookingPage().cancelOrderId(OrderId);
	}


}
