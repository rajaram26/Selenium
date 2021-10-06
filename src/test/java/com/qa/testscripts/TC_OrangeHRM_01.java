package com.qa.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TC_OrangeHRM_01 extends TestBase{
	
	
	@Test(dataProvider = "InputProvider",priority = 1)
	public void PerformLogin(String username,String password) throws InterruptedException {
		page.getLoginUsername().sendKeys(username);
		Thread.sleep(3000);
		page.getLoginPassword().sendKeys(password);
		Thread.sleep(3000);
		page.getLoginButton().click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2,enabled = true)
	public void StartRecuirment() throws InterruptedException, IOException {
		act.moveToElement(page.getRecruit_button()).build().perform();
		Thread.sleep(3000);
		page.getRecruit_vacancy().click();
		Thread.sleep(3000);
		page.getAddUser().click();
		
	}
	
	@Test(priority = 3, dataProvider = "InputProvider",enabled = true)
	public void fullFormDetails(String name1,String name2) throws InterruptedException {
		
		assertTrue(false);
		page.getFirstname().sendKeys(name1);
		page.getLastname().sendKeys(name2);
		page.getEmail().sendKeys(name1+name2+"@gmail.com");
		Thread.sleep(3000);
		page.getResume().sendKeys("C:\\Users\\rajar\\Desktop\\sample.txt");
		script.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		page.getSaveButton().click();
		Thread.sleep(2000);
		page.getProfile().click();
		Thread.sleep(3000);
		page.getLogout().click();
		
	}
	
	@Test(priority = 3,enabled = false)
	public void MultiHover() throws InterruptedException {
		act.moveToElement(page.getPerfromance()).build().perform();
		Thread.sleep(2000);
		act.moveToElement(page.getConfigure()).build().perform();
		Thread.sleep(2000);
		page.getTracker().click();
		Thread.sleep(3000);
		page.getProfile().click();
		Thread.sleep(3000);
		page.getLogout().click();

	}
	
	@DataProvider(name="InputProvider")
	public Object[][] DataProvider(){
		Object data[][] = {
				{"Admin","admin123"},
		};
		return data;
	}
	
}
