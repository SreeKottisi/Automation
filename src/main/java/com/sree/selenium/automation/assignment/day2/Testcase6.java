package com.sree.selenium.automation.assignment.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testcase6 extends BaseTest {

	public static void main(String[] args) throws Exception {

		launchBrowser("firefox");
		
		gotoURl("https://demoqa.com/checkbox/");

		WebElement toggleHome = driver.findElement(By.cssSelector("button[title='Toggle']"));
		clickElement(toggleHome, "Toggle Home");
		WebElement downloads = driver.findElement(By.xpath("//label[@for='tree-node-downloads']"));
		WebElement desktop = driver.findElement(By.xpath("//label[@for='tree-node-desktop\']"));
		clickElement(downloads, "downloads checkBox");
		clickElement(desktop, "downloads checkBox");
		
        // Get result text
        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Selected Items: " + result.getText());
	}
}
