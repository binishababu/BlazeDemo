package com.blaze.agency.demo.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.utils.TestConstants;
import com.blaze.agency.demo.utils.TestUtils;

public class BookFlightPage {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	
	public BookFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h2")
	WebElement txtHeader;
	
	@FindBy(how=How.CSS, using="input[type='submit']")
	WebElement purchaseBtn;
	
	@FindBy(how=How.ID, using="inputName")
	WebElement name;
	
	@FindBy(how=How.ID, using="address")
	WebElement address;
	
	@FindBy(how=How.ID, using="city")
	WebElement city;
	
	@FindBy(how=How.ID, using="state")
	WebElement state;
	
	@FindBy(how=How.ID, using="zipCode")
	WebElement zipCode;
	
	@FindBy(how=How.ID, using="cardType")
	WebElement cardType;
	
	@FindBy(how=How.ID, using="creditCardNumber")
	WebElement creditCardNumber;
	
	@FindBy(how=How.ID, using="creditCardMonth")
	WebElement creditCardMonth;
	
	@FindBy(how=How.ID, using="creditCardYear")
	WebElement creditCardYear;
	
	@FindBy(how=How.ID, using="nameOnCard")
	WebElement nameOnCard;
	
	@FindBy(how=How.CSS, using="body > div.container > p:nth-child(4)")
	WebElement priceInReservation;
	
	@FindBy(how=How.CSS, using="body > div.container > p:nth-child(2)")
	WebElement airlineAfterReserve;
	
	public void purchaseFlight() {
		
		try {
			
//			TestUtils.focusAndClick(14);
			purchaseBtn.click();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Description : Fill the form with valid details.
	 */
	public void fillFormWithValidDetails() {
		name.sendKeys(TestConstants.NAME);
		address.sendKeys(TestConstants.ADDRESS);
		city.sendKeys(TestConstants.CITY);
		state.sendKeys(TestConstants.STATE);
		zipCode.sendKeys(TestConstants.ZIPCODE);
//		Select select = new Select(cardType);
//		select.selectByValue(TestConstants.CARDTYPE);
		creditCardNumber.sendKeys(TestConstants.CARD_NUMBER);
		creditCardMonth.sendKeys(TestConstants.MONTH);
		name.sendKeys(TestConstants.YEAR);
		name.sendKeys(TestConstants.NAMEONCARD);
		name.sendKeys(TestConstants.NAME);
	}
	
	public String getPriceAtReservation() {
		String price = priceInReservation.getText().toString();
		return price;
		
	}
	
	public String getAirlineInReserve() {
		return airlineAfterReserve.getText().toString();
	}

}
