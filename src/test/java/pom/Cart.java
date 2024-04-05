package pom;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import genericScripts.ScrollToElement;
import genericScripts.TakeImage;

public class Cart {
	WebDriver driver;

	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;

	@FindBy(xpath = "//*[.='Cart']")
	private WebElement cartDrawerText;

	@FindBy(xpath = "//p[.='Your cart is currently empty.']")
	private WebElement emptyCartText;

	@FindBy(xpath = "//button[.='Check out']")
	private WebElement checkout;

	@FindBy(xpath = "//p[@class='ajax-cart__title']/a")
	private WebElement productTitle;

//	@FindBy(xpath="//span[@class='line-item_price']")
	@FindBy(css = "dd[data-cart-item-regular-price] span")
	private WebElement productPrice;
	
	@FindBy(css = "li[class*='ajax-cart__item-details'] div div div span")
	private List<WebElement> productSizeColor;

	@FindBy(xpath = "(//div[@class='ajax-cart__cart-variants'])[1]/div/span[1]")
	private WebElement productSize;

	@FindBy(xpath = "(//div[@class='ajax-cart__cart-variants'])[1]/div/span[2]")
	private WebElement productColor;
	
	@FindBy(css = "input[data-item-qty]")
	private WebElement productQuantity;
	
	@FindBy(xpath = "//a[contains(@class, 'qty-control--down')]")
	private WebElement productQuantityDown;
	
	@FindBy(xpath = "//a[contains(@class, 'qty-control--up')]")
	private WebElement productQuantityUp;

	@FindBy(xpath = "//li[contains(@class,'item-remove')]")
	private WebElement productRemoveIcon;

	public Cart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyCartPage() throws Exception {
		Assert.assertEquals(driver.getTitle(), "Your Shopping Cart – U.S. Polo Assn. India");
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
	}

	public void verifyEmptyCart() throws Exception {
		Assert.assertTrue(emptyCartText.isDisplayed());
		Thread.sleep(2000);
	}

	public void clickCompanyLogo() throws Exception {
		companyLogo.click();
		Thread.sleep(2000);
	}

	public void verifyAddedProductDetails(LinkedHashMap<String, String> productDetails) throws Exception {
		System.out.println(productTitle.getText());
		System.out.println(productPrice.getText());
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productDetails.get("title"), productTitle.getText());
		softAssert.assertEquals(productDetails.get("price"), productPrice.getText());
		softAssert.assertAll();
	}
	
	public void verifyAddedProductDetails1(LinkedHashMap<String, String> productDetails) throws Exception {
//		/*
		System.out.println(productTitle.getText());
		System.out.println(productPrice.getText());
		System.out.println(productSize.getText().substring(0, productSize.getText().indexOf('/')));
//		*/
		
//		/*
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productDetails.get("title"), productTitle.getText());
//		softAssert.assertEquals(productDetails.get("price"), productPrice.getText());
		softAssert.assertEquals(productDetails.get("size"),
				productSize.getText().substring(0, productSize.getText().indexOf('/')));
		softAssert.assertAll();
//		*/
	}

	public void verifyAddedProductDetails2(LinkedHashMap<String, String> productDetails) throws Exception {
//		/*
		System.out.println(productTitle.getText());
		System.out.println(productPrice.getText());
		System.out.println(productSizeColor.get(0).getText());
		System.out.println(productSizeColor.get(1).getText());
		System.out.println(productQuantity.getText());
//		*/
		
//		/*
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(productTitle.getText(), productDetails.get("title"));
//		softAssert.assertEquals(productPrice.getText(), productDetails.get("price"));
		softAssert.assertEquals(productSizeColor.get(0).getText().substring(0, productSizeColor.get(0).getText().indexOf('/')), productDetails.get("size")
				);
		softAssert.assertEquals(productSizeColor.get(1).getText(), productDetails.get("color"));
		softAssert.assertEquals(productQuantity.getAttribute("value"), productDetails.get("quantity"));
		
		softAssert.assertAll();
//		*/
	}
	
	public void verifyQuantitySelector() throws Exception {
		increaseQuantity(2);
		reduceQuantity(2);
	}
	
	public void increaseQuantity(int num) throws Exception {
//		ScrollToElement.scrollToElement(driver, quantityUp);
//		ScrollToElement.scrollToElementByPixel(driver, productQuantityUp, 400);
//		Thread.sleep(2000);
		
		for (int i = 1; i <= num; i++) {
			productQuantityUp.click();
			Thread.sleep(2000);
		}

	}
	
	public void reduceQuantity(int num) throws Exception {
//		ScrollToElement.scrollToElement(driver, quantityUp);
//		ScrollToElement.scrollToElementByPixel(driver, productQuantityUp, 400);
//		Thread.sleep(2000);
		
		for (int i = 1; i <= num; i++) {
			productQuantityDown.click();
			Thread.sleep(2000);
		}

	}

	public void clickProductRemoveIcon() throws Exception {
		productRemoveIcon.click();
		Thread.sleep(2000);
	}

	public void clickCheckoutButton() throws Exception {
		checkout.click();
		Thread.sleep(2000);
	}
}
