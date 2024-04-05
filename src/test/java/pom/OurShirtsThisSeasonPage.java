package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OurShirtsThisSeasonPage {
	WebDriver driver;
	
	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;
	
	@FindBy(xpath = "//div[contains(@id,'total-products')]/span/span")
	private WebElement totalProductsCount;
	
	public OurShirtsThisSeasonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickCompanyLogo() throws Exception
	{
		companyLogo.click();
		Thread.sleep(2000);
	}
	
	public void verifyOurShirtsThisSeasonPage() throws Exception
	{
		Assert.assertEquals(driver.getTitle(), "Our Shirts this Season – U.S. Polo Assn. India");
	}
	
	public void verifyTotalProductsCount(int homePageCount) throws Exception
	{
		Assert.assertEquals(Integer.parseInt(totalProductsCount.getText()), homePageCount);
	}
}
