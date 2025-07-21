package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Utils {
	
	WebDriver driver;

	public Utils(WebDriver driver) 
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this );

	}
	

	
	  public static String generateNewEmailTimeStamp() {
	  
	  Date date = new Date(); return
	  date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
	  
	  }
	 
	
	public static String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
		return screenshotFilePath;
	}
	
}
