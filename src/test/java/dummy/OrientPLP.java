package dummy;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericScripts.ScrollToElement;

public class OrientPLP {
	WebDriver driver;

	LinkedHashMap<String, String> productDetails;

	@FindBy(xpath = "//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a")
	private List<WebElement> productLists;
	
	@FindBy(css = "p.closeBtn")
	private List<WebElement> initialPopUpCloseButton;
	
	public OrientPLP(WebDriver driver) {
//		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		this.driver = driver;
	}

	public void closeInitialPopUp() throws Exception {
		if (initialPopUpCloseButton.size() != 0) {
			initialPopUpCloseButton.get(0).click();
			Thread.sleep(2000);
		}
	}
	
	public void fetchProductTitle() throws Exception {
		OrientPDP orientPDP = null;
		List<WebElement> findElements = driver.findElements(By.xpath("//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a"));
		while(findElements.size()!=171)
		{
			Thread.sleep(2000);
			findElements = driver.findElements(By.xpath("//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a"));
		}
		
		System.out.println(productLists.size());
		int i=1;
		for (WebElement product : productLists) {
			System.out.println(i+". "+product.getText());
			i++;
			ScrollToElement.scrollToElementBy300(driver, product);
			product.click();
			
			orientPDP = new OrientPDP(driver);
			orientPDP.scrollToFAQ();
			orientPDP.clickFAQ();
		}
	}
	
	public void clickProductAndFAQ() throws Exception {
		OrientPDP orientPDP = null;
		
		int i=1;
		while(i<=171)
		{
			/*
			if(i%27==1)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(10000);
			}
			*/
			
			List<WebElement> product1 = driver.findElements(By.xpath("(//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a)["+i+"]"));
			
			if(product1.size()==0) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0, 100)");
				Thread.sleep(10000);
			}
				
			WebElement product = driver.findElement(By.xpath("(//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a)["+i+"]"));
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@id='product-grid']/li/div/div/div[1]/div/h3/a)["+i+"]")));
			
//			System.out.println(product.getText());
			
			product.click();
			
			orientPDP = new OrientPDP(driver);
			orientPDP.scrollToFAQ();
			orientPDP.clickFAQ();
			orientPDP.verifyFAQ();
			orientPDP.clickBackButton();
			i++;
		}
	}
}
