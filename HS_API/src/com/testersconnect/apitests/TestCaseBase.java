package com.testersconnect.apitests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCaseBase {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "//test results//AP_Automation_Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Sridhara");

		htmlReporter.config().setDocumentTitle("API Automation using Extent Reports");
		htmlReporter.config().setReportName("Automation Reports");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	
	@AfterTest
	public void endReport() {
		extent.flush();
	}

}
