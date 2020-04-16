package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//Webelements
	
	@FindBy(linkText="Edit Customer")
	@CacheLookup
	WebElement editcl;

	@FindBy(name="addr")
	@CacheLookup
	WebElement changeaddr;
	
	
	
	public void clickedit()
	{
		editcl.click();
	}
	public String addrchange(String address)
	{
		changeaddr.clear();
		changeaddr.sendKeys(address);
		return address;
	}
	

}
