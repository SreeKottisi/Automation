package com.sree.selenium.automation.assignment.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 {

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
		passwordField.sendKeys("admin1234");
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		loginButton.click();
		
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
						
		//driver.quit();
		
	}

}
