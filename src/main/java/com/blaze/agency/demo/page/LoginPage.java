package com.blaze.agency.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="body > div.navbar.navbar-inverse > div > div > a:nth-child(3)")
	WebElement homeLink;
	
	@FindBy(how=How.XPATH, using="//a[@href='https://blazedemo.com/register']")
	WebElement registerLink;
	
	@FindBy(how=How.ID, using="email")
	WebElement emailId;
	
	@FindBy(how=How.ID, using="password")
	WebElement password;
	
	@FindBy(how=How.CSS, using="button[type='submit']")
	WebElement loginButton;
	
	
	public void navigateToHome() {
		try {
			homeLink.click();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void navigateToRegistration() {
		try {
			registerLink.click();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
