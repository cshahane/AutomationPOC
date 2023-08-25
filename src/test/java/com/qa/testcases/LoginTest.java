package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.pageObjects.*;
import com.qa.base.Base;
import com.qa.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;
	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		loginPage.Email(email);
		loginPage.password(password);
		loginPage.LoginButton();
		// AccountPage accountPage = new AccountPage(driver);
		// Assert.assertTrue(accountPage.EditYourAccountInformation(),"");

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.Email(Utilities.generateEmailWithTimeStamp());
		loginPage.password(dataProp.getProperty("invalidPassword"));
		loginPage.LoginButton();

		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		loginPage.Email(Utilities.generateEmailWithTimeStamp());
		loginPage.password(prop.getProperty("validPassword"));
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not displayed");
		driver.quit();
	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		loginPage.Email(prop.getProperty("validEmail"));
		loginPage.password(dataProp.getProperty("invalidPassword"));
		loginPage.LoginButton();
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvingCredentials() {
		loginPage.LoginButton();
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarning();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),
				"Expected warning message is not displayed");

	}

}
