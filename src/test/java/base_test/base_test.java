package base_test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Base_Class;

public class base_test  {

	public WebDriver driver;
	
	
	@BeforeMethod(alwaysRun=true)
	public WebDriver setup() throws IOException {

		driver = Base_Class.initializeBrowser();
		driver.get(Base_Class.prop.getProperty("url"));
		return driver;
	}
	 
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
	} 
	
}
