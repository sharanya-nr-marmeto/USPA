package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import genericScripts.ExcelDataHandling;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath = "//h1[.='Register']")
	private WebElement registerPageHeading;
	
	@FindBy(name = "customer[first_name]")
	private WebElement firstNameField;
	
	@FindBy(name = "customer[last_name]")
	private WebElement lastNameField;
	
	@FindBy(name = "customer[email]")
	private WebElement emailField;
	
	@FindBy(name = "customer[password]")
	private WebElement passwordField;
	
	@FindBy(xpath = "//button[.='Create my account']")
	private WebElement createAccountButton;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void verifyRegisterPage() throws Exception
	{
		Assert.assertTrue(registerPageHeading.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void fillForm() throws Exception
	{
		Faker faker = new Faker();
		
		firstNameField.sendKeys(faker.name().firstName());
		Thread.sleep(1500);
		lastNameField.sendKeys(faker.name().lastName());
		Thread.sleep(1500);
		String email = faker.internet().emailAddress();
		String password = faker.internet().password();
		emailField.sendKeys(email);
		Thread.sleep(1500);
		passwordField.sendKeys(password);
		Thread.sleep(1500);
		
		ExcelDataHandling.writeExcel(email, password);
	}
	
	public void clickcreateAccountButton() throws Exception
	{
		createAccountButton.click();
		Thread.sleep(1500);
	}
}
