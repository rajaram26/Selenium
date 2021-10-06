package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.RediffPopUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_PopUp {
	
	WebDriver driver;
	RediffPopUpPage page;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		page = new RediffPopUpPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void startTest() throws InterruptedException {
		
		page.getName().sendKeys("12312313");
		page.getName().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		Alert at = driver.switchTo().alert();
		at.accept();
		
		page.getName().clear();
		Thread.sleep(3000);
		
		page.getName().sendKeys("Raja Mariappan");
		Thread.sleep(3000);
		
		Actions mouse = new Actions(driver);
		Action move = mouse.moveToElement(page.getlink()).build();
		move.perform();
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
