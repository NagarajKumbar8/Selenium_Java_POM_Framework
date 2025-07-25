package utilities;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

public static  Properties prop;
	
	public static  WebDriver driver;
	
	public static  WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		
		File file = new File("src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");
			//option.addArguments("--ignore-certificate-errors, --disable-notifictions");
			driver = new ChromeDriver(option);
			
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	

	
}
