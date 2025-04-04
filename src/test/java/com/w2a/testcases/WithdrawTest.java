package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.cust.CustomerHome;
import com.w2a.pages.cust.CustomerWithdraw;
import com.w2a.utilities.TestUtil;

public class WithdrawTest extends BaseTest {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void withdrawTest(Hashtable<String, String> data) throws IOException, InterruptedException {
		
		CustomerHome custhome = new CustomerHome();
		custhome.checkBalance();
		custhome.goToWithdrawl();
		CustomerWithdraw cw = new CustomerWithdraw();
		cw.withdraw(data.get("withdrawamt"));
		
	}
	
	
}
