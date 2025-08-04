package com.sree.selenium.automation.training.day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("chrome");
		
		gotoURl("https://qa-tekarch.firebaseapp.com/");

		WebElement userNameField = driver.findElement(By.id("email_field"));
		WebElement passwordField = driver.findElement(By.id("password_field"));
		//login form
		enterText(userNameField, "admin123@gmail.com", "User Name Field");
		enterText(passwordField, "admin123", "Password Field");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");	
		
		Thread.sleep(3000);
		
		WebElement cityElement = driver.findElement(By.id("city"));
		Select selectCity = selectByIndex(cityElement, 1);
		List<WebElement> cityOptions = selectCity.getOptions();	
		for(WebElement option: cityOptions) {
			System.out.println(option.getText());
		}
		closeBrowser();
	}
}
