package com.qa.testscripts;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.GoogleAccountPage;

public class TC_GoogleAccCreation_01 {
	
	WebDriver driver;
	GoogleAccountPage page;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signup");
        page = new GoogleAccountPage(driver); 
	}
	
	@Test
	public void SelectLinks() throws InterruptedException {
		String parent = driver.getWindowHandle();
		page.getTerms().click();
		page.getPrivacy().click();
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String x : tabs) {
			driver.switchTo().window(x);
			Reporter.log(driver.getTitle());
			List<WebElement> links = page.getLinks();
			for(WebElement y : links) {
				Reporter.log(y.getText());
			}
			driver.close();
		}
		
	}
	
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
}
