package com.qa.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.GooglePages;

public class TC_GoogleSearchItem_01 {

	WebDriver driver;
	GooglePages page;
	
	@BeforeClass
	@Parameters({"Browser","Url"})
	public void setup(String browser,String url) {
		if(browser.equalsIgnoreCase("GoogleChrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();	
		}else if(browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		}else if(browser.equalsIgnoreCase("EdgeBrowser")) {
			System.setProperty("webdriver.edge.driver", "D:\\eclipse-workspace\\selenium\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}
		page = new GooglePages(driver);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
//	    driver.manage().window().fullscreen();
	}
		
	@Test(dataProvider="InputProvider")
	public void SearchItem(String text) throws InterruptedException {
		// Testing in search bar
		page.setValueForSearchBox(text);
		Thread.sleep(3000);
		// Print suggestion drop list
		page.getSuggestion();
		// Perform click event
		page.seacrh();
		//Verify Title
		page.verifyTitle(text);
		Thread.sleep(3000);
		//Navigate Back
		page.NavigateBack();
		//Clear Input
		page.ClearInput();
	}
	
	@AfterClass
	public void TearDown() {
		page.quit();
	}
	
	@DataProvider(name="InputProvider")
	public Object[][] getData() throws IOException {
		FileInputStream file = new FileInputStream("D:\\Documents\\SearchItem.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0); 
		int no_row = sheet.getPhysicalNumberOfRows();
		int no_col = row.getLastCellNum();
		Object data[][] = new Object[no_row-1][no_col];
		
		for(int i=1;i<no_row;i++)
		{
			XSSFRow l_row = sheet.getRow(i);
			data[i-1][0] = l_row.getCell(0).toString();
			System.out.println(data[i-1][0]);
		}
		
		return data;
	}

}
