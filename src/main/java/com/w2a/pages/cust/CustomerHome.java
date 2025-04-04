package com.w2a.pages.cust;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;

public class CustomerHome extends Page{

	public CustomerHome() throws IOException {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	public CustomerDeposit goToDeposit() throws IOException
	{
		click("depositbtn_XPATH");
		
		return new CustomerDeposit();
	}
	
	public  CustomerWithdraw goToWithdrawl() throws IOException
	{
		click("withdrawlbtn_XPATH");
		
		return new CustomerWithdraw();
	}
	
	public Transaction goToTransactions() throws IOException
	{
		click("transaction_XPATH");
		return new Transaction();
	}
	
	public void checkBalance()
	{
		WebElement Balance = driver.findElement(By.xpath(OR.getProperty("balance_XPATH")));
		System.out.println(Balance.getText());
	}
	
	public void logout()
	{
		click("logoutbtn_XPATH");
	}
}
