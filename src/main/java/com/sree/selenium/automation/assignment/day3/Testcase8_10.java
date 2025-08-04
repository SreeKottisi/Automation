package com.sree.selenium.automation.assignment.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sree.selenium.automation.common.BaseFireBase;

public class Testcase8_10 extends BaseFireBase {

	public static void main(String[] args) throws Exception {

		launchBrowser("firefox");
		
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_FireBase();

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
		WebElement cityElement = driver.findElement(By.id("city"));
		WebElement courseElement = driver.findElement(By.id("course"));
		WebElement districtElement = driver.findElement(By.id("district"));
		WebElement stateElement = driver.findElement(By.id("state"));
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
		selectRadioButtonElement(femaleRadioButton, "FeMale Radio Button");
		selectByValue(cityElement, "goa");
		selectByText(courseElement, "MCA");
		selectByValue(districtElement, "goa");
		selectByText(stateElement, "GOA");

		enterText(pincode, "94568", "Pincode Field");
		enterText(emailid, "admin123@demo.com", "Emailid Field");

		Thread.sleep(4000);
		
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div/span/button"));
		//clickElement(submitButton, "Submit Button");
		
	}
}
