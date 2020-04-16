package stepdefi;

import org.testng.Assert;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.testcases.BaseClass;

import cucumber.api.java.en.*;

public class StepDefin extends BaseClass {
	
	@Given("^initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Initalised chrome browser");
	}

	@Given("^navigate to baseurl site$")
	public void navigate_to_site() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("url is opened");
	    
	}

	@Given("^click on login link in home page to land on signin page$")
	public void click_on_login_link_in_home_page_to_land_on_signin_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("Username is entered");
		lp.setpassword(password);
		logger.info("password is entered");
		lp.login();
		
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

	@When("^user enters username and password and logsin$")
	public void user_enters_and_and_logsin() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("Signed in");
	    
	}

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println("successfully signed in");

	}



}
