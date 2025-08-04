package com.sree.selenium.automation.training.day8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotTest {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.google.com/");
		
		((WebDriver) driver.manage()).navigate().refresh();
		
		Thread.sleep(5000);	
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);

		Thread.sleep(4000);

		WebElement aboutLink = driver.findElement(By.linkText("About"));
		aboutLink.click();
		System.out.println("clicked on About tab");
		robot.delay(3000);
		robot.mouseWheel(50);
		
	}

}