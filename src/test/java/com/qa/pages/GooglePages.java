package com.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class GooglePages {
	
	WebDriver driver;
	
	@FindBy(name="q")
	WebElement seacrhbox;
	
	@FindBy(xpath="//div[@class='wM6W7d']")
	List<WebElement> suggestion;
	
	@FindBy(name="q")
	WebElement Search;
	
	public GooglePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setValueForSearchBox(String text) {
		seacrhbox.sendKeys(text);
	}
	
	public void ClearInput() {
		seacrhbox.clear();
	}
	
	public void getSuggestion() {
		for(WebElement x : suggestion) {
			Reporter.log(x.getText());
		}
	}
	
	public void seacrh() {
		Search.sendKeys(Keys.ENTER);
	}
	
	public void verifyTitle(String text) {
		if(driver.getTitle().contains(text)) {
			Reporter.log("Title has "+text);
		}else {
			Reporter.log("Title dont have"+text);
		}
	}

	public void quit() {
		System.out.println("Browser has been closed");
		driver.close();
	}

	public void NavigateBack() {
		driver.navigate().back();
	}
}
