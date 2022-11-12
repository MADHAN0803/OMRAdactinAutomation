package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username_show")
	private WebElement success;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement error;

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getError() {
		return error;
	}

	public WebElement getSuccess() {
		return success;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String userName, String password) {
		type(getTxtUserName(), userName);
		type(getTxtPassword(), password);
		click(btnLogin);
	}

	// 2, Login with ENTER key
	public void loginWithEnter(String userName, String password) throws AWTException {
		type(getTxtUserName(), userName);
		type(getTxtPassword(), password);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

public String verify() {
		
		String attribute = getAttributedDn(getSuccess());
		return attribute;
	}
	
	public String loginError() {
		String text = getText(getError());
		System.out.println(text);
		return text;		
	}
}
