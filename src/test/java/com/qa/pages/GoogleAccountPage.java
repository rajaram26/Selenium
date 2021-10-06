package com.qa.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GoogleAccountPage {
	
	WebDriver driver;
	String parent;
	
	@FindBy(linkText="Privacy")
	WebElement privacy;
	
	@FindBy(linkText="Terms")
	WebElement terms;
	
	@FindAll({@FindBy(tagName = "a")})
	List<WebElement> links;
	
	public GoogleAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPrivacy() {
		return privacy;
	}

	public WebElement getTerms() {
		return terms;
	}
	
	public List<WebElement> getLinks(){
		return links;
	}
	
}
