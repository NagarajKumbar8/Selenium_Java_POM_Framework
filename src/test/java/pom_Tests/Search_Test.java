package pom_Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_test.base_test;
import pom_Pages.Home_Page;
import pom_Pages.Search_Page;
import utilities.Base_Class;
import base_test.base_test;

public class Search_Test extends base_test{

	
	
	@Test(groups="Functional") //, dependsOnMethods="loginWithValidCrendetials")
	public void searchWithValidProductName() {
		
		Home_Page homePage = new Home_Page(driver);
		homePage.enterSearchTextIntoSearchField(Base_Class.prop.getProperty("validproduct"));
		Search_Page searchPage = homePage.clickOnSearchButton();
	
		Assert.assertTrue(searchPage.verifyTheDisplayOfHpProductInSearchResults());

	}
	
	@Test(groups="Functional")
	public void searchWithInvalidProductName() {
		Home_Page homePage = new Home_Page(driver);
		homePage.enterSearchTextIntoSearchField(Base_Class.prop.getProperty("nonexistingproduct"));
		Search_Page searchPage = homePage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.retrieveNoProductSearchMessage(),Base_Class.prop.getProperty("noproductinsearchmessage"));
	
	}
	
	@Test(groups="Functional")
	public void searchByNotProvidingAnyProductName() {
		
		Home_Page homePage = new Home_Page(driver);
		homePage.enterSearchTextIntoSearchField("");
		Search_Page searchPage = homePage.clickOnSearchButton();
		
		Assert.assertEquals(searchPage.retrieveNoProductSearchMessage(),Base_Class.prop.getProperty("noproductinsearchmessage"));
		
	}
	
	
}
