package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotels;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnNoOfRooms;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement dDnAdultsPerRoom;

	@FindBy(id = "child_room")
	private WebElement dDnChildrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	@FindBy(id = "checkin_span")
	private WebElement checkin;

	@FindBy(xpath  = "//span[contains(text(),'Date shall be after')]")
	private WebElement checkout;

	@FindBy(id = "location_span")
	private WebElement locationError;

	@FindBy(className = "login_title")
	private WebElement SuccessMessage;

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getLocationError() {
		return locationError;
	}

	public WebElement getSuccessMessage() {
		return SuccessMessage;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnNoOfRooms() {
		return dDnNoOfRooms;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}

	public WebElement getdDnChildrenPerRoom() {
		return dDnChildrenPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void searchHotels(String location, String hotels, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) throws InterruptedException {
		SelectOptionByText(getdDnLocation(), location);
		SelectOptionByText(getdDnHotels(), hotels);
		SelectOptionByText(getdDnRoomType(), roomType);
		SelectOptionByText(getdDnNoOfRooms(), noOfRooms);
		Sleep(1000);
		getTxtCheckInDate().clear();
		type(getTxtCheckInDate(), checkInDate);
		Sleep(1000);
		getTxtCheckOutDate().clear();
		type(getTxtCheckOutDate(), checkOutDate);
		SelectOptionByText(getdDnAdultsPerRoom(), adultsPerRoom);
		SelectOptionByText(getdDnChildrenPerRoom(), childrenPerRoom);
		click(getBtnSubmit());

	}

	public void searchHotels(String location, String noOfRooms, String checkInDate, String checkOutDate,
			String adultsPerRoom) throws InterruptedException {
		Thread.sleep(3000);
		SelectOptionByText(getdDnLocation(), location);
		SelectOptionByText(getdDnNoOfRooms(), noOfRooms);
		getTxtCheckInDate().clear();
		type(getTxtCheckInDate(), checkInDate);
		getTxtCheckOutDate().clear();
		type(getTxtCheckOutDate(), checkOutDate);
		SelectOptionByText(getdDnAdultsPerRoom(), adultsPerRoom);
		click(getBtnSubmit());

	}

	public void searchHotels() {
		click(getBtnSubmit());
	}

	public String checkInError() {
		String cIn = getText(getCheckin());
		return cIn;
	}

	public String checkOutError() {
		String cOut = getText(getCheckout());
		return cOut;
	}

	public String locationErrorMessage() {

		String text = getText(getLocationError());
		return text;
	}

	public String successMessage() {

		String text = getText(getSuccessMessage());
		return text;
	}

}
