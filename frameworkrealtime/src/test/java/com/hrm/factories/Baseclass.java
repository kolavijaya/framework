package com.hrm.factories;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.helper;

public class Baseclass {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports Reports ; //public static --can be used by others and static value doesnot make change
	public static ExtentTest logger;
	public static WebDriver driver;
	//first annotation
	//first will be execute and initated a report
	@BeforeSuite
	public void statusReport()  throws IOException
	{
		
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir")+"/Reports/SeleniumReport"+helper.dateformat()+".html");//it will take our project(framework realtime) path in eclipse and create a report
				Reports = new ExtentReports();
				Reports.attachReporter(spark);
				System.out.println("***************************Suit initiated**********************");
	}
	
	 @AfterMethod
	//publishing the report in logs 
	 public void ResultReport(ITestResult result) 
	  {
		 //int status = result.getStatus();
			//System.out.println(status);
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				logger.log(Status.PASS, "Test passed", MediaEntityBuilder.createScreenCaptureFromBase64String(
						helper.takescreenshot(driver)).build());
			}
			
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				logger.log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(
						helper.takescreenshot(driver)).build());
				
			
			}
			
			else if(result.getStatus()==ITestResult.SKIP)
			{
				logger.log(Status.SKIP, "Test Skipped");
			}
			
		 Reports.flush();//it will push the screenshot into reports folder after build we need to flush
   	 }
	 
	 //intiate the browser launch
	 @BeforeClass
	 public void startsession()
	 {
		 //what type of browser u r using and url of applications it is in the dataprovider 
		 
		 String browser=readData.getproperty("browser");//make sure browser is case senitive check how it is written on testdata
		 String url=readData.getproperty("url");//check the testdatafile how url is written
		 driver=browserfactory.startbrowser(browser, url);
		 
	 }
	 
	 @AfterClass
	 public void endsession() {
		 browserfactory.closebrowser(driver);
		 
	 }

	
}
