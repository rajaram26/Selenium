package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPopUpPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	WebElement getName;
	
	public WebElement getName() {
		return getName;
	}
	
	@FindBy(xpath = "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")
	WebElement link;
	
	public WebElement getlink() {
		return link;
	}
	
	public RediffPopUpPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
