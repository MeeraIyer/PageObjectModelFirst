package com.w2a.pages.cust;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.Page;

public class CustomerDeposit extends Page{
	
	public CustomerDeposit() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void depositAmt(String amount) throws InterruptedException {
	
		type("depositamt_XPATH", amount);
		click("depositSubmit_XPATH");
		Thread.sleep(10000);
		WebElement deposit = driver.findElement(By.xpath(OR.getProperty("depositTitle_XPATH")));
	
	if(deposit.getText().equals("Deposit Successful"))
	{
		System.out.println("Deposit is successful");
	}else
	{
		System.out.println("Deposit is unsuccessful");
	}
	
	}
}
