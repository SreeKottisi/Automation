package com.sree.selenium.automation.training.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertTest extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("chrome");
		
		gotoURl("https://qa-tekarch.firebaseapp.com/");

		WebElement userNameField = driver.findElement(By.id("email_field"));
		WebElement passwordField = driver.findElement(By.id("password_field"));
		//login form
		enterText(userNameField, "admin123@gmail.com", "User Name Field");
		enterText(passwordField, "admin1234", "Password Field");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");	
		
		Thread.sleep(3000);
		
		Alert loginAlert = driver.switchTo().alert();
		System.out.println(loginAlert.getText());
		loginAlert.accept();
		closeBrowser();
	}
}
