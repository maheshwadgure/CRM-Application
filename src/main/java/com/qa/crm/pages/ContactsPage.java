package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.tesbase.TestBase;



public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[@class='datacardtitle'][contains(text(),'Contacts')]")
	WebElement contactsPageLable;
	
	@FindBy(xpath="//select[@class='select' and @name='title']")
	WebElement selectTitle;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement compName;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement saveBtn;
	

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLable()
	{
		return contactsPageLable.isDisplayed();
	}
	
	public void selectContacts(String contactName)
	{
	//driver.findElement(By.xpath("//td[contains(text(),'"+name+"')]"));
		driver.findElement(By.xpath("//a[text()='"+contactName+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title,String fName,String lName,String company)
	{
		Select select=new Select(selectTitle);
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		compName.sendKeys(company);
		saveBtn.click();
	}

}
