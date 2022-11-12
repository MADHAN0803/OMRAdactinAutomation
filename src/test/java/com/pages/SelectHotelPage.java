package com.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "radiobutton_0")
	private WebElement rdoButton;

	@FindBy(id = "continue")
	private WebElement btnContinue;
	
	@FindBy(id="radiobutton_span")
	private WebElement errorMessageSelect;
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement bookPage;
	
	
	

	public WebElement getErrorMessageSelect() {
		return errorMessageSelect;
	}

	public WebElement getBookPage() {
		return bookPage;
	}

	public WebElement getRdoButton() {
		return rdoButton;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
		

	public void selectHotel() {
		click(getRdoButton());
		click(getBtnContinue());
	}
	
	public void clickContinue() {
		
		click(getBtnContinue());
	}
	
	public String errorMessage() {
		String text = getText(getErrorMessageSelect());
		return text;		
	}
	
	public String bookPage() {

		String text = getText(getBookPage());
		return text;
	}
	
}
