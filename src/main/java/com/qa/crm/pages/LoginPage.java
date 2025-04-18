package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.tesbase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR
	
		@FindBy(name="username")
		WebElement useName;
		
		@FindBy(name="password")
		WebElement passWord;
		
		@FindBy(xpath = "//input[@type='submit']")
		WebElement loginBtn;

		@FindBy(xpath = "//div[@class='navbar-header']//img[@class='img-responsive']")
		WebElement crmlogo;
		
		
		//Intialising the Page Object
		public LoginPage() {
			
			PageFactory.initElements(driver, this);
			//PageFactory.initElements(driver, LoginPage.class);
		}
		
		
		//Actions
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
			
		}
		
		public boolean validateLoginPageLogo()
		{
			return crmlogo.isDisplayed();
		}
		
		
		public HomePage login(String un,String pass)
		{
			
			useName.sendKeys(un);
			passWord.sendKeys(pass);
			loginBtn.click();
			return new HomePage();
		}
}
