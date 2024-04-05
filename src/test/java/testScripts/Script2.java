package testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;

//	Script to test login - Email - Excel

public class Script2 extends OpenCloseApplication 
{
//	/*
	@DataProvider(name= "testData")
	public Object[][] testData() throws Exception
	{
		File f = new File("./excel/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet xssfSheet = wb.getSheet("USPA");
		int lastRowNum = xssfSheet.getLastRowNum();
		XSSFRow row = xssfSheet.getRow(0);
		int lastCellNum = row.getLastCellNum();
		Object[][] obj = new Object[lastRowNum-1][lastCellNum];
		
		for(int i=1;i<lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				obj[i-1][j] = xssfSheet.getRow(i).getCell(j).toString();
			}
		}
		
		wb.close();
		
		return obj;
		
	}
	@Test(enabled = true, dataProvider = "testData")
	public void testApp(String email, String status) throws Exception
	{
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
		homePage.closeInitialPopUp();
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
//	*/
}
