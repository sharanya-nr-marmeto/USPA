package pom;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genericScripts.ScrollToElement;

public class PDP {
	WebDriver driver;

	LinkedHashMap<String, String> productDetails;

	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;

	@FindBy(xpath = "//h1[@class='product__section-title product-title']")
	private WebElement productTitle;
	
	@FindBy(xpath = "//div[@class='wishlist-engine-button']")
	private WebElement productAddToWishlist;
	
//	@FindBy(xpath = "//div[@class='wishlit-popupinr']/div/h3[contains(text(), 'Item has been successfully added to wishlist')]")
//	private WebElement productAddedToWishlistConfirmationMessage;
	
	@FindBy(xpath = "//div[@class='wishlit-popupinr']")
	private WebElement productAddedToWishlistConfirmationMessage;
	
	@FindBy(xpath = "//button[@class='close-wishlist']")
	private WebElement closeWishlistPopup;

	@FindBy(xpath = "//dl[@class='price__sale']/dd/span[@class='price-item price-item--sale']")
	private WebElement productPrice;

	@FindBy(xpath = "//a[@class='up quantity-control-up']")
	private WebElement quantityUp;
	
	@FindBy(xpath = "//a[@class='down quantity-control-down']")
	private WebElement quantityDown;

	@FindBy(id = "addToCart")
	private WebElement addToCart;

	@FindBy(xpath = "//div[contains(text(),'Item is successfully added to the cart!')]")
	private WebElement itemCartConfirmationMessage;

	@FindBy(xpath = "//div[@class='product-info-container']/a[@href='/cart']")
	private WebElement goToCartButton;

	@FindBy(xpath = "//ul[@class='shopping__cart-links']/li/a[@href='/cart']")
	private WebElement cartIcon;

	@FindBy(xpath = "(//div[@class='rte accordion__active'])[2]")
	private WebElement accordionSection;

	@FindBy(xpath = "//div[contains(@class,'product__variants')]/div/p/span[@id='selected-option-1']")
	private WebElement sizeText;

	@FindBy(xpath = "//div[contains(@class,'color-swatches')]/div/span[@class='swatch-type']")
	private WebElement colorText;

	public PDP(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		productDetails = new LinkedHashMap<String, String>();
	}

	public LinkedHashMap<String, String> captureProductDetails() {
		String title = productTitle.getText();
		String price = productPrice.getText();

		productDetails.put("title", title);
		productDetails.put("price", price);

		System.out.println(productDetails);
		return productDetails;
	}

	public LinkedHashMap<String, String> captureProductDetails2() {
		String title = productTitle.getText();
		String price = productPrice.getText();
		String size = sizeText.getText();
		String color = colorText.getText();

		productDetails.put("title", title);
		productDetails.put("price", price);
		productDetails.put("size", size);
		productDetails.put("color", color);
		productDetails.put("quantity", "1");

		System.out.println(productDetails);
		return productDetails;
	}
	
	public LinkedHashMap<String, String> captureProductDetails2(int quantity) throws Exception {
		String title = productTitle.getText();
		String price = productPrice.getText();
		String size = sizeText.getText();
		String color = colorText.getText();
		
		increaseQuantity(quantity);
		
		reduceQuantity(2);

		productDetails.put("title", title);
		productDetails.put("price", price);
		productDetails.put("size", size);
		productDetails.put("color", color);
		productDetails.put("quantity", String.valueOf(quantity-2));

		System.out.println(productDetails);
		return productDetails;
	}

	public void verifyProductTitle(String homepageTitle) throws Exception {
		Assert.assertEquals(productTitle.getText(), homepageTitle);
	}

	public void increaseQuantity(int num) throws Exception {
//		ScrollToElement.scrollToElement(driver, quantityUp);
		ScrollToElement.scrollToElementByPixel(driver, quantityUp, 400);
		Thread.sleep(2000);
		
		for (int i = 1; i < num; i++) {
			quantityUp.click();
			Thread.sleep(2000);
		}

	}
	
	public void reduceQuantity(int num) throws Exception {
//		ScrollToElement.scrollToElement(driver, quantityDown);
//		ScrollToElement.scrollToElementByPixel(driver, quantityDown, 400);
//		Thread.sleep(2000);
		
		for (int i = 1; i <= num; i++) {
			quantityDown.click();
			Thread.sleep(2000);
		}

	}

	public void clickAddToCartButton() throws Exception {
//		/*
		ScrollToElement.scrollToElementByPixel(driver, addToCart, 300);
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, 25);
//		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
//		*/

		/*
		 * for(int i=0;i<5;i++) ScrollToElement.scrollToElementStepByStep(driver);
		 * 
		 */
		addToCart.click();
		Thread.sleep(2000);
	}
	
	public void clickAddToCartButtonAfterIncreasingQuantity() throws Exception {
		addToCart.click();
		Thread.sleep(2000);
	}

	public void verifyItemAddedToCartSuccessMessage() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(itemCartConfirmationMessage));
		Assert.assertTrue(itemCartConfirmationMessage.isDisplayed());

		/*
		 * Assert.assertEquals(addToCart.getAttribute("value"), "Adding...");
		 * Assert.assertEquals(addToCart.getAttribute("value"), "Added to Cart");
		 */

		goToCartButton.click();
		Thread.sleep(2000);
	}

	public void clickCartIcon() throws Exception {
		cartIcon.click();
		Thread.sleep(2000);
	}
	
	public void clickWishlistIcon() throws Exception {
		productAddToWishlist.click();
		Thread.sleep(2000);
	}
	
	public void verifyProductIsAddedToWishlist() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(productAddedToWishlistConfirmationMessage));
		
		closeWishlistPopup.click();
	}

	public void clickCompanyLogo() throws Exception {
		companyLogo.click();
		Thread.sleep(2000);
	}
}
