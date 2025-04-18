package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.tesbase.TestBase;

@Listeners(com.qa.crm.utils.TestNGListener.class)
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	/*
	 * public LoginPageTest() { //super(); }
	 */
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest()
	{
		String loginPageTitle= loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Free CRM software for customer relationship management, sales, and support.");
	
	}
	
	@Test(priority = 2)
	public void validateLoginPageLogoTest()
	{
		boolean isLoginPageLogo= loginPage.validateLoginPageLogo();
		Assert.assertTrue(isLoginPageLogo);
	}
	
	@Test (priority = 3)
	public void logiTest()
	{
		
		//homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
