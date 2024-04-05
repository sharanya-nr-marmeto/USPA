package pom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import genericScripts.HandlingPropertyFile;
import genericScripts.ScrollToElement;
import genericScripts.TakeImage;

public class HomePage {
	WebDriver driver;
	
	LinkedHashMap<String, String> productDetails;

	@FindBy(xpath = "//div[@class='brz-popup2__close']")
	private List<WebElement> initialPopUpCloseButton;

	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;

	@FindBy(css = "div[id='shopify-section-announcement-bar']")
	private WebElement announcementBar;

	// Mega menu Items locators
	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[1]")
	private WebElement menuItems1;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[2]")
	private WebElement menuItems2;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[3]")
	private WebElement menuItems3;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[4]")
	private WebElement menuItems4;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[5]")
	private WebElement menuItems5;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[6]")
	private WebElement menuItems6;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[7]")
	private WebElement menuItems7;

	@FindBy(xpath = "(//ul[@class='dropdown js-dropdown'][@aria-label='KIDS']/li/a)[2]")
	private WebElement menuItems71;

	@FindBy(xpath = "(//ul[@class='dropdown js-dropdown'][@aria-label='KIDS']/li/a)[3]")
	private WebElement menuItems72;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[8]")
	private WebElement menuItems8;

	@FindBy(xpath = "(//div[contains(@class,'navgation_container')]/ul/li/a)[9]")
	private WebElement menuItems9;

	@FindBy(xpath = "//ul[@class='shopping__cart-links']/li[@class='wishlistt-li']/a")
	private WebElement wishlistIcon;

	@FindBy(xpath = "//h1[.='My wishlist']")
	private WebElement wishlistHeading;

	@FindBy(xpath = "//button[@class='sewp-close']")
	private WebElement wishlistCloseButton;

	@FindBy(xpath = "//ul[@class='shopping__cart-links']/li/a[@href='/account/login']")
	private WebElement accountIcon;

	@FindBy(xpath = "//ul[@class='shopping__cart-links']/li/a[@href='/cart']")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//ul[@class='shopping__cart-links']/li/a[@href='/pages/capillary-generic-page']")
	private WebElement royaltyIcon;

	@FindBy(id = "searchbox-")
	private WebElement searchInputField;

//	Shop Social  section locators
//	@FindBy(xpath="//span[.='Shop All']")
//	private WebElement shopAllButton;

	@FindBy(xpath = "//h2[.='Shop Social']")
	private WebElement shopSocial;

	@FindBy(xpath = "//a[@href='/collections/shop-all']")
	private WebElement shopAllButton;

	@FindBy(xpath = "//div[@class='search__page-filter']/div/p")
	private WebElement resultsText;

	@FindBy(xpath = "//div[@class='slideshow__slide-desktop image_banner']/div/img")
	private WebElement banner;

	@FindBy(xpath = "(//button[@class='flickity-button flickity-prev-next-button next'])[1]")
	private WebElement bannerFlickityForward;

	@FindBy(xpath = "//ul[@class='dropdown js-dropdown'][@aria-label='NEW ARRIVALS']/li/a")
	private List<WebElement> newArrivalsDropdownItems;

	@FindBy(id = "footer-wrapper")
	private WebElement footer;

	@FindBy(css = "div#footer section")
	private List<WebElement> footerSections;

	@FindBy(css = "div.footer-sect ul li")
	private List<WebElement> footerLinks;
	
	@FindBy(xpath = "//div[@class='product-info']")
	private List<WebElement> homePageProductList;
	
	@FindBy(xpath = "//marmeto-product-card/div/a/div/div/img")
	private List<WebElement> homePageProducts;
	
//	Winter Wear For The Season section locators
//	/*

	@FindBy(xpath = "//h2[.='WINTER WEAR FOR THE SEASON']")
	private WebElement winterWearForTheSeason;
	
	@FindBy(xpath = "//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div")
	private List<WebElement> winterWearForTheSeasonProductList;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement winterWearForTheSeasonProduct1Title;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/div/dl[2]/dd[2]/span")
	private WebElement winterWearForTheSeasonProduct1Price;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/form/div/ul[@class='option_sizes']/li[contains(@class, 'selected')]")
	private WebElement winterWearForTheSeasonProduct1Size;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span/../../form/div/input")
	private WebElement winterWearForTheSeasonProduct1AddToCart;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[3]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement winterWearForTheSeasonProduct2Title;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[3]/marmeto-product-card/div[@class='product-info']/div/div/dl[2]/dd[2]/span")
	private WebElement winterWearForTheSeasonProduct2Price;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[3]/marmeto-product-card/div[@class='product-info']/div/form/div/ul[@class='option_sizes']/li[contains(@class, 'selected')]")
	private WebElement winterWearForTheSeasonProduct2Size;
	
	@FindBy(xpath = "(//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/div/div/div)[3]/marmeto-product-card/div[@class='product-info']/div/a/span/../../form/div/input")
	private WebElement winterWearForTheSeasonProduct2AddToCart;
	
	@FindBy(xpath = "//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/button[@aria-label='Next']")
	private WebElement winterWearForTheSeasonFlickityNext;
	
	@FindBy(xpath = "//h2[.='WINTER WEAR FOR THE SEASON']/../../div[3]/button[@aria-label='Previous']")
	private WebElement winterWearForTheSeasonFlickityPrevious;
	
	@FindBy(xpath = "//h2[.='WINTER WEAR FOR THE SEASON']/../../div[@class='view_all_button']/a")
	private WebElement winterWearForTheSeasonViewAllButton;
	
//	Our Shirts This Season section locators 
//	*/
	
	@FindBy(xpath = "//h2[.='OUR SHIRTS THIS SEASON']")
	private WebElement ourShirtsThisSeason;
	
	@FindBy(xpath = "//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/div/div/div")
	private List<WebElement> ourShirtsThisSeasonProductList;
	
	@FindBy(xpath = "(//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement ourShirtsThisSeasonProduct1Title;
	
	@FindBy(xpath = "(//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/div/dl[2]/dd[2]/span")
	private WebElement ourShirtsThisSeasonProduct1Price;
	
	@FindBy(xpath = "(//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span/../../form/div/input")
	private WebElement ourShirtsThisSeasonProduct1AddToCart;
	
	@FindBy(xpath = "(//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/div/div/div)[3]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement ourShirtsThisSeasonProduct2Title;
	
	@FindBy(xpath = "//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/button[@aria-label='Next']")
	private WebElement ourShirtsThisSeasonFlickityNext;
	
	@FindBy(xpath = "//h2[.='OUR SHIRTS THIS SEASON']/../../div[3]/button[@aria-label='Previous']")
	private WebElement ourShirtsThisSeasonFlickityPrevious;
	
	@FindBy(xpath = "//h2[.='OUR SHIRTS THIS SEASON']/../../div[@class='view_all_button']/a")
	private WebElement ourShirtsThisSeasonViewAllButton;
	
//	Our Signature Polos section locators 
	@FindBy(xpath = "//h2[.='OUR SIGNATURE POLOS']")
	private WebElement ourSignaturePolos;
	
	@FindBy(xpath = "//h2[.='OUR SIGNATURE POLOS']/../../div[3]/div/div/div")
	private List<WebElement> ourSignaturePolosProductList;
	
	@FindBy(xpath = "(//h2[.='OUR SIGNATURE POLOS']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement ourSignaturePolosProduct1Title;
	
	@FindBy(xpath = "(//h2[.='OUR SIGNATURE POLOS']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/div/dl[2]/dd[2]/span")
	private WebElement ourSignaturePolosProduct1Price;
	
	@FindBy(xpath = "(//h2[.='OUR SIGNATURE POLOS']/../../div[3]/div/div/div)[2]/marmeto-product-card/div[@class='product-info']/div/a/span/../../form/div/input")
	private WebElement ourSignaturePolosProduct1AddToCart;
	
	@FindBy(xpath = "(//h2[.='OUR SIGNATURE POLOS']/../../div[3]/div/div/div)[0]/marmeto-product-card/div[@class='product-info']/div/a/span")
	private WebElement ourSignaturePolosProduct2Title;
	
	@FindBy(xpath = "//h2[.='OUR SIGNATURE POLOS']/../../div[3]/button[@aria-label='Next']")
	private WebElement ourSignaturePolosFlickityNext;
	
	@FindBy(xpath = "//h2[.='OUR SIGNATURE POLOS']/../../div[3]/button[@aria-label='Previous']")
	private WebElement ourSignaturePolosFlickityPrevious;
	
	@FindBy(xpath = "//h2[.='OUR SIGNATURE POLOS']/../../div[@class='view_all_button']/a")
	private WebElement ourSignaturePolosViewAllButton;
	
//	Cart confirmation message
	@FindBy(xpath = "//div[contains(text(),'Item is successfully added to the cart!')]")
	private WebElement itemCartConfirmationMessage;
	
	@FindBy(xpath = "//div[@class='product-info-container']/a[@href='/cart']")
	private WebElement goToCartButton;
	
//	Homepage collections
	@FindBy(xpath = "//div[@class='textWithImage__column-image']/div/img")
	private List<WebElement> homepageCollections;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void closeInitialPopUp() throws Exception {
		if (initialPopUpCloseButton.size() != 0) {
			initialPopUpCloseButton.get(0).click();
//			Thread.sleep(2000);
		}
	}

	public void verifyHomePage() throws Exception {
		Assert.assertEquals(driver.getTitle(), "U. S. Polo Assn. India | USPA Official Site – U.S. Polo Assn. India");
//		Thread.sleep(2000);
	}

	public void verifyLogo() throws Exception {
		Assert.assertTrue(companyLogo.isDisplayed());
		Thread.sleep(2000);
	}

	public void verifyAnnouncementBar() throws Exception {
		Assert.assertTrue(announcementBar.isDisplayed());
		Thread.sleep(2000);
	}

	public void clickCompanyLogo() throws Exception {
		companyLogo.click();
//		Thread.sleep(2000);
	}

	public void clickAccountIcon() throws Exception {
		accountIcon.click();
		Thread.sleep(2000);
	}

	public void verifySearchField() throws Exception {
		Assert.assertTrue(searchInputField.isDisplayed());
		searchInputField.click();
		TakeImage.takeScreenshot(driver);
		Thread.sleep(2000);
	}

	public void clickOnSearchField() throws Exception {
		Assert.assertTrue(searchInputField.isDisplayed());
		searchInputField.click();
		Thread.sleep(2000);
	}

	public void clickFlickity() throws Exception {
		bannerFlickityForward.click();
	}

	public void clickBanner() throws Exception {
		banner.click();
	}
	
	public void clickBanner(String xpath) throws Exception {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void enterDataIntoSearchField(String str) throws Exception {
		searchInputField.sendKeys(str + Keys.ENTER);
		Thread.sleep(2000);
	}

	public void verifySearchResults(String str) throws Exception {
		if (str.equals("invalid")) {
			Assert.assertTrue(resultsText.getText().startsWith("Filter 0 results"));
		} 
		
		else {
			String text = resultsText.getText();
			String results = text.substring(7, text.indexOf("results") - 1);
			Assert.assertTrue(Integer.parseInt(results) != 0);
		}
		Thread.sleep(2000);
	}

	public void verifyWishlist() throws Exception {
		wishlistIcon.click();
		Thread.sleep(2000);

		TakeImage.takeScreenshot(driver);

		Assert.assertTrue(wishlistHeading.isDisplayed());
		wishlistCloseButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyRoyalty() throws Exception {
		royaltyIcon.click();
		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), "Capillary Generic Page – U.S. Polo Assn. India");
		TakeImage.takeScreenshot(driver);
	}

	public void clickCartIcon() throws Exception {
		cartIcon.click();
		Thread.sleep(2000);

		/*
		 * Assert.assertTrue(cartDrawerText.isDisplayed());
		 * Assert.assertTrue(emptyCartText.isDisplayed()); cartDrawerCloseIcon.click();
		 * Thread.sleep(2000);
		 */
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
	
	public void happyFlow() throws Exception {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
		productDetails = new LinkedHashMap<String, String>();
		
//		Faker faker = new Faker();
//		int num = faker.number().numberBetween(0, homePageProductList.size());
//		System.out.println(homePageProductList.size()+" "+num);
		WebElement product = homePageProducts.get(5);
		
		WebElement title = product.findElement(By.xpath("//span[@class='prod-title']"));
		WebElement price = product.findElement(By.xpath("//dl[@class='price__sale']/dd/span[@class='price-item price-item--sale']"));
		WebElement size = product.findElement(By.xpath("//ul[@class='option_sizes']/li[contains(@class, 'selected')]"));
		
		productDetails.put("title", title.getText());
		productDetails.put("price", price.getText());
		productDetails.put("size", size.getText());
		
		System.out.println(productDetails);
		
		WebElement productAddToCart = product.findElement(By.xpath("//input[@id='addToCart']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(productAddToCart));
		
		productAddToCart.click();
		Thread.sleep(1000);
		verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyAddedProductDetails1(productDetails);
//		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
	}
	
	public void clickWinterWearForTheSeasonViewAll() throws Exception {
		ScrollToElement.scrollToElementBy300(driver, winterWearForTheSeasonViewAllButton);
		winterWearForTheSeasonViewAllButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyWinterWearForTheSeason() throws Exception {
//		ScrollToElement.scrollToElement(driver, winterWearForTheSeason);
//		Thread.sleep(2000);
		int productCount = winterWearForTheSeasonProductList.size();
		
		Assert.assertNotEquals(productCount, 0, "No products displayed under Our Signature Polos");
		Assert.assertTrue(winterWearForTheSeasonFlickityPrevious.isDisplayed(),"No previous flickity displayed under Winter Wear For The Season");
		Assert.assertTrue(winterWearForTheSeasonFlickityNext.isDisplayed(),"No next flickity displayed under Winter Wear For The Season");
		
		ScrollToElement.scrollToElementBy700(driver, winterWearForTheSeasonViewAllButton);
		Thread.sleep(2000);
		
		productDetails = new LinkedHashMap<String, String>();
		String title = winterWearForTheSeasonProduct1Title.getText();
		String price = winterWearForTheSeasonProduct1Price.getText();
		
		productDetails.put("title", title);
		productDetails.put("price", price);
		
		winterWearForTheSeasonProduct1AddToCart.click();
		Thread.sleep(1000);
		verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy700(driver, winterWearForTheSeasonViewAllButton);
		Thread.sleep(2000);
		
		String homePageTitle = winterWearForTheSeasonProduct2Title.getText();
		winterWearForTheSeasonProduct2Title.click();
		Thread.sleep(2000);
		
		PDP pdp = new PDP(driver);
		pdp.verifyProductTitle(homePageTitle);
		productDetails = pdp.captureProductDetails();
//		pdp.clickCompanyLogo();
		pdp.clickAddToCartButton();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy300(driver, winterWearForTheSeason);
		Thread.sleep(2000);
		
		for(int i=1;i<=4;i++)
		{
			winterWearForTheSeasonFlickityNext.click();
			Thread.sleep(1000);
			TakeImage.takeScreenshot(driver);
		}
		
		winterWearForTheSeasonViewAllButton.click();
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getTitle(), "Winter Wear For The Season – U.S. Polo Assn. India");
		
		WinterWearForTheSeasonPage winterWearForTheSeasonPage = new WinterWearForTheSeasonPage(driver);
		winterWearForTheSeasonPage.verifyWinterWearForTheSeasonPage();
//		winterWearForTheSeasonPage.verifyTotalProductsCount(homePageCount);
		
		winterWearForTheSeasonPage.clickCompanyLogo();
		Thread.sleep(2000);
	}
	
	public void verifyOurShirtsThisSeason() throws Exception {
//		ScrollToElement.scrollToElement(driver, ourShirtsThisSeason);
//		Thread.sleep(2000);
		
		Assert.assertNotEquals(ourShirtsThisSeasonProductList.size(), 0, "No products displayed under Our Shirts This Season");
		Assert.assertTrue(ourShirtsThisSeasonFlickityPrevious.isDisplayed(),"No previous flickity displayed under Our Shirts This Season");
		Assert.assertTrue(ourShirtsThisSeasonFlickityNext.isDisplayed(),"No next flickity displayed under Our Shirts This Season");
		
		ScrollToElement.scrollToElementBy700(driver, ourShirtsThisSeasonViewAllButton);
		Thread.sleep(2000);
		
		productDetails = new LinkedHashMap<String, String>();
		String title = ourShirtsThisSeasonProduct1Title.getText();
		String price = ourShirtsThisSeasonProduct1Price.getText();
		
		productDetails.put("title", title);
		productDetails.put("price", price);
		
		ourShirtsThisSeasonProduct1AddToCart.click();
		Thread.sleep(1000);
		verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy700(driver, ourShirtsThisSeasonViewAllButton);
		Thread.sleep(2000);
		
		String homePageTitle = ourShirtsThisSeasonProduct2Title.getText();
		ourShirtsThisSeasonProduct2Title.click();
		Thread.sleep(2000);
		
		PDP pdp = new PDP(driver);
		pdp.verifyProductTitle(homePageTitle);
		productDetails = pdp.captureProductDetails();
//		pdp.clickCompanyLogo();
		pdp.clickAddToCartButton();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy300(driver, ourShirtsThisSeason);
		Thread.sleep(2000);
		
		for(int i=1;i<=4;i++)
		{
			ourShirtsThisSeasonFlickityNext.click();
			Thread.sleep(1000);
			TakeImage.takeScreenshot(driver);
		}
		
		ourShirtsThisSeasonFlickityPrevious.click();
		
		ourShirtsThisSeasonViewAllButton.click();
		Thread.sleep(2000);
		
		OurShirtsThisSeasonPage ourShirtsThisSeasonPage = new OurShirtsThisSeasonPage(driver);
		ourShirtsThisSeasonPage.verifyOurShirtsThisSeasonPage();
		ourShirtsThisSeasonPage.clickCompanyLogo();
		Thread.sleep(2000);
	}
	
	public void verifyOurSignaturePolos() throws Exception {
//		ScrollToElement.scrollToElement(driver, ourSignaturePolos);
//		Thread.sleep(2000);
		
		int productCount = ourSignaturePolosProductList.size();
		
		Assert.assertNotEquals(productCount, 0, "No products displayed under Our Signature Polos");
		Assert.assertTrue(ourSignaturePolosFlickityPrevious.isDisplayed(),"No previous flickity displayed under Our Signature Polos");
		Assert.assertTrue(ourSignaturePolosFlickityNext.isDisplayed(),"No next flickity displayed under Our Signature Polos");
		
		ScrollToElement.scrollToElementBy700(driver, ourSignaturePolosViewAllButton);
		Thread.sleep(2000);
		
		productDetails = new LinkedHashMap<String, String>();
		String title = ourSignaturePolosProduct1Title.getText();
		String price = ourSignaturePolosProduct1Price.getText();
		
		productDetails.put("title", title);
		productDetails.put("price", price);
		
		ourSignaturePolosProduct1AddToCart.click();
		Thread.sleep(1000);
		verifyItemAddedToCartSuccessMessage();
		
		Cart cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy700(driver, ourSignaturePolosViewAllButton);
		Thread.sleep(2000);
		
		String homePageTitle = ourSignaturePolosProduct2Title.getText();
		ourSignaturePolosProduct2Title.click();
		Thread.sleep(2000);
		
		PDP pdp = new PDP(driver);
		pdp.verifyProductTitle(homePageTitle);
		productDetails = pdp.captureProductDetails();
//		pdp.clickCompanyLogo();
		pdp.clickAddToCartButton();
		pdp.verifyItemAddedToCartSuccessMessage();
		
		cart = new Cart(driver);
		cart.verifyAddedProductDetails(productDetails);
		cart.clickProductRemoveIcon();
		cart.clickCompanyLogo();
		
		ScrollToElement.scrollToElementBy300(driver, ourSignaturePolos);
		Thread.sleep(2000);
		
		for(int i=1;i<=4;i++)
		{
			ourSignaturePolosFlickityNext.click();
			Thread.sleep(1000);
//			TakeImage.takeScreenshot(driver);
		}
		ourSignaturePolosFlickityPrevious.click();
		Thread.sleep(1000);
		
		ourSignaturePolosViewAllButton.click();
		Thread.sleep(2000);
		
		OurSignaturePolosPage ourSignaturePolosPage = new OurSignaturePolosPage(driver);
		ourSignaturePolosPage.verifyOurSignaturePolosPage();
		ourSignaturePolosPage.clickCompanyLogo();
		Thread.sleep(2000);
	}
	
	public void verifyBannerRedirection() throws Exception {
		String homePageURL = HandlingPropertyFile.getProperty("./Utilities/website.properties", "url");
		banner.click();
		TakeImage.takeScreenshot(driver);
		Assert.assertNotEquals(homePageURL, driver.getTitle());
		companyLogo.click();
	}

	public void verifyBannerRedirection2() throws Exception {
		File f = new File("./excel/Xpaths.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet("Banner");

		Iterator<Row> rowIterator = xssfSheet.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			double position = row.getCell(0).getNumericCellValue();
			String locator = row.getCell(1).getStringCellValue();
			String title = row.getCell(2).getStringCellValue();

			for (double i = 1; i <= position; i++) {
				clickFlickity();
			}
			
			clickBanner(locator);
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			SoftAssert sAssert = new SoftAssert();
			sAssert.assertEquals(driver.getTitle(), title);
			sAssert.assertAll();
			TakeImage.takeScreenshot(driver);
			clickCompanyLogo();
		}
		wb.close();
	}

	public void clickShopAllButton() throws Exception {
		/*
		 * ScrollToElement.scrollToElement(driver, shopAllButton); Thread.sleep(2000);
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.elementToBeClickable(shopAllButton));
		 * shopAllButton.click(); Thread.sleep(2000);
		 */

		driver.navigate().to("https://uspoloassn.in/collections/shop-all");
	}

	public void takeScreenShotsOfMegaMenuItems() throws Exception {
		Actions actions = new Actions(driver);

		actions.moveToElement(menuItems1).build().perform();
		Thread.sleep(2000);
		menuItems1.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems2).build().perform();
		Thread.sleep(2000);
		menuItems2.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems3).build().perform();
		Thread.sleep(2000);
		menuItems3.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems4).build().perform();
		Thread.sleep(2000);
		menuItems4.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems5).build().perform();
		Thread.sleep(2000);
		menuItems5.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems6).build().perform();
		Thread.sleep(2000);
		menuItems6.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		actions = new Actions(driver);
		actions.moveToElement(menuItems7).build().perform();
		Thread.sleep(2000);
		menuItems7.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		menuItems8.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);

		menuItems9.click();
		Thread.sleep(2000);
		TakeImage.takeScreenshot(driver);
		companyLogo.click();
		Thread.sleep(2000);
	}

	public void takeScreenShotsOfMenuItems() throws Exception {
		/*
		 Actions actions = new Actions(driver);
		 
		 for (WebElement item : newArrivalsDropdownItems) { Actions actions = new
		 Actions(driver); actions.moveToElement(menuItems1).build().perform();
		 Thread.sleep(2000);
		 
		 actions.moveToElement(item).click().build().perform(); Thread.sleep(2000);
		 TakeImage.takeScreenshot(driver); companyLogo.click(); Thread.sleep(2000);
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(item))
		 );
		 
		 }
		 */

		
		takeScreenShotsOfNewArrivalsMenu(); 
		takeScreenShotsOfCollectionsMenu();
		takeScreenShotsOfMenMenu(); 
		takeScreenShotsOfWomenMenu();
		takeScreenShotsOfFootwearMenu(); 
		takeScreenShotsOfInnerwearMenu();
		takeScreenShotsOfKidsMenu();

		
		 menuItems8.click(); 
		 Thread.sleep(2000); 
		 TakeImage.takeScreenshot(driver);
		 companyLogo.click(); 
		 Thread.sleep(2000);
		 
		 menuItems9.click(); 
		 Thread.sleep(2000); 
		 TakeImage.takeScreenshot(driver);
		 companyLogo.click(); 
		 Thread.sleep(2000); 
	}

	public void takeScreenShotsOfNewArrivalsMenu() throws Exception {
		excelFileHandling(menuItems1, "./excel/Xpaths.xlsx", "NewArrivals");
	}

	public void takeScreenShotsOfCollectionsMenu() throws Exception {
		excelFileHandling(menuItems2, "./excel/Xpaths.xlsx", "Collections");
	}

	public void takeScreenShotsOfMenMenu() throws Exception {
		excelFileHandling(menuItems3, "./excel/Xpaths.xlsx", "Men");
	}

	public void takeScreenShotsOfWomenMenu() throws Exception {
		excelFileHandling(menuItems4, "./excel/Xpaths.xlsx", "Women");
	}

	public void takeScreenShotsOfFootwearMenu() throws Exception {
		excelFileHandling(menuItems5, "./excel/Xpaths.xlsx", "Footwear");
	}

	public void takeScreenShotsOfInnerwearMenu() throws Exception {
		excelFileHandling(menuItems6, "./excel/Xpaths.xlsx", "Innerwear");
	}

	public void takeScreenShotsOfKidsMenu() throws Exception {
		excelFileHandling(menuItems7, "./excel/Xpaths.xlsx", "Kids", 0);
		excelFileHandling(menuItems7, "./excel/Xpaths.xlsx", "Kids", 1);
		excelFileHandling(menuItems7, "./excel/Xpaths.xlsx", "Kids", 2);
		excelFileHandling(menuItems7, menuItems71, "./excel/Xpaths.xlsx", "Kids", 3, 10);
		excelFileHandling(menuItems7, menuItems72, "./excel/Xpaths.xlsx", "Kids", 11, 12);
	}

	public void excelFileHandling(String file, String sheet) throws Exception {
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet(sheet);

		Iterator<Row> rowIterator = xssfSheet.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			String item = row.getCell(0).getStringCellValue();
			String title = row.getCell(1).getStringCellValue();

			clickAndVerifySubMenuItem(item, title);
			clickCompanyLogo();
		}
		wb.close();
	}

	public void excelFileHandling(WebElement mainMenu, String file, String sheet) throws Exception {
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet(sheet);

		Iterator<Row> rowIterator = xssfSheet.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			/*
			 * Iterator<Cell> cellIterator = row.cellIterator();
			 * 
			 * while (cellIterator.hasNext()) { Cell cell = cellIterator.next(); String item
			 * = cell.getStringCellValue(); Actions actions = new Actions(driver);
			 * actions.moveToElement(mainMenu).build().perform(); Thread.sleep(2000);
			 * 
			 * driver.findElement(By.xpath(item)).click(); Thread.sleep(2000); //
			 * System.out.println(driver.getTitle()); // TakeImage.takeScreenshot(driver);
			 * clickCompanyLogo(); }
			 */

//			/*
			String item = row.getCell(0).getStringCellValue();
			String title = row.getCell(1).getStringCellValue();

			mouseHoverOnMainMenuItem(mainMenu);
			clickAndVerifySubMenuItem(item, title);
			clickCompanyLogo();
//			*/
		}
		wb.close();
	}

	public void excelFileHandling(WebElement mainMenu, String file, String sheet, int rowNum) throws Exception {
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet(sheet);

		XSSFRow row = xssfSheet.getRow(rowNum);
		String item = row.getCell(0).getStringCellValue();
		String title = row.getCell(1).getStringCellValue();

		mouseHoverOnMainMenuItem(mainMenu);
		clickAndVerifySubMenuItem(item, title);
		clickCompanyLogo();

		wb.close();
	}

	public void excelFileHandling(WebElement mainMenu, WebElement subMenu, String file, String sheet, int rowStart,
			int rowEnd) throws Exception {
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet(sheet);

		for (int i = rowStart; i <= rowEnd; i++) {
			XSSFRow row = xssfSheet.getRow(i);
			String item = row.getCell(0).getStringCellValue();
			String title = row.getCell(1).getStringCellValue();

			mouseHoverOnMainMenuItem(mainMenu);
			mouseHoverOnMainMenuItem(subMenu);
			clickAndVerifySubMenuItem(item, title);
			clickCompanyLogo();
		}

		wb.close();
	}

	public void mouseHoverOnMainMenuItem(WebElement mainMenu) throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu).build().perform();
		Thread.sleep(2000);
	}

	public void clickAndVerifySubMenuItem(String xpath, String title) throws Exception {
		WebElement collection = driver.findElement(By.xpath(xpath));
		ScrollToElement.scrollToElementBy300(driver, collection);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(collection));
		collection.click();
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath(xpath)).click();
//		Thread.sleep(2000);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), title);
		softAssert.assertAll();

//		TakeImage.takeScreenshot(driver);
	}

	public void scrollToFooter() throws Exception {
		ScrollToElement.scrollToElement(driver, footer);
		Thread.sleep(2000);
	}

	public void verifyFooter() throws Exception {
		ScrollToElement.scrollToElement(driver, footer);

		for (WebElement section : footerSections) {
			Assert.assertTrue(section.isDisplayed());
		}

		excelFileHandling("./excel/Xpaths.xlsx", "Footer");
	}
	
	public void verifyHomepageCollections() throws Exception
	{
		excelFileHandling("./excel/Xpaths.xlsx", "HPCollections");
	}
}
