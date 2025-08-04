package com.sree.selenium.automation.training.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOverTest extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("chrome");

		gotoURl("https://qa-tekarch.firebaseapp.com/");

		WebElement userNameField = driver.findElement(By.id("email_field"));
		WebElement passwordField = driver.findElement(By.id("password_field"));
		// login form
		enterText(userNameField, "admin123@gmail.com", "User Name Field");
		enterText(passwordField, "admin123", "Password Field");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");

		Thread.sleep(3000);
		//Switch to menu
		WebElement swithToMenuEle = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[1]/button"));
		Actions actions = new Actions(driver);
		actions.moveToElement(swithToMenuEle).build().perform();
		System.out.println("Switch to menu selected");
		//alert menu
		WebElement alertMenu = driver.findElement(By.linkText("Alert"));
		System.out.println("Switch to menu selected");
		alertMenu.click();
		Thread.sleep(3000);
		System.out.println("alert menu selected");
		//Window Alert
		WebElement windowAlertEle = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[1]/button[1]"));
		windowAlertEle.click();
		Alert windowAlert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(windowAlert.getText());
		windowAlert.accept();
		System.out.println("Window Alert Handled");
		//promptAlertEle
		WebElement promptAlertEle = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[1]/button[2]"));
		promptAlertEle.click();
		Thread.sleep(3000);
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("RajaKishore");
		promptAlert.accept();
		System.out.println("Prompt Alert handled");		
		Thread.sleep(3000);
		closeBrowser();
	}
}
