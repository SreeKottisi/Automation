package com.sree.selenium.automation.training.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExcTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.google.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title").toString();		// get title
		System.out.println(title);
		
		WebElement searchBox = driver.findElement(By.name("q"));
		js.executeScript("arguments[0].value='Selenium'",searchBox);     // sendkeys
		
		Thread.sleep(3000);
		
		WebElement searchButton = driver.findElement(By.className("gNO89b"));
		js.executeScript("arguments[0].click()",searchButton);			// click
		Thread.sleep(5000);
//		js.executeScript("location.reload()");				// page refresh
		Thread.sleep(3000);
//		js.executeScript("scrollBy(0,1500)");				// scroll using pixel
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'Is selenium')]"));
		js.executeScript("arguments[0].scrollIntoView(true)",ele);		// scroll using webelement
	}

}