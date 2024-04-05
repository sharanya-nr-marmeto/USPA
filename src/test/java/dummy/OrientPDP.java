package dummy;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericScripts.ScrollToElement;

public class OrientPDP {
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@id, 'product__title')]/h1")
	private WebElement productTitle;
	
	@FindBy(css = "div.product_faq_main_heading_container")
	private WebElement faqContainer;
	
	@FindBy(css = "div.product_faq_main_heading_container")
	private WebElement faqSection;
	
	@FindBy(css = "div.product_faq_tab_container")
	private List<WebElement> faqSectionContainer;
	
	public OrientPDP(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void scrollToFAQ() throws Exception {
		ScrollToElement.scrollToElementByPixel(driver, faqContainer, 400);
	}
	
	public void clickFAQ() throws Exception {
		faqSection.click();
		Thread.sleep(1000);
	}
	
	public void verifyFAQ() throws Exception {
		if(faqSectionContainer.size()!=0)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 100)");
			Thread.sleep(1000);
			
			System.out.println(productTitle.getText());
		}
	}
	
	public void clickBackButton() throws Exception {
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
	
}
