package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.HomePage;
import com.w2a.pages.cust.customerLogin;
import com.w2a.utilities.TestUtil;

public class CustomerLoginTest extends BaseTest{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void customerLoginTest(Hashtable<String,String> data) throws IOException
	{
		
		customerLogin clogin = new customerLogin();
		clogin.goToCustomerHome(data.get("custname"));
		
	}

}
