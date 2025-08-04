package com.sree.selenium.automation.assignment.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {
	/**
	 * Salesforce Login testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
		WebElement UsernamField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		UsernamField.sendKeys("sreelatha.kottisi413@agentforce.com");
		// Thread.sleep(3000);
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		passwordField.sendKeys("Sree9!Raj");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		loginButton.click();

	}

}
