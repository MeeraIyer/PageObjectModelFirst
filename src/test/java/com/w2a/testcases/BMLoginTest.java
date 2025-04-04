package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.pages.HomePage;
import com.w2a.pages.bml.AddCustomer;
import com.w2a.pages.bml.BankManagerLogin;
import com.w2a.utilities.TestUtil;


public class BMLoginTest extends BaseTest{
	
	@Test
	public void bmloginTest() throws IOException{
		
		HomePage home = new HomePage();
		BankManagerLogin BMLogin = home.goToBankManagerLogin();
		BMLogin.goToAddCustomer();
		
		
	
		
	}

}

