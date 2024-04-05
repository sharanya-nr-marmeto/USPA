package testScripts;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;

//Script to verify 'Winter Wear for the Season'

public class Script10 extends OpenCloseApplication 
{
	@Test
	public void testApp() throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.verifyWinterWearForTheSeason();
	}
}
