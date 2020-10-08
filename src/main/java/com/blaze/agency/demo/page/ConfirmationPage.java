package com.blaze.agency.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.blaze.agency.demo.utils.TestConstants;
import com.blaze.agency.demo.utils.TestUtils;



/**
 * 
 * @author Binisha
 *
 */
public class ConfirmationPage {
	
		
		WebDriver driver;
		SoftAssert softAssert = new SoftAssert();
						
			public ConfirmationPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			@FindBy(how=How.XPATH, using="//h1")
			WebElement txtHeader;
			@CacheLookup
			
			@FindBy(how=How.XPATH, using="/html/body/div[2]/div/table/tbody/tr[1]/td[2]")
			WebElement confirmationId;
			
						
			@FindBy(how=How.CSS, using="body > div.container > div > table > tbody > tr:nth-child(7) > td:nth-child(2)")
			WebElement dateTime;
			
			/**
			 * Get the confirmation ID
			 * @return
			 */
			public String getConfirmationId() {
				
				String confirmId = driver.findElement(By.cssSelector("tbody>tr:nth-child(1)>td:nth-child(2)")).getText();
				System.out.println("Confirmation Id is  "+confirmId);
				return confirmId;
			}
			
			
			
			public Boolean verifyConfirmationMessage() {
				String actualTitle = driver.findElement(By.tagName("h1")).getText().toString();
				return actualTitle.equals(TestConstants.CONFIRMATION_MSG);
			}
			
			public void getTicketBookingDateTime() {
				
				TestUtils.getCurrentTime();
				System.out.println("Actual "+dateTime.getText());
			}
			
			
}
