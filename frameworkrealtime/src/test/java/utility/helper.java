package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class helper {

	public static String dateformat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_YYYY_DD_mm_HH_SS");
		Date d = new Date();
		String datename=sdf.format(d);
		return datename;
		
		
	}
	static WebDriver driver;
	public static WebDriver	BrowserSettings(){
			
		
			
		System.setProperty(
				"webDriver.chrome.driver", "C:\\Users\\JASWITHA\\Desktop\\Automation\\chromedriver\\chromedriver.exe");

		ChromeOptions c1 = new ChromeOptions();
		c1.addArguments("--no-sandbox");
		c1.addArguments("--disable-extensions");
		c1.addArguments("--remote-allow-origins=*");

			//create a variable for the webdriver

		driver = new ChromeDriver(c1);   //chrome class obects,methods area called using driver
		 
		 return driver ;

			}
		public static WebDriver WaitforElementandEnter(By ele, String input) {
			
			//ele carries xpath
			//input carries inputfiled avlue like username and pwd
			//create WebDriverWait element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(ele));//until the xpath element is found.
			driver.findElement(ele).sendKeys(input); //getting the xpath for ele and username for input from main class
			
			
			return driver;
			
		}
		
		//checking the presence of the element like nationality, here we are not sending keys, we are choosing from the list
		//for label type of elements
	public static WebDriver WaitforElement(By ele) {
			
			//ele carries xpath
			//input carries inputfiled avlue like username and pwd
			//create WebDriverWait element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(ele));//until the xpath element is found.
			
			
			return driver;
			
		}
		
	public static WebDriver WaitforElementandClickby(By ele) {
			
			//ele carries xpath
			//input carries inputfiled avlue like username and pwd
			//create WebDriverWait element
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(ele));//until the xpath element is found.
			driver.findElement(ele).click(); //getting the xpath for ele and username for input from main class
					
			return driver;
			
		}
	//some times user cannot perform click by using By element in  such cases below method can used with WebElement

	public static WebDriver WaitforElementandClickable(WebElement ele) {
		
		//ele carries xpath
		//input carries inputfiled avlue like username and pwd
		//create WebDriverWait element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));//until the xpath element is found.
		ele.click(); //getting the xpath for ele and username for input from main class
				
		return driver;
		
	}

	//wait for the alert to perform action on the button
	public static WebDriver WaitforalerttoPerform(WebDriver driver, String input) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.alertIsPresent());//until the xpath element is found.
		Alert alt=driver.switchTo().alert();
		
		if(input.equalsIgnoreCase("Accept"))
			alt.accept();
		else if(input.equalsIgnoreCase("dismiss"))
			alt.dismiss();
		
				
		return driver;
		
	}
	public static WebDriver findAndSendKeys(WebDriver driver, By ele, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		driver.findElement(ele).sendKeys(value);
		return driver;

	}
	public static WebDriver findAndClick(WebDriver driver, By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		driver.findElement(ele).click();
		return driver;

	}
	
	public static String takescreenshot(WebDriver driver)
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		   
			  SimpleDateFormat sdf = new SimpleDateFormat("MM_DD_YYYY_HH_mm_ss");
			  Date d= new Date();
			  String str_date =sdf.format(d);
			  
			  	  
		  File src =  ts.getScreenshotAs(OutputType.FILE);
		  String destn ="C:\\Users\\JASWITHA\\eclipse-workspace\\Training\\Screenshots\\"+str_date+".png";
		File des= new File(destn);
		 
		try {
		  FileHandler.copy(src, des);
		  
		 }catch(Exception e)
		  {
			  System.out.println(e);
		  }
		return destn;
		  


	}
	}

