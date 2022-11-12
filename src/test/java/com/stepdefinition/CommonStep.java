package com.stepdefinition;

import org.junit.Assert;

import com.baseClass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;




public class CommonStep extends BaseClass {
	PageObjectManager pageObjectManager = new PageObjectManager();

	
	@Given("User is on the Adactin Page")
	public void userIsOnTheAdactinPage() {
//	
//		getDriver(Configuration.BROWSERTYPE);
//		loadUrl(Configuration.URL);
//	
	}
	
	@Then("User should verify success message after Login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String value) {
		String verify = pageObjectManager.getLoginPage().verify();
		System.out.println(verify);
		Assert.assertEquals(verify, value);
		
	}
	
}
