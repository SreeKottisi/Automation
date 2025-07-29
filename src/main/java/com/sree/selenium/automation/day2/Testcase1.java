package com.sree.selenium.automation.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase1 extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("firefox");
		
		gotoURl("https://qa-tekarch.firebaseapp.com/");

		WebElement userNameField = driver.findElement(By.id("email_field"));
		WebElement passwordField = driver.findElement(By.id("password_field"));
		//login form
		enterText(userNameField, "admin123@gmail.com", "User Name Field");
		enterText(passwordField, "admin123", "Password Field");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		String headingText = heading.getText();
		System.out.println("headingText: " + headingText);

		WebElement name = driver.findElement(By.xpath("//input[@id=\"name\"]"));
		WebElement lname = driver.findElement(By.xpath("//input[@id=\"lname\"]"));
		WebElement postaladdress = driver.findElement(By.xpath("//input[@id=\"postaladdress\"]"));
		WebElement personaladdress = driver.findElement(By.xpath("//input[@id=\"personaladdress\"]"));
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='male']"));
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='female']"));
		WebElement pincode = driver.findElement(By.xpath("//input[@id=\"pincode\"]"));
		WebElement emailid = driver.findElement(By.xpath("//input[@id=\"emailid\"]"));

		/**
		 * fill the form
		 */

		enterText(name, "Sree", "Name Field");
		enterText(lname, "K", "Last Name Field");
		enterText(postaladdress, "1050HaciendaDr", "Postal Address Field");
		enterText(personaladdress, "1051HaciendaDr", "Personal Address Field");
		//selectRadioButton(maleRadioButton, "Male Radio Button");
		selectRadioButton(femaleRadioButton, "FeMale Radio Button");
		enterText(pincode, "94568", "Pincode Field");
		enterText(emailid, "admin123@demo.com", "Emailid Field");

		Thread.sleep(4000);
		
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div/span/button"));
		clickElement(submitButton, "Submit Button");
		
	}
}
