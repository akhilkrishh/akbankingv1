package com.akBanking.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.akBanking.pageObjects.LoginPage;

public class TC_Logintest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is entered");
		
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			System.out.println(driver.getTitle());
			Assert.assertTrue(true);
			logger.info("Login test is passed");
		}
		else
		{
			System.out.println("Inside failed function");
			logger.info("Login test is failed");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			
			
		}
		//captureScreen(driver, "loginTest");
	}

}
