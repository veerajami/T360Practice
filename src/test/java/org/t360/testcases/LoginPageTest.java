package org.t360.testcases;

import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends Controller{
	
	LoginPage loginpage;
	HomePage homepage;
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void start(){
		
		initialize();
		loginpage=new LoginPage();
		
	}
	
	@AfterMethod()
	public void shutdown()
	{
		driver.close();
	}
	
	
	@Test(priority=1, description="Test Case ID:1111")
	public void validateLoginPageTest(){
		Assert.assertTrue(loginpage.validateLoginPage());
	}
	
	@Test(priority=2, description="Test Case ID:1112")
	public void loginTest(){
		homepage=loginpage.login("System Administrator");
		Assert.assertTrue(homepage.validateUser("System Administrator"));
	}
	
}
