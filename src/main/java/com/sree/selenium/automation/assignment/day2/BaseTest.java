package com.sree.selenium.automation.assignment.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

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

}
