package testScripts;

// Script for user flow - Login, Search for product, Add to Cart, Checkout

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
import pom.RegisterPage;

public class Script4 extends OpenCloseApplication 
{
	LinkedHashMap<String, String> captureProductDetails;
	
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		
//		/*
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
		homePage.verifyHomePage();
//		*/
		homePage.clickShopAllButton();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
//		collectionsPage.closeInitialPopUp();
		collectionsPage.clickOnAnyProduct();
		
		PDP pdp = new PDP(driver);
		captureProductDetails = pdp.captureProductDetails();
		pdp.clickAddToCartButton();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyCartPage();
		cart.verifyAddedProductDetails(captureProductDetails);
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
