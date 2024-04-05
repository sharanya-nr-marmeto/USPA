package testScripts;

//Script for search functionality

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.HomePage;
import pom.LoginPage;
import pom.MyAccountPage;
import pom.RegisterPage;

//	Script for Search Functionality

public class Script3 extends OpenCloseApplication 
{
	@DataProvider(name="searchKeyword")
	public Object[][] dataProvider()
	{
		return new Object[][] {
			{"pants", "valid"},
			{"adsadsv", "invalid"},
			{"women", "valid"},
			{"123456", "invalid"},
			{"kids", "valid"},
			{"~!@#$%^&", "invalid"}
		};
	}
	
//	(dataProvider = "searchKeyword")
//	String keyword, String status
	
	@Test
	public void testApp() throws Exception
	{
		/*
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		homePage.clickOnSearchField();
		homePage.enterDataIntoSearchField(keyword);
		homePage.verifySearchResults(status);
		*/
		
//		/*
		LinkedHashMap<String, String> keywords = new LinkedHashMap<String, String>();
		keywords.put("pants", "valid");
		keywords.put("adsadsv", "invalid");
		keywords.put("women", "valid");
		keywords.put("123456", "invalid");
		keywords.put("kids", "valid");
		keywords.put("~!@#$%^&", "invalid");
		
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePage();
//		homePage.closeInitialPopUp();
		
		for(Entry<String, String> e:keywords.entrySet())
		{
			homePage.clickOnSearchField();
			homePage.enterDataIntoSearchField(e.getKey());
			homePage.verifySearchResults(e.getValue());
		}
//		*/
	}
}
