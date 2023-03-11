package com.adactintestscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

public class getTextExample extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		chromeBrowserLaunch();
		launchURL("https://www.google.com/");
		Thread.sleep(10000);
		WebElement findElement = driver.findElement(By.className("RNmpXc"));
		System.out.println(findElement.getText());
	}
	

}
