package com.w2a.rough;

import java.io.IOException;

import com.w2a.pages.HomePage;
import com.w2a.pages.bml.AddCustomer;
import com.w2a.pages.bml.BankManagerLogin;
import com.w2a.pages.bml.Customers;
import com.w2a.pages.bml.OpenAccount;
import com.w2a.pages.cust.CustomerDeposit;
import com.w2a.pages.cust.CustomerHome;
import com.w2a.pages.cust.CustomerWithdraw;
import com.w2a.pages.cust.Transaction;
import com.w2a.pages.cust.customerLogin;

public class LoginTest{
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//this is a rough page
		HomePage home = new HomePage();
		BankManagerLogin BMLogin = home.goToBankManagerLogin();
		BMLogin.goToAddCustomer();
		AddCustomer customer = new AddCustomer();
		customer.AddCustomer("Gattu", "iyer", "l4b8d9");
		BMLogin.goToOpenAccount();
		OpenAccount opnacct = new OpenAccount();
		opnacct.selectCustomer("Gattu iyer", "Rupee");
		BMLogin.goToCustomers();
		Customers cust = new Customers();
		cust.searchCustomer("Gattu");
		home.goToCustomerLogin();
		customerLogin clogin = new customerLogin();
		clogin.goToCustomerHome("Gattu iyer");
		CustomerHome custhome = new CustomerHome();
		custhome.checkBalance();
		custhome.goToDeposit();
		CustomerDeposit cd = new CustomerDeposit();
		cd.depositAmt("500");
		custhome.goToWithdrawl();
		CustomerWithdraw cw = new CustomerWithdraw();
		cw.withdraw("100");
		cw.withdraw("100");
		custhome.goToTransactions();
		Transaction ct = new Transaction();
		ct.Transaction("500", "100");
		custhome.checkBalance();
		ct.testReset();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
