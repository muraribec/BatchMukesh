package com.qa.facebook.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * This method is used to load the properties from config.properties files
	 * @return it returns the properties prop object
	 */
	
	public Properties init_prop() {		
		 
		prop = new Properties();
		
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	return prop;	
		
	}
	
	
	
	
}
