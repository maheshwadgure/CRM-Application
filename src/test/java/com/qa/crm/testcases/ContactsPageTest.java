package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.tesbase.TestBase;
import com.qa.crm.utils.TestUtils;


@Listeners(com.qa.crm.utils.TestNGListener.class)
public class ContactsPageTest extends TestBase {

	TestUtils tesUtils = new TestUtils();
	LoginPage login = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contacts = new ContactsPage();
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		
		//WebDriver Initialization
		initialisation();
		
		//Object Initialization
		tesUtils = new TestUtils();
		login = new LoginPage();
		homePage = new HomePage();
		contacts = new ContactsPage();
		
		//Go to Contacts Page
		homePage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		tesUtils.switchToFrame();
		contacts = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLableTest() 
	
	{
		Assert.assertTrue(contacts.verifyContactsPageLable(), "This is not Contacts Page");

	}
	
	@Test(priority = 2)
	
	public void verifySelectSingleContacts()
	{
		contacts.selectContacts("aaarya ss");
		
	}


	@Test(priority = 2)
	
	public void verifySelectMultipleContacts()
	{
		contacts.selectContacts("00Himanshu sharma");
		contacts.selectContacts("aaarya ss");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	

	@Test(priority = 4,dataProvider="getCRMTestData")
	public void verifyCreateNewContacts(String title, String firstName, String lastName, String company)
	{
		homePage.clickOnNewContactLink();
		//contacts.createNewContact("Mr.", "Mahesh", "Wadgure", "Vicon");
		contacts.createNewContact(title, firstName, lastName, company);
		
	}
	
	@Test(priority = 5)
	public void jenkingConfigure()
	{
		System.out.println("Jenkin is sucessfully configured");
		
	}
	
	 @AfterMethod 
	 public void tearDown() { driver.quit(); }
	 

}
