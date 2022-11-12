package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BookingConfirmationPage extends com.baseClass.BaseClass {

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="order_no")
	private WebElement attributeValue;

	public WebElement getAttributeValue() {
		return attributeValue;
	}

	public String orderId() {
		String value = getAttributedDn(getAttributeValue());
		return value;
		
	}
	
}
