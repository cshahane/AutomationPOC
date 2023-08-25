package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pageObjects.HomePage;
import com.qa.pageObjects.RegisterPage;
import com.qa.utils.Utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerPage;
	public RegisterTest() {
		super();
	}
	
	
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
	    driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	    HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		 registerPage = homePage.ClickOnRegister();
	
	}


	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		registerPage.firstNameField(dataProp.getProperty("firstName"));
		registerPage.lastNamefield(dataProp.getProperty("lastName"));
		registerPage.emailField(Utilities.generateEmailWithTimeStamp());
		registerPage.telephoneField(dataProp.getProperty("telephone"));
	    registerPage.passwordField(prop.getProperty("validPassword"));
		registerPage.confirmPassField(prop.getProperty("validPassword"));
		registerPage.privacyPolicyField();
		registerPage.ContinueButtn();
		

		//String ActualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		//Assert.assertEquals(ActualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account page is not displayed");
		
	}

	@Test(priority = 2)
	public void verifyRegisteringAnAccountByProvidingAllFields() {
		
		
		registerPage.firstNameField(dataProp.getProperty("firstName"));
		registerPage.lastNamefield(dataProp.getProperty("lastName"));
		registerPage.emailField(Utilities.generateEmailWithTimeStamp());
		registerPage.telephoneField(dataProp.getProperty("telephone"));
	    registerPage.passwordField(prop.getProperty("validPassword"));
		registerPage.confirmPassField(prop.getProperty("validPassword"));
		registerPage.NewsletterField();
		registerPage.privacyPolicyField();
		registerPage.ContinueButtn();
		// String
		// ActualSuccessHeading=driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		// Assert.assertEquals(ActualSuccessHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account page is not displayed");
		
	}

	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		
		
		registerPage.firstNameField(dataProp.getProperty("firstName"));
		registerPage.lastNamefield(dataProp.getProperty("lastName"));
		registerPage.emailField(prop.getProperty("validEmail"));
	    registerPage.telephoneField(dataProp.getProperty("telephone"));
	    registerPage.passwordField(prop.getProperty("validPassword"));
		registerPage.confirmPassField(prop.getProperty("validPassword"));
		registerPage.NewsletterField();
		registerPage.privacyPolicyField();
		registerPage.ContinueButtn();

		// String
		// actualWarning=driver.findElement(By.xpath("//div[@contains(@class,'alert-dismissible']")).getText();
		// Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning"));
	
	}

	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
		
		registerPage.ContinueButtn();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}