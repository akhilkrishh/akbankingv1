package com.akBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name ="uid")
	WebElement txtUsername;
	
	@FindBy(name ="password")
	WebElement txtPassword;
	
	@FindBy(name ="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText = "Log out")
	WebElement lnklogout;
	
	
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
}
		