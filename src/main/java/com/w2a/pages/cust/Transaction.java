package com.w2a.pages.cust;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.Page;

public class Transaction extends Page{

	
	
	public Transaction() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void Transaction(String credit, String debit)
	{
		
		
		click("transactionbtn_XPATH");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-bordered table-striped']")));
		
		WebElement startDate = driver.findElement(By.xpath("//*[@id=\"start\"]"));
		System.out.println(startDate.getText());
		WebElement endDate = driver.findElement(By.xpath("//input[@id='end']"));
		System.out.println(endDate.getText());
		
		boolean amountFound=false;
		boolean withdrawlFound=false;
		
		WebElement table = driver.findElement(By.xpath(OR.getProperty("transactionTbl_XPATH")));
		List <WebElement> rows =  table.findElements(By.tagName("tr"));
		for(WebElement row : rows)
		{
			List <WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell: cells)
			{
				if(cell.getText().contains(credit))
				{
					amountFound=true;
				}
				if(cell.getText().equals(debit))
				{
					withdrawlFound=true;
				}
			}
			
		}
		if (amountFound) {
            System.out.println(credit + " is found in the table.");
        } else {
            System.out.println(credit + " is not in the table.");
        }
		if (withdrawlFound) {
            System.out.println(debit + " is found in the table.");
        } else {
            System.out.println(debit + " is not in the table.");
        }
		
		click("backbtn_XPATH");
		
	}
		
	public void testReset()
	{
		
		click("transactionbtn_XPATH");
		click("resetbtn_XPATH");
		click("backbtn_XPATH");
		WebElement Balance = driver.findElement(By.xpath(OR.getProperty("balance_XPATH")));
		if(Balance.getText().contains("Balance : 0"))
		{
			System.out.println("Reset is success");
		}else
		{
			System.out.println("Reset is failure");
		}
	}
	
	public void testBack() {
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]")).click();
	}
}
