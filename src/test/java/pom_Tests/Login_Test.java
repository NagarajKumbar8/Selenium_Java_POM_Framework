package pom_Tests;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import base_test.base_test;
import pom_Pages.Account_Page;
import pom_Pages.Home_Page;
import pom_Pages.Login_Page;
import utilities.Base_Class;
import utilities.Get_Json_data; 

public class Login_Test extends base_test{


	
	@Test(dataProvider="getdata",groups="Smoke")
	public void loginWithValidCrendetials(HashMap<String,String> input) {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(input.get("validemail"));
		loginPage.enterPassword(input.get("validpassword"));
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
	
	
	@DataProvider
	public Object[][] getdata() {
		
		HashMap<String,String> map=new HashMap<String,String>();
		
		map.put("validemail", "nagaraj2225@gmail.com");
		map.put("validpassword", "@Nag123");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		
		map1.put("invalidemail", "nag@gmail.com");
		map1.put("invalidpassword", "@112");
		
		
		return new Object[][] {{map}};
	}
	
	/*
	@Test(dataProvider="getdata",groups="Smoke")
	public void loginWithValidCrendetials(HashMap<String,String> input) {
	
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Login_Page loginPage = homePage.clickOnLoginOption();
		loginPage.enterEmailAddress(input.get("validemail"));
		loginPage.enterPassword(input.get("validpassword"));
		Account_Page accountPage = loginPage.clickOnLoginButton();		
		Assert.assertTrue(accountPage.verifyDisplayOfEditYourAccountInformationOption());

	}
	
	@DataProvider
	public Object[][] getdata() {
		
		List<HashMap<String, String>> data=;
		
		
		return new Object[][] {{map}};
	}
	
	
	  */

	
}
