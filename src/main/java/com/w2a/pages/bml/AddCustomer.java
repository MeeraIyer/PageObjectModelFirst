package com.w2a.pages.bml;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;




public class AddCustomer extends Page{

	
	public AddCustomer() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void AddCustomer(String fname, String lname, String postcode)
	{
		type("fname_XPATH", fname);
		type("lname_XPATH", lname);
		type("postalcode_XPATH", postcode);
		click("submitCust_XPATH");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		if(alertText.contains("Customer added successfully"))
		{
			System.out.println("Customer added Successfully");
			alert.accept();
		}else
		{
			System.out.println("Customer did not get added");
		}
		
				
	
	}
	
	
}
