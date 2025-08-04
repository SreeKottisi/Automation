package com.sree.selenium.automation.training.day7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sree.selenium.automation.common.BaseFireBase;

public class ESPNTableTest extends BaseFireBase{
	
	public static void main(String[] args) throws Exception {
		launchBrowser("firefox");
		goToURL("https://www.espn.in/cricket/series/22802/game/1448352/england-vs-india-4th-test-india-in-england-2025");
		
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