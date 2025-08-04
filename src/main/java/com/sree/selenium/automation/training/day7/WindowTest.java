package com.sree.selenium.automation.training.day7;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sree.selenium.automation.common.BaseFireBase;

public class WindowTest extends BaseFireBase{
	
	public static void main(String[] args) throws Exception {
		
		launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);    // global wait
		
		goToURL("https://qa-tekarch.firebaseapp.com/");
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"email_field\"]"));
		
		waitForVisibilityOfElement(username, 20, "username");
		enterText(username, "admin123@gmail.com", "username filed");
	
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password_field\"]"));
		enterText(password, "admin123", "password field");
		
		WebElement loginButton=driver.findElement(By.xpath("//*[@id='login_div']/button"));
		clickElement(loginButton, "login button");
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver); 
		wait.withTimeout(Duration.ofSeconds(30)) 
		.pollingEvery(Duration.ofSeconds(2)) 
		.withMessage("alert is not present after fluent wait waiting time 30sec") 
		.ignoring(NoAlertPresentException.class) 
		.until(ExpectedConditions.alertIsPresent()); 
		
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		closeDriver();
		
	}

}