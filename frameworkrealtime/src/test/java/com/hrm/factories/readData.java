package com.hrm.factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readData {
	
	public static String getproperty(String input) 
	{
		
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
	
	return (String) pro.get(input);
	
	}

	public static String getExecldata(String sheetname,int row, int col) 
	{
		String input=" ";
      File src = new File(System.getProperty("user.dir")+"\\testdata\\testdataexcel.xlsx");
		
		//read the file
		
		try {
		FileInputStream fis = new FileInputStream(src);// for reading
		//to write fileoutputstream
		//we need to have XSSFWorkbook to use excel data
		XSSFWorkbook wb = new XSSFWorkbook(fis); // identifier for the entire workbook
		XSSFSheet sh= wb.getSheet( "crm");
		sh.getRow(row).getCell(col).getStringCellValue();
		}
		catch(Exception e)
		{
			
		}
		return input;
		
	}

	
}
