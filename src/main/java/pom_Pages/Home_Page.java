package pom_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class Home_Page extends Utils{

WebDriver driver;
	
	public Home_Page(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//i[contains(@class,'fa-search')]")
	private WebElement searchButton;
	
	
	public void enterSearchTextIntoSearchField(String searchText) {
		
		searchBoxField.sendKeys(searchText);
		
	}
	
	public Search_Page clickOnSearchButton() {
		
		searchButton.click();
		
		return new Search_Page(driver);
		
	}
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public void clickOnMyAccountDropMenu() {
		
		myAccountDropMenu.click();
		
	}
	
	public Login_Page clickOnLoginOption() {
		
		loginOption.click();
		return new Login_Page(driver);
	}
	
	public Register_Page clickOnRegisterOption() {
		
		registerOption.click();
		return new Register_Page(driver);
		
	}
	
}
