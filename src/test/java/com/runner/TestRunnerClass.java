package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.Report.reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login", snippets = SnippetType.CAMELCASE, dryRun = false, plugin = { "pretty",
		"json:target\\Adactin.json" }, monochrome = true, features = "src\\test\\resources", glue = {
				"com.stepdefinition" })
public class TestRunnerClass {

	@AfterClass
	public static void afterClass() {
		reporting.generateJVMReport(
				"C:\\Users\\Admin\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\Adactin.json");
	}
	
}