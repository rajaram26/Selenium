package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class AmazonPages {
	
	WebDriver driver;
	
	@FindBy(id="searchDropdownBox")
	WebElement category;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement input;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> list;
	
	public AmazonPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCategory(String text) {
		Select options = new Select(category);
		options.selectByVisibleText(text);
	}
	
	public void TypeInput(String text) {
		input.sendKeys(text);
	}
	
	public void ClearInput() {
		input.clear();
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void PrintElements(String text) {
		if(driver.getTitle().contains(text)) {
			Reporter.log(text+"is searched");
		}else {
			Reporter.log(text+"is not searched");
		}
		
		for(WebElement b : list ) {
			Reporter.log(b.getText());
		}
	}
	
	public void close() {
		Reporter.log("Browser is closed");
		driver.close();
	}

}
