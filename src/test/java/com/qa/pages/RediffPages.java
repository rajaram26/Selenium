package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffPages {
	
	WebDriver driver;
	
	@FindBy(linkText = "Create Account")
	WebElement OpenCreateAccount;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement CheckBox;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")
	WebElement Day;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")
	WebElement Month;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")
	WebElement Year;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")
	WebElement MaleRadio;
	
	@FindBy(xpath="//*[@id=\"country\"]")
	WebElement Country;
	
	@FindBy(xpath="//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")
	WebElement City;
	
	
	public RediffPages(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void CheckIfRegistrationPage() {
		OpenCreateAccount.click();
//		Thread.sleep(3000);
		if(driver.getCurrentUrl().contains("register")) {
			System.out.println("Landed in Registration ");
		}else {
			System.out.println("Not landed in Registration ");
		}
	}
	
	public void AddDetailsInForm(String name,String email) {
		FirstName.sendKeys(name);
		EmailId.sendKeys(email);
	}
	
	public void CheckBox() {
		if(!CheckBox.isSelected()) {
			System.out.println("True it was not selected");
		}else {
			System.out.println("True it was  selected");
		}
	}
	
	public void setDate() {
		Select Dayy = new Select(Day);
		Select month = new Select(Month);
		Select year = new Select(Year);
		Dayy.selectByVisibleText("01");
		month.selectByVisibleText("JAN");
		year.selectByVisibleText("2002");
	}
	
	public void checkMaleRadio() {
		if(MaleRadio.isSelected()) {
			System.out.println("Male radio button is selected");
		}else {
			System.out.println("Male radio button is not selected");
		}
	}
	
	public void CheckCountry() {
		Select country = new Select(Country);
		if(country.getFirstSelectedOption().getText().contains("India")) {
			System.out.println("India is selected");
		}else {
			System.out.println("India is not selected");
		}
	}
	
	public void SelectCity() {
		Select city = new Select(City);
		city.selectByVisibleText("Coimbatore");
	}
	
	public void close() {
		driver.close();
	}
}
