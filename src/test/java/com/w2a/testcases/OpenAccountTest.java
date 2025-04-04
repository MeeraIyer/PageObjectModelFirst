package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.bml.BankManagerLogin;
import com.w2a.pages.bml.OpenAccount;
import com.w2a.testcases.*;
import com.w2a.utilities.TestUtil;

public class OpenAccountTest extends BaseTest{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccountTest(Hashtable<String,String> data) throws IOException, InterruptedException {
		
		BankManagerLogin BMLogin = new BankManagerLogin();
		BMLogin.goToOpenAccount();
		OpenAccount opnacct = new OpenAccount();
		opnacct.selectCustomer(data.get("custname"), data.get("currency"));
		
		
		
		
	}
}
