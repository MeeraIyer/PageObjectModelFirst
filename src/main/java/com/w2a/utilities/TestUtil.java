package com.w2a.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import com.w2a.utilities.ExcelReader;
import com.w2a.base.Page;


public class TestUtil extends Page {
	
	
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{
		String sheetName=m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		//System.out.println("Rows - "+rows);
		//System.out.println("Columns - "+cols);
		
		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;
		
		for(int rowNum=2;rowNum <= rows; rowNum++) {
			
			table = new Hashtable<String,String>();
			
			for(int colNum=0;colNum<cols;colNum++)
			{
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}
		}
		return data;
	}
	
	public static boolean isTestRunnable(String testName, ExcelReader excel)
	{
		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);
		for(int rNum=2; rNum<=rows; rNum++)
		{
			String testCase=  excel.getCellData(sheetName,"TCID",rNum);
			if(testCase.equalsIgnoreCase(testName))
			{
				String runmode = excel.getCellData(sheetName,"runmode", rNum);
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
	}
		return false;
	
	}

}
