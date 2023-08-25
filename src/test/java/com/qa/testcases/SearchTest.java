package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pageObjects.HomePage;

public class SearchTest extends Base {
	public SearchTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProducts() {
		HomePage homePage = new HomePage(driver);
		homePage.searchField(dataProp.getProperty("validProduct"));
		homePage.searchButton();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),
				"Valid product HP is not displayed in the search results");
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProducts() {
		HomePage homePage = new HomePage(driver);
		homePage.searchField(dataProp.getProperty("invalidProduct"));
		homePage.searchButton();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
				.getText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProducttestInSearchResults"),
				"No product message in search results is not displayed");

	}

	@Test(priority = 3)
	public void verifySearchWithoutAnyProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.searchButton();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p"))
				.getText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("NoProducttestInSearchResults"),
				"No product message in search results is not displayed");
	}
}
