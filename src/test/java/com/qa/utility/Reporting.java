package com.qa.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports exReports;
	public ExtentTest exTest;
	
	
	public void onStart(ITestContext testContext) {
		
		String date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName =  "Test-Report-"+date+".html";
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
		exReports =  new ExtentReports();
		
		exReports.attachReporter(htmlReporter);
		exReports.setSystemInfo("QA", "Raja M");
		exReports.setSystemInfo("OS", "Windows");
		
		htmlReporter.config().setDocumentTitle("Functional Testing");
		htmlReporter.config().setReportName("ORM Website");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		
	}
	
	public void onFinish(ITestContext testContext) {
		exReports.flush();
	}
	
	public void onTestSuccess(ITestResult tr) {
		exTest = exReports.createTest(tr.getName());
		exTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		exTest.log(Status.PASS,"Test is Passed");
	}
	
	public void onTestFailure(ITestResult tr) {
		exTest = exReports.createTest(tr.getName());
		exTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		exTest.log(Status.FAIL,"Test is Failed");
		
		exTest.fail("Testcase Failed");
	}
	
	public void onTestSkipped(ITestResult tr) {
		exTest = exReports.createTest(tr.getName());
		exTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		exTest.log(Status.SKIP,"Test is Skipped");
	}
	
	
	

}
