package com.sree.selenium.automation.training.day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sree.selenium.automation.common.BaseFireBase;

public class WindowTest extends BaseFireBase{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("firefox");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(3000);
		login_FireBase();
		WebElement switchToEle = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(switchToEle).build().perform();   // mouse hover
		System.out.println("SwitchTo menu selected");
		Thread.sleep(3000);	
		WebElement winMenu = driver.findElement(By.linkText("Windows"));
		clickElement(winMenu,"window menu");
		Thread.sleep(3000);
		
	//	System.out.println(driver.getWindowHandles());
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("Before Total number of windows= "+allWindows.size());
		for(String window:allWindows)
		{
			System.out.println(window);
		}
		System.out.println("..........................."+driver.getWindowHandle());
		String parentWindow=driver.getWindowHandle();
		Thread.sleep(4000);
		WebElement windowButtonEle = driver.findElement(By.xpath("//button[contains(text(),'Window')]"));
		clickElement(windowButtonEle, "Window Button");
		Set<String> allWindows2=driver.getWindowHandles();
		System.out.println("After Total number of windows= "+driver.getWindowHandles().size());
		for(String handle:allWindows2)
		{
			if(!handle.equals(parentWindow))
				driver.switchTo().window(handle);
			System.out.println(allWindows2);
		}
		Thread.sleep(4000);
		System.out.println("..........................."+driver.getWindowHandle());
		
		WebElement searchbox = driver.findElement(By.name("q"));
		enterText(searchbox, "selenium","Google Search Box");
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getWindowHandle());
		closeDriver();
	}

}