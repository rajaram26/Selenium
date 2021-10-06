package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.GuruHome;
import com.qa.pages.GuruLogin;

public class GuruTestCase {
	
	WebDriver driver;
	GuruLogin login;
	GuruHome home;
	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/v4/");
	}
	
	@Test
	public void StartTest() throws InterruptedException {
		login = new GuruLogin(driver);
		login.loginToGuru("mngr347996","EzagYsU");
		
		home = new GuruHome(driver);
		String result = home.findUsername();
		
		if(result.contains("mngr347996")) {
			System.out.println("Login in successfull");
		}
		
		Thread.sleep(3000);
		home.logout();
	}
}
