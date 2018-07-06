package org.t360.testcases;

import org.junit.Assert;
import org.t360.controller.Controller;
import org.t360.pages.HomePage;
import org.t360.pages.LoginPage;
import org.t360.pages.MatterCreationWorkflowPage;
import org.t360.pages.MatterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MatterCreationWorkflowPageTest extends Controller {
	
	LoginPage loginpage;
	HomePage homepage;
	MatterCreationWorkflowPage mattercreationworkflowPage;
	MatterPage matterpage;
	
	@BeforeMethod
	public void start() {
	 initialize();
	 loginpage=new LoginPage();
	 homepage=loginpage.login("System Administrator");
	 mattercreationworkflowPage=homepage.navigateToMatterCreationWorkflowPage(homepage);
	}

	@AfterMethod
	public void shutdown(){
		driver.close();
	}
	
	@Test(priority=1, description="Test Case ID:3331")
	public void validateMatterCreationWorkflowPageTest()
	{
		Assert.assertTrue(mattercreationworkflowPage.validateMatterCreationWorkflowPage());
	}
	
	@Test(priority=2, description="Test Case ID:3332")
	public void addMatterTest(){
		matterpage=mattercreationworkflowPage.addMatter("temp matter7", "02 MF WA", "7/4/2018", mattercreationworkflowPage);
		Assert.assertTrue(matterpage.validateMatterPage());
	}
	
	
	
	
	
}
