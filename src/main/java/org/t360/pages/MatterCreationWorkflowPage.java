package org.t360.pages;

import java.util.Set;

import org.apache.commons.net.imap.IMAPClient.SEARCH_CRITERIA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.t360.controller.Controller;

public class MatterCreationWorkflowPage extends Controller{
	
	

	
	@FindBy(xpath="//div[text()='Matter Creation Workflow']")
	WebElement matterCreationWorkflow_text;
	
	@FindBy(xpath="//tr[@class='Header']/td[text()='Matter System Fields']")
	WebElement matterSystemFields_text;
	
	@FindBy(xpath="//input[@name='MatterNameTextBox']")
	WebElement matterName_textbox;
	
	@FindBy(xpath="//input[@name='WorkareaPopupTreeControl:SelectedNodeName']")
	WebElement workArea_textbox;
	
	
	@FindBy(xpath="//input[@name='WorkareaPopupTreeControl:PopupButton']")
	WebElement workArea_popupButton;

	@FindBy(xpath="//input[@value='Next']")
	WebElement next_button;
	
	@FindBy(xpath="//input[@value='Finish']")
	WebElement finish_button;
	
	@FindBy(xpath="//input[@name='MatterOpenDatePicker']")
	WebElement matterOpenDate_textbox;
	
	@FindBy(xpath="//select[@id='dfcontrol_786']")
	WebElement df_4_dropdown;
	
	MatterCreationWorkflowPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMatterCreationWorkflowPage(){
		
		driver.switchTo().frame(2);
		return matterCreationWorkflow_text.isDisplayed();
		
	}
	
	public MatterPage addMatter(String matter_name, String workarea, String date, MatterCreationWorkflowPage mattercreationworkflowPage){
		
		driver.switchTo().frame(2);
		matterName_textbox.sendKeys(matter_name);
		workArea_popupButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MatterCreationWorkflowPage.WorkAreaTreePopup workareatreepopup=mattercreationworkflowPage.new WorkAreaTreePopup();
		mattercreationworkflowPage=workareatreepopup.selectWorkArea(mattercreationworkflowPage, workarea, workareatreepopup);
		
		matterOpenDate_textbox.sendKeys(date);
		finish_button.click();
		return new MatterPage();
		
		
	}
	
//************************************************************ Work Area Tree Popup *************************************************************
	
	public class WorkAreaTreePopup{
		
		
		public WorkAreaTreePopup(){
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[text()='Matter Creation Workflow']")
		WebElement matterCreationWorkflow_text;
		
		@FindBy(xpath="/div[@class='modal in ui-draggable FramedDialog']")
		WebElement workArea_popup;
		
		@FindBy(xpath="//input[@name='SearchForTextBox']")
		WebElement searchbox;
		
		@FindBy(xpath="//button[@value='SearchPanel.searchButton']")
		WebElement search_button;
		
		public WebElement workArea_link;
		
		@FindBy(xpath="//input[@class='Button SubmitButton']")
		WebElement select_button;
		
		@FindBy(xpath="//input[@value='Cancel']")
		WebElement cancel_button;
		
		@FindBy(xpath="//input[@value='Tree View']")
		WebElement treeView_button;
		
		public MatterCreationWorkflowPage selectWorkArea(MatterCreationWorkflowPage mattercreationworkflowPage, String workarea,WorkAreaTreePopup workareatreepopup){
			
            workArea_popup.findElement(By.xpath("//div[text()='Matter Creation Workflow']"));
			System.out.println(driver.findElement(By.xpath("//td[text()='Work Area Tree']")).getText());
			searchbox.sendKeys(workarea);
			workareatreepopup=clickOnSearchButton();
			workArea_link=driver.findElement(By.xpath("//a[text()='"+workarea+"']"));
			workArea_link.click();
			select_button.click();
			
			return new MatterCreationWorkflowPage();
		}
		
		public WorkAreaTreePopup clickOnSearchButton(){
			
			search_button.click();
			
			return new WorkAreaTreePopup();
		}
		
		
		
	}
	
	
//**************************************************************************************************************************************************************************
/*	
	
	@FindBy(xpath="//select[@id='MonthSelect']")
	WebElement calender_monthSelect_dropdown;

	@FindBy(xpath="//select[@id='YearSelect']")
	WebElement calender_yearSelect_dropdown;
	

	
	@FindBy(xpath="//tr[td[label[text()='Matter Name:']]]//span")
	WebElement matterName_text;
	
	@FindBy(xpath="//tr[td[label[text()='Open Date:']]]//span")
	WebElement openDate_text;
	
	@FindBy(xpath="//tr[td[label[text()='Matter Number:']]]//span")
	WebElement matterNumber_number;
	

	

	*/
	
	
}
