package com.blaze.agency.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.blaze.agency.demo.utils.BrowserUtils.BrowserType;



public class TestConfig {

	private static final String TEST_CONFIG_FILE = "testConfig.Properties";
	private static String testRoot, testConfigFile;
	private static String fileSeperator = File.separator;
	public static Properties properties = new Properties();
	
	
	public TestConfig() {
		
	}
	/**
	 * Function to read the property file data.
	 */
	static {

		try {
			testRoot = System.getProperty("testRoot");
			if(testRoot == null) {
				testRoot = System.getProperty("user.dir");
			}
			FileInputStream in = null;
			testConfigFile = System.getProperty("testConfigFile");
			if(testConfigFile == null) {
				in = new FileInputStream(testConfigFile = testRoot + fileSeperator + TEST_CONFIG_FILE);
			} else {
				in = new FileInputStream(testRoot + fileSeperator + testConfigFile) ;
			}

			properties.load(in);
			in.close();

		} catch(Exception e) {

			System.err.println("Failed to read the config file "+testConfigFile);
		}

	}

	/**
	 * Get browsertype value based on property file or console.
	 * @return
	 */
	public static BrowserType getBrowserType() {
		String browser = System.getProperty("browser");
		if(browser == null) 
			return BrowserUtils.getBrowserType(String.valueOf(properties.getProperty("browser")).trim());
		else 
			return BrowserUtils.getBrowserType(browser);

	}

	/**
	 * Get the project directory location
	 * @return
	 */
	public static String getTestRoot() {
		return testRoot;
	}

	/**
	 * Get the application Url from testConfig file.
	 * @return
	 */
	public static String getApplicationUrl() {
		String appUrl = "";
		try {
			appUrl = System.getProperty("application.url");

			if(appUrl == null)
			appUrl = String.valueOf(properties.getProperty("application.url").trim());
		} catch(Exception e) {
			System.err.println("Application Url is not found! ");
		}
		return appUrl;	
	}


}
