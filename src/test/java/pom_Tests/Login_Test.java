package pom_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import base_test.base_test;
import pom_Pages.Account_Page;
import pom_Pages.Home_Page;
import pom_Pages.Login_Page;
import utilities.Base_Class;
 

public class Login_Test extends base_test{


	
	@Test(groups="Smoke")
	public void loginWithValidCrendetials() {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(Base_Class.prop.getProperty("validemail"));
		loginPage.enterPassword(Base_Class.prop.getProperty("validpassword"));
		Account_Page accountPage = loginPage.clickOnLoginButton();		
		Assert.assertTrue(accountPage.verifyDisplayOfEditYourAccountInformationOption());

	}
	
	@Test(groups="Smoke", retryAnalyzer=listeners.Retry.class)
	public void loginWithInvalidCredentials() {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(Base_Class.prop.getProperty("invalidemail"));
		loginPage.enterPassword(Base_Class.prop.getProperty("invalidpassword"));
		loginPage.clickOnLoginButton();
		
		Assert.assertTrue(loginPage.retrieveInvalidCredentailsWarningMessage().contains(Base_Class.prop.getProperty("invalidcredentailswarning")));
	
	}
	
	

	
}
