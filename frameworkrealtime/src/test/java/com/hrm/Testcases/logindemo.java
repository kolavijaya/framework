package com.hrm.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hrm.factories.Baseclass;
import com.hrm.pages.login;

public class logindemo extends Baseclass {
	@Test
	public void logintest() 
	{
		//WebDriver driver;
		logger=Reports.createTest("login test");
		//login l_p = new login(driver);
		login loginp = PageFactory.initElements(driver, login.class);
		loginp.enterusername();
		loginp.enterpassword();
		loginp.submit();
		
		
		
	}

}
