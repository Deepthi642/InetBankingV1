package com.inetbanking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	//LoginPage lp = new LoginPage(driver);
	
	@Test
	public void logintest() throws InterruptedException, IOException
	{
		//driver.get(baseurl);
		
		//logger.info("URL  is opened");
		//driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		//Thread.sleep(5000);
		
		//lp.clickcross();
		
		lp.setusername(username);
		logger.info("Username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		lp.login();
		//Thread.sleep(1000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test is passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login test is failed");
		}
	}

}
