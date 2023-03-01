package com.qa.facebook.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.facebook.automation.factory.DriverFactory;
import com.qa.facebook.automation.utils.ElementActions;

public class LoginPageWithoutUsingPageFactory extends DriverFactory{
	
	ElementActions elementActions;
	//1. Define locators: Page Objects but without using PageFactory
	
	By emailId = By.id("email");
	By passwordTextBox = By.name("pass");
	By loginButton = By.name("login");
	By forgottenPwdLink = By.linkText("Forgotten password?");
	
	//2]Constructor
	public LoginPageWithoutUsingPageFactory(WebDriver driver)
	{
		this.driver=driver;
		elementActions = new ElementActions(driver);
	}
	
	//3]PageAction/ Member function
	
	public String getLoginPageTitle() {
		return elementActions.getPageTitle();		
	}
	
	
	public void doLogin(String userName, String pwd) {
		elementActions.unconditionalWait(6);
		elementActions.elementSendKeys(emailId, userName);
		elementActions.unconditionalWait(2);
		elementActions.elementSendKeys(passwordTextBox, pwd);
		elementActions.unconditionalWait(2);
		elementActions.elementClick(loginButton);
	}
	
	

}
