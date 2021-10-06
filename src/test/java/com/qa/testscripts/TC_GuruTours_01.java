package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.GuruTourPages;

public class TC_GuruTours_01 {
	
	WebDriver driver;
	GuruTourPages page;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/");
        page = new GuruTourPages(driver); 
	}
	
	@Test(priority = 0,dataProvider = "InputProvider")
	public void StartTest(String passenger,String d_port, String d_date,String d_month,String a_port, String a_date,String a_month) throws InterruptedException {
		//Logging in
		page.getLoginInput().sendKeys("mercury");
		page.getPasswordInput().sendKeys("mercury");
		page.getCheckSumbit().click();
		Thread.sleep(2000);
		
		//Clicking Flights
		page.getFlights().click();
		
		//Filling flight form
		Select PassCount = new Select(page.getPassCount());
		PassCount.selectByIndex((int)Double.parseDouble(passenger));
		
		//Full Depart Details
		page.setFromDate(d_date);
		page.setFromMonth(d_month);
		page.setFromPort(d_port); 
		Thread.sleep(2000);
		
		//Full Arrival Details
		page.setToPort(a_port);
		page.setToDate(a_date);
		page.setToMonth(a_month);
		Thread.sleep(2000);
		
		//Sumbit
		page.getFindFlights().click();
		page.getSignOff().click();
		
	}
	
	@Test(priority = 1)
	public void CheckLocationDefault() throws InterruptedException {
		//Logging in
		page.getLoginInput().sendKeys("mercury");
		page.getPasswordInput().sendKeys("mercury");
		page.getCheckSumbit().click();
		Thread.sleep(2000);
			
		//Clicking Flights
		page.getFlights().click();
				
		Select to_port = new Select(page.getToPort());
		Select from_port = new Select(page.getFromPort());
		if(to_port.getFirstSelectedOption().getText().equals(from_port.getFirstSelectedOption().getText())) {
			Reporter.log("The Location in Depart and Arrival is same by default");
		}else {
			Reporter.log("The Location in Depart and Arrival is different by default");
		}
		
		page.getLogout().click();
	}
	
	@Test(priority = 2)
	public void CheckSize() throws IOException {
		if(page.getLoginInput().getSize().getHeight() == page.getPasswordInput().getSize().getHeight() && page.getLoginInput().getSize().getWidth() == page.getPasswordInput().getSize().getWidth()) {
			Reporter.log("Both have same height and width");
		}else {
			Reporter.log("Both have different height and width");
		}
	}
	
	@DataProvider(name="InputProvider")
	public Object[][] getData() throws IOException{
		FileInputStream file = new FileInputStream("D:\\Documents\\Guru99Tour.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		int no_row = sheet.getPhysicalNumberOfRows();
		int no_col = row.getLastCellNum();
		Object data[][] = new Object[no_row-1][no_col];
		
		for(int i=1;i<no_row;i++)
		{
			XSSFRow l_row = sheet.getRow(i);
			for(int j=0;j<no_col;j++)
			{
				data[i-1][j] = l_row.getCell(j).toString();
			}
		}
		
		return data;
	}
	
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
