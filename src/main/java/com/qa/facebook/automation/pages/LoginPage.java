package com.qa.facebook.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.facebook.automation.factory.DriverFactory;
import com.qa.facebook.automation.utils.ElementActions;
import com.qa.facebook.automation.utils.TimeUtil;

public class LoginPage extends DriverFactory{

	WebDriver driver;
	ElementActions elementActions;
	//1]PageObject/Locators
	
	@FindBy(id="email")
	WebElement emailTextBox;
	
	@FindBy(id="pass")
	WebElement pwdTextBox;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	//2]Single Argumnet COnstructor
	public LoginPage(WebDriver driver){
		this.driver=driver;
		elementActions = new ElementActions(driver);
	}
	
	//3]Member Function / Page Actions
	
	public String verifyTitleOfLogin() {
	 return driver.getTitle();		
	}
	
	public boolean verifyLoginBtn()
	{
		return loginBtn.isDisplayed();	
	}
	
	public void doLogin(String userName,String password) throws Exception {
		TimeUtil.shortWait();
		emailTextBox.sendKeys(userName);
		TimeUtil.shortWait();
		pwdTextBox.sendKeys(password);
		TimeUtil.shortWait();
		loginBtn.click();		
		TimeUtil.shortWait();
	}
	
}
