package com.qa.facebook.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	DesiredCapabilities chromeCapabilities = null;
	
	public static ThreadLocal tlDriver = new ThreadLocal(); 
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis 
	 * of given browser	
	 * @param browser
	 * @return this will return tlDriver
	 */
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser value is: "+browser);		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();  
			tlDriver .set(new ChromeDriver());
			
		}else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().driverVersion("110.0").setup();
			tlDriver.set(new FirefoxDriver());		
			
		}else if (browser.equals("safari")) {
			//	tlDriver.set(new SafariDriver());
		}else {
			System.out.println("Please pass the correct browser value: "+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return (WebDriver) tlDriver.get();
	}
	
	

}
