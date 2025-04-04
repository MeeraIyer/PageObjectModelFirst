package com.w2a.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.w2a.pages.HomePage;

public class GoToCustLoginTest extends BaseTest {

	@Test
	public void goToCustLoginTest() throws IOException {
		
	HomePage home = new HomePage();
	home.goToCustomerLogin();
	
	}
}
