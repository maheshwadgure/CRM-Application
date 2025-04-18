package com.qa.crm.pages;

import java.awt.Dimension;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.tesbase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Gagan Khanna')]")
	WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsWebLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement tasksWebLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsWebLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactsLink;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateuserNameLable() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactsWebLink.click();
		return new ContactsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksWebLink.click();
		return new TasksPage();

	}

	public DealsPage clickOnDealsLink() {
		dealsWebLink.click();
		return new DealsPage();

	}
	
   public void clickOnNewContactLink() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsWebLink).perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"let submenu = arguments[0].nextElementSibling;" + "submenu.style.opacity = '1';"
						+ "submenu.style.visibility = 'visible';" + "submenu.style.display = 'block';",
				contactsWebLink);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(newContactsLink));
		newContactsLink.click();

		// OR

		/*
		 * WebElement contactsLink =
		 * driver.findElement(By.xpath("//a[text()='Contacts']")); Actions actions = new
		 * Actions(driver); actions.moveToElement(contactsLink).perform();
		 * 
		 * // 2. Force display the submenu using JavaScript JavascriptExecutor js =
		 * (JavascriptExecutor) driver; js.executeScript(
		 * "let submenu = arguments[0].nextElementSibling;" +
		 * "submenu.style.opacity = '1';" + "submenu.style.visibility = 'visible';" +
		 * "submenu.style.display = 'block';", contactsLink );
		 * 
		 * // 3. Wait and click 'New Contact' WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(5)); WebElement newContactLink =
		 * wait.until(ExpectedConditions
		 * .elementToBeClickable(By.xpath("//a[text()='New Contact']")));
		 * newContactLink.click();
		 */

	}
	
}
