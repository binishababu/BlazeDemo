package com.blaze.agency.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.blaze.agency.demo.utils.TestConfig;
import com.blaze.agency.demo.utils.BrowserUtils;
import com.blaze.agency.demo.utils.BrowserUtils.BrowserType;

public class BaseWebDriver {

	public WebDriver driver;


	@BeforeClass(alwaysRun = true)
	public void setUp() {
		if(TestConfig.getBrowserType() == BrowserType.chrome) {
			BrowserUtils.setUpChromeDriver();
		}else if (TestConfig.getBrowserType() == BrowserType.firefox) {
			BrowserUtils.setUpFirefoxDriver();
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void testSetUp() {
		driver = WebDriverFactory.getWebDriver();
		driver.get(TestConfig.getApplicationUrl());
		System.out.println(TestConfig.getApplicationUrl());
		waitForPageLoad();
	}

	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}
	
	public static boolean verifytTextPresent(WebDriver driver, String value) {
		return driver.getPageSource().toLowerCase().contains(value.toLowerCase());
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
