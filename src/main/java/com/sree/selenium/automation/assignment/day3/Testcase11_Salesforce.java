package com.sree.selenium.automation.assignment.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sree.selenium.automation.assignment.day2.BaseTest;

public class Testcase11_Salesforce extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("chrome");
		
		gotoURl("https://login.salesforce.com/");

		WebElement userNameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		//login form
		enterText(userNameField, "sreelatha.kottisi413@agentforce.com", "User Name Field");
		enterText(passwordField, "Sree9!Raj", "Password Field");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
			
		clickElement(loginButton, "Login Button");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		String headingText = heading.getText();
		System.out.println("headingText: " + headingText);
		
        System.out.println("TODO");
	}
}
