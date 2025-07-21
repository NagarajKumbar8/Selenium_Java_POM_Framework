package pom_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class Account_Page extends Utils {

WebDriver driver;
	
	public Account_Page(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	public boolean verifyDisplayOfEditYourAccountInformationOption() {
		
		return editYourAccountInformationOption.isDisplayed();
		
	}
	
}
