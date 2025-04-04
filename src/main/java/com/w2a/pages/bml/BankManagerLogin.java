package com.w2a.pages.bml;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class BankManagerLogin extends Page{
	
	
	
	public BankManagerLogin() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCustomer goToAddCustomer() throws IOException
	{
		click("addCustbtn_XPATH");
		
		return new AddCustomer();
	}
	
	public OpenAccount goToOpenAccount() throws IOException
	{
		click("openAccount_XPATH");
		
		return new OpenAccount();
	}
	
	public Customers goToCustomers() throws IOException
	{
		click("customers_XPATH");
		
		return new Customers();
	}
}
