package com.akBanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.akBanking.pageObjects.LoginPage;
import com.akBanking.utilities.XLUtils;

public class TC_LogintestDP_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String password) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();//close alert
			captureScreen(driver, "loginDDT");
			driver.switchTo().defaultContent();
			logger.info("Info Login failed");
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			logger.info("Login passed");
		}
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	public String [][] getdata() throws IOException
	{
		System.out.println("inside dp");
		String path = System.getProperty("user.dir")+"/src/test/java/com/akBanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(rownum);
		System.out.println(colcount);
		String logindata[][] = new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j = 0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				System.out.println(logindata[i-1][j]);
			}
		}
		return logindata;
	}

}
