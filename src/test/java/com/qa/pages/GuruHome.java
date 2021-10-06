package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuruHome {

	WebDriver driver; 
	
	public GuruHome(WebDriver driver){
		this.driver = driver;
	}
	
	public String findUsername() {
		return driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
	}
	
	public void logout() {
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
	}
}
