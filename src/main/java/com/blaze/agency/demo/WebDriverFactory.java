package com.blaze.agency.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.blaze.agency.demo.utils.BrowserUtils.BrowserType;

import com.blaze.agency.demo.utils.TestConfig;

public class WebDriverFactory {

	public static WebDriver driver ;

	public static WebDriver getWebDriver() {


		if(driver == null) {
			if(TestConfig.getBrowserType() == BrowserType.chrome) {
				
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_settings.state.flash",1);
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("start-maximized");
				options.addArguments("--disable-notifications");
				options.addArguments("--whitelisted-ips");
				options.setExperimentalOption("excludeSwitches",
					Arrays.asList("disable-popup-blocking"));
				//options.addArguments("--ignore-certificate-errors-spki-list");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);														
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			}

			//Set up firefox , Safari, iexplorer
			else if(TestConfig.getBrowserType() == BrowserType.firefox) {

				// webdriver.firefox.bin
				FirefoxProfile firefoxProfile = new FirefoxProfile();
//				firefoxProfile.setEnableNativeEvents(false);
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				} else if(TestConfig.getBrowserType() == BrowserType.iexplorer) {

				}

			}
			System.out.println("Returning Driver");
			return driver;
		}



	}
