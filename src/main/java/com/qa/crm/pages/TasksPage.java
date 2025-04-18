package com.qa.crm.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.crm.tesbase.TestBase;

public class TasksPage extends TestBase{
	
	public TasksPage() {
		
		PageFactory.initElements(driver, this);
	}

}
