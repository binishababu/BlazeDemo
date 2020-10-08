package com.blaze.agency.demo.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.BaseWebDriver;
import com.blaze.agency.demo.page.BookFlightPage;
import com.blaze.agency.demo.page.ChooseFlightPage;
import com.blaze.agency.demo.page.FindFlightsPage;
import com.blaze.agency.demo.utils.TestConstants;

public class FindFlightTests extends BaseWebDriver{
	
	FindFlightsPage findFlight = PageFactory.initElements(driver, FindFlightsPage.class);
	/**
	 * Verify search functionality.
	 */
	@Test(enabled=true)
	public void testSearchFlight() {
		
		System.out.println("Title is "+driver.getTitle().toString());
		findFlight.searchForFLight();
		ChooseFlightPage chooseFlight = PageFactory.initElements(driver, ChooseFlightPage.class);
		chooseFlight.verifyHeader(TestConstants.FROM_CITY, TestConstants.TO_CITY);
	}
	
	
	//Verify destination of the week
	
	

}
