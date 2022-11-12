package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseClass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.config.Configuration;

public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() {
		getDriver(Configuration.BROWSERTYPE);
		loadUrl(Configuration.URL);
	}

	@After
	public void afterScenario(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			s.embed(screenshotAs, s.getName() + ".png");

		}
		driver.quit();
	}

}
