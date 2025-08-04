package com.sree.selenium.automation.training.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireBaseTest2 {
	public static WebDriver driver;

	public static void enterText(WebElement ele, String data, String objName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("Data Entered in the " + objName);
		} else {
			System.out.println(objName + " text box is not displayed");
		}
	}

	public static void clickElement(WebElement ele, String objName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objName + " is Enabled and Clicked");
		} else {
			System.out.println(objName + " is disabled");
		}
	}

	public static void selectRadioButton(WebElement ele, String objName) {
		if (ele.isDisplayed()) {
			if (!ele.isSelected()) {
				ele.click();
				System.out.println(objName + " Radio Button is Selected");
			} else {
				System.out.println(objName + " Radio Button is already Selected");
			}
		} else {
			System.out.println(objName + " is not displayed");
		}
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");

		WebElement userName = driver.findElement(By.id("email_field"));
		enterText(userName, "admin123@gmail.com", "UserName Field");
		WebElement passwordField = driver.findElement(By.id("password_field"));
		enterText(passwordField, "admin123", "Password Field");
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_div\"]/button"));
		clickElement(loginButton, "Login Button");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		String headingText = heading.getText();
		System.out.println("headingText: " + headingText);
		
		//*[@id="name"]
	//	/html/body/div[2]/div[2]/form/div[1]/div[2]/input
		/*
		 * List<WebElement> allRadioButton =
		 * driver.findElements(By.xpath("//*[@id=\"radiobut\"]"));
		 * 
		 * allRadioButton.get(1).click();
		 */
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='female']"));
		selectRadioButton(maleRadioButton, "Male Radio Button");

	}

}
