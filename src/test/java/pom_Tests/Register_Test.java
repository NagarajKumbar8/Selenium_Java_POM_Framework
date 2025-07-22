package pom_Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_test.base_test;
import pom_Pages.Account_Success_Page;
import pom_Pages.Home_Page;
import pom_Pages.Register_Page;
import utilities.Base_Class;
import utilities.Utils;
import base_test.base_test;

public class Register_Test extends base_test{


	
	@Test( groups="Smoke")
	public void registerWithMandatoryFields() {
		
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Register_Page registerPage = homePage.clickOnRegisterOption();
		registerPage.enterFirstName(Base_Class.prop.getProperty("firstname"));
		registerPage.enterLastName(Base_Class.prop.getProperty("lastname"));
		registerPage.enterEmailAddress(Utils.generateNewEmailTimeStamp());
		registerPage.enterTelephone(Base_Class.prop.getProperty("telephone"));
		registerPage.enterPassword(Base_Class.prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(Base_Class.prop.getProperty("validpassword"));
		registerPage.selectAgree();
		Account_Success_Page accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(),Base_Class.prop.getProperty("accountsuccessmessage"));
		
	}
	
	@Test( groups="Smoke")
	public void registerWithAllFields() {
		
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnMyAccountDropMenu();
		Register_Page registerPage = homePage.clickOnRegisterOption();
		registerPage.enterFirstName(Base_Class.prop.getProperty("firstname"));
		registerPage.enterLastName(Base_Class.prop.getProperty("lastname"));
		registerPage.enterEmailAddress(Utils.generateNewEmailTimeStamp());
		registerPage.enterTelephone(Base_Class.prop.getProperty("telephone"));
		registerPage.enterPassword(Base_Class.prop.getProperty("validpassword"));
		registerPage.enterPasswordConfirm(Base_Class.prop.getProperty("validpassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectAgree();
		Account_Success_Page accountSuccessPage = registerPage.clickOnContinueButton();
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessMessage(),Base_Class.prop.getProperty("accountsuccessmessage"));
		
	}
	
	 
}
