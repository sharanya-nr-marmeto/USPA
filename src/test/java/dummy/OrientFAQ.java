package dummy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericScripts.HandlingPropertyFile;

public class OrientFAQ 
{
	public static final String chromeBinaryPath = "./Softwares/chrome-win64/chrome-win64/chrome.exe";
	public static final String chromeDriverKey = "webdriver.chrome.driver";
	public static final String chromeDriverValue = "./drivers/chromedriver.exe";
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openApp() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
//		options.setBinary(chromeBinaryPath);
		options.addArguments("--disable-notifications");
		System.setProperty(chromeDriverKey, chromeDriverValue);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://shop.orientelectric.com/collections/all");
	}
	
	@Test
	public void testApp() throws Exception
	{
		
		OrientPLP orientPLP = new OrientPLP(driver);
		orientPLP.closeInitialPopUp();
		orientPLP.clickProductAndFAQ();
	}
	
	@AfterMethod
	public void closeApp() throws Exception
	{
		driver.close();
	}
}
