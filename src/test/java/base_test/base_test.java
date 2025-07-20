package base_test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Base_Class;

public class base_test  {

	public static WebDriver driver;
	
	
	@BeforeMethod
	public void setup() throws IOException {

		driver = Base_Class.initializeBrowser();
		driver.get(Base_Class.prop.getProperty("url"));
		
	}
	 
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	} 
	
}
