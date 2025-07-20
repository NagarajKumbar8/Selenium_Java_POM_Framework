package pom_Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base_test.base_test;
import pom_Pages.Account_Page;
import pom_Pages.Home_Page;
import pom_Pages.Login_Page;
import utilities.Base_Class;
import utilities.Utils;
import base_test.base_test;

public class Login_Test extends base_test{

public WebDriver driver;


	
	@Test(priority=1)
	public void loginWithValidCrendetials() {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(Base_Class.prop.getProperty("validemail"));
		loginPage.enterPassword(Base_Class.prop.getProperty("validpassword"));
		Account_Page accountPage = loginPage.clickOnLoginButton();		
		Assert.assertTrue(accountPage.verifyDisplayOfEditYourAccountInformationOption());

	}
	
	@Test(priority=2)
	public void loginWithInvalidCredentials() {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(Base_Class.prop.getProperty("invalidemail"));
		loginPage.enterPassword(Base_Class.prop.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.retrieveInvalidCredentailsWarningMessage().contains(Base_Class.prop.getProperty("invalidcredentailswarning")));
	
	}
	
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
