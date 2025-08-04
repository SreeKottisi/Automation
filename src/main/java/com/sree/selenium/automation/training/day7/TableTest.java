package com.sree.selenium.automation.training.day7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sree.selenium.automation.common.BaseFireBase;

public class TableTest extends BaseFireBase{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("firefox");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_FireBase();
		Thread.sleep(4000);
		WebElement widgetEle = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(widgetEle).build().perform(); // mouse hover
		System.out.println("widget menu selected");
		Thread.sleep(3000);
		WebElement autoCompleteMenu = driver.findElement(By.linkText("Table"));
		clickElement(autoCompleteMenu, "Table menu");
		Thread.sleep(3000);
		WebElement fullTable = driver.findElement(By.xpath("//table/tbody"));
		
		List<WebElement> allRows = fullTable.findElements(By.xpath("//tr"));
		for(WebElement rowData:allRows)
		{
			List<WebElement> allHeaderRowEle = rowData.findElements(By.tagName("th"));
			for(WebElement header:allHeaderRowEle)
			{
				System.out.print(header.getText()+"  ");
			}
			break;
		}
		
	//	List<WebElement> Rows=allRows;
		for(WebElement rowData:allRows)
		{
			List<WebElement> allDataRowEle = rowData.findElements(By.tagName("td"));
			for(WebElement dataEle:allDataRowEle)
			{
				System.out.print(dataEle.getText()+"  ");
			}
			System.out.println();
		}
		closeDriver();
	}

}