package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.RediffPages;

public class TC_RediffRegistration_01 {
	
	WebDriver driver;
	RediffPages rediffpage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://rediff.com");
	}
	
	@Test(priority = 0)
	public void startTest() throws InterruptedException {
		
		rediffpage = new RediffPages(driver);
		
		String name="Kim Smith";
		String email="test@test.com";
		
		rediffpage.CheckIfRegistrationPage();
		
		rediffpage.AddDetailsInForm(name, email);
		
		rediffpage.CheckBox();
		
	}
	
	@Test(priority=1)
	public void TestTwo() throws InterruptedException 
	{
		rediffpage.checkMaleRadio();
				
		rediffpage.setDate();
		
		rediffpage.CheckCountry();
		
		rediffpage.SelectCity();
		
		Thread.sleep(3000);
		
		rediffpage.close();
	}

}
