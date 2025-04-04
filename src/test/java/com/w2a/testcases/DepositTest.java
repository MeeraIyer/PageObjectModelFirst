package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.cust.CustomerDeposit;
import com.w2a.pages.cust.CustomerHome;
import com.w2a.utilities.TestUtil;

public class DepositTest extends BaseTest{

	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void depositTest(Hashtable<String, String> data) throws IOException, InterruptedException {
		
		
		CustomerHome custhome = new CustomerHome();
		custhome.goToDeposit();
		CustomerDeposit cd = new CustomerDeposit();
		cd.depositAmt(data.get("depositamt"));
		
	}
	
	
	
	
}
