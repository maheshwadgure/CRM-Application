package com.qa.crm.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.crm.tesbase.TestBase;

public class WebDriverEventListener extends TestBase implements WebDriverListener {

	@Override
	public void beforeGet(WebDriver driver, String url) {
		
		System.out.println("Before Navigating to the URL" +url);
	}

	@Override
	public void beforeClose(WebDriver driver) {
		System.out.println("Webdriver connection is Open");
	}

	@Override
	public void afterClose(WebDriver driver) {
		
		System.out.println("Webdriver connection is closed ");
	}

	@Override
	public void beforeClick(WebElement element) {
		System.out.println("Elemement before click :");
	}

	@Override
	public void afterClick(WebElement element) {
		
		System.out.println("Elemement after click :");
		
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		
		System.out.println("After Navigating to the URL" +url);
	}

	

}
