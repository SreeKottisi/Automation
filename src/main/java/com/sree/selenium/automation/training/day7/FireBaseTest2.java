package com.sree.selenium.automation.training.day7;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;
import com.sree.selenium.automation.common.BaseTest;

public class FireBaseTest2 extends BaseTest{
	
	public static void main(String[] args) throws Exception {

		launchBrowser("chrome");

		driver.manage().window().maximize();

		goToURL("https://qa-tekarch.firebaseapp.com/");
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"email_field\"]"));
		enterText(username, "admin123@gmail.com", "username filed");
	//	String data=username.getAttribute("value");
	//	System.out.println(data);
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password_field\"]"));
		enterText(password, "admin123", "password field");
		
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
	//	System.out.println(loginButton.getText());
		clickElement(loginButton, "login button");
		
		Thread.sleep(3000);		// static wait
		
		WebElement form_container = driver.findElement(By.cssSelector(".container"));
		
		String expected="Student Registration Form1";
		
		String actual=driver.findElement(By.tagName("h1")).getText();
		
		if(actual.equals(expected))
		{
			System.out.println("testcase passed");
		}
		else
		{
			System.out.println("testcase failed");
			File src = form_container.getScreenshotAs(OutputType.FILE);
			File destFile=new File(System.getProperty("user.dir")+"/Screenshot/form-container1.png");
			Files.copy(src, destFile);
		}
		
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='female']"));
		selectRadioButtonElement(femaleRadioButton, "female radio button");
		Thread.sleep(2000);
		

		Thread.sleep(6000);
		System.out.println("Test Executed Successfully..");
		driver.close();

	}

}