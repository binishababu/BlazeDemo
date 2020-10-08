package com.blaze.agency.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.BaseWebDriver;
import com.blaze.agency.demo.page.BookFlightPage;
import com.blaze.agency.demo.page.ChooseFlightPage;
import com.blaze.agency.demo.page.ConfirmationPage;
import com.blaze.agency.demo.page.FindFlightsPage;
import com.blaze.agency.demo.utils.TestConstants;
import com.blaze.agency.demo.utils.TestUtils;

public class BookFlightTests extends BaseWebDriver{
	
	SoftAssert softAssert = new SoftAssert();
	BookFlightPage bp = PageFactory.initElements(driver, BookFlightPage.class);
	
	/**
	 * Verify successful booking with valid details.
	 * @throws InterruptedException 
	 */
	@Test(enabled=true)
    public void verifyBookFlightWithValidData() throws InterruptedException {
		
		FindFlightsPage fp = new FindFlightsPage(driver);
		verifytTextPresent(driver, "Find Flights");
		
		System.out.println("Search for the flight.");
		fp.searchForFLight();
		
		System.out.println("verify Header in Choose flight page");
		ChooseFlightPage chooseFlight = new ChooseFlightPage(driver);
		chooseFlight.verifyHeader(TestConstants.FROM_CITY, TestConstants.TO_CITY);
		
		System.out.println("Select a flight");
		chooseFlight.chooseAFlight();
		BookFlightPage bookFlight = new BookFlightPage(driver);
		bookFlight.fillFormWithValidDetails();
		bookFlight.purchaseFlight();
				
		ConfirmationPage confirmPage = new ConfirmationPage(driver);
		System.out.println("Verify the confirmation Id.");
		softAssert.assertFalse(confirmPage.getConfirmationId().isEmpty());
	}
	
	
	/**
	 * Verify whether user is not able to search for a flight without providing user details
	 * @throws InterruptedException 
	 */
	@Test(enabled=true)
	public void verifyBookFlightWithoutData() throws InterruptedException  {
		
		FindFlightsPage fp = new FindFlightsPage(driver);
		verifytTextPresent(driver, "Find Flights");
		
		System.out.println("Search for the flight.");
		fp.searchForFLight();
		
		System.out.println("verify Header in Choose flight page");
		ChooseFlightPage chooseFlight = new ChooseFlightPage(driver);
		chooseFlight.verifyHeader(TestConstants.FROM_CITY, TestConstants.TO_CITY);
		
		System.out.println("Select a flight");
		chooseFlight.chooseAFlight();
		
		System.out.println("Purchase Flight without adding any value");
		bp.purchaseFlight();
		
		ConfirmationPage cp = PageFactory.initElements(driver, ConfirmationPage.class);
		softAssert.assertEquals(false, driver.getPageSource().contains("id"));
	}
	
	
	
	
	/**
	 * Verify correct price and correct flight details got booked
	 * @throws InterruptedException 
	 */
	@Test(enabled=true)
    public void verifyPriceAndFlightDetails() throws InterruptedException {
		
		FindFlightsPage fp = new FindFlightsPage(driver);
		verifytTextPresent(driver, "Find Flights");
		
		System.out.println("Search for the flight.");
		fp.searchForFLight();
		
		System.out.println("verify Header in Choose flight page");
		ChooseFlightPage chooseFlight = new ChooseFlightPage(driver);
		chooseFlight.verifyHeader(TestConstants.FROM_CITY, TestConstants.TO_CITY);
		
		System.out.println("Verify DepartFrom place and ArriveTo place while choosing flight.");
		chooseFlight.verifyDepartPlace(TestConstants.FROM_CITY);
		chooseFlight.verifyArriveToPlace(TestConstants.TO_CITY);
		String airLine = chooseFlight.getAirlineBeforeReserving();
		
		System.out.println("Select a flight");
		chooseFlight.chooseAFlight();
		
		String priceBeforeReserving =chooseFlight.getPriceOfFlight(1);
		BookFlightPage bookFlight = new BookFlightPage(driver);
		
		String priceAfterReserving = bookFlight.getPriceAtReservation();
		System.out.println("Verify Price before reserving and after reserving");
		softAssert.assertEquals(priceBeforeReserving, priceAfterReserving);
		
		System.out.println("Verify Airline before reserve and after reserving.");
		softAssert.assertEquals(bookFlight.getAirlineInReserve(), airLine);
		
		
	}
	
	
	
}
