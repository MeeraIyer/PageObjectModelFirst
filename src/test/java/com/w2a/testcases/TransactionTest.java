package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.cust.CustomerHome;
import com.w2a.pages.cust.Transaction;
import com.w2a.utilities.TestUtil;

public class TransactionTest extends BaseTest{

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void transactionTest(Hashtable<String, String> data) throws IOException {
		
		CustomerHome custhome = new CustomerHome();
		custhome.goToTransactions();
		Transaction ct = new Transaction();
		ct.Transaction(data.get("depositamt"), data.get("withdrawamt"));
		custhome.checkBalance();
		ct.testReset();
		
		
	}
	
}
