package com.sree.selenium.automation.assignment.day1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 {

	public static void main(String[] args) {
		System.out.println("Hello Sreealtha");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		WebElement emailField = driver.findElement(By.id("email_field"));
		emailField.sendKeys("admin123@gmail.com");
		//Thread.sleep(3000);
		WebElement passwordField = driver.findElement(By.id("password_field"));
		passwordField.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 5); 
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		
        String headingText = heading.getText();
		System.out.println("headingText: " + headingText);

        
		WebElement formTitle1 = driver.findElement(By.cssSelector("#user_div > div.container > h1"));
		System.out.println("Form Title1: " + formTitle1.getText());
		WebElement formTitle2 = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/h1"));
		System.out.println("Form Title2: " + formTitle2.getText());

		
	}

}
