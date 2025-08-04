package com.sree.selenium.automation.training.day8;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.sree.selenium.automation.common.BaseFireBase;

public class FileUploadTest extends BaseFireBase{
	
	public static void FileUpload() throws Exception
	{
		launchBrowser("chrome");
		goToURL("https://qa-tekarch.firebaseapp.com/");
		login_FireBase();
		
		WebElement fileUpload = driver.findElement(By.xpath("//a[text()='File Upload']"));
		waitForVisibilityOfElement(fileUpload, 30, "file upload link");
		
		clickElement(fileUpload, "file upload link");
		Thread.sleep(4000);
		WebElement clearButton = driver.findElement(By.xpath("//button[text()='Clear']"));
		waitForVisibilityOfElement(clearButton, 30, "clear button element");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",clearButton);
		Thread.sleep(3000);
		WebElement browseButton = driver.findElement(By.xpath("//input[@id='logo']"));
		waitForVisibilityOfElement(browseButton, 30,"choose file upload button");
		js.executeScript("arguments[0].click()",browseButton);
		js.executeScript("arguments[0].value='C:\\Users\\Akshay Kumar\\Downloads\\FileUpload.txt'", browseButton);
	//	StringSelection selection=new StringSelection("C:\\Users\\Akshay Kumar\\Downloads\\FileUpload.txt");
	//	browseButton.sendKeys("C:\\Users\\Akshay Kumar\\Downloads\\FileUpload.txt");
	/*	
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		
		clipboard.setContents(selection, null);
		
		System.out.println("copied to clipboard");
		
		Thread.sleep(5000);
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	*/
		Thread.sleep(4000);
		closeDriver();
	}
	
	
	public static void main(String[] args) throws Exception {
		FileUpload();
	}

}