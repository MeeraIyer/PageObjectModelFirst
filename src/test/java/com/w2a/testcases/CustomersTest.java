package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.bml.BankManagerLogin;
import com.w2a.pages.bml.Customers;
import com.w2a.utilities.TestUtil;

public class CustomersTest extends BaseTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void customersTest(Hashtable<String,String> data) throws IOException {
		
		BankManagerLogin BMLogin = new BankManagerLogin();
		BMLogin.goToCustomers();
		Customers cust = new Customers();
		cust.searchCustomer(data.get("custname"));
		
		
		
	}
	
}
