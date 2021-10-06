package com.qa.testscripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.OrangeHRMPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	OrangeHRMPage page;
	Actions act;
	JavascriptExecutor script;
	
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void setUp(String browser,String url) {
		if(browser.equalsIgnoreCase("GoogleChrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("EdgeBrowser")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
		 page = new OrangeHRMPage(driver);
		 act = new Actions(driver);
		 script = (JavascriptExecutor) driver;
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 driver.get(url);
	}
	
	public void TakeScreenshot() throws IOException {
		TakesScreenshot shot = (TakesScreenshot) driver;
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String des = System.getProperty("user.dir") + "/Screenshot/"+"HRMLogo" + date + ".png";
		File source = page.getLogo().getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File (des));
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
