package com.sree.selenium.automation.training.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOptionsTest{
	
	public static void TestBrowserOption() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
	//	options.addArguments("--start-maximized");
	//	options.addArguments("--incognito");	// Firefox: private
		options.addArguments("--headless");		// without launching browser
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().getCookies();   		// handle the cookies
		driver.get("http://www.google.com/");
		
		System.out.println("URL passed successfully...");
		Thread.sleep(4000);
		
		WebElement aboutLink = driver.findElement(By.linkText("About"));
		aboutLink.click();
		System.out.println("clicked on About tab");
		
		String webTitle=driver.getTitle();
		System.out.println("Web App Title: "+webTitle);
		Thread.sleep(4000);
		driver.close();
		System.out.println("Brower closed successfully..");
	}

	public static void main(String[] args) throws Exception {
		TestBrowserOption();
	}
}