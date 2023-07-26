package com.green.rfp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.green.rfp.qa.base.BaseClass;


public class DashboardVerificationPage extends BaseClass{

	public DashboardVerificationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDashboardPage(String user) {
		pause(3);
		
		boolean bool = false;
		String supportEmailIcon = "";
		String toolHelp = "";
		String activeRFP = "";
		String activeTemplates = "";
		String pendingTaskList = "";
		String acceptedTaskList = "";
		String completedRFP = "";
		String accessRequests = "";
		String messageCenter = "";
		
		switch(user){
		case "SuperAdmin":
			supportEmailIcon = driver.findElement(By.xpath("//md-icon[@aria-label='Support Email']")).getAttribute("aria-label");
			toolHelp = driver.findElement(By.xpath("//md-icon[@id='toolbar-help']")).getAttribute("aria-label");
			activeRFP = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[1]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[1]/ms-widget-front/div/div[1]")));
			activeTemplates = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[2]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[3]/ms-widget-front/div/div[1]")));
			pendingTaskList = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[3]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[4]/ms-widget-front/div/div[1]")));
			acceptedTaskList = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[4]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[5]/ms-widget-front/div/div[1]")));
			completedRFP = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[5]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[6]/ms-widget-front/div/div[contains(text(),'Message Center')]")));
			messageCenter = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[6]/ms-widget-front/div/div[1]")).getText().trim();
			break;
		case "CustomerAdmin":
			supportEmailIcon = driver.findElement(By.xpath("//md-icon[@aria-label='Support Email']")).getAttribute("aria-label");
			toolHelp = driver.findElement(By.xpath("//md-icon[@id='toolbar-help']")).getAttribute("aria-label");
			activeRFP = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[1]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[1]/ms-widget-front/div/div[1]")));
			activeTemplates = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[2]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[3]/ms-widget-front/div/div[1]")));
			pendingTaskList = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[3]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[4]/ms-widget-front/div/div[1]")));
			acceptedTaskList = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[4]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[5]/ms-widget-front/div/div[1]")));
			completedRFP = driver.findElement(By.xpath("//div[@id='widgets']/div/ms-widget[5]/ms-widget-front/div/div[1]")).getText().trim();
			scrollToElementTillTrue( driver.findElement(By.xpath("//div[contains(text(),'Message Center')]")));
			messageCenter = driver.findElement(By.xpath("//div[contains(text(),'Message Center')]")).getText().trim();
			break;
		
		}
		
		switch(user){
		case "SuperAdmin":
			if(supportEmailIcon.equalsIgnoreCase("Support Email") 
					&& toolHelp.equalsIgnoreCase("Help")
					&& activeRFP.equalsIgnoreCase("Active RFP's")
					&& activeTemplates.equalsIgnoreCase("Active Templates")
					&& pendingTaskList.equalsIgnoreCase("PENDING TASK LIST")
					&& acceptedTaskList.equalsIgnoreCase("ACCEPTED TASK LIST")
					&& completedRFP.equalsIgnoreCase("COMPLETED RFP'S")
					&& messageCenter.equalsIgnoreCase("MESSAGE CENTER")
			)
			{
				bool = true;
			}else {
				bool = false;
			}
			break;
		case "CustomerAdmin":
			System.out.println(supportEmailIcon);
			System.out.println(toolHelp);
			System.out.println(activeRFP);
			System.out.println(activeTemplates);
			System.out.println(pendingTaskList);
			System.out.println(acceptedTaskList);
			System.out.println(completedRFP);
			System.out.println(messageCenter);
			if(supportEmailIcon.equalsIgnoreCase("Support Email") 
					&& toolHelp.equalsIgnoreCase("Help")
					&& activeRFP.equalsIgnoreCase("ACTIVE RFP'S/BIDS")
					&& activeTemplates.equalsIgnoreCase("Active Templates")
					&& pendingTaskList.equalsIgnoreCase("PENDING TASK LIST")
					&& acceptedTaskList.equalsIgnoreCase("ACCEPTED TASK LIST")
					&& completedRFP.equalsIgnoreCase("COMPLETED RFP'S/BIDS")
					&& messageCenter.equalsIgnoreCase("MESSAGE CENTER")
					)
			{
				
				bool = true;
			}else {
				bool = false;
			}
			break;
		}
		 
		System.out.println(bool);
		return bool;
	}
	
}
