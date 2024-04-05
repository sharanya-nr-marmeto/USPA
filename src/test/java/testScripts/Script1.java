package testScripts;

//Script to test login - Email

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;

public class Script1 extends OpenCloseApplication 
{
	@DataProvider(name= "testData")
	public Object[][] testData()
	{
		Object[][] obj = new Object[7][2];
		
//		Valid email
		obj[0][0] = "snravindra0102@gmail.com";
		obj[0][1] = "valid";
		
//		Invalid email format - without the '@' symbol
		obj[1][0] = "snravindra0102";
		obj[1][1] = "invalid";
		
//		Invalid email format - without a domain 
		obj[2][0] = "snravindra0102@";
		obj[2][1] = "invalid";
		
//		Invalid email format - without a top-level domain
		obj[3][0] = "snravindra0102@gmail";
		obj[3][1] = "invalid";
		
//		Use mobile number instead of email
		obj[4][0] = "7829156580";
		obj[4][1] = "invalid";
		
//		Invalid email format - Only special characters '~!@#$^&()'
		obj[5][0] = "~!@#$^&()";
		obj[5][1] = "invalid";
		
//		No email
		obj[6][0] = "";
		obj[6][1] = "invalid";
		
		return obj;
		
	}
	@Test(dataProvider = "testData")
	public void testApp(String email, String status) throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.clickAccountIcon();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickEmail();
		loginPage.enterEmailInTextField(email);
		loginPage.clickRequestOTPButton();
		
		if(status.equals("invalid"))
		{
			loginPage.verifyInvalidEmailErrorMessage();
		}
		
		else
		{
			loginPage.enterOTP();
			
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			myAccountPage.verifyAccountPage();
			myAccountPage.clickLogoutLink();
		}
	}
}
