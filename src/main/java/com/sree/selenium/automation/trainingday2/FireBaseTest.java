package com.sree.selenium.automation.trainingday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FireBaseTest extends BaseTest{


	public static void main(String[] args) throws Exception {

		launchBrowser("firefox");

		goToURL("https://qa-tekarch.firebaseapp.com/");

		WebElement userName = driver.findElement(By.id("email_field"));
		enterText(userName, "admin123@gmail.com", "UserName Field");
		
		WebElement passwordField = driver.findElement(By.id("password_field"));
		enterText(passwordField, "admin123", "Password Field");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		
		String headingText = heading.getText();
		System.out.println("headingText: " + headingText);
		
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='female']"));
		selectRadioButton(maleRadioButton, "Male Radio Button");
	}

}
