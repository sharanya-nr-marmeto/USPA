package testScripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;

// Script to verify footer
public class Script7 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.verifyFooter();
	}
}
