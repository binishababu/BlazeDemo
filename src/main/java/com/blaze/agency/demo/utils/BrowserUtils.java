package com.blaze.agency.demo.utils;

import java.io.File;

import com.blaze.agency.demo.utils.OSTypeUtil.OSType;
/**
 * 
 * @author Binisha Babu.
 *
 */
public class BrowserUtils {

	public enum BrowserType{
		firefox, chrome, safari, iexplorer,
	}

	/**
	 * Get method for getting the browser name of enum BrowserType
	 * @param browserType
	 * @return
	 */
	public static BrowserType getBrowserType(String browser){

		if (browser == null)
			return BrowserType.chrome;
		if (browser.equalsIgnoreCase("*iexplore"))
			return BrowserType.iexplorer;
		else if (browser.equalsIgnoreCase("*firefox"))
			return BrowserType.firefox;
		else if (browser.equalsIgnoreCase("*safari"))
			return BrowserType.safari;
		else if (browser.equalsIgnoreCase("*chrome"))
			return BrowserType.chrome;

		else 
			return BrowserType.chrome; 

	}


	public static void setUpChromeDriver() {

		String chromeProp = "webdrver.chrome.driver";
		File targetChromedriver = null;
		try {
			/*		if(getTestClientOSType() == OSType.windows) {
			targetChromedriver = new File(TestConfig.getTestRoot() + File.separator + "target"
					+ File.separator + "drivers" + File.separator + "chrome" + File.separator
					+ "chromedriver.exe");
		} else if (getTestClientOSType() == OSType.mac) {
			targetChromedriver = new File(TestConfig.getTestRoot() + File.separator + "target"
					+ File.separator + "drivers" + File.separator + "chrome" + File.separator
					+ "chromedriver");
		} */

			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromedriver.exe");
		}catch(Exception e) {
			System.err.println("Could not find the Chrome Driver file.");
		}

	}
	
	public static void setUpFirefoxDriver() {

		String ffPath = "webdriver.gecko.driver";
		File targetChromedriver = null;
		try {

			String path = System.getProperty("user.dir");
			System.out.println(path); 
			System.setProperty(ffPath,path+"\\resources\\geckodriver.exe");
		}catch(Exception e) {
			System.err.println("Could not find the Chrome Driver file.");
		}

	}



	public static OSType getTestClientOSType() {
		String osType = System.getProperty("os.name");
		return OSTypeUtil.getTestOSType(osType);
	}

}
