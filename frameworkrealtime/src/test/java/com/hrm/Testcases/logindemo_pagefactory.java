package com.hrm.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrm.factories.Baseclass;
import com.hrm.pages.login;

public class logindemo_pagefactory extends Baseclass {
	@Test
	public void logintest() 
	{
		//WebDriver driver;
		logger=Reports.createTest("login test");
		login l_p = new login(driver);
		l_p.enterusername();
		l_p.enterpassword();
		l_p.submit();
		
		
		
	}

}
