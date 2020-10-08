package com.blaze.agency.demo.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	public static void getCurrentTime( ) {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		System.out.println("DATETIME = " + utc.format(DateTimeFormatter.ofPattern("day, dd MMM yyyy HH:mm:ss")));
	}
	
	/**
	 * Tab to focus and then click.
	 */
	public static void focusAndClick() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);	
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	/**
	 * Tab count times and click.
	 * @param count
	 */
	public static void focusAndClick(int count) {
		Robot robot = null;
		
		for(int i =0; i<count; i++) {
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		robot.keyPress(KeyEvent.VK_ENTER);	
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/**
	 * Wait for the page to load.
	 */
	public static void waitForPageLoad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 50);

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver wdriver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState"
						).equals("complete");
			}
		});


	}


	public static boolean existsElement(WebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
}
