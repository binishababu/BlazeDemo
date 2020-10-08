package com.blaze.agency.demo.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.utils.TestConstants;
import com.blaze.agency.demo.utils.TestUtils;

public class ChooseFlightPage {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();


	public ChooseFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//h3")
	WebElement txtHeader;

	@FindBy(how=How.CSS, using="input[type='submit']")
	WebElement btnChooseFlight;

	@FindBy(how=How.XPATH, using="//table/tbody//tr[1]/td")
	List<WebElement> firstFlightDetails;

	@FindBy(how=How.XPATH, using="//table/thead//tr/th")
	List<WebElement> flightDetailsTable;

	@FindBy(how=How.CSS, using="//table/tbody/tr[1]/form[1]/td[2])")
	WebElement flightData;

	@FindBy(how=How.CSS, using="body > div.container > table > thead > tr > th:nth-child(4)")
	WebElement departFrom;

	@FindBy(how=How.CSS, using="body > div.container > table > thead > tr > th:nth-child(5)")
	WebElement arriveTo;

	@FindBy(how=How.CSS, using="body > div.container > table > tbody > tr:nth-child(1) > td:nth-child(7)")
	WebElement priceOfFlight;
	
	@FindBy(how=How.CSS, using="body > div.container > table > tbody > tr:nth-child(1) > td:nth-child(4)")
	WebElement airlineName;

	/**
	 * Verify Header of the Choose city page
	 * @param fromCity
	 * @param toCity
	 */
	public void verifyHeader(String fromCity, String toCity) {

		String expectedHeader = TestConstants.HEADER+fromCity+TestConstants.TO+toCity;
		try {
			String actualHeader = driver.findElement(By.tagName("h3")).getText().toString();   //txtHeader.getText().toString().trim();
			softAssert.assertEquals(expectedHeader, actualHeader);
		}catch(Exception e) {
			System.err.println("Could not find the Header Name");
		}
	}

	/**
	 * Choose a flight for booking.
	 * @throws InterruptedException 
	 */
	public void chooseAFlight() throws InterruptedException {
		//		Thread.sleep(3000);
		System.out.println(flightData.getText());
		try {
			//			TestUtils.focusAndClick(3);
			btnChooseFlight.click();
		}catch(Exception e) {
			System.err.println("Cloud not able to click the 'Choose This Flight' button");
			e.printStackTrace();
		}

	}


	public Map<String, String> getFlightDetails() {
		Map<String, String> flightDetails = new HashMap<String, String>();

		Queue<String> q1 = new LinkedList<String>(); 
		Queue<String> q2 = new LinkedList<String>(); 

		for(WebElement header : flightDetailsTable)  {
			q1.add(header.getText().toString().trim());
		}
		for(WebElement detail : firstFlightDetails) {
			q2.add(detail.getText().toString().trim());
		}

		//		System.out.println("Header size "+list.size());
		softAssert.assertTrue(q1.containsAll(q2));
		//		for(int i = 0; i<firstFlightDetails.size(); i++) {
		//			flightDetails.put(q1.get(i), firstFlightDetails.get(i).getText().toString().trim());
		//			
		//		}
		System.out.println("Flight Headers "+q1);
		System.out.println("Flight Headers "+q2);
		return flightDetails;
	}

	/**
	 * Verify depart from city
	 * @param place
	 */
	public void verifyDepartPlace(String place) {
		String actualValue = departFrom.getText().toString();
		System.out.println("Depart from "+actualValue);
		softAssert.assertEquals(actualValue, place);
		
	}

	/**
	 * Verify arrive to city
	 * @param place
	 */
	public void verifyArriveToPlace(String place) {
		String actualValue = arriveTo.getText().toString();
		System.out.println("Depart from "+actualValue);
		softAssert.assertEquals(actualValue, place);
	}

	/**
	 * Get Price of flight.
	 * @param n
	 * @return
	 */
	public String getPriceOfFlight(int n) {

		String price = priceOfFlight.getText().toString();
		System.out.println("Price "+price);
		return price;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAirlineBeforeReserving() {
		String airline = "";
		try {
			airline = airlineName.getText().toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return airline;
		
	}
	

}
