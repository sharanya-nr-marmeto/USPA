package testScripts;

//	Script to test login - PhoneNumber

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;

public class Script11 extends OpenCloseApplication 
{
	@DataProvider(name= "testData")
	public Object[][] testData()
	{
		Object[][] obj = new Object[10][2];
		
//		Valid mobile number
		obj[0][0] = "8883868068";
		obj[0][1] = "valid";
		
//		Invalid mobile number - more than 10 digits
		obj[1][0] = "8883868068234";
		obj[1][1] = "invalid";
		
//		Invalid mobile number - Leading spaces
		obj[2][0] = "    " +  "8883868068";
		obj[2][1] = "invalid";
		
//		Invalid mobile number - Trailing spaces
		obj[3][0] = "8883868068"+"    ";
		obj[3][1] = "invalid";
		
//		Alphabets
		obj[4][0] = "asdfghjlqw";
		obj[4][1] = "invalid";
		
//		Special  Characters
		obj[5][0] = "~!@#$^&()+-";
		obj[5][1] = "invalid";
		
//		Email id
		obj[6][0] = "snravindra0102@gmail.com";
		obj[6][1] = "invalid";
		
//		Email id
		obj[7][0] = "snravindra0102@gmail.com";
		obj[7][1] = "invalid";
		
//		Empty
		obj[8][0] = "";
		obj[8][1] = "invalid";
		
//		Unregistered
		obj[9][0] = "9449880352";
		obj[9][1] = "unregistered";
		
		return obj;
		
	}
//	@Test(dataProvider = "testData")
//	String phoneNumber, String status
	
	@Test(dataProvider = "testData")
	public void testApp(String phoneNumber, String status) throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.clickAccountIcon();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyCountryDropDown();
		loginPage.enterPhoneNumberInTextField(phoneNumber);
		loginPage.clickRequestOTPButton();
		
		if(status.equals("invalid"))
		{
			loginPage.verifyInvalidPhoneErrorMessage();
		}
		
		else if(status.equals("unregistered"))
		{
			loginPage.enterOTP();
			loginPage.verifyCreateAccountPage();
		}
		
		else
		{
			loginPage.enterOTP();
			loginPage.verifyIncorrectOTP();
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			myAccountPage.verifyAccountPage();
			myAccountPage.clickLogoutLink();
		}
	}
}
