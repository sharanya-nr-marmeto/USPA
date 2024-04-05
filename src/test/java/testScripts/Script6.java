package testScripts;

// Script for verifying homepage banner

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.Cart;
import pom.HomePage;
import pom.LoginPage;

public class Script6 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		
		homePage.verifyBannerRedirection();
//		homePage.verifyBannerRedirection2();
	}
}
