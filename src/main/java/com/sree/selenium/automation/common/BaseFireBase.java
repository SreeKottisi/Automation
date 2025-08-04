package com.sree.selenium.automation.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sree.selenium.automation.common.BaseTest;

public class BaseFireBase extends BaseTest{
	
	public static void login_FireBase() throws InterruptedException
	{
		WebElement username = driver.findElement(By.xpath("//*[@id=\"email_field\"]"));
		enterText(username, "admin123@gmail.com", "username filed");
	
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password_field\"]"));
		enterText(password, "admin123", "password field");
		
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "login button");
		Thread.sleep(5000);
	}
	
	public static void inValidLogin_FireBase()
	{
		WebElement username = driver.findElement(By.xpath("//*[@id=\"email_field\"]"));
		enterText(username, "admin123@gmail.com", "username filed");
	
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password_field\"]"));
		enterText(password, "admin12345", "password field");
		
		WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "login button");
	}

}