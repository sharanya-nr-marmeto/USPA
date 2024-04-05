package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genericScripts.ScrollToElement;

public class MyAccountPage {
	WebDriver driver;
	
	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;
	
	@FindBy(xpath = "//div[@class='SectionHeader']/h1")
	private WebElement myAccountText;
	
	@FindBy(xpath = "(//a[@href='/account/logout'])[2]")
	private WebElement logoutLink;
	
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void verifyAccountPage() throws Exception
	{
		Assert.assertEquals(driver.getTitle(), "Account – U.S. Polo Assn. India");
		Thread.sleep(2000);
	}
	
	public void clickLogoutLink() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		logoutLink.click();
		Thread.sleep(2000);
	}
	
	public void clickCompanyLogo() throws Exception
	{
		companyLogo.click();
		Thread.sleep(2000);
	}
}
