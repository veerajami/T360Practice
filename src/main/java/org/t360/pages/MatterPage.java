package org.t360.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;

public class MatterPage extends Controller{

	public MatterPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Matter:')]")
	WebElement matter_text;
	
	public boolean validateMatterPage(){
		
		driver.switchTo().frame(2);
		return matter_text.isDisplayed();
	}
}
