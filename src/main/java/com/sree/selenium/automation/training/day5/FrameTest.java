package com.sree.selenium.automation.training.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sree.selenium.automation.common.BaseTest;

public class FrameTest extends BaseTest{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("chrome");
		goToURL("https://demoqa.com/frames");
		Thread.sleep(8000);
	//	driver.switchTo().frame("frame1");		// using Frame id
		WebElement iFrame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iFrame1);		// using Frame Web element
	//	driver.switchTo().frame(0);				// using Frame index
		WebElement ele1 = driver.findElement(By.cssSelector("#sampleHeading"));
		System.out.println("From Frame-1= "+ele1.getText());
		driver.switchTo().defaultContent();
		
		WebElement frameEle = driver.findElement(By.xpath("//h1[contains(text(),'Frames')]"));
		System.out.println(frameEle.getText());
		Thread.sleep(3000);
		driver.switchTo().frame("frame2");		// using Frame id
	//	driver.switchTo().frame(1);				// using Frame index
		Thread.sleep(6000);
		WebElement ele2 = driver.findElement(By.cssSelector("#sampleHeading"));
		System.out.println("From Frame-2= "+ele2.getText());
		closeDriver();
	}

}