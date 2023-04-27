package com.hrm.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//will have methods for starting the browser
public class browserfactory {

 
	public static WebDriver startbrowser(String browser, String url)
	{
		System.out.println("***************************Browser initiated**********************");
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty(
					"webDriver.chrome.driver", System.getProperty("user.dir")+"src/test/resources/chromedriver/chromedriver.exe");

			ChromeOptions c1 = new ChromeOptions();
			c1.addArguments("--no-sandbox");
			c1.addArguments("--disable-extensions");
			c1.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(c1);   //chrome class obects,methods area called using driver
			driver.get(url); 
			 driver.manage().window().maximize();
			 return driver ;
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		
			System.setProperty(
					"webDriver.chrome.driver", System.getProperty("user.dir")+"src/test/resources/geckodriver-v0.33.0-win32/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
	        driver = new FirefoxDriver(options);
	      	
			  //firefox class obects,methods area called using driver
	        driver.get(url); 
	        driver.manage().window().maximize();
			 return driver ;
		}
		return driver;
	}	
	  
	  //close the driver method
		
	public static void closebrowser(WebDriver driver)	
	{
	
		driver.close();
   }
}