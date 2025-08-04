package com.sree.selenium.automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;

	public static void launchBrowser(String browserName)
	{
		switch (browserName.toLowerCase()) {
		case "chrome": WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;

		case "firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		
		case "edge": WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		
		case "safari": WebDriverManager.safaridriver().setup();
		driver=new SafariDriver();
		break;
		
		default: System.out.println("invalid browser selection");
			break;
		}
	}
	
	public static void goToURL(String url) throws Exception
	{
		driver.get(url);
		System.out.println(url+" is entered");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	public static void enterText(WebElement ele, String data, String objectName)
	{
		if(ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(data);
			System.out.println("data is entered in the "+objectName);
		}
		else
		{
			System.out.println(objectName+ "textbox is not displayed");
		}
	}

	public static void clickElement(WebElement ele, String objectName)
	{
		if(ele.isEnabled())
		{
			ele.click();
			System.out.println(objectName+" was enabled and clicked successfully");
		}
		else
		{
			System.out.println(objectName+" is disabled");
		}
	}

	public static void selectRadioButtonElement(WebElement ele, String objectName)
	{
		if(!ele.isSelected())
		{
			ele.click();
			System.out.println(objectName+" is selected");
		}
		else
		{
			System.out.println(objectName+" is already selected");
		}

	}
	
	public static void selectByValue(WebElement ele, String value)
	{
		Select select=new Select(ele);
		select.selectByValue(value);
	}
	
	public static void selectByText(WebElement ele, String value)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(value);
	}
	
	public static void selectByIndex(WebElement ele, int value)
	{
		Select select=new Select(ele);
		select.selectByIndex(value);
	}
	
	public static void waitForVisibilityOfElement(WebElement ele, long timeInSec, String ObjectName)
	{
		System.out.println(ObjectName+" waiting for visibility for maximum of "+timeInSec+ "sec");
		WebDriverWait wait=new WebDriverWait(driver,timeInSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForAlertToPresent(long timeInSec)
	{
		System.out.println("waiting for Alert box visibility for maximum of "+timeInSec+ "sec");
		WebDriverWait wait=new WebDriverWait(driver,timeInSec);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitForElementToBeClickable(WebElement ele, long timeInSec, String ObjectName)
	{
		System.out.println(ObjectName+" waiting for visibility for maximum of "+timeInSec+ "sec");
		WebDriverWait wait=new WebDriverWait(driver,timeInSec);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void closeDriver()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("browser get closed successfully..");
	}

}