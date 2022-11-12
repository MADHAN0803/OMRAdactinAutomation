package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "my_itinerary")
	private WebElement btnItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "//input[@name=\"ids[]\"]")
	private WebElement rdoButton;

	@FindBy(xpath = "//input[@type=\"button\"][1]")
	private WebElement btnCancel;

	@FindBy(xpath = "//a[@href=\"BookedItinerary.php\"]")
	private WebElement btnBooked;

	@FindBy(xpath = "//label[contains(text(),'The booking')]")
	private WebElement txtMessage;

	public WebElement getTxtMessage() {
		return txtMessage;
	}

	public WebElement getBtnBooked() {
		return btnBooked;
	}

	public WebElement getBtnItinerary() {
		return btnItinerary;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getRdoButton() {
		return rdoButton;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public void cancelBooking(String OrderId) throws InterruptedException {
		Thread.sleep(5000);
		click(getBtnItinerary());
		type(getTxtOrderId(), OrderId);
		click(getBtnGo());
		click(getRdoButton());
		click(getBtnCancel());
		alertAccept();
	}

	public void cancelOrderId(String OrderId) {
		click(getBtnBooked());
		type(getTxtOrderId(), OrderId);
		click(getBtnGo());
		click(getRdoButton());
		click(getBtnCancel());
		alertAccept();

	}

}
