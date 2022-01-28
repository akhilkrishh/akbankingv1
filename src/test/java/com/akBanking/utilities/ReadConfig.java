package com.akBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
			
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
}
