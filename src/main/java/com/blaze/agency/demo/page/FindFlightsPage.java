package com.blaze.agency.demo.page;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blaze.agency.demo.utils.TestConstants;
import com.blaze.agency.demo.utils.TestUtils;

public class FindFlightsPage {
	
	@FindBy(how=How.NAME, using="fromPort")
	WebElement chooseFromCity;
	
	@FindBy(how=How.NAME, using="toPort")
	WebElement chooseToCity;
	
	@FindBy(how=How.CSS, using="input[type='submit'")
	WebElement findFlight;
	
	
	WebDriver driver;
	
	
	public FindFlightsPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Get the list of from cities
	 * @return
	 */
	public List<String> getFromCityNames() {
		
		List<String> cityList = new ArrayList<String>();
		Select select = new Select(chooseFromCity);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options) {
			cityList.add(option.getText().toString());
		}
		return cityList;
	}
	
	public List<String> getToCityNames() {
		List<String> cityList = new ArrayList<String>();
		Select select = new Select(chooseToCity);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options) {
			cityList.add(option.getText().toString());
		}
		return cityList;
		
	}
	
	public List<String> getCityNames(String type) {
		
		List<String> cityList = new ArrayList<String>();
		List<WebElement> options = driver.findElements(By.xpath("//form/select[name="+type+"Port"));
		
		for(WebElement option : options) {
			cityList.add(option.getText().toString());
		}
		return cityList;
		
	}
	
	public void chooseFromCity() {
		Select select = new Select(chooseFromCity);
		try {
		select.selectByVisibleText(TestConstants.FROM_CITY);
		} catch(Exception e) {
			System.err.println("Could not find the city "+chooseFromCity);
		}
	}
	
	
	
	public void chooseToCity() {
		Select select = new Select(chooseToCity);
		try {
		select.selectByVisibleText(TestConstants.TO_CITY);
		} catch(Exception e) {
			System.err.println("Could not find the city "+chooseFromCity);
		}
	}
	

	public void clickOnFinishButton() {
		try {
//			TestUtils.focusAndClick();
			findFlight.click();
		} catch(Exception e) {
			System.err.println("Could not click on the Finish button.");
			
		}
		
	}
	
	public void searchForFLight() {
		chooseFromCity();
		chooseToCity();
//		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		clickOnFinishButton();
	}
}
