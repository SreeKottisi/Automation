package com.sree.selenium.automation.assignment.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello Sreealtha");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		//Thread.sleep(3000);
		searchBox.sendKeys("Rockrose Dr");
		WebElement searchButton = driver.findElement(By.name("btnK"));
		//searchButton.click();
		
		WebElement aboutLink = driver.findElement(By.linkText("About"));
		//aboutLink.click();
		
		WebElement aboutLink2 = driver.findElement(By.partialLinkText("Abo"));
		//aboutLink2.click();
		//WebElement aboutLink3 = driver.findElement(By.tagName("button"));
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		System.out.println(driver.getCurrentUrl());
	}

} 
