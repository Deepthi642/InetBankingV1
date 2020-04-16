package com.inetbanking.testcases;

import java.io.IOException;

//import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	@Test
	public void addnewcust() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("URL is launched");
		lp.setusername(username);
		logger.info("username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		lp.login();
		
		//Thread.sleep(3000);
		
		AddNewCustomer ad = new AddNewCustomer(driver);
		
		ad.clicknewcustomer();
		logger.info("New customer page got opened");
		
		String userName = randomstring();
		ad.enterusername(userName);
		logger.info("Entered user name");
		ad.sgender();
		logger.info("gender selected");
		ad.edob("05", "05", "2009");
		logger.info("Entered date of birth");
		//Thread.sleep(3000);
		
		ad.eaddr("INDIA");
		logger.info("Entered address");
		ad.ecity("Hyderabad");
		logger.info("entered city");
		ad.estate("Andhra");
		logger.info("entered state");
		ad.epin("560045");
		logger.info("entered pin");
		ad.eteno("9848969507");
		logger.info("entered telephone number");
		//ad.eemail("keerthic@gmail.com");
		
		String email = randomstring()+"@gmail.com";
		ad.eemail(email);      
		//creates random email
		
		logger.info("entered email");
		
		ad.epwd("Deepu@1998");
		logger.info("Entered password");
		ad.esubmit();
		logger.info("Successfully submitted");
		
		Thread.sleep(3000);
		
		
		 
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			/*WebElement custid = driver.findElement(By.xpath("html/body/table[2]/tr[4)/td[2]"));
			String cuid = custid.getText();
			System.out.println("custid ="+cuid);*/
			
		}
		else
		{
			captureScreen(driver, "addnewcust");
			Assert.assertTrue(false);
		}
		
		
				
		
	}
	
	
	

}
