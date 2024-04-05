package testScripts;

// Script for verifying homepage header

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Cart;
import pom.HomePage;
import pom.LoginPage;

public class Script5 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		
//		/*
		homePage.verifyAnnouncementBar();
		homePage.verifySearchField();
		homePage.verifyLogo();
		
//		homePage = new HomePage(driver);
		homePage.verifyWishlist();
		homePage.verifyRoyalty();
		homePage.clickCompanyLogo();
		homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		*/
		
		homePage.takeScreenShotsOfMenuItems();
		
//		/*
		homePage.clickAccountIcon();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLoginPage();
		loginPage.clickCompanyLogo();
		
		homePage = new HomePage(driver);
		homePage.clickCartIcon();
	
		Cart cart = new Cart(driver);
		cart.verifyCartPage();
		cart.verifyEmptyCart();
		cart.clickCompanyLogo();
//		*/
	}
}
