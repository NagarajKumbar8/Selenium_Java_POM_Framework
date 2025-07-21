package pom_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class Account_Success_Page extends Utils {

	WebDriver driver;

	public Account_Success_Page(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessHeading;
	
	public String retrieveAccountSuccessMessage() {
		
		return accountSuccessHeading.getText();
		
	}
	
}
