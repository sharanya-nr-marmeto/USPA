package testScripts;

// Script for testing PDP

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

public class Script14 extends OpenCloseApplication 
{
	LinkedHashMap<String, String> captureProductDetails;
	
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.clickAccountIcon();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickEmail();
		loginPage.enterEmailInTextField();
		loginPage.clickRequestOTPButton();
		loginPage.enterOTP();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.verifyAccountPage();
		
//		/*
		myAccountPage.clickCompanyLogo();
		homePage = new HomePage(driver);
		homePage.clickShopAllButton();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
		collectionsPage.clickOnAnyProduct();
		
		PDP pdp = new PDP(driver);
		pdp.clickWishlistIcon();
		pdp.verifyProductIsAddedToWishlist();
		captureProductDetails = pdp.captureProductDetails2();
		pdp.clickAddToCartButton();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyCartPage();
		cart.verifyAddedProductDetails2(captureProductDetails);
		cart.clickCheckoutButton();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyCheckoutPage();
		checkoutPage.clickAddressSelectDropdown();
		checkoutPage.fillAddressDetails();
		checkoutPage.clickContinueButton();
		checkoutPage.clickContinueButton();
		checkoutPage.clickContinueButton();
//		*/
	}
}
