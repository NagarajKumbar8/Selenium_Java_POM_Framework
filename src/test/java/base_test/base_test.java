package base_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Base_Class;

public class base_test  {

	public WebDriver driver;
	
	/*
	@BeforeMethod
	public void setup() throws IOException {

		driver = Base_Class.initializeBrowser();
		driver.get(Base_Class.prop.getProperty("url"));
		
	}
	 
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	} 
	*/
}
