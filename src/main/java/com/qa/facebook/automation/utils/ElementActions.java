package com.qa.facebook.automation.utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.facebook.automation.factory.DriverFactory;

import dev.failsafe.internal.util.Assert;

public class ElementActions extends DriverFactory{
	
	public ElementActions(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getElement(By locator) {
		WebElement element =null;
		try {
		element = driver.findElement(locator);
		}catch (Exception e) {
			System.out.println("Some exception occur while creating the webelement"+locator);;
		}
		return element;
	}
	
	
	public void elementClick(By locator) {
		getElement(locator).click();
	}
	
	public void elementSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public String getPageTitle() {
		String title = null;
		try {
		title = driver.getTitle();
		}catch (Exception e) {
			System.out.println("SOme exception occur while getting the title::"+title);
			e.printStackTrace();
		}
		return title;
	}
	
	public void implicitwait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void fluentWait(int sec) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(sec)).ignoring(NoSuchElementException.class);
	}
	
	public String getNormalized(String stdTextStr) {
		String normalizedText = stdTextStr.replaceAll("[-,;|!\\s]", "").toLowerCase();
		return normalizedText;
	}
	
	public void unconditionalWait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getText(By locator) {
		String text = null;
		try {
		text = driver.findElement(locator).getText();
		}catch (WebDriverException we) {
			we.printStackTrace();
		}
		return text;
	}
	
	public void scrollToElementBy(By locator) {		
		try {
		WebElement ele = getElement(locator);		
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)driver);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", ele);
		}catch (Exception e) {
        System.out.println("SCrollIntoView:: Web-elemnt doesnt exit with the path"+locator);
		}
	}
	
	public String getAlertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	
	public void elementClickByAction(By locator) {
		WebElement element  = getElement(locator);		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	public void moveToElementUsingAction(By locator) {
		WebElement element  = getElement(locator);		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public boolean elementEnabled(By locator) {
		WebElement element = getElement(locator);
		
		if(element.isEnabled())
			return true;
		else
			return false;		
	}

}
