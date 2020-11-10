package assignment.genericUtils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
private  Map<String, WebDriver> drivers=new HashMap<String, WebDriver>();
public  WebDriver getBrowser(String browser){
	WebDriver driver=null;
	switch (browser) {
	case "firefox":
		 driver = drivers.get("firefox");
		 if(driver==null)

		 driver=new FirefoxDriver();
		 drivers.put("frifox", driver);
		 break;
		 
	case "chrome":
		driver=drivers.get("chrome");
		if(driver==null)
			driver=new ChromeDriver();
		drivers.put("chrome", driver);
		break;
		

	default:
		System.out.println("invalid browser");
		break;
	}
	return driver;
}
public  void closeBrowser()
{
	for (String key : drivers.keySet()) {
		drivers.get(key).quit();
	}
}
}
