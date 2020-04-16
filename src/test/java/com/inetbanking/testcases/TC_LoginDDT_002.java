package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
         
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(user);
		logger.info("username is provided");
		lp.setpassword(pwd);
		logger.info("Password is provided");
		lp.login();
		
		Thread.sleep(3000);
		
		
		if(isalertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
			else
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.logout();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
			
			
			
		}
		
		
	
	
	public boolean isalertPresent()   //user defined method created to check alert is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
		
	}
	
	@DataProvider(name="LoginData")     //get data from excel file and store as 2 demensional array
	String[][] getdata() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/LoginData.xls";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for( int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getcelldata(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
