package com.akBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.akBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	// public String baseURL = "http://demo.guru99.com/V4/index.php";
	// public String username = "mngr377226";
	// public String password = "jutYvEj";

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String brwsr) {

		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		// driver = new ChromeDriver();

		logger = Logger.getLogger("abanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (brwsr.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
			System.out.println("Chrome Browser");
		} else if (brwsr.equals("firefox")) {
			System.setProperty("webdriver.geko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		
		
		//driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		System.out.println("Inside screenshot fn");
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");	
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedNumber;
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
