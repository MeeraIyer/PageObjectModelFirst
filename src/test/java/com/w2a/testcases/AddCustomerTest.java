package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.bml.AddCustomer;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends BaseTest{
		
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
		public void addCustomerTest(Hashtable<String,String> data) throws IOException {
			
		AddCustomer customer = new AddCustomer();
		customer.AddCustomer(data.get("firstname"), data.get("lastname"), data.get("postalcode"));
		
	}
	
}
