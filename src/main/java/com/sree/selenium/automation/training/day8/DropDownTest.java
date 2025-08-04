package com.sree.selenium.automation.training.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.sree.selenium.automation.common.BaseFireBase;

public class DropDownTest extends BaseFireBase{
	
	public static void dropDown() throws Exception
	{
		launchBrowser("chrome");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_FireBase();
		Thread.sleep(4000);
		WebElement cityDropDown = driver.findElement(By.id("city"));
		waitForVisibilityOfElement(cityDropDown, 30, "city DropDown");
		
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='newdelhi'",cityDropDown);    // dropdown
		
	}
	
	public static void main(String[] args) throws Exception {
		dropDown();
	}

}