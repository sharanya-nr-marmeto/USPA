package pom;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

import genericScripts.ScrollToElement;

public class CollectionsPage {
	WebDriver driver;
	
	LinkedHashMap<String, String> productDetails;

	@FindBy(xpath = "//div[@class='brz-popup2__close']")
	private List<WebElement> initialPopUpCloseButton;

	@FindBy(xpath = "//div[@class='argoid-card__wrapper']/marmeto-product-card/div[@class='js-product-image animated prod-image image_portrait']/a/div/div/img")
	private List<WebElement> products;
	
	@FindBy(xpath = "(//div[@class='argoid-card__wrapper']/marmeto-product-card/div[@class='js-product-image animated prod-image image_portrait']/a/div/div/img)[2]")
	private WebElement products2;
	
	@FindBy(xpath = "//div[@class='product-info']")
	private List<WebElement> collectionPageProductList;
	
	@FindBy(xpath = "//dl[@class='price__sale']/dd/span[@class='price-item price-item--sale']")
	private List<WebElement> collectionPageProductPrice;
	
	// Sort options
	@FindBy(xpath = "//div[@id='argoid-sort--desktop']")
	private WebElement sortDropdown;
	
	@FindBy(xpath = "(//span[@class='argoid-sort-label__text'])[3]")
	private WebElement sortText;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='New Arrivals'])[2]")
	private WebElement sortNewArrivals;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='Recommended'])[2]")
	private WebElement sortRecommended;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='Price High to Low'])[2]")
	private WebElement sortPriceHighToLow;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='Price Low to High'])[2]")
	private WebElement sortPriceLowToHigh;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='On Discount'])[2]")
	private WebElement sortOnDiscount;
	
	@FindBy(xpath = "(//div[@class='sort-option-container']/p[.='Bestsellers'])[2]")
	private WebElement sortBestsellers;

	@FindBy(xpath = "//div[contains(@id,'total-products--desktop')]/span/span")
	private WebElement filterProductCount;

	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Category']")
	private WebElement filterCategoryOption;

	@FindBy(xpath = "//li[@data-display-name='Category']/div/label/span[1]")
	private List<WebElement> filterCategorySubOption;

	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Pattern']")
	private WebElement filterPatternOption;

	@FindBy(xpath = "//li[@data-display-name='Pattern']/div/label/span[1]")
	private List<WebElement> filterPatternSubOption;

	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Price']")
	private WebElement filterPriceOption;

	@FindBy(xpath = "(//ul[@data-display-name='Price']/li/div/input[@type='text'])[1]")
	private WebElement filterPriceOptionMin;

	@FindBy(xpath = "(//ul[@data-display-name='Price']/li/div/input[@type='text'])[2]")
	private WebElement filterPriceOptionMax;

	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Size']")
	private WebElement filterSizeOption;

	@FindBy(xpath = "//li[@data-display-name='Size']/div/label")
	private List<WebElement> filterSizeSubOption;

	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Brand Colour']")
	private WebElement filterBrandColorOption;

	@FindBy(xpath = "//li[@data-display-name='Brand Colour']/div/label/span[1]")
	private List<WebElement> filterBrandColorSubOption;
	
	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Neck']")
	private WebElement filterNeckOption;

	@FindBy(xpath = "//li[@data-display-name='Neck']/div/label/span[1]")
	private List<WebElement> filterNeckSubOption;
	
//	/*
	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Gender']")
	private WebElement filterGenderOption;

	@FindBy(xpath = "//li[@data-display-name='Gender']/div/label/span[1]")
	private List<WebElement> filterGenderSubOption;
	
	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Discount']")
	private WebElement filterDiscountOption;

	@FindBy(xpath = "//li[@data-display-name='Discount']/div/label/span[1]")
	private List<WebElement> filterDiscountSubOption;
	
	@FindBy(xpath = "//li[@class='argoid-facets__list-item']/div/span[.='Fit']")
	private WebElement filterFitOption;

	@FindBy(xpath = "//li[@data-display-name='Fit']/div/label/span[1]")
	private List<WebElement> filterFitSubOption;
//	*/
	@FindBy(xpath = "//span[@class='argoid-selected__pill-text']/span[2]")
	private WebElement selectedFilterOption;

	@FindBy(xpath = "(//div[.='Refine By'])[2]")
	private WebElement refineByText;

	@FindBy(xpath = "(//button[contains(text(),'Clear All')])[2]")
	private WebElement clearAllButton;

	@FindBy(xpath = "//div[@class='Header__Wrapper']//a[@href='/account']")
	private WebElement accountIcon;
	
//	Cart confirmation message
	@FindBy(xpath = "//div[contains(text(),'Item is successfully added to the cart!')]")
	private WebElement itemCartConfirmationMessage;
	
	@FindBy(xpath = "//div[@class='product-info-container']/a[@href='/cart']")
	private WebElement goToCartButton;

	public CollectionsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyCollectionsPage() throws Exception {
		Assert.assertEquals(driver.getTitle(), "Shop All – U.S. Polo Assn. India");
		Thread.sleep(2000);
	}

	public void closeInitialPopUp() throws Exception {
		if (initialPopUpCloseButton.size() != 0) {
			initialPopUpCloseButton.get(0).click();
			Thread.sleep(2000);
		}
	}
	
	public void happyFlow() throws Exception {
		productDetails = new LinkedHashMap<String, String>();
		
//		Faker faker = new Faker();
//		int num = faker.number().numberBetween(0, products.size());
//		System.out.println(collectionPageProductList.size()+" "+num);
//		WebElement product = collectionPageProductList.get(8);
		
		WebElement product = products.get(0);
		
		WebElement title = product.findElement(By.xpath("//span[@class='prod-title']"));
		WebElement price = product.findElement(By.xpath("//dl[@class='price__sale']/dd/span[@class='price-item price-item--sale']"));
		WebElement size = product.findElement(By.xpath("//ul[@class='option_sizes']/li[contains(@class, 'selected')]"));
		
		productDetails.put("title", title.getText());
		productDetails.put("price", price.getText());
		productDetails.put("size", size.getText());
		
		System.out.println(productDetails);
		
		product.findElement(By.xpath("//input[@id='addToCart']")).click();
		Thread.sleep(1000);
		verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyAddedProductDetails1(productDetails);
//		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
	}
	
	public void verifyItemAddedToCartSuccessMessage() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(itemCartConfirmationMessage));
		Assert.assertTrue(itemCartConfirmationMessage.isDisplayed());
		
		/*
		Assert.assertEquals(addToCart.getAttribute("value"), "Adding...");
		Assert.assertEquals(addToCart.getAttribute("value"), "Added to Cart");
		*/
		
		goToCartButton.click();
		Thread.sleep(2000);
	}

	public void clickOnAnyProduct() throws Exception {
//		/*
//		Faker faker = new Faker();
//		int random = faker.number().numberBetween(0, products.size());
//		int random = faker.number().numberBetween(0, 15);

//		WebElement product = products.get(1);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(product));
//		*/

		WebElement product = products.get(1);
//		ScrollToElement.scrollToElement(driver, product);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(product));
		product.click();
		Thread.sleep(2000);
	}

	public void verifyCategoryFilter() throws Exception {
		filterCategoryOption.click();

//		for (int i = filterCategorySubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterCategorySubOption) {
//			WebElement option = filterCategorySubOption.get(i);
//			ScrollToElement.scrollToElement(driver, option);
//			ScrollToElement.scrollToElementByPixel(driver, option, 500);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(option));
			
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait2 = new WebDriverWait(driver, 20);
				wait2.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait2 = new WebDriverWait(driver, 20);
				wait2.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
				ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}

	public void verifySizeFilter() throws Exception {
		filterSizeOption.click();

//		for (int i=filterSizeSubOption.size()-1;i>=0;i--)
		for (WebElement option : filterSizeSubOption) {
//			WebElement option = filterSizeSubOption.get(i);
			ScrollToElement.scrollToElementByPixel(driver, option, 500);
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(refineByText));

			System.out.println(option.getText());
			Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

			clearAllButton.click();

			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOf(refineByText));
		}
	}

	public void verifyPriceFilter() throws Exception {
		filterPriceOption.click();
		Thread.sleep(1000);

		filterPriceOptionMin.click();
		filterPriceOptionMin.sendKeys(Keys.CONTROL + "A");
		filterPriceOptionMin.sendKeys(Keys.DELETE);
		filterPriceOptionMin.sendKeys("0");
		Thread.sleep(1000);

//		/*
		filterPriceOptionMax.click();
		filterPriceOptionMax.sendKeys(Keys.CONTROL + "A");
		filterPriceOptionMax.sendKeys(Keys.DELETE);
		filterPriceOptionMax.sendKeys("2000" + Keys.ENTER);
		Thread.sleep(1000);
//		*/

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(refineByText));

		clearAllButton.click();

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(refineByText));
	}

	public void verifyPatternFilter() throws Exception {
		filterPatternOption.click();

//		for (int i = filterPatternSubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterPatternSubOption) {
//			WebElement option = filterPatternSubOption.get(i);
//			ScrollToElement.scrollToElement(driver, option);
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
//				ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}

	public void verifyBrandColorFilter() throws Exception {
		filterBrandColorOption.click();

//		for (int i = filterPatternSubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterBrandColorSubOption) {
//			WebElement option = filterPatternSubOption.get(i);
//			ScrollToElement.scrollToElement(driver, option);
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
//				ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public void verifyNeckFilter() throws Exception {
//		verifyFilter(filterNeckOption, filterNeckSubOption);
		ScrollToElement.scrollToElement(driver, filterNeckOption);
		filterNeckOption.click();

//		for (int i = filterPatternSubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterNeckSubOption) {
//			WebElement option = filterPatternSubOption.get(i);
//			ScrollToElement.scrollToElement(driver, option);
			
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.elementToBeClickable(option));
			
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
//				ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public void verifyGenderFilter() throws Exception {
//		verifyFilter(filterGenderOption, filterGenderSubOption);
		
//		verifyFilter(filterNeckOption, filterNeckSubOption);
		ScrollToElement.scrollToElement(driver, filterGenderOption);
		filterGenderOption.click();

//		for (int i = filterPatternSubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterGenderSubOption) {
//			WebElement option = filterPatternSubOption.get(i);
//			ScrollToElement.scrollToElement(driver, option);
			
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.elementToBeClickable(option));
			
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
//				ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public void verifyDiscountFilter() throws Exception {
		verifyFilter(filterDiscountOption, filterDiscountSubOption);
	}
	
	public void verifyFitFilter() throws Exception {
		verifyFilter(filterFitOption, filterFitSubOption);
	}

	public void verifyFilter(WebElement filterMainOption, List<WebElement> filterSubOption) throws Exception {
//		ScrollToElement.scrollToElement(driver, filterMainOption);
		filterMainOption.click();

//			for (int i = filterPatternSubOption.size() - 1; i >= 0; i--)
		for (WebElement option : filterBrandColorSubOption) {
//				WebElement option = filterPatternSubOption.get(i);
//				ScrollToElement.scrollToElement(driver, option);
			option.click();
			Thread.sleep(1000);

			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			wait1.until(ExpectedConditions.visibilityOf(filterProductCount));

			if (!filterProductCount.getText().equals("0")) {

				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(refineByText));

				System.out.println(option.getText());
				Assert.assertEquals(option.getText().toLowerCase(), selectedFilterOption.getText().toLowerCase());

				clearAllButton.click();

				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.invisibilityOf(refineByText));
			}

			else {
//					ScrollToElement.scrollToElement(driver, option);
				option.click();
				Thread.sleep(1000);
			}
		}
	}
	
	public void clicksortDropdown() throws Exception {
		sortDropdown.click();
		Thread.sleep(1000);
	}
	
	public void clicksortRecommended() throws Exception {
		sortRecommended.click();
		Thread.sleep(5000);
	}
	
	public void clicksortNewArrivals() throws Exception {
		sortNewArrivals.click();
		Thread.sleep(5000);
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
		
		Assert.assertEquals(sortText.getText(), "New Arrivals");
	}
	
	public void clicksortPriceHighToLow() throws Exception {
		sortPriceHighToLow.click();
		Thread.sleep(5000);
	}
	
	public void clickAndVerifysortPriceHighToLow() throws Exception {
		ArrayList<Double> pricesBeforeSort = new ArrayList<Double>();
		
		for (WebElement ele : collectionPageProductPrice) {
			String priceText = ele.getText().substring(ele.getText().indexOf(" ")+1).replaceAll(",", "");
			pricesBeforeSort.add(Double.parseDouble(priceText));
		}
		
		System.out.println(pricesBeforeSort);
		
		sortPriceHighToLow.click();
		Thread.sleep(5000);
		
		ArrayList<Double> pricesAfterSort = new ArrayList<Double>();
		
		collectionPageProductPrice = driver.findElements(By.xpath("//dl[@class='price__sale']/dd/span[@class='price-item price-item--sale']"));
		
		for (WebElement ele : collectionPageProductPrice) {
			String priceText = ele.getText().substring(ele.getText().indexOf(" ")+1).replaceAll(",", "");
			pricesAfterSort.add(Double.parseDouble(priceText));
		}
		System.out.println(pricesAfterSort);
	}
	
	public void clicksortPriceLowToHigh() throws Exception {
		sortPriceLowToHigh.click();
		Thread.sleep(5000);
	}
	
	public void clicksortOnDiscount() throws Exception {
		sortOnDiscount.click();
		Thread.sleep(5000);
	}
	
	public void clicksortBestsellers() throws Exception {
		sortBestsellers.click();
		Thread.sleep(5000);
	}
}
