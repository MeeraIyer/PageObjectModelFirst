package com.w2a.pages.cust;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.Page;

public class CustomerWithdraw extends Page{
	
	public CustomerWithdraw() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void withdraw(String withdrawl) throws InterruptedException
	{
		type("withdrawamt_XPATH", withdrawl);
		click("withdrawSubmit_XPATH");
		Thread.sleep(15000);
		WebElement withdraw = driver.findElement(By.xpath(OR.getProperty("withdrawTitle_XPATH")));
		
		if(withdraw.getText().equals("Transaction successful"))
		{
			System.out.println("Withdrawl is successful");
		}else
		{
			System.out.println("Withdrawl is unsuccessful");
		}
	}
}
