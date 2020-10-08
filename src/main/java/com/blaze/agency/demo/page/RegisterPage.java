package com.blaze.agency.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.blaze.agency.demo.utils.TestConstants;

public class RegisterPage {
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="name")
	WebElement name;
	
	@FindBy(how=How.ID, using="company")
	WebElement company;
	
	@FindBy(how=How.ID, using="email")
	WebElement email;
	
	@FindBy(how=How.ID, using="password")
	WebElement password;
	
	@FindBy(how=How.ID, using="password-confirm")
	WebElement confirmPwd;
	
	@FindBy(how=How.CSS, using=".btn-primary")
	WebElement register;
	
	@FindBy(how=How.XPATH, using="//a[@href='https://blazedemo.com/register']")
	WebElement registerLink;
	
	
	public void register() {
		
		name.sendKeys(TestConstants.NAME);
		email.sendKeys(TestConstants.EMAIL);
		company.sendKeys(TestConstants.COMPANY);
		password.sendKeys(TestConstants.PASSWORD);
		confirmPwd.sendKeys(TestConstants.PASSWORD);
		register.click();
	}
	
}
