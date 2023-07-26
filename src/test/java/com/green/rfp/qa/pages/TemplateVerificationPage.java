package com.green.rfp.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.green.rfp.qa.base.BaseClass;



public class TemplateVerificationPage extends BaseClass {
	
	
	public TemplateVerificationPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='NEW QUESTION']") WebElement newque_btn;
	@FindBy(xpath = "//button[text()='NEW QUESTION']") WebElement import_btn;
	
	public boolean verifySidenavigation(){
		pause(2);
		boolean bool= false;
		List<WebElement> alloptions= driver.findElements(By.xpath("(//ul[@class='ng-scope'])[1]/li[(@aria-hidden='false')]//span"));
		String s1=alloptions.get(0).getText();
		String s2=alloptions.get(1).getText();
		String s3=alloptions.get(2).getText();
		String s4=alloptions.get(3).getText();
		String s5=alloptions.get(4).getText();
		String s6=alloptions.get(5).getText();
		System.out.println(s1+"\n"+"\n"+s2+"\n+"+s3+"\n"+s4+"\"n"+s4+"\n"+s5+"\n"+s6);
		
		pause(2);
		if(s1.equalsIgnoreCase("Dashboard") && s2.equalsIgnoreCase("Template") && s3.equalsIgnoreCase("RFP's/Bids") && s4.equalsIgnoreCase("Reports") && s5.equalsIgnoreCase("Administration") && s6.equalsIgnoreCase("Notifications"))
		{
			bool=true;
		}
		return bool;
	}
	
	public boolean verifyEditAndDeleteIconForContentSection(String sectionContentName) {
		pause(3);
		boolean bool = false;
		if(driver.findElement(By.xpath("//*[contains(text(),'"+sectionContentName+"')]/../following-sibling::div/span/button[@aria-label='Edit Section']")).isDisplayed()
		&& driver.findElement(By.xpath("//*[contains(text(),'"+sectionContentName+"')]/../following-sibling::div/span/button[@aria-label='Delete Section']")).isDisplayed()) {
			testCaselog("-----Edit and delete icon verification after adding section content: PASSED-----");
			testCaselog("Edit Icon : Displayed for section = "+sectionContentName);
			testCaselog("Delete Icon : Displayed for section = "+sectionContentName);
			bool = true;
		}else {
			testCaselog("-----Edit and delete icon verification after adding section content: FAILED-----");
			testCaselog("Edit Icon : Not Displayed for section = "+sectionContentName);
			testCaselog("Delete Icon : Not Displayed for section = "+sectionContentName);
		}
		return bool;
	}
	
public boolean verifyEmailIconForSME(String sectionName, int rownum) {
		
		pause(2);
		boolean bool = false;
		if(driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//md-icon[contains(@class,'orange') and @aria-label='icon-email']")).isDisplayed()) {
			bool = true;
		}
		return bool;
	}

public boolean verifyCompletionPercentage(String templateName,String percentage)
{
		
	pause(3);
	boolean bool=false;
	
	pause(3);
     scrollToElement( driver.findElement(By.xpath("(//td[1]/span/a[contains(text(),'"+templateName+"')]/../../following-sibling::td)[3]")));
     pause(2);
 	testInfoLog("Expectec Percentage: "+ percentage);
	testInfoLog("Actual Percentage: "+ driver.findElement(By.xpath("(//td[1]/span/a[contains(text(),'"+templateName+"')]/../../following-sibling::td)[3]//span")).getText());
	if((driver.findElement(By.xpath("(//td[1]/span/a[contains(text(),'"+templateName+"')]/../../following-sibling::td)[3]//span")).getText()).equals(percentage))
	{
		bool= true;
	}
	return bool;
}

public boolean verifyNotificationfromNotificationslinkNew(String templateName,String status)
{
	List<WebElement> notification = driver.findElements(By.xpath("//div[@id='templates-list']//tr[1]/td[3]/span/p/a"));

	return 	notification.get(0).getText().equals(templateName)	
			&& notification.get(1).getText().equals(status);			
}

public boolean verifyNotificationfromBellRingNew(String templateName,String status)
{
	List<WebElement> notification = driver.findElements(By.xpath("//div[@id='notification-popup']/div[1]/p/a"));

	return 	notification.get(0).getText().equals(templateName)	
			&& notification.get(1).getText().equals(status);
}

public boolean verifyNotificationformMessagecenterNew(String templateName,String status,String notificationStatus)
{
	List<WebElement> notification = driver.findElements(By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/a"));
	WebElement Status = driver.findElement(By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"+notificationStatus+"')]"));
	
	return 	notification.get(0).getText().equals(templateName)
			&& notification.get(1).getText().equals(status)
			&& Status.isDisplayed();
	//span/p[contains(text(),'A task in the template')]/a[1][contains(text(),'noti')]/../a[2][contains(text(),'assigned')]/../a[3][contains(text(),'QA-Testing')]/../a[4][contains(text(),'CAdmin')]
}

public boolean verifyNotificationformPopupNew(String templateName,String status)
{

	List<WebElement> notification = driver.findElements(By.xpath("//span[@ng-bind-html='notification_message']/p/a"));

	return 	notification.get(0).getText().equals(templateName)	
			&& notification.get(1).getText().equals(status);
}

public boolean verifyNotificationcount(String count)
{
	int count1 =Integer.parseInt(count);
	int count2 = count1-1;	
	String newCount=String.valueOf(count2);
	pause(3);
	return 	driver.findElement(By.xpath("//span[@class='child-badge ng-binding ng-scope']")).getText().equals(newCount) ;
}

public boolean verifyApprovedIcon(String sectionName) {
	
	pause(7);
	boolean bool = false;
	String approvedLabelText = driver.findElement(By.xpath("(//span[text()='"+sectionName+"']/following-sibling::md-icon)[1]")).getAttribute("aria-label");
	System.out.println("----------approvedLabelText---"+approvedLabelText);
	
	if(approvedLabelText.equalsIgnoreCase("Approved")) {
		bool = true;
	}
	return bool;
}

public boolean verifyTaskAcceptedIconBySME(String sectionName) {
	
	pause(2);
	boolean bool = false;
	if(driver.findElement(By.xpath("//md-icon[contains(@aria-label,'Task Accepted')]")).isDisplayed()) {
		bool = true;
	}
	return bool;
}

public boolean verifyEditedQuePresentAtReviewTab(String question) {
	pause(3);
	return driver.findElement(By.xpath("(//span[contains(text(),'"+question+"')])[2]")).isDisplayed();
	}

public boolean verifyLogDisplayed(String log) {
	pause(2);
	return driver.findElement(By.xpath("//th[contains(text(),'User')]/../../..//td[contains(text(),'"+log+"')]")).isDisplayed();
	}

public boolean verifyEditedQuePresent(String question) {
	pause(3);
	return driver.findElement(By.xpath("//span[text()='"+question+"']")).isDisplayed();
	}


public boolean verifyTaskRejectedIconByApprover() {
	pause(3);
	boolean bool = false;
	if(driver.findElement(By.xpath("//label[contains(text(),'REJECTED')]")).isDisplayed()) {
		bool = true;
	}
	return bool;
}

public boolean verifyApproveAndRejectButton(String question,String sectionname)
{
	pause(2);
	scrollToElement( driver.findElement(By.xpath("//div[contains(text(),'"+sectionname+"')]")));
	return 	driver.findElement(By.xpath("//span[text()='"+question+"']/../../..//button[contains(text(),'Approve')]")).isDisplayed() &&
			driver.findElement(By.xpath("//span[text()='"+question+"']/../../..//button[contains(text(),'Reject')]")).isDisplayed();
			
}

public boolean verifyTaskPendingIcon()
{
	pause(2);
	boolean bool = false;
	if(visibilityOfElementLocated( By.xpath("//md-icon[contains(@aria-label,'Task Pending') and contains(@class,'orange')]")));
	{
		bool=true;
	}
	
	return bool;
}


public boolean verifyImportedQuestionAndDeleteIcon() {
	
	pause(2);
	boolean bool = false;
	if(driver.findElement(By.xpath("//span[contains(text(),'Book1.xlsx')]")).isDisplayed() && driver.findElement(By.xpath("(//md-icon[@md-font-icon='icon-trash' and @aria-label='icon-trash'])[2]")).isDisplayed()) {
		bool = true;
	}
	return bool;
}
public boolean verifysmeInvitationMail()
{
	return 	driver.findElement(By.xpath("(//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'GreenRFP: SME invitation')])[1]")).isDisplayed() ;
}

public boolean verifyReassignTaskisnotDisplayinPendingTab(String templateName) {
	pause(3);
	boolean bool = false;
	if(invisibilityOfElementLocated(By.xpath("//a[contains(text(),'Introduction')]/ancestor::tr//a[text()='"+templateName+"']/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Reassign']"),30)) {
		bool = true;
	}
	return bool;
}

public boolean verifyReassignTaskisDisplayinAnotherSMEPendingTab(String templateName) {
	pause(3);
	boolean bool = false;
	if(visibilityOfElementLocated(By.xpath("//a[contains(text(),'Introduction')]/ancestor::tr//a[text()='"+templateName+"']/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Reassign']"))) {
		bool = true;
	}
	return bool;
}

public boolean verifyReassignIconPresent(String user) {
	pause(3);
	boolean bool = false;
	if(driver.findElement(By.xpath("//md-icon[@md-font-icon='icon-rotate-right']")).isDisplayed() && driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]")).isDisplayed()) {
		bool = true;
	}
	return bool;
}
public boolean verifycheckPublishScreenDisplay() {
	
	pause(3);
	boolean bool=false;
	scrollToElement( driver.findElement(By.xpath("//h4[contains(text(),'SUMMARY')]")));
	
	if(visibilityOfElementLocated(By.xpath("//h4[contains(text(),'SUMMARY')]"))) {
		bool = true;
	}
	return bool;
	
}

public boolean verifyNoTemplateFoundMessageDisplays() {
	pause(3);
	return driver.findElement(By.xpath("//div[@id='templates-list']/div[3]/div/div/div/p")).getText().contains("NO TEMPLATES FOUND") && 
			invisibilityOfElementLocated( By.xpath("//md-select[@ng-model='vm.sort']"), 7);
}
public boolean verifyReassingTaskRemovedFromDashboad(String templateName) {
	pause(3);
	boolean bool = false;
	if(invisibilityOfElementLocated(By.xpath("//a[@title='Go to Template'][contains(text(),'"+templateName+"')]"),30)) {
		bool = true;
	}
	return bool;
}

public boolean verifyReassinedApprover3IsDisplay() {
	pause(3);
	boolean bool = false;
	String approverName = driver.findElement(By.xpath("//li[contains(@ng-repeat,'approver')]/div/div/div/span[2]")).getText();
	if(approverName.equalsIgnoreCase("QaNarola approver3") && 
			driver.findElement(By.xpath("//span[contains(text(),'QaNarola approver3')]/../../../div[2]/span/md-icon[contains(@class,'orange')]")).isDisplayed()
			) 
	{
		bool = true;
	}
	return bool;
}

public boolean verifyNewQuestionbuttonEnabled(){
	pause(3);
	boolean bool= false;
	if (newque_btn.isEnabled()) {
		bool=true;
		
	} 
	return bool;
}

public boolean verifyImportButtonEnabled(){
	pause(3);
	boolean bool= false;
	if (import_btn.isEnabled()) {
		bool=true;
		
	} 
	return bool;
}

public boolean verifyTaskacceptedIcon(int iconnumber)
{
	pause(2);
	boolean bool = false;
	if(visibilityOfElementLocated( By.xpath("//md-icon[contains(@aria-label,'Task Accepted')]['"+iconnumber+"']")));
	{
		bool=true;
	}
	
	return bool;
}


public boolean verifyQuestionAdded() {
	
	pause(2);
	boolean bool = false;
	
	if(driver.findElement(By.xpath("//tbody[@ui-sortable='assigned_questions_sort']//span[contains(text(),'question 1')]")).isDisplayed()) {
		bool = true;
	}
	return bool;
}
public boolean verifyCommentCount(String question) {
	
	return driver.findElement(By.xpath("//span[contains(text(),'"+question+"')]/../../../..//span[text()=1 and @ng-if='question.comments_count > 0']")).isDisplayed();
	}

public boolean verifyCommentFromTemplateCreated(int comment_row_num) {
	pause(2);
	boolean bool = false;
	
	scrollToElementTillTrue( driver.findElement(By.xpath("//button[@aria-label='Comment']")));
		pause(2);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@aria-label='Comment']")));
		pause(2);
		String user_for_comment = driver.findElement(By.xpath("//div[contains(@ng-repeat,'popup_comments')]["+comment_row_num+"]/div/div[1]")).getText();
		String received_comment = driver.findElement(By.xpath("//div[contains(@ng-repeat,'popup_comments')]["+comment_row_num+"]/div/div[2]")).getText();
		if(globalMap.get("givenComment").equalsIgnoreCase(received_comment)
				&& globalMap.get("user").equalsIgnoreCase(user_for_comment)){
		bool = true;
		}
	
	return bool;
}

public boolean verifyNeedsTab(String sectionname)
{
	pause(2);
	scrollToElement( driver.findElement(By.xpath("//md-tab-item[contains(text(),'"+sectionname+"')]")));
	visibilityOfElementLocated( By.xpath("//md-tab-item[contains(text(),'"+sectionname+"')]"));
	return 	driver.findElement(By.xpath("//md-tab-item[contains(text(),'"+sectionname+"')]")).isDisplayed() ;				
}

public boolean verifyApproverInvitationMail()
{
	return 	driver.findElement(By.xpath("(//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'GreenRFP: Approver invitation')])[1]")).isDisplayed() ;
}

public boolean verifyOrangeColorForEmailIcon()
{
	return 	driver.findElement(By.xpath("//md-icon[contains(@class,'orange')]")).isDisplayed() ;
}

public boolean verifyPendingTaskIconForSME(String sectionName, int rownum) {
	
	pause(2);
	boolean bool = false;
	if(driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//md-icon[contains(@class,'orange') and @aria-label='Task Pending']")).isDisplayed()) {
		bool = true;
	}
	return bool;
}

public boolean verifyPlusIconForSME(String sectionName, int rownum) {
	
	pause(2);
	boolean bool = false;
	if(driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//button[contains(@class,'green') and @aria-label='Add New SME']")).isDisplayed()) {
		bool = true;
	}
	return bool;
}

public boolean verifyResendReassignDeleteIcons(String sectionName, int rownum) {
	
	pause(2);
	boolean bool = false;
	if(driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//button[@aria-label='Resend']")).isDisplayed() && driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//button[@aria-label='Reassign']")).isDisplayed() && driver.findElement(By.xpath("//td[contains(text(),'"+sectionName+"')]/following-sibling::td/div["+rownum+"]//button[@aria-label='Delete SME']")).isDisplayed()) {
		bool = true;
	}
	return bool;
}

}