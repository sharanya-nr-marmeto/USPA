package testScripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;

//Script to verify Our Signature Polos

public class Script9 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.verifyOurSignaturePolos();
	}
}
