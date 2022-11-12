package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC1_LoginStep {

	PageObjectManager pageObjectManager = new PageObjectManager();

	
	@When("User should Login {string} and {string}")
	public void userShouldLoginAnd(String name, String pass) {
		pageObjectManager.getLoginPage().login(name, pass);
	}

	@When("User should Login {string} and {string} using Enter Key")
	public void userShouldLoginAndUsingEnterKey(String name, String pass) throws AWTException {
		pageObjectManager.getLoginPage().loginWithEnter(name, pass);
	}
	
	
	@Then("User should verify error message contains after Login {string}")
	public void userShouldVerifyErrorMessageContainsAfterLogin(String value) {

		String loginError = pageObjectManager.getLoginPage().loginError();
		
		Assert.assertEquals("Verified",loginError, value);
	}

	
	
}
