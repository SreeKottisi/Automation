package com.sree.selenium.automation.trainingday2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireBaseTest1 {
	public static void main(String[] args) {
		System.out.println("Hello Sreealtha");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		WebElement userName = driver.findElement(By.id("email_field"));
		if (userName.isDisplayed()) {
			userName.clear();
			userName.sendKeys("admin123@gmail.com");
		} else {
			System.out.println("Username field is not displayed");
		}
		// Thread.sleep(3000);
		WebElement passwordField = driver.findElement(By.id("password_field"));
		passwordField.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		if (loginButton.isEnabled()) {
			loginButton.click();
		} else {
			System.out.println("Login Button is disabled");
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);


		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
		String actual = heading.getText();
		System.out.println("Actual Text: " + actual);
		
		String expected = "Student Registration Form";
		
		if(actual.equals(expected)) {
			System.out.println("testcase passed");
		}else {
			System.out.println("testcase failed");
		}
		/*
		 * List<WebElement> allRadioButton =
		 * driver.findElements(By.xpath("//*[@id=\"radiobut\"]"));
		 * 
		 * allRadioButton.get(1).click();
		 */
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='male']"));
		maleRadioButton.click();
		if (maleRadioButton.isSelected()) {
			System.out.println("testcase is passed");
		} else {
			System.out.println("testcase is failed");
		}

		WebElement formTitle1 = driver.findElement(By.cssSelector("#user_div > div.container > h1"));
		System.out.println("Form Title1: " + formTitle1.getText());
		WebElement formTitle2 = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/h1"));
		System.out.println("Form Title2: " + formTitle2.getText());

	}

}
