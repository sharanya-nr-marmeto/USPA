package testScripts;

//Script to verify Homepage collection redirection

import org.testng.annotations.Test;

//	Script to test home page collections redirection

import genericScripts.OpenCloseApplication;
import pom.HomePage;

public class Script12 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.verifyHomepageCollections();
	}
}
