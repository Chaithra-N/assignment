package assignment.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
		public String getPropertyKeyValue(String key) throws Throwable  {
		  
			FileInputStream fis = new FileInputStream(IConstant.commonDataFilePath);
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
		
		return value;
	}


}
