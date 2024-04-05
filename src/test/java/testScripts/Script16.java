package testScripts;

// Script for testing Cart

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Cart;
import pom.CheckoutPage;
import pom.CollectionsPage;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;
import pom.PDP;

public class Script16 extends OpenCloseApplication 
{
	LinkedHashMap<String, String> captureProductDetails;
	
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		
//		/*
		homePage.clickAccountIcon();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickEmail();
		loginPage.enterEmailInTextField();
		loginPage.clickRequestOTPButton();
		loginPage.enterOTP();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.verifyAccountPage();
//		*/
//		/*
		myAccountPage.clickCompanyLogo();
		homePage = new HomePage(driver);
		homePage.clickShopAllButton();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
		collectionsPage.clickOnAnyProduct();
		
		int quantity = 5;
		PDP pdp = new PDP(driver);
		captureProductDetails = pdp.captureProductDetails2(quantity);
//		pdp.increaseQuantity(quantity);
		pdp.clickAddToCartButtonAfterIncreasingQuantity();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyCartPage();
		cart.verifyAddedProductDetails2(captureProductDetails);
		cart.verifyQuantitySelector();
		cart.clickCheckoutButton();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyCheckoutPage();
//		*/
	}
}
