package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	// Objects
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassField;

	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement NewsletterField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueButton;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// Actions
	public void firstNameField(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void lastNamefield(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void emailField(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void telephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void passwordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void confirmPassField(String confirmPassText) {
		confirmPassField.sendKeys(confirmPassText);
	}
	public void NewsletterField() {
		NewsletterField.click();
	}
	public void privacyPolicyField() {
		privacyPolicyField.click();
	}
	public void ContinueButtn() {
		ContinueButton.click();
}}
