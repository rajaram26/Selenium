package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuruLogin {
	
	WebDriver driver;
	
	public GuruLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String username) {
		driver.findElement(By.name("uid")).sendKeys(username);;
	}

	public void setPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void loginToGuru(String username,String password) throws InterruptedException {
		this.setUsername(username);
		this.setPassword(password);
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
	}
}
