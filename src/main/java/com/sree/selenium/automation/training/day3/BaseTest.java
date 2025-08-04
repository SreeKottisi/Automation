package com.sree.selenium.automation.training.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;

	public static void launchBrowser(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			break;
		}
	}
	
	public static void closeBrowser() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	public static void gotoURl(String url) throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1000);
	}


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

	public static Select selectByValue(WebElement ele, String value) {
		Select selectObject =  new Select(ele);
		selectObject.selectByValue(value);
		return selectObject;
	}
	
	public static Select selectByText(WebElement ele, String value) {
		Select selectObject =  new Select(ele);
		selectObject.selectByVisibleText(value);
		return selectObject;
	}
	
	public static Select selectByIndex(WebElement ele, int value) {
		Select selectObject =  new Select(ele);
		selectObject.selectByIndex(value);
		return selectObject;
	}
}
