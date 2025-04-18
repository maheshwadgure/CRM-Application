package com.qa.crm.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.crm.tesbase.TestBase;

public class DealsPage extends TestBase{

	public DealsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
}
