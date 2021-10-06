package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GuruTourPages {
	
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement LoginInput;
	
	@FindBy(name="password")
	WebElement PasswordInput;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")
	WebElement CheckSumbit;
	
	@FindBy(linkText = "Flights")
	WebElement Flights;
	
	@FindBy(name="passCount")
	WebElement PassCount;
	
	@FindBy(name="fromPort")
	WebElement FromPort;
	
	@FindBy(name="fromMonth")
	WebElement FromMonth;
	
	@FindBy(name="fromDay")
	WebElement FromDate;
	
	@FindBy(name="toPort")
	WebElement ToPort;
	
	@FindBy(name="toMonth")
	WebElement ToMonth;
	
	@FindBy(name="toDay")
	WebElement ToDate;
	
	@FindBy(name="findFlights")
	WebElement FindFlights;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a/img")
	WebElement SignOff;
	
	@FindBy(linkText="SIGN-OFF")
	WebElement logout;
	
	
	public GuruTourPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLoginInput() {
		return LoginInput;
	}

	public WebElement getPasswordInput() {
		return PasswordInput;
	}

	public WebElement getCheckSumbit() {
		return CheckSumbit;
	}

	public WebElement getFlights() {
		return Flights;
	}

	public WebElement getPassCount() {
		return PassCount;
	}

	public WebElement getFromPort() {
		return FromPort;
	}

	public WebElement getFromMonth() {
		return FromMonth;
	}

	public WebElement getFromDate() {
		return FromDate;
	}

	public WebElement getToPort() {
		return ToPort;
	}

	public WebElement getToMonth() {
		return ToMonth;
	}

	public WebElement getToDate() {
		return ToDate;
	}

	public WebElement getFindFlights() {
		return FindFlights;
	}

	public WebElement getSignOff() {
		return SignOff;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void setFromPort(String fromPort) {
		Select from_port = new Select(FromPort);
		from_port.selectByValue(fromPort);
	}

	public void setFromMonth(String fromMonth) {
		Select from_month = new Select(FromMonth);
		from_month.selectByValue(String.valueOf((int)Double.parseDouble(fromMonth)));
	}

	public void setFromDate(String fromdate) {
		Select from_date = new Select(FromDate);
		from_date.selectByValue(String.valueOf((int)Double.parseDouble(fromdate)));
	}

	public void setToPort(String toPort) {
		Select to_port = new Select(ToPort);
		to_port.selectByVisibleText(toPort);
	}

	public void setToMonth(String toMonth) {
		Select to_month = new Select(ToMonth);
		to_month.selectByVisibleText(toMonth);
	}

	public void setToDate(String todate) {
		Select to_date = new Select(ToDate);
		to_date.selectByValue(String.valueOf((int)Double.parseDouble(todate)));
	}	
	
	
}
