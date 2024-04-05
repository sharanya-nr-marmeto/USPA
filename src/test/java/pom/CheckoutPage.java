package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class CheckoutPage {
	WebDriver driver;

	@FindBy(name = "checkout")
	private WebElement checkout;
	
	@FindBy(id = "checkout_shipping_address_id")
	private WebElement addressSelectDropdown;
	
	@FindBy(id = "checkout_shipping_address_first_name")
	private WebElement addressFirstName;
	
	@FindBy(id = "checkout_shipping_address_last_name")
	private WebElement addressLastName;
	
	@FindBy(id = "checkout_shipping_address_address1")
	private WebElement addressLine1;
	
	@FindBy(id = "checkout_shipping_address_address2")
	private WebElement addressLine2;
	
	@FindBy(id = "checkout_shipping_address_city")
	private WebElement addressCity;
	
	@FindBy(id = "checkout_shipping_address_province")
	private WebElement addressStateDropdown;
	
	@FindBy(id = "checkout_shipping_address_zip")
	private WebElement addressZip;
	
	@FindBy(id = "checkout_shipping_address_phone")
	private WebElement addressPhone;
	
	@FindBy(id = "continue_button")
	private WebElement continueButton;

	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void verifyCheckoutPage() throws Exception
	{
		Assert.assertEquals(driver.getTitle(), "Information - U.S. Polo Assn. India - Checkout");
		Thread.sleep(2000);
	}
	
	public void clickAddressSelectDropdown() throws Exception
	{
		Select addressDropdown = new Select(addressSelectDropdown);
		addressSelectDropdown.click();
		Thread.sleep(2000);
		addressDropdown.selectByVisibleText("Use a new address");
	}
	
	public void fillAddressDetails() throws Exception
	{
		Faker faker = new Faker();
		addressFirstName.sendKeys(faker.name().firstName());
		Thread.sleep(1000);
		addressLastName.sendKeys(faker.name().lastName());
		Thread.sleep(1000);
		addressLine1.sendKeys(faker.address().streetName());
		Thread.sleep(1000);
		addressLine2.sendKeys(faker.address().buildingNumber());
		Thread.sleep(1000);
		addressCity.sendKeys("Bengaluru");
		Thread.sleep(1000);
		
		Select stateDropdown = new Select(addressStateDropdown);
		addressStateDropdown.click();
		Thread.sleep(1000);
		stateDropdown.selectByVisibleText("Karnataka");
		Thread.sleep(1000);
		
		addressZip.sendKeys("560102");
		Thread.sleep(1000);
		
		addressPhone.sendKeys("99999 99999");
		Thread.sleep(1000);
		
	}
	
	public void clickContinueButton() throws Exception
	{
		continueButton.click();
		Thread.sleep(2000);
	}
}
