package pom_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;



public class Login_Page extends Utils {

	WebDriver driver;

	public Login_Page(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this );

	}

	@FindBy(id="input-email")
	private static WebElement emailAddressField;

	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement invalidCredentailsWarningMessage;

	public static void enterEmailAddress(String emailText) {

		emailAddressField.sendKeys(emailText);

	}

	public void enterPassword(String passwordText) {

		passwordField.sendKeys(passwordText);
	}

	public Account_Page clickOnLoginButton() {

		loginButton.click();
		return new Account_Page(driver);
	}

	public String retrieveInvalidCredentailsWarningMessage() {

		return invalidCredentailsWarningMessage.getText();

	}
	
}
