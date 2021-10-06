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

import com.qa.pages.AmazonPages;
import com.qa.pages.GooglePages;

public class TC_AmazonSearch_01 {
	
	WebDriver driver;
	AmazonPages page;
	
	@BeforeClass
	@Parameters({"browser","url"})
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
		page = new AmazonPages(driver);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
//	    driver.manage().window().fullscreen();
	}
	
	@Test(dataProvider="BooksProvider")
	public void SearchItem(String category,String input) throws InterruptedException {
		// Select category
		page.selectCategory(category);
		Thread.sleep(2000);
		//type keys
		page.TypeInput(input);
		Thread.sleep(2000);
		//Search 
		page.clickSearch();
		//print elements
		page.PrintElements(input);
		Thread.sleep(2000);
		//Clear Previous input
		page.ClearInput();
	}
	
	@DataProvider(name="BooksProvider")
	public Object[][] getData() throws IOException {
		FileInputStream file = new FileInputStream("D:\\Documents\\Amazon.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0); 
		int no_row = sheet.getPhysicalNumberOfRows();
		int no_col = row.getLastCellNum();
		Object data[][] = new Object[no_row-1][no_col];
		System.out.println(no_row+" "+no_col);
		for(int i=1;i<no_row;i++)
		{
			XSSFRow l_row = sheet.getRow(i);
			for(int j=0;j<no_col;j++)
			{
				data[i-1][j] = l_row.getCell(j).toString();
//				System.out.println(data[i-1][j]);
			}
		}
		
		return data;
	}
	
	@AfterClass
	public void TearDown() {
		page.close();
	}
}
