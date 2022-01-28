package com.akBanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.akBanking.pageObjects.AddCustomerPage;
import com.akBanking.pageObjects.LoginPage;

public class TC_AddCustomertest_003 extends BaseClass {

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details");
		addcust.custName("Akhil");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		String email = randomString()+"@yopmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");	
		addcust.custsubmit();
		
		logger.info("Validation started");
		try
		{
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		Thread.sleep(5000);
		
		if(result == true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			System.out.println("inside failed else loop");	
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
		}
		catch (Exception e) {
			System.out.println("Inside exception");
			System.out.println(e);
			Assert.assertTrue(false);
			captureScreen(driver, "addNewCustomer");
			logger.info("Test case failed");
		}
	}
	
	
	
}
