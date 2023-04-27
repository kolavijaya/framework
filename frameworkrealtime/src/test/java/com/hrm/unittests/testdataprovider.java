package com.hrm.unittests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class testdataprovider {

	@Test
	public void read() {
		Properties pro = new Properties();
		try{
			File src = new File(System.getProperty("user.dir")+"\\Configfiles\\testdata.properties");
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);	
			
			
		  }
		catch(IOException e) 
		{
			e.printStackTrace();
			
	     }
		
		System.out.println(pro.get("browser"));
	}
}
