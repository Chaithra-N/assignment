package com.interview.searchtext;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import assignment.genericUtils.BaseClass;
import assignment.genericUtils.ExcelUtility;

public class FindTermTest extends BaseClass {

	
	@Test(groups = "smokeTest")
	public void findTexttest() throws Throwable  {
	
		driver.get("file://C://Users//chaitra//Desktop//Assignment.html");
		FindTermPage fpage = new FindTermPage(driver);
		ExcelUtility testData = new ExcelUtility();
		String search = testData.getExcelData("test", 0, 0);
		fpage.setSearch(search);
		String content=testData.getExcelData("test", 0, 1);
		fpage.setContent(content);
		fpage.getFind().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(false, "test is failed");
		
		
	}
}
