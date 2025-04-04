package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;
import com.w2a.pages.bml.BankManagerLogin;
import com.w2a.pages.cust.customerLogin;

public class HomePage extends Page {
	
	

	public HomePage() throws IOException {
		super();
	}

	public BankManagerLogin goToBankManagerLogin() throws IOException
	{	
		
		click("Home_XPATH");
		click("bmlbtn_XPATH");
		
		return new BankManagerLogin();
	}
	
	public customerLogin goToCustomerLogin() throws IOException
	{
		
		click("Home_XPATH");
		click("custbtn_XPATH");
		
		return new customerLogin();
	
	}
	public void goToSampleForm()
	{
		
		click("Home_XPATH");
		click("sampleform_XPATH");
		
	}
	
	public void goToLifetime()
	{
		
		click("Home_XPATH");
		click("lifetimeMem_XPATH");
		
	}
	
	
}
