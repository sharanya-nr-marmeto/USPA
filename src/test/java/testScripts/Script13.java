package testScripts;

import static org.testng.Assert.fail;

// Script for testing PLP

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

public class Script13 extends OpenCloseApplication 
{
	LinkedHashMap<String, String> captureProductDetails;
	
	// Filter
	@Test(enabled = true)
	public void plp1() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.clickShopAllButton();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
//		collectionsPage.verifyPriceFilter();
		collectionsPage.verifyCategoryFilter();
//		collectionsPage.verifySizeFilter();
//		collectionsPage.verifyPatternFilter();
//		collectionsPage.verifyBrandColorFilter();
//		collectionsPage.verifyNeckFilter();
//		collectionsPage.verifyGenderFilter();
//		collectionsPage.verifyDiscountFilter();
//		collectionsPage.verifyFitFilter();
		
	}
	
	// Sort
	@Test(enabled = false)
	public void plp2() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.clickShopAllButton();
		
		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortNewArrivals();
		
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortRecommended();
		
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortPriceHighToLow();
		
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortPriceLowToHigh();
		
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortOnDiscount();
		
		collectionsPage.clicksortDropdown();
		collectionsPage.clicksortBestsellers();
	}
}
