package genericScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class OpenCloseApplication implements FrameworkConstants
{
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
		driver.get(HandlingPropertyFile.getProperty("./Utilities/website.properties", "url"));
	}
	
	@AfterMethod
	public void closeApp() throws Exception
	{
		driver.close();
	}
}
