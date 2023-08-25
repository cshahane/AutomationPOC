package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// Objects
	@FindBy(id ="input-email")
	private WebElement emailAddressField;

	@FindBy(id ="input-password")
	private WebElement passwordField;

	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void Email(String emailText) {
		emailAddressField.sendKeys(emailText);
	}

	public void password(String PassText) {
		passwordField.sendKeys(PassText);
	}

	public void LoginButton() {
		loginButton.click();
	}
	
	public String retrieveEmailPasswordNotMatchingWarning() {
		String warningText= emailPasswordNotMatchingWarning.getText();
		return warningText;
	}
}
