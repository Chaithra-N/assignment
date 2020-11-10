package assignment.genericUtils;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public  WebDriver driver;

	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	public BrowserFactory bf=new BrowserFactory();
	
	@BeforeSuite
	public void setUpReporter()
	{
		htmlreporter=new ExtentHtmlReporter("./Ereports/"+new Date().toString().replace(":", "-")+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void openApp(@Optional("chrome")String browser)
	{
		if(browser.equals("chrome"))
		{
		driver=bf.getBrowser("chrome");
		
		}
		else if(browser.equals("firefox"))
		{
		driver=bf.getBrowser("firefox");
		
		}
	}
	@AfterMethod
	public void closeApp(ITestResult res) 
	{
		if(ITestResult.FAILURE==res.getStatus())//failure status code=2
		{
			String tc_name=res.getName();//get the name of the failed test case
			//new Screenshot().capture(driver, tc_name);
			try {
				test.fail("test case failed", MediaEntityBuilder.createScreenCaptureFromPath(new Screenshot().capture(driver, tc_name)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Reporter.log("unable to fetch screenshot", true);
			}
		}
		bf.closeBrowser();
	}
	@AfterSuite
	public void saveReport()
	{
		reports.flush();
	}
}
