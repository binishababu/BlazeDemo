package com.blaze.agency.demo.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.BaseWebDriver;
import com.blaze.agency.demo.page.LoginPage;

public class LoginPageTests extends BaseWebDriver {
	
	LoginPage loginPage = new LoginPage(driver);
	SoftAssert softAssert = new SoftAssert();
	/**
	 * Verify on Registration of the application.
	 * @throws Exception 
	 */
	@Test(enabled=true)
    public void verifyRegistration() throws Exception {
		Thread.sleep(3000);
		loginPage.navigateToHome();
		loginPage.navigateToRegistration();
		
		
	}
	
	/**
	 * Verify on Login to the application.
	 */
	@Test(enabled=false)
    public void verifyLoginToApplication() {
		
	}
	
	//Verify login with valid credentials
	//Verify navigation to Register
	//Verify Forgot password flow.

}
