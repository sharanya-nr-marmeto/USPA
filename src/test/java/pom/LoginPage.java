package pom;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genericScripts.HandlingPropertyFile;
import genericScripts.ScrollToElement;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(css = "div[id='logo'] a img")
	private WebElement companyLogo;
	
	@FindBy(xpath = "//h3[.='Login with OTP']")
	private WebElement loginHeaderText;
	
	@FindBy(xpath = "//h3[.='Enter Account Details']")
	private WebElement enterAccountDetailsHeader;
	
	@FindBy(xpath = "//h6[.='Please enter correct OTP']")
	private List<WebElement> incorrectOTPErrorMessage;
	
	@FindBy(xpath = "//div[@class='other-options-box']/div/div/p[.='Email']")
	private WebElement email;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(css = "div.selected-country")
	private WebElement countrySelectDropDown;
	
	@FindBy(css = "ul[class='country-selector-list active'] li")
	private WebElement countrySelectDropDownIndiaOption;
	
	@FindBy(css = "div[class='toast-card error'] div[class='toast-card-content'] h6")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//button[@class='send-btn otp-btn']")
	private WebElement requestOTP;
	
	@FindBy(xpath = "//div[@class='verify-content']/input")
	private WebElement emailOTP;
	
	@FindBy(xpath = "//button[@class='verify-btn otp-btn']")
	private WebElement verifyOTP;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void verifyLoginPage() throws Exception
	{
		Assert.assertEquals(driver.getTitle(), "Account – U.S. Polo Assn. India");
		Thread.sleep(2000);
	}
	
	public void verifyCreateAccountPage() throws Exception
	{
		Assert.assertTrue(enterAccountDetailsHeader.isDisplayed());
		Thread.sleep(2000);
	}
	
	public void clickCompanyLogo() throws Exception
	{
		companyLogo.click();
		Thread.sleep(2000);
	}
	
	public void clickEmail() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(email));
		ScrollToElement.scrollToElement(driver, loginHeaderText);
		email.click();
		Thread.sleep(2000);
	}

	
	public void enterEmailInTextField() throws Exception
	{
		String emailData = HandlingPropertyFile.getProperty("./Utilities/website.properties", "email");
		ScrollToElement.scrollToElement(driver, emailTextField);
		emailTextField.sendKeys(emailData);
		Thread.sleep(2000);
	}
	
	public void enterEmailInTextField(String emailData) throws Exception
	{
		ScrollToElement.scrollToElement(driver, emailTextField);
		emailTextField.sendKeys(emailData);
		Thread.sleep(2000);
	}
	
	public void verifyCountryDropDown() throws Exception
	{
		Assert.assertTrue(countrySelectDropDown.isDisplayed());
		countrySelectDropDown.click();
		
		Assert.assertTrue(countrySelectDropDownIndiaOption.isDisplayed());
	}
	
	public void enterPhoneNumberInTextField(String phoneData) throws Exception
	{
		ScrollToElement.scrollToElement(driver, phoneTextField);
		phoneTextField.sendKeys(phoneData);
		Thread.sleep(2000);
	}
	
	public void clickRequestOTPButton() throws Exception
	{
		requestOTP.click();
		Thread.sleep(2000);
	}
	
	public void verifyInvalidEmailErrorMessage() throws Exception
	{
		Assert.assertTrue(emailErrorMessage.isDisplayed());
		Assert.assertTrue(emailErrorMessage.getText().equals("Please enter valid email id"));
		Thread.sleep(2000);
	}
	
	public void verifyInvalidPhoneErrorMessage() throws Exception
	{
		Assert.assertTrue(emailErrorMessage.isDisplayed());
		Assert.assertTrue(emailErrorMessage.getText().equals("Please enter valid mobile number"));
		Thread.sleep(2000);
	}
	
	public void enterOTP()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter OTP:");
		String otp = scan.next();
		scan.close();
		emailOTP.sendKeys(otp);
	}
	
	public void verifyIncorrectOTP() throws Exception
	{
		Assert.assertEquals(incorrectOTPErrorMessage.size(), 0);
	}
	
	public void clickVerifyOTPButton() throws Exception
	{
		requestOTP.click();
		Thread.sleep(2000);
	}
}
