package com.w2a.pages.cust;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.w2a.base.Page;

public class customerLogin extends Page{

	
	
	public customerLogin() throws IOException {
	super();
		// TODO Auto-generated constructor stub
	}

	public CustomerHome goToCustomerHome(String customer) throws IOException
	{
		select("selectCust_XPATH", customer);
		click("loginbtn_XPATH");
		WebElement title = driver.findElement(By.xpath(OR.getProperty("custTitle_XPATH")));
		if(title.getText().contains(customer))
		{
			System.out.println(title.getText());
		}else
		{
			System.out.println(customer +"is not in the title");
		}
		return new CustomerHome();
	}
	
	
	
	
}
