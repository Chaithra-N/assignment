package assignment.genericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshot {
	public String capture(WebDriver driver,String tc_name)
	{
		Date d=new Date();
		String date=d.toString().replace(":", "-");
		
		String path =System.getProperty("user.dir")+ "./Defects/"+date+tc_name+".png";
		
		TakesScreenshot sc=(TakesScreenshot) driver;
		File src=sc.getScreenshotAs(OutputType.FILE);
		
		//File dest = new File(path+System.currentTimeMillis()+".jpg");
		File dest = new File(path);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) 
		{
			Reporter.log("failed to take screenshot",true);
		}
		return path;
		
		
	}

}
