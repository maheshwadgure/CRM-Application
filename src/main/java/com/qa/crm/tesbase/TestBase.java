package com.qa.crm.tesbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import com.qa.crm.utils.TestUtils;//imports the package when needed
import com.qa.crm.utils.WebDriverEventListener;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;



public class TestBase {

	public static WebDriver driver;
	//public static WebDriver e_driver;
	public static Properties prop;
	
	public static WebDriverEventListener eventLister;
    //public static WebDriverListener eventLister;
	public static EventFiringDecorator<WebDriver> decorator;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Selenium\\CRMSelenium\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
			prop.load(ip);

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialisation() {
		String browserName = prop.getProperty("browser");
		
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--incognito");

		 eventLister=new WebDriverEventListener();
		 decorator=new EventFiringDecorator<>(eventLister);
		 //driver= decorator.decorate(driver);
		 
		//System.out.println(browserName);
		if (browserName.equals("chrome")) {

			//driver = new ChromeDriver(options);
			//driver = new ChromeDriver();
			
			driver=decorator.decorate(new ChromeDriver(options));

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.implicitWaitTime));
		driver.get(prop.getProperty("url"));
	}

}
