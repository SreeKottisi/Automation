package com.sree.selenium.automation.training.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SalesforceTest extends BaseTest{

	public static void main(String[] args) throws Exception {
		launchBrowser("chrome");
		goToURL("https://login.salesforce.com/");
		WebElement userName =  driver.findElement(By.xpath("//*[@id=\"username\"]"));
		enterText(userName, "sreelatha.kottisi413@agentforce.com", "User Name");
		
		WebElement userName1 =  driver.findElement(By.xpath("//*[@id=\"username\"]"));
		enterText(userName, "sreelatha.kottisi413@agentforce.com", "User Name");

		
		//*[@id="Login"]
		
		
		//input[@id="name"]
	}

}
