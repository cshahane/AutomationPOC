package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropDown;

	@FindBy(linkText ="Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement HomePage;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}

	public LoginPage clickOnLogin() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage ClickOnRegister() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	public void searchField(String searchFieldText) {
		HomePage.sendKeys(searchFieldText);;
	}
	public void searchButton() {
		searchButton.click();
	}
}
