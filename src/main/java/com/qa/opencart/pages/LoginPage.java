package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementsUtility;

public class LoginPage {
	
	private By emailField = By.id(("input-email"));
	private By passwordField = By.id("input-password");
	private By forgotPasswordLink = By.linkText("Forgotten Password");
	private By signInBtn = By.cssSelector("input[type='submit']");
	private By registrationLink = By.linkText("Register");
	private By accountPageHeaders = By.xpath("//div/h2");
	
	private WebDriver driver;
	private ElementsUtility eleUtil;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtility(driver);
		
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailField).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordField).sendKeys(pwd);
	}
	
	public RegistrationPage selectRegistrationLink() {
		driver.findElement(registrationLink).click();
		return new RegistrationPage(driver);
	}

	public void clickOnLogin() {
		driver.findElement(signInBtn).click();
	}

	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailField).sendKeys(un);
		driver.findElement(passwordField).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		eleUtil.waitForTitleContains("My Account", 10);
		return new AccountsPage(driver);
	}


}
