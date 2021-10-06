package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.CloseTripPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_HiddedPopup {
	
	WebDriver driver;
	CloseTripPage page;
	String path = "D://Shots//test.png";
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		page = new CloseTripPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/flights");
	}
	
	@Test
	public void startTest() throws InterruptedException, IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		page.getDateButton().click();
		Thread.sleep(3000);
		
		//Taking screenshot
		TakesScreenshot src = (TakesScreenshot) driver;
		File file = src.getScreenshotAs(OutputType.FILE);
		File Des = new File(path);
		FileUtils.copyFile(file, Des);
		
		
		page.getdate().click(); 
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
