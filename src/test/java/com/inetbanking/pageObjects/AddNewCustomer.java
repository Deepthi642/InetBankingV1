package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {
	
	WebDriver ldriver;

	public AddNewCustomer(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//webelements
	
	@FindBy(linkText="New Customer")
	@CacheLookup
	WebElement newcustlink;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement cutname;
	
	@FindBy(xpath=".//input[@value='f']")
	@CacheLookup
	WebElement cgender;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement cdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement caddr;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement ccity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement cstate;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement cpin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement ctelno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement cemail;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement cpassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement csubmit;
			
	public void clicknewcustomer()
	{
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		WebElement custlink = wait.until(ExpectedConditions.elementToBeClickable(newcustlink));
		custlink.click();
	}
	
	public void enterusername(String cname)
	{
		cutname.sendKeys(cname);
	}
	
	public void sgender()
	{
		cgender.click();
	}
	public void edob(String dd, String mm, String yyyy)
	{
		cdob.sendKeys(dd);
		cdob.sendKeys(mm);
		cdob.sendKeys(yyyy);
	}
	public void eaddr(String address)
	{
		caddr.sendKeys(address);
	}
	public void ecity(String city)
	{
		ccity.sendKeys(city);
	}
	public void estate(String state)
	{
		cstate.sendKeys(state);
	}
	public void epin(String pin)
	{
		cpin.sendKeys(String.valueOf(pin));
	}
	public void eteno(String tnumber)
	{
		ctelno.sendKeys(tnumber);
	}
	public void eemail(String email)
	{
		cemail.sendKeys(email);
	}
	public void epwd(String pwd)
	{
		cpassword.sendKeys(pwd);
	}
	public void esubmit()
	{
		csubmit.click();
	}
	
	
}
