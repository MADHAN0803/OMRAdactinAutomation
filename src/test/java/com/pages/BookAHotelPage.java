package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

import cucumber.api.cli.Main;

public class BookAHotelPage extends BaseClass {

	public BookAHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCcNum;

	@FindBy(id = "cc_type")
	private WebElement dDnCcType;

	@FindBy(id = "cc_exp_month")
	private WebElement dDnExpMonth;

	@FindBy(name = "cc_exp_year")
	private WebElement dDnExpYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvv;

	@FindBy(id = "book_now")
	private WebElement btnBook;

	@FindBy(id = "first_name_span")
	private WebElement firstNameError;

	@FindBy(id = "last_name_span")
	private WebElement lastNameError;

	@FindBy(id = "address_span")
	private WebElement addressError;

	@FindBy(id = "cc_num_span")
	private WebElement ccnumberError;

	@FindBy(id = "cc_type_span")
	private WebElement ccTypeError;

	@FindBy(id = "cc_expiry_span")
	private WebElement ccDateError;

	@FindBy(id = "cc_cvv_span")
	private WebElement cvvError;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement confirmation;

	public WebElement getFirstNameError() {
		return firstNameError;
	}

	public WebElement getLastNameError() {
		return lastNameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCcnumberError() {
		return ccnumberError;
	}

	public WebElement getCcTypeError() {
		return ccTypeError;
	}

	public WebElement getCcDateError() {
		return ccDateError;
	}

	public WebElement getCvvError() {
		return cvvError;
	}

	public WebElement getConfirmation() {
		return confirmation;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCcNum() {
		return txtCcNum;
	}

	public WebElement getdDnCcType() {
		return dDnCcType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public void bookAHotel(String firstName, String lastName, String address, String ccNum, String ccType,
			String expMonth, String expYear, String cvv) throws InterruptedException {
		type(getTxtFirstName(), firstName);
		type(getTxtLastName(), lastName);
		type(getTxtAddress(), address);
		type(getTxtCcNum(), ccNum);
		SelectOptionByText(getdDnCcType(), ccType);
		SelectOptionByText(getdDnExpMonth(), expMonth);
		SelectOptionByText(getdDnExpYear(), expYear);
		type(getTxtCvv(), cvv);
		click(getBtnBook());
		Thread.sleep(5000);

	}

	public void bookAHotel() {
		click(getBtnBook());
	}

}
