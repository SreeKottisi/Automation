package com.sree.selenium.automation.training.day7;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;
import com.sree.selenium.automation.common.BaseFireBase;

public class AutoCompleteTest extends BaseFireBase {

	public static void autoComplete(String text) throws Exception {
		launchBrowser("firefox");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_FireBase();
		Thread.sleep(4000);
		WebElement widgetEle = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(widgetEle).build().perform(); // mouse hover
		System.out.println("widget menu selected");
		Thread.sleep(3000);
		WebElement autoCompleteMenu = driver.findElement(By.linkText("AutoComplete"));
		clickElement(autoCompleteMenu, "AutoComplete menu");
		Thread.sleep(3000);
		WebElement countryField = driver.findElement(By.xpath("//input[@name='myCountry']"));
		waitForVisibilityOfElement(countryField, 30, "country filed search box");
		enterText(countryField, text.substring(0, 1), "search box element");

		List<WebElement> allCountriesList = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']/div"));
		for (WebElement country : allCountriesList) {
			if (country.getText().equalsIgnoreCase("Kuwait")) {
				country.click();
				break;
			}
		}

		String actualCountry = countryField.getAttribute("value");
		if (actualCountry.equals(text)) {
			System.out.println("Testcase is passed");
		} else {
			System.out.println("Testcase is failed");

	/*		// screenshot
			TakesScreenshot screenCapture = (TakesScreenshot) driver;
			File src = screenCapture.getScreenshotAs(OutputType.FILE);
			File destFile=new File(System.getProperty("user.dir")+"/Screenshot/AutoComplete1.png");
			Files.copy(src, destFile);
	*/
		//	TakesScreenshot screenCapture = (TakesScreenshot) driver;
			File src = countryField.getScreenshotAs(OutputType.FILE);
			File destFile=new File(System.getProperty("user.dir")+"/Screenshot/AutoComplete2.png");
			Files.copy(src, destFile);
		
		}
		closeDriver();
	}

	public static void main(String[] args) throws Exception {

		// autoComplete("India");
		autoComplete("Kenya");
	}

}