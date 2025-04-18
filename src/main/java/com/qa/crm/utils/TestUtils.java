package com.qa.crm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.tesbase.TestBase;

public class TestUtils extends TestBase
{
	public static int pageLoadTime=40;
	public static int implicitWaitTime=40;
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
	
	public static String TESTDATA_SHEET_PATH = "C:\\Selenium\\CRMSelenium\\src\\main\\java\\com\\qa"
			+ "\\crm\\testdata\\FreeCRMTestData.xlsx";

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public  void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
	
	public void checkAlertPresent()
	{
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert()
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	

}
