package com.baseClass;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1,
	public static void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "Ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "safari":
			WebDriverManager.edgedriver().setup();
			driver = new SafariDriver();
			break;

		default:
			break;
		}
	}

	// 2,
	public static void loadUrl(String url) {
		driver.get(url);
	}

	// 3,
	public static void maximize() {
		driver.manage().window().maximize();
	}

	// 4,
	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 5,
	public void click(WebElement element) {
		element.click();
	}

	// 6,
	public WebElement FindElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	// 7,
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	// 8,
	public String getTitle() {
		String text = driver.getTitle();
		return text;
	}

	// 9,
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	// 10,
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 11,
	public String getUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 12,
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 13,
	public static void closeWindow() {
		driver.close();
	}

	// 14,
	public static void closeAllWindows() {
		driver.quit();
	}

	// 15.1, 99%---> Value
	public String getAttributeValue(WebElement element) {
		String values = element.getAttribute("value");
		return values;
	}

	// 15.2, 1%----> Value
	public String getAttributeValue(WebElement element, String value) {
		String text = element.getAttribute(value);
		return text;
	}

	// 16
	public String getAttributedDn(WebElement element) {
		String values = element.getAttribute("value");
		return values;
	}

	// 17,
	public void SelectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 18,
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 19,
	public void typeJs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],setAttribute('value','" + text + "')", element);
	}

	// 20,
	public void navigateUrl(String url) {
		driver.navigate().to(url);
	}

	// 21,
	public void navigateBack() {
		driver.navigate().back();
	}

	// 22,
	public void navigateForwrd() {
		driver.navigate().forward();
	}

	// 23,
	public void navigateRefresh() {
		driver.navigate().refresh();
	}

	// 24,
	public void Sleep(long num) throws InterruptedException {
		Thread.sleep(num);
	}

	// 25,
	public void selectByIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.selectByIndex(num);
	}

	// 26,
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 27,
	public void dragAndDrop(WebElement s, WebElement d) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(s, d).perform();
	}

	// 28,
	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	// 29,
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	// 30,
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 31,
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 32,
	public void promptAlertAccept(String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	// 33,
	public void scrollDownJs(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 34,
	public void scrollUpJs(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 35,
	public void screenShotPage(String path) throws IOException {
		TakesScreenshot SS = (TakesScreenshot) driver;
		File s = SS.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
	}

	// 36,
	public void screenShotElement(WebElement element, String path) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
	}

	// 37,
	public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 38,
	public void selectByValuedDn(WebElement element, String value) {
		// selectByValue("IND")-m
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 39,
	public void selectByValueTextdDn(WebElement element, String value) {
		// selectByValue("India")-m
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// 40,
	public void getAllSelectedOptionsdDn(WebElement element, String value) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);
			select.getAllSelectedOptions();
		}
	}

	// 41,
	public void deSelectByIndexdDn(WebElement element, String value, int num) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.deselectByIndex(num);
		}
	}

	// 42,
	public void deSelectAlldDn(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.deselectAll();
		}
	}

	// 43,
	public void isMultipledDn(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.isMultiple();
		}
	}

	// 44,
	public void deSelectByVisibleTextdDn(WebElement element, String value) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.deselectByVisibleText(value);
		}
	}

	// 45,
	public void deSelectByValuedDn(WebElement element, String value) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.deselectByValue(value);
		}
	}

	// 46,
	public void getFirstSelectedOptiondDn(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByIndex(i);

			select.getAllSelectedOptions();
		}
	}

	// 47,
	public void frameNameorId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 48,
	public void frameWebElementFrameElement(WebElement WebElementFrameElement) {
		driver.switchTo().frame(WebElementFrameElement);
	}

	// 49,
	public void frameInt(int num) {
		driver.switchTo().frame(num);
	}

	// 50,
	public String getWindowHandle() {
		String prtWindow = driver.getWindowHandle();
		return prtWindow;
	}

	// 51,
	public Set<String> getWindowHandles() {
		Set<String> allWindows = driver.getWindowHandles();
		return allWindows;
	}

}
