package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPage {
	
	WebDriver driver;
	
	@FindBy(id = "txtUsername")
	WebElement LoginUsername;
	
	@FindBy(id = "txtPassword")
	WebElement LoginPassword;
	
	@FindBy(id = "btnLogin")
	WebElement LoginButton;
	
	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	WebElement recruit_button;
	
	@FindBy(id = "menu_recruitment_viewCandidates")
	WebElement recruit_vacancy;
	
	@FindBy(id ="btnAdd")
	WebElement AddUser;
	
	@FindBy(xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
	WebElement Logo;
	
	@FindBy(xpath="//input[@id='addCandidate_firstName']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='addCandidate_lastName']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='addCandidate_email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='addCandidate_resume']")
	WebElement resume;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement SaveButton;
	
	@FindBy(xpath="//a[@id='welcome']")
	WebElement Profile;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(id="menu__Performance")
	WebElement perfromance;
	
	@FindBy(xpath="//a[@id='menu_performance_Configure']")
	WebElement configure;
	
	@FindBy(xpath="//a[@id='menu_performance_addPerformanceTracker']")
	WebElement tracker;
	
	
	public WebElement getPerfromance() {
		return perfromance;
	}

	public WebElement getConfigure() {
		return configure;
	}

	public WebElement getTracker() {
		return tracker;
	}

	public WebElement getFirstname() {
		return Firstname;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getResume() {
		return resume;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getProfile() {
		return Profile;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getAddUser() {
		return AddUser;
	}

	public WebElement getLogo() {
		return Logo;
	}

	public WebElement getLoginUsername() {
		return LoginUsername;
	}

	public WebElement getLoginPassword() {
		return LoginPassword;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	public WebElement getRecruit_button() {
		return recruit_button;
	}

	public WebElement getRecruit_vacancy() {
		return recruit_vacancy;
	}
	
	public OrangeHRMPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

}
