package com.w2a.pages.bml;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;

public class Customers extends Page{
	

	public Customers() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void searchCustomer(String customer)
	{
		type("searchCust_XPATH", customer);
		boolean nameFound = false;
		WebElement table = driver.findElement(By.xpath(OR.getProperty("custTable_XPATH")));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row : rows)
		{
			
			List <WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) {
		            if (cell.getText().contains(customer)) {
		                nameFound = true;
		                break;
		            }
		        }
		
        }
		if (nameFound) {
            System.out.println(customer + " is found in the table.");
        } else {
            System.out.println(customer + " is not in the table.");
        }
		
	}
	
	public void deleteCustomer(String customer)
	{
		type("searchCust_XPATH", customer);
		WebElement table = driver.findElement(By.xpath(OR.getProperty("custTable_XPATH")));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row : rows)
		{
			
			List <WebElement> cells = row.findElements(By.tagName("td"));
			 for (WebElement cell : cells) {
				 if(cell.getText().contains(customer))
				 {
					 WebElement deleteButton = row.findElement(By.xpath("./td[last()]/button")); // Adjust the tag if the delete button is a link or other element
		                deleteButton.click();
		                System.out.println("Delete button clicked for customer: " + customer);
		                break;
				 }
			 }
		}
	}
	
}
