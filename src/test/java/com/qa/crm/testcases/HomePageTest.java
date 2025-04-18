package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.tesbase.TestBase;
import com.qa.crm.utils.TestUtils;

@Listeners(com.qa.crm.utils.TestNGListener.class)
public class HomePageTest extends TestBase{
	
	
	LoginPage login;
	HomePage homePage;
	TestUtils tesUtils;
	ContactsPage contacts;
	
	public HomePageTest() {

		//super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialisation();
		tesUtils=new TestUtils();
		login=new LoginPage();
		homePage=new HomePage();
		contacts=new ContactsPage();
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@Test (priority = 1)
	public void validateHomePageTitleTest()
	{
		String homePageTitle= homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
		
	}
	
	@Test (priority = 2)
	public void verifyLoginUserNameTest()
	{
		
		tesUtils.switchToFrame();
		Assert.assertTrue(homePage.validateuserNameLable());
		
	}
	
	
	@Test (priority = 3)
	public void clickOnContactsLinkTest()
	{
		//TestUtilst.switchToFrame();
		tesUtils.switchToFrame();
		contacts=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
		driver.close();
	}

}
