package com.w2a.pages.bml;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.w2a.base.Page;

public class OpenAccount extends Page{

	
	public OpenAccount() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void selectCustomer(String Custname, String currency) throws InterruptedException
	{
		select("selectCust_XPATH", Custname);
		select("selectCurr_XPATH",currency);
		click("processbtn_XPATH");
		
		Thread.sleep(30);
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if(alertText.contains("Account created successfully"))
		{
			System.out.println("Account created successfully");
			alert.accept();
		}else
		{
			System.out.println("Account did not get created");
		}
		
	}
}
