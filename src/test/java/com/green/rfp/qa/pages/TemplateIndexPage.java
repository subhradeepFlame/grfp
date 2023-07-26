package com.green.rfp.qa.pages;

import java.awt.AWTException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.green.rfp.qa.base.BaseClass;

import com.green.rfp.qa.utility.XLUtils;

public class TemplateIndexPage extends BaseClass {

	public TemplateIndexPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Create']")
	WebElement create_btn;
	@FindBy(name = "name")
	WebElement name_field;
	@FindBy(xpath = "//textarea[@name='description']") // Not Working
	WebElement description_field;
	@FindBy(name = "section_name")
	WebElement section_name_field;
	@FindBy(xpath = "//button[contains(@ng-click,'section_name')]")
	WebElement section_plus_btn;
	@FindBy(xpath = "//input[@placeholder = 'Add User or Email ID']")
	WebElement sme_field;
	@FindBy(xpath = "(//ul[@class='md-autocomplete-suggestions']/li)[1]")
	WebElement sme_autofill;
	@FindBy(xpath = "//md-select[@aria-label='Permission']")
	WebElement permissions_field;
	@FindBy(xpath = "//div[text()='Add Questions']")
	WebElement add_questions_permission;
	@FindBy(xpath = "//button[@aria-label='Add New SME']")
	List<WebElement> add_sme_button;
	@FindBy(xpath = "//button[contains(text(),'Help my SME')]")
	WebElement help_my_sme_btn;
	@FindBy(xpath = "//md-step-label-wrapper[@class='SMEs']")
	WebElement smes_bubble;

	@FindBy(xpath = "//div[contains(@ng-if,'vm.answer_type')]//md-radio-button[@aria-label='Yes']")
	WebElement yes_radio_btn;
	@FindBy(xpath = "//md-select[contains(@aria-label,'Question Weight')]")
	WebElement questionWeightField;
	@FindBy(xpath = "(//md-select[contains(@aria-label,'Select Section')])[3]")
	WebElement selectSectionField;
	@FindBy(xpath = "//md-option[@value='Yes/No']")
	WebElement yesNoOption;

	@FindBy(xpath = "//md-option[@value='Medium']")
	WebElement mediumQuestionWeightOption;
	@FindBy(xpath = "//label[contains(text(),'Question')]/following::div/textarea")
	WebElement questionTextArea;
	@FindBy(xpath = "//form[@name='newQuestionForm']//button[contains(text(),'Save')]")
	WebElement questionSaveButton;
	@FindBy(xpath = "//md-select[@placeholder='Select']")
	WebElement select_btn;
	@FindBy(xpath = "//div[text()='Correct']")
	WebElement correct_btn;
	@FindBy(xpath = "//*[@placeholder='Log In As']")
	WebElement log_in_as_btn;
	@FindBy(xpath = "//div[@id='suggestive_pop']/md-content[1]/md-list[1]/md-list-item[1]/div[1]/button[1]")
	WebElement qa_testing_btn;
	@FindBy(xpath = "//md-select[@placeholder='Select User']")
	WebElement select_user_btn;
	@FindBy(xpath = "//md-option/div[text()='QA approver1']")
	WebElement qa_approver1_btn;

	@FindBy(xpath = "//button[text()[normalize-space()='Go']]")
	WebElement go_btn;
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yes_btn;
	@FindBy(className = "icon-window-close")
	WebElement remote_close_btn;
	@FindBy(xpath = "//div[contains(text(),'Pending Task List')]")
	WebElement pendingTaskListLabel;
	@FindBy(xpath = "//div[contains(text(),'Accepted Task List')]")
	WebElement acceptedTaskListLabel;
	@FindBy(xpath = "(//grammarly-ghost/following::textarea)[1]")
	WebElement textareaCursor;
	@FindBy(xpath = "//button[text()='NEW QUESTION']")
	WebElement newQuestion_btn;
	@FindBy(xpath = "//md-step-label-wrapper[@class='Review']")
	WebElement temp_review_bubble;
	@FindBy(xpath = "(//button[text()='Approve All'])[1]")
	WebElement approveAllButton;
	@FindBy(xpath = "(//button[contains(text(),'APPROVE')])[1]")
	WebElement approveButton;
	@FindBy(xpath = "//md-step-label-wrapper[@class='Publish']")
	WebElement temp_publish_bubble;
	@FindBy(xpath = "//button[contains(text(),'PUBLISH')]")
	WebElement temp_publish_btn;
	@FindBy(xpath = "//button[text()='Got It']")
	WebElement gotIt_btn;
	@FindBy(xpath = "//button[@aria-label='Delete']")
	WebElement delete_btn;
	@FindBy(xpath = "//md-step-label-wrapper[@class='Approvers']")
	WebElement approver_bubble;
	@FindBy(xpath = "//button[contains(text(),'ACCEPT')]")
	WebElement accept_btn;
	@FindBy(xpath = "(//button[contains(text(),'SAVE')])[1]")
	WebElement save_btn;
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/..")
	WebElement dashboard_leftpannel;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement KIS_OK_btn;
	@FindBy(xpath = "//button[contains(text(),'REJECT')]")
	WebElement reject_btn;
	@FindBy(xpath = "//md-dialog[@role='dialog']//button[contains(text(),'Reject')]")
	WebElement dialog_reject_btn;
	@FindBy(xpath = "//button[contains(text(),'Reassign')]")
	WebElement reassign_btn;
	@FindBy(xpath = "//textarea[contains(@ng-model,'ressignMessage')]")
	WebElement reassign_textarea;
	@FindBy(xpath = "//md-dialog[@role='dialog']//button[contains(text(),'Send')]")
	WebElement reassign_sendbtn;
	@FindBy(xpath = "//md-icon[@md-font-icon='icon-account-network']")
	WebElement account_netwrokicon;

	@FindBy(xpath = "(//md-option/div[text()='QA Vendor1'])[2]")
	WebElement select_user_qaVendor1;
	@FindBy(xpath = "(//ul[@class='ng-scope'])[1]")
	WebElement navigationlist_Cadmin;
	@FindBy(xpath = "//div[contains(text(),'Message Center')]")
	WebElement Messagecenter;
	@FindBy(xpath = "//div[contains(text(),'Upload Attachment')]/../input")
	WebElement upload_attachments;
	@FindBy(xpath = "//ul[@class='group-button']//button[@aria-label='Delete']")
	WebElement deleteiconUploadAttachment;


	public TemplateVerificationPage clickOnCreateButton() {
		pause(5);
		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(create_btn);
		jsClick(create_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterName(String templateName) {
		PresenceOfElement(By.name("name"));
		enterDataIn(name_field, templateName);
		globalMap.put("created_templateName", templateName);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//iframe[@tabindex='0']")
	WebElement frame;

	public TemplateVerificationPage enterDescription() {
		pause(2);
		driver.switchTo().frame(frame);
		pause(3);
		PresenceOfElement(By.xpath("(//html/body[@contenteditable='true'])[1]"));
		pause(2);
		enterDataIn(driver.findElement(By.xpath("(//html/body[@contenteditable='true'])[1]")), "This is Description");
		pause(2);
		driver.switchTo().defaultContent();
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterSectionName(String sectionName) {
		scrollToElement(section_name_field);
		enterDataIn(section_name_field, sectionName);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnPlusButtonInSections() {
		PresenceOfElement(By.xpath("//button[contains(@ng-click,'section_name')]"));
		clickableElement(section_plus_btn);
		jsClick(section_plus_btn);
		pause(2);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnContinueButton(String sectionTab) {
		pause(3);
		scrollToElement(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		PresenceOfElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterSMENew(String sectionName, String smeName, String permission, int rowNumber) {
		pause(2);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div[" + rowNumber
				+ "]//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		scrollToElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")).sendKeys(smeName);
		pause(3);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);
		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]"));
			clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));
			jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			pause(2);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

			pause(1);
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			waitforElementClickable(
					driver.findElement(
							By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")),
					explicitWait);
			pause(1);
			PresenceOfElement(By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']"));
			clickableElement(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));
			jsClick(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));

			break;

		case "Objectives":
			if (rowNumber == 1) {
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
			}
			else {
				scrollToElementTillTrue(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				PresenceOfElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]"));
				clickableElement(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				jsClick(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
			}
			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);
			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);

			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[" + rowNumber + "]/div[3]//md-select[@aria-label='Permission']")));

			pause(2);

			PresenceOfElement(By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']"));
			clickableElement(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));
			jsClick(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));
			System.out.println("(//div[text()='" + permission + "'])[5]");
			break;
		}
		if (rowNumber != 2)
			PresenceOfElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']"));
		clickableElement(driver.findElement(By
				.xpath("//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
		jsClick(driver.findElement(By
				.xpath("//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnHelpMySmes() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Help my SME')]"));
		clickableElement(help_my_sme_btn);
		jsClick(help_my_sme_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnSmesBubble() {
		scrollToElementTillTrue(smes_bubble);
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='SMEs']"));
		clickableElement(smes_bubble);
		jsClick(smes_bubble);
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	WebElement Dashboard;

	public TemplateVerificationPage clickOnDashboardLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		clickableElement(Dashboard);
		jsClick(Dashboard);
		pause(3);
		boolean status = afetrloginPopUP();
		if (status) {
			pause(3);
			driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		}

		else {
			System.out.println("Pop Not Displyed");
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnCloseRemoteButton() {
		PresenceOfElement(By.className("icon-window-close"));
		clickableElement(remote_close_btn);
		jsClick(remote_close_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnYesButton() {

		PresenceOfElement(By.xpath("//button[text()='Yes']"));
		jsClick(yes_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnLogInAsButton() {
		pause(5);
		waitforElementClickable(log_in_as_btn, explicitWait);
		PresenceOfElement(By.xpath("//*[@placeholder='Log In As']"));
		clickableElement(log_in_as_btn);
		clickOn(log_in_as_btn);
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement search;

	public WebElement companyNameForLoginAs(String companyName) {
		return driver.findElement(
				By.xpath("//div[@id='suggestive_pop']/md-content[1]/md-list[1]/md-list-item//button[@aria-label='"
						+ companyName + "']"));

	}

	public TemplateVerificationPage selectCompany(String text) {
		pause(2);
		type(search, text);
		pause(8);
		clickOn(companyNameForLoginAs(text));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnSelectUserButton() {
		PresenceOfElement(By.xpath("//md-select[@placeholder='Select User']"));
		clickableElement(select_user_btn);
		jsClick(select_user_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectQACsme2(String smeUser) {
		PresenceOfElement(By.xpath("//md-option/div[contains(text(),'" + smeUser + "')]"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[contains(text(),'" + smeUser + "')]")));
		jsClick(driver.findElement(By.xpath("//md-option/div[contains(text(),'" + smeUser + "')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnGoButton() {
		PresenceOfElement(By.xpath("//button[text()[normalize-space()='Go']]"));
		clickableElement(go_btn);
		jsClick(go_btn);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//span[contains(text(),'Notifications')]")
	WebElement Notification;

	public TemplateVerificationPage clickOnNotificationLeftLink() {
		pause(5);
		PresenceOfElement(By.xpath("//span[contains(text(),'Notifications')]"));
		clickableElement(Notification);
		jsClick(Notification);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//span[@class='child-badge ng-binding ng-scope']")
	WebElement count;

	public String getNotificationCount() {
		pause(3);
		System.out.println("Total number of Notification Count ==>" + count.getText());
		return count.getText();
	}

	@FindBy(xpath = "//md-icon[@md-font-icon='icon-bell-ring']")
	WebElement bellringIcon;

	public TemplateVerificationPage scrollTillbellringIcon() {
		pause(3);
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-bell-ring']"));
		scrollToElementTillTrue(bellringIcon);

		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnbellringIcon() {
		pause(3);
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-bell-ring']"));
		clickableElement(bellringIcon);
		jsClick(bellringIcon);
		pause(3);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//div[contains(text(),'Message Center')]")
	WebElement messageCenterListLabel;

	public TemplateVerificationPage scrollTillMessageCenter() {
		pause(3);
		PresenceOfElement(By.xpath("//div[contains(text(),'Message Center')]"));
		scrollToElementTillTrue(messageCenterListLabel);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnNotification(String notificationStatus) {
		pause(3);
		PresenceOfElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"
						+ notificationStatus + "')]"));
		clickableElement(driver.findElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"
						+ notificationStatus + "')]")));
		jsClick(driver.findElement(
				By.xpath("//div[@id='widgets']//tr[1]/td[2]/span/p/text()[1]/../../../../td[3]//label[contains(text(),'"
						+ notificationStatus + "')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement clickOnOK;

	public TemplateVerificationPage clickOnOk() {
		pause(3);
		PresenceOfElement(By.xpath("//button[contains(text(),'Ok')]"));
		clickableElement(clickOnOK);
		jsClick(clickOnOK);
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage scrollTillPendingTaskList() {
		pause(3);
		scrollToElement(pendingTaskListLabel);
		scrollToElementTillTrue(pendingTaskListLabel);
		pause(2);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnAcceptButton(String templateName, String sectionName) {
		pause(10);
		String acceptButton = "//a[contains(text(),'#Description')]/ancestor::tr//a[contains(text(),'#templateName')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']";
		acceptButton = acceptButton.replace("#templateName", templateName);
		acceptButton = acceptButton.replace("#Description",
				"SME for Template " + templateName + " " + "for" + " " + sectionName);
		scrollToElement(driver.findElement(By.xpath(acceptButton)));
		PresenceOfElement(By.xpath(acceptButton));
		clickableElement(driver.findElement(By.xpath(acceptButton)));
		jsClick(driver.findElement(By.xpath(acceptButton)));
		return new TemplateVerificationPage();
	}

	public static boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	@FindBy(xpath = "//button[contains(text(),'SAVE & SUBMIT')]")
	WebElement save_and_submit_button;

	public TemplateVerificationPage clickOnSaveAndSubmitButton() {
		pause(5);
		scrollToElement(save_and_submit_button);
		pause(3);
		waitforElementClickable(save_and_submit_button, explicitWait);
		if (isElementEnabled(save_and_submit_button)) {
			PresenceOfElement(By.xpath("//button[contains(text(),'SAVE & SUBMIT')]"));
			jsClick(save_and_submit_button);
			pause(2);
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage editDescription(String sectionName) {
		pause(5);
		switch (sectionName) {
		case "Introduction":
			driver.switchTo().frame(0);
			break;
		case "Objectives":
			driver.switchTo().frame(1);
			break;

		case "Pricing":
			driver.switchTo().frame(2);
			break;
		}
		WebElement el = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		driver.findElement(By.xpath("/html/body")).sendKeys("Section is editable");
		pause(2);
		driver.switchTo().defaultContent();
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'NEW QUESTION')])[1]")
	WebElement ObjNewQueButton;

	public TemplateVerificationPage scrollTillNewQuestionBtn() {
		pause(3);
		scrollToElement(ObjNewQueButton);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnNewQuestionButton(String sectionName) {
		pause(3);
		if (driver.findElement(By.xpath("//button[@aria-label='User settings']/div/span")).getText()
				.equalsIgnoreCase("QaNarola Sme1") && sectionName.equalsIgnoreCase("Introduction")) {
			scrollToElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
			PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]"));
			clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
			jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		}
		if (driver.findElement(By.xpath("//button[@aria-label='User settings']/div/span")).getText()
				.equalsIgnoreCase("QaNarola Sme1") && sectionName.equalsIgnoreCase("Objectives")) {
			PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]"));
			clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]")));
			jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]")));
		}

		if (driver.findElement(By.xpath("//button[@aria-label='User settings']/div/span")).getText()
				.equalsIgnoreCase("QaNarola Sme2") && sectionName.equalsIgnoreCase("Objectives")) {
			PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]"));
			clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
			jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		}
		if (driver.findElement(By.xpath("//button[@aria-label='User settings']/div/span")).getText()
				.equalsIgnoreCase("QaNarola Sme1") && sectionName.equalsIgnoreCase("Pricing")) {
			PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[3]"));
			clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[3]")));
			jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[3]")));
		}
		if (driver.findElement(By.xpath("//button[@aria-label='User settings']/div/span")).getText()
				.equalsIgnoreCase("QaNarola Sme2") && sectionName.equalsIgnoreCase("Pricing")) {
			PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]"));
			clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]")));
			jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[2]")));
		}
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-option[@value='Free Form']")
	WebElement freeFormOption;
	@FindBy(xpath = "//md-select[@aria-label='Answer Type']")
	WebElement answerTypeFiled;
	@FindBy(xpath = "//label[contains(text(),'Question')]/following::div/textarea[@ng-model='vm.question_text']")
	WebElement addquestioninTextArea;

	public TemplateVerificationPage fillNewQuestionData(String answerType, String question, String questionWeight,
			String section) {
		switch (answerType) {

		case "newQuestion":
			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Free Form']"));
			clickableElement(freeFormOption);
			jsClick(freeFormOption);
			pause(3);
			enterDataIn(addquestioninTextArea, question);
			pause(2);
			break;
		case "freeForm":

			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Free Form']"));
			clickableElement(freeFormOption);
			jsClick(freeFormOption);
			pause(3);
			enterDataIn(addquestioninTextArea, question);

			pause(2);
			break;
		case "yesNo":
			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Yes/No']"));
			clickableElement(yesNoOption);
			jsClick(yesNoOption);
			pause(3);
			PresenceOfElement(By.xpath("//md-radio-button[@aria-label='Yes']"));
			clickableElement(yes_radio_btn);
			jsClick(yes_radio_btn);
			enterDataIn(questionTextArea, question);
			PresenceOfElement(By.xpath("//md-select[@placeholder='Select']"));
			clickableElement(select_btn);
			jsClick(select_btn);
			PresenceOfElement(By.xpath("//div[text()='Correct']"));
			clickableElement(correct_btn);
			jsClick(correct_btn);
			pause(2);
			break;
		}
		PresenceOfElement(By.xpath("//md-select[contains(@aria-label,'Question Weight')]"));
		clickableElement(questionWeightField);
		jsClick(questionWeightField);
		pause(2);
		PresenceOfElement(By.xpath("//md-option[@value='Medium']"));
		clickableElement(mediumQuestionWeightOption);
		jsClick(mediumQuestionWeightOption);
		pause(3);
		PresenceOfElement(By.xpath("(//md-select[contains(@aria-label,'Select Section')])[3]"));
		clickableElement(selectSectionField);
		jsClick(selectSectionField);
		pause(2);
		switch (section) {

		case "Introduction":
			PresenceOfElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]"));
			clickableElement(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			jsClick(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			break;
		case "Objectives":
			PresenceOfElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]"));
			clickableElement(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			jsClick(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			break;
		case "Pricing":
			PresenceOfElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]"));
			clickableElement(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			jsClick(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			break;
		case "New Section":
			PresenceOfElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]"));
			clickableElement(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			jsClick(driver.findElement(By.xpath(
					"(//md-option[contains(@ng-selected,'section.id')]/div[contains(text(),'" + section + "')])[3]")));
			break;
		}
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnSaveQuestionButton() {
		waitforElementClickable(questionSaveButton, 30);
		pause(3);
		scrollToElement(
				driver.findElement(By.xpath("//form[@name='newQuestionForm']//button[contains(text(),'Save')]")));
		if (isElementEnabled(questionSaveButton)) {
			PresenceOfElement(By.xpath("//form[@name='newQuestionForm']//button[contains(text(),'Save')]"));
			clickableElement(questionSaveButton);
			jsClick(questionSaveButton);
			pause(2);
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectTemplate(String templateName) {
		pause(3);
		PresenceOfElement(
				By.xpath("//a[contains(text(),'" + templateName + "') and @aria-label='" + templateName + "']"));
		scrollToElement(driver.findElement(
				By.xpath("//a[contains(text(),'" + templateName + "') and @aria-label='" + templateName + "']")));
		pause(3);
		clickableElement(driver.findElement(
				By.xpath("//a[contains(text(),'" + templateName + "') and @aria-label='" + templateName + "']")));
		jsClick(driver.findElement(
				By.xpath("//a[contains(text(),'" + templateName + "') and @aria-label='" + templateName + "']")));
		pause(5);
		return new TemplateVerificationPage();
	}

	public void searchSelectTemplate(String templatename) {
		searchTemplate(templatename);
		selectTemplate(templatename);
	}

	public TemplateVerificationPage clickOnReviewBubble() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Review']"));
		clickableElement(temp_review_bubble);
		jsClick(temp_review_bubble);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnApproveAll() {
		PresenceOfElement(By.xpath("(//button[text()='Approve All'])[1]"));
		clickableElement(approveAllButton);
		jsClick(approveAllButton);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnTabUnderReview(String tabName) {
		scrollToElement(driver.findElement(By.xpath("//md-tab-item//span[text()='" + tabName + "']")));
		PresenceOfElement(By.xpath("//md-tab-item//span[text()='" + tabName + "']"));
		clickableElement(driver.findElement(By.xpath("//md-tab-item//span[text()='" + tabName + "']")));
		jsClick(driver.findElement(By.xpath("//md-tab-item//span[text()='" + tabName + "']")));
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-step-label-wrapper[@class='Approvers']")
	WebElement temp_approvers_bubble;

	public TemplateVerificationPage clickOnApproversBubble() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Approvers']"));
		clickableElement(temp_approvers_bubble);
		jsClick(temp_approvers_bubble);
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']")
	WebElement approverSearch;

	public TemplateVerificationPage addQAApprover(String type, String approverName) {
		pause(3);
		PresenceOfElement(By.xpath("//md-radio-button[@aria-label='" + type + "']"));
		jsClick(driver.findElement(By.xpath("//md-radio-button[@aria-label='" + type + "']")));
		pause(3);

		PresenceOfElement(
				By.xpath("//md-autocomplete[contains(@md-search-text,'searchTextApprover')]//input[@type='search']"));
		jsClick(approverSearch);
		approverSearch.clear();
		approverSearch.sendKeys(approverName);

		PresenceOfElement(By.xpath("//span[contains(text(),'" + approverName + "')]"));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + approverName + "')]")));

		return new TemplateVerificationPage();
	}
	
	public TemplateVerificationPage selectQAApprover1(String approver) {
		PresenceOfElement(By.xpath("//md-option/div[text()='" + approver + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + approver + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + approver + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage templateClickDashboardAccBtnForApprover(String templateName) {
		PresenceOfElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']"));
		clickableElement(driver.findElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']")));
		jsClick(driver.findElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Accept']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickGotitButton() {
		pause(3);
		PresenceOfElement(By.xpath("//button[text()='Got It']"));
		clickableElement(gotIt_btn);
		jsClick(gotIt_btn);
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnApproveButton() {
		pause(5);
		PresenceOfElement(By.xpath("(//button[contains(text(),'APPROVE')])[1]"));
		clickableElement(approveButton);
		jsClick(approveButton);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnPublishBubble() {
		scrollToElement(temp_publish_bubble);
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Publish']"));
		clickableElement(temp_publish_bubble);
		jsClick(temp_publish_bubble);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage makeTemplatePublic() {
		pause(3);
		PresenceOfElement(By.xpath("//md-switch[@aria-label='Switch 1']"));
		clickableElement(driver.findElement(By.xpath("//md-switch[@aria-label='Switch 1']")));
		jsClick(driver.findElement(By.xpath("//md-switch[@aria-label='Switch 1']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickTemplatePublishButton() {
		scrollToElement(temp_publish_btn);
		pause(2);
		PresenceOfElement(By.xpath("//button[contains(text(),'PUBLISH')]"));
		clickableElement(temp_publish_btn);
		jsClick(temp_publish_btn);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectTemplateCheckbox(String templateName) {
		pause(3);
		PresenceOfElement(By.xpath("//a[contains(text(),'" + templateName + "')]/../../../../..//md-checkbox"));
		clickableElement(driver
				.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]/../../../../..//md-checkbox")));
		jsClick(driver
				.findElement(By.xpath("//a[contains(text(),'" + templateName + "')]/../../../../..//md-checkbox")));
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-icon[@aria-label='icon-people']")
	WebElement delegate_btn;

	public TemplateVerificationPage selectActionsFromHeader(String action) {
		pause(3);
		switch (action) {
		case "Delete":
			PresenceOfElement(By.xpath("//button[@aria-label='Delete']"));
			clickableElement(delete_btn);
			jsClick(delete_btn);
			break;
		case "Duplicate":
			break;
		case "Print":
			break;
		case "Download":
			break;
		case "SendAsEmail":
			break;
		case "Delegate":
			PresenceOfElement(By.xpath("//md-icon[@aria-label='icon-people']"));
			clickableElement(delegate_btn);
			jsClick(delegate_btn);
			break;
		}

		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterSMEName(String sectionName, String smeName, int rowNumber) {
		pause(2);
		visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
				+ rowNumber + "']//input[@placeholder = 'Add User or Email ID']"));
		pause(1);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
				+ rowNumber + "']//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div['" + rowNumber + "']//input[@placeholder = 'Add User or Email ID']")));
		jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
				+ rowNumber + "']//input[@placeholder = 'Add User or Email ID']")));
		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
				+ rowNumber + "']//input[@placeholder = 'Add User or Email ID']")).sendKeys(smeName);

		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]"));
			clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));
			jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));
			pause(3);
			break;
		case "Objectives":
			if (rowNumber == 1) {
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme1" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
			} else {
				scrollToElementTillTrue(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme1" + rowNumber + "')])[" + (rowNumber) + "]")));
				PresenceOfElement(
						By.xpath("(//span[contains(text(),'QA csme" + rowNumber + "')])[" + (rowNumber) + "]"));
				clickableElement(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				jsClick(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
			}

			break;
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectSMEDate(String sectionName, int rowNumber) {
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);
		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);
			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);
			break;
		case "Objectives":
			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);
			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);
			break;
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSMEPermission(String sectionName, String permission, int rowNumber) {
		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]"));
			clickableElement(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
							+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]")));
			jsClick(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
							+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]")));
			pause(2);
			break;
		case "Objectives":
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
					+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]"));
			clickableElement(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
							+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]")));
			jsClick(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
							+ rowNumber + "]/div[3]//md-select[contains(@aria-label,'Permission')]")));
			pause(2);
			break;
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectSMEPermission(String sectionName, String permission, int rowNumber) {
		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("(//div[text()='" + permission + "'])[" + (rowNumber + 1) + "]"));
			clickableElement(
					driver.findElement(By.xpath("(//div[text()='" + permission + "'])[" + (rowNumber + 1) + "]")));
			jsClick(driver.findElement(By.xpath("(//div[text()='" + permission + "'])[" + (rowNumber + 1) + "]")));
			break;
		case "Objectives":
			PresenceOfElement(By.xpath("(//div[text()='" + permission + "'])[4]"));
			clickableElement(driver.findElement(By.xpath("(//div[text()='" + permission + "'])[4]")));
			jsClick(driver.findElement(By.xpath("(//div[text()='" + permission + "'])[4]")));
			break;
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickAddNewSMEButton(String sectionName, int rowNumber) {
		if (rowNumber != 2)
			PresenceOfElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']"));
		clickableElement(driver.findElement(By
				.xpath("//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
		jsClick(driver.findElement(By
				.xpath("//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Take me to Dashboard')]")
	WebElement takeMeToDashboard;

	public TemplateVerificationPage clickOnTakeMeToDashboard() {
		PresenceOfElement(By.xpath("//button[contains(text(),'Take me to Dashboard')]"));
		clickableElement(takeMeToDashboard);

		jsClick(takeMeToDashboard);
		pause(4);
		boolean status = afetrloginPopUP();
		if (status) {
			pause(3);
			driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		}

		else {
			System.out.println("Pop Not Displyed");
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage scrollToAssignedQuestions() {

		pause(5);
		PresenceOfElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]"));
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnDotsIcon(String que) {
		pause(3);
		PresenceOfElement(By.xpath("//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()']"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()']")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectEditOption(String option) {
		PresenceOfElement(By.xpath("//md-menu-content[@class='md-default-theme']"));
		clickableElement(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		jsClick(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		pause(2);

		PresenceOfElement(By.xpath("//button[@aria-label='" + option + "']"));
		clickableElement(driver.findElement(By.xpath("//button[@aria-label='" + option + "']")));
		jsClick(driver.findElement(By.xpath("//button[@aria-label='" + option + "']")));
		pause(2);

		PresenceOfElement(By.xpath("//md-backdrop"));
		clickableElement(driver.findElement(By.xpath("//md-backdrop")));
		jsClick(driver.findElement(By.xpath("//md-backdrop")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectDeleteOption(String option) {
		PresenceOfElement(By.xpath("//md-menu-content[@class='md-default-theme']"));
		clickableElement(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		jsClick(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		pause(2);

		PresenceOfElement(By.xpath("(//button[@aria-label='" + option + "'])[3]"));
		clickableElement(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[3]")));
		jsClick(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[3]")));
		pause(2);

		PresenceOfElement(By.xpath("//md-backdrop"));
		clickableElement(driver.findElement(By.xpath("//md-backdrop")));
		jsClick(driver.findElement(By.xpath("//md-backdrop")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectDeleteOptionAtReviewTab(String option) {
		PresenceOfElement(By.xpath("//md-menu-content[@class='md-default-theme']"));
		clickableElement(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		jsClick(driver.findElement(By.xpath("//md-menu-content[@class='md-default-theme']")));
		pause(2);

		PresenceOfElement(By.xpath("(//button[@aria-label='" + option + "'])[6]"));
		clickableElement(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[6]")));
		jsClick(driver.findElement(By.xpath("(//button[@aria-label='" + option + "'])[6]")));
		pause(2);
		PresenceOfElement(By.xpath("//md-backdrop"));
		clickableElement(driver.findElement(By.xpath("//md-backdrop")));
		jsClick(driver.findElement(By.xpath("//md-backdrop")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage scrollToAssignedQuestionss() {

		pause(5);
		PresenceOfElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]"));
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Assigned Questions for Introduction')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage editQuestionData(String question) {
		enterDataIn(questionTextArea, question);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnDownArrowForLog(String que) {
		PresenceOfElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-chevron-down']"));
		clickableElement(driver.findElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-chevron-down']")));
		jsClick(driver.findElement(By.xpath(
				"//span[contains(text(),'" + que + "')]/../../../../..//md-icon[@md-font-icon='icon-chevron-down']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnDotsIconAtReviewTab(String que) {
		pause(3);
		PresenceOfElement(By.xpath("(//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()'])[2]"));
		clickableElement(driver.findElement(By.xpath("(//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()'])[2]")));
		jsClick(driver.findElement(By.xpath("(//span[contains(text(),'" + que
				+ "')]/../../../../..//md-icon[@md-font-icon='icon-dots-vertical' and @ng-click='$mdMenu.open()'])[2]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dashboardSMETaskRejectButton(String templateName, String sectionName) {
		pause(10);
		String SMETaskRejectButton = "//a[text()='SME for Template" + " " + templateName + " for " + sectionName
				+ "']/ancestor::tr//a[text()='" + templateName
				+ "']/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Reject']";
		PresenceOfElement(By.xpath(SMETaskRejectButton));
		clickableElement(driver.findElement(By.xpath(SMETaskRejectButton)));
		jsClick(driver.findElement(By.xpath(SMETaskRejectButton)));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dashboardSMETaskRejectReason(String templateName, String sectionName) {
		pause(2);
		String smeTaskRejectReason = "//textarea[@id='reject_reason']";
		PresenceOfElement(By.xpath(smeTaskRejectReason));
		clickableElement(driver.findElement(By.xpath(smeTaskRejectReason)));
		jsClick(driver.findElement(By.xpath(smeTaskRejectReason)));
		driver.findElement(By.xpath(smeTaskRejectReason)).sendKeys("Rejected this task.");
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage sendRejectReasonButton() {
		pause(1);
		PresenceOfElement(By.xpath("(//button[text()='Send'])[2]"));
		clickableElement(driver.findElement(By.xpath("(//button[text()='Send'])[2]")));
		jsClick(driver.findElement(By.xpath("(//button[text()='Send'])[2]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage searchTemplate(String templateName) {
		clickableElement(
				driver.findElement(By.xpath("//md-card-content//a[contains(@class,'ng-binding md-default-theme')]")));
		pause(3);
		PresenceOfElement(By.xpath("//md-icon[@aria-label='icon-magnify']"));
		clickableElement(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		pause(3);
		jsClick(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		PresenceOfElement(By.xpath("//input[contains(@data-ng-model,'search')]"));
		clickableElement(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		jsClick(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		pause(3);
		driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")).sendKeys(templateName);
		pause(3);
		return new TemplateVerificationPage();
	}

	/////////////////
	public TemplateVerificationPage searchContent(String contentName) {
		clickableElement(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		jsClick(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		clickableElement(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		jsClick(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		pause(3);
		driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")).sendKeys(contentName);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//tr[@class='ng-scope']//td/a[contains(text(),'" + contentName + "')]"))));
		return new TemplateVerificationPage();
	}
	///////////////////

	public TemplateVerificationPage clickOnRejectButton(String question) {
		pause(5);
		PresenceOfElement(By.xpath("//span[text()='" + question + "']/../../..//button[contains(text(),'Reject')]"));
		clickableElement(driver.findElement(
				By.xpath("//span[text()='" + question + "']/../../..//button[contains(text(),'Reject')]")));
		jsClick(driver.findElement(
				By.xpath("//span[text()='" + question + "']/../../..//button[contains(text(),'Reject')]")));
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//textarea[@ng-model='vm.rejectReason'])[2]")
	WebElement rejectReasonTextbox;
	@FindBy(xpath = "//button[@ng-click='vm.rejectReasonFunction()']")
	WebElement sendBtn;

	public TemplateVerificationPage giveRejectReason(String Reason) {

		pause(2);
		rejectReasonTextbox.sendKeys(Reason);
		PresenceOfElement(By.xpath("//button[@ng-click='vm.rejectReasonFunction()']"));
		clickableElement(sendBtn);
		jsClick(sendBtn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectSME(String sectionName, String smeName, int rowNumber) {

		pause(2);
		visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']"));
		pause(1);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div[" + rowNumber
				+ "]//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")).sendKeys(smeName);

		PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola Sme2')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme2')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme2')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dashboardSMETaskReassignButton(String templateName, String sectionName, String name,
			String nameDropdown) {
		pause(10);
		String reassignButton = "//a[text()='SME for Template" + " " + templateName + " for " + sectionName
				+ "']/ancestor::tr//a[text()='" + templateName
				+ "']/../../parent::td//following-sibling::td[@class='group-button']/div/button[@aria-label='Reassign']";
		PresenceOfElement(By.xpath(reassignButton));
		clickableElement(driver.findElement(By.xpath(reassignButton)));
		jsClick(driver.findElement(By.xpath(reassignButton)));
		pause(1);

		// Insert email address
		PresenceOfElement(By.xpath("//input[@aria-label='Email']"));
		clickableElement(driver.findElement(By.xpath("//input[@aria-label='Email']")));
		jsClick(driver.findElement(By.xpath("//input[@aria-label='Email']")));

		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys(name);

		PresenceOfElement(By.xpath("//span[contains(text(),'" + nameDropdown + "')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + nameDropdown + "')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + nameDropdown + "')]")));

		// Insert reassign message
		PresenceOfElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']"));
		clickableElement(driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']")));
		jsClick(driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']")));
		driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']")).sendKeys("Reassign task.");

		// Click send button.
		PresenceOfElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']"));
		clickableElement(
				driver.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage scrollToUnAssignedQuestions() {

		pause(2);
		scrollToElement(driver.findElement(By.xpath("//div[text()='Unassigned Questions']")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'hold')])[1]")
	WebElement holdButton;

	public TemplateVerificationPage clickOnHoldButton() {
		PresenceOfElement(By.xpath("(//button[contains(text(),'hold')])[1]"));
		clickableElement(holdButton);
		jsClick(holdButton);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterHoldReason() {

		pause(3);
		PresenceOfElement(By.xpath("//textarea[contains(@id,'hold_reason')]"));
		enterDataIn(driver.findElement(By.xpath("//textarea[contains(@id,'hold_reason')]")), "hold this");
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//div[@id='holdTaskDialog']/md-dialog//button[contains(text(),'Send')]")
	WebElement sendButton;

	public TemplateVerificationPage clickOnSendButton() {
		PresenceOfElement(By.xpath("//div[@id='holdTaskDialog']/md-dialog//button[contains(text(),'Send')]"));
		clickableElement(sendButton);
		jsClick(sendButton);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage ClickontemplateByName(String templateName) {
		pause(2);
		PresenceOfElement(By.xpath("//div[@id='widgets']//span/p/a[contains(text(),'" + templateName + "')]"));
		clickableElement(driver
				.findElement(By.xpath("//div[@id='widgets']//span/p/a[contains(text(),'" + templateName + "')]")));
		jsClick(driver
				.findElement(By.xpath("//div[@id='widgets']//span/p/a[contains(text(),'" + templateName + "')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dashboardApproverTaskRejectButton(String templateName) {
		pause(2);
		String approverTaskRejectButton = "//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div//md-icon[@aria-label='icon-close']";
		PresenceOfElement(By.xpath(approverTaskRejectButton));
		clickableElement(driver.findElement(By.xpath(approverTaskRejectButton)));
		jsClick(driver.findElement(By.xpath(approverTaskRejectButton)));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dashboardApproverTaskRejectReason() {
		pause(2);
		String smeTaskRejectReason = "//textarea[@id='reject_reason']";
		PresenceOfElement(By.xpath(smeTaskRejectReason));
		clickableElement(driver.findElement(By.xpath(smeTaskRejectReason)));
		jsClick(driver.findElement(By.xpath(smeTaskRejectReason)));
		driver.findElement(By.xpath(smeTaskRejectReason)).sendKeys("Rejected this task.");
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickDashboardReassignBtnForApprover(String templateName) {
		PresenceOfElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div//md-icon[@aria-label='icon-rotate-right']"));
		clickableElement(driver.findElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div//md-icon[@aria-label='icon-rotate-right']")));
		jsClick(driver.findElement(By.xpath("//a[@title='Go to Template'][contains(text(),'" + templateName
				+ "')]/../../parent::td//following-sibling::td[@class='group-button']/div//md-icon[@aria-label='icon-rotate-right']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickTemplateApproverBubble() {
		pause(5);
		PresenceOfElement(By.xpath("//md-step-label-wrapper[@class='Approvers']"));
		clickableElement(approver_bubble);
		jsClick(approver_bubble);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage templateTaskReassignEmailForApprover3(String templateName) {

		// Insert email address
		PresenceOfElement(By.xpath("//input[@aria-label='Email']"));
		clickableElement(driver.findElement(By.xpath("//input[@aria-label='Email']")));
		jsClick(driver.findElement(By.xpath("//input[@aria-label='Email']")));
		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys(getEmail("Customer Approver 3"));
		PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola approver3')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola approver3')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola approver3')]")));

		// Insert reassign message
		PresenceOfElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']"));
		clickableElement(driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']")));
		jsClick(driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']")));
		driver.findElement(By.xpath("//textarea[@ng-model='vm.ressignMessage']"))
				.sendKeys("Reassign task to approver2.");

		// Click send button.
		PresenceOfElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']"));
		clickableElement(
				driver.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']")));
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Send') and @ng-click='vm.sendReassign()']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickAcceptButton() {
		waitForPageLoaded();
		pause(3);
		scrollToElement(accept_btn);
		pause(3);
		PresenceOfElement(By.xpath("//button[contains(text(),'ACCEPT')]"));
		clickableElement(accept_btn);
		jsClick(accept_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSavebutton() {
		pause(3);
		scrollToElement(save_btn);
		waitforElementClickable(save_btn, explicitWait);
		pause(2);
		PresenceOfElement(By.xpath("(//button[contains(text(),'SAVE')])[1]"));
		clickableElement(save_btn);
		jsClick(save_btn);

		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[text()[normalize-space()='SAVE']]")
	WebElement saveBtn;

	public TemplateVerificationPage clickOnSavebutton() {
		scrollToElement(saveBtn);
		waitforElementClickable(saveBtn, explicitWait);
		pause(3);
		PresenceOfElement(By.xpath("//button[text()[normalize-space()='SAVE']]"));
		clickableElement(saveBtn);
		jsClick(saveBtn);

		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'Save')])[4]")
	WebElement saveButton;

	public TemplateVerificationPage clickSavebuttonForQueDatabase() {
		waitforElementClickable(saveButton, explicitWait);
		pause(2);
		PresenceOfElement(By.xpath("(//button[contains(text(),'Save')])[4]"));
		clickableElement(saveButton);
		jsClick(saveButton);

		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickonDashboardLeftSidePannel() {
		pause(2);
		waitforElementClickable(dashboard_leftpannel, explicitWait);
		PresenceOfElement(By.xpath("//span[contains(text(),'Dashboard')]/.."));
		clickableElement(dashboard_leftpannel);
		jsClick(dashboard_leftpannel);
		pause(3);
		boolean status = afetrloginPopUP();
		if (status) {
			pause(3);
			driver.findElement(By.xpath("//button[text()='SKIP']")).click();
		}

		else {
			System.out.println("Pop Not Displyed");
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickRejectButton() {
		waitForPageLoaded();
		pause(3);
		scrollToElement(reject_btn);
		pause(3);
		PresenceOfElement(By.xpath("//button[contains(text(),'REJECT')]"));
		clickableElement(reject_btn);
		jsClick(reject_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterrejectReason() {
		waitForPageLoaded();
		pause(2);
		String rejectreason = "//md-dialog[@role='dialog']//div[contains(@class,'md-resize-wrapper')]/textarea";

		PresenceOfElement(By.xpath(rejectreason));
		clickableElement(driver.findElement(By.xpath(rejectreason)));
		jsClick(driver.findElement(By.xpath(rejectreason)));

		driver.findElement(By.xpath(rejectreason)).sendKeys("Rejected this task.");
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage dialogRejectButton() {
		waitForPageLoaded();
		pause(2);
		scrollToElement(dialog_reject_btn);
		pause(1);

		PresenceOfElement(By.xpath("//md-dialog[@role='dialog']//button[contains(text(),'Reject')]"));
		clickableElement(dialog_reject_btn);
		jsClick(dialog_reject_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickReassignButton() {
		waitForPageLoaded();
		pause(1);
		scrollToElement(reassign_btn);
		pause(1);
		PresenceOfElement(By.xpath("//button[contains(text(),'Reassign')]"));
		clickableElement(reassign_btn);
		jsClick(reassign_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage inputReassigndialouge(String smename, String message) {
		visibilityOfElementLocated(By.xpath("//input[contains(@aria-label,'Add User or Email ID')]"));

		PresenceOfElement(By.xpath("//input[contains(@aria-label,'Add User or Email ID')]"));
		clickableElement(driver.findElement(By.xpath("//input[contains(@aria-label,'Add User or Email ID')]")));
		jsClick(driver.findElement(By.xpath("//input[contains(@aria-label,'Add User or Email ID')]")));

		driver.findElement(By.xpath("//input[contains(@aria-label,'Add User or Email ID')]")).sendKeys(smename);
		visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + smename + "')]"));
		pause(1);

		PresenceOfElement(By.xpath("//span[contains(text(),'" + smename + "')]"));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + smename + "')]")));
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'" + smename + "')]")));

		waitforElementClickable(reassign_textarea, explicitWait);

		PresenceOfElement(By.xpath("//textarea[contains(@ng-model,'ressignMessage')]"));
		clickableElement(reassign_textarea);
		jsClick(reassign_textarea);
		driver.findElement(By.xpath("//textarea[contains(@ng-model,'ressignMessage')]")).sendKeys(message);
		waitforElementClickable(reassign_sendbtn, explicitWait);
		pause(1);

		PresenceOfElement(By.xpath("//md-dialog[@role='dialog']//button[contains(text(),'Send')]"));
		clickableElement(reassign_sendbtn);
		jsClick(reassign_sendbtn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterSME(String sectionName, String smeName, String permission, int rowNumber) {
		pause(2);
		PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div[" + rowNumber
				+ "]//input[@placeholder = 'Add User or Email ID']"));
		clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
				+ "')]/following-sibling::td/div[" + rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")));
		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div["
				+ rowNumber + "]//input[@placeholder = 'Add User or Email ID']")).sendKeys(smeName);
		pause(3);
		DateFormat dateFormat = new SimpleDateFormat("EEEE MMMMM d y");
		Date currentDate = new Date();
		String smeDate = dateFormat.format(currentDate);
		switch (sectionName) {
		case "Introduction":
			PresenceOfElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]"));
			clickableElement(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));
			jsClick(driver.findElement(By.xpath("//span[contains(text(),'QaNarola Sme" + rowNumber + "')]")));

			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));

			pause(2);

			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));

			pause(1);
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[\"+rowNumber+\"]/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[\"+rowNumber+\"]/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver.findElement(By.xpath("//td[contains(text(),'" + sectionName
					+ "')]/following-sibling::td/div[\"+rowNumber+\"]/div[3]//md-select[@aria-label='Permission']")));

			pause(1);
			PresenceOfElement(By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']"));
			clickableElement(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));
			jsClick(driver.findElement(
					By.xpath("//div[contains(@class,'md-active')]//md-option[@value='" + permission + "']")));

			break;

		case "Objectives":
			if (rowNumber == 1) {
				PresenceOfElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]"));
				clickableElement(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
				jsClick(driver.findElement(By
						.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber + 1) + "]")));
			}
			else {

				scrollToElementTillTrue(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				PresenceOfElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]"));
				clickableElement(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
				jsClick(driver.findElement(
						By.xpath("(//span[contains(text(),'QaNarola Sme" + rowNumber + "')])[" + (rowNumber) + "]")));
			}
			System.out.println("ROw number" + rowNumber);
			PresenceOfElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]"));
			clickableElement(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			jsClick(driver.findElement(By.xpath("(//td[contains(text(),'" + sectionName
					+ "')]//parent::tr//button[@aria-label='Open calendar'])[" + rowNumber + "]")));
			pause(1);
			PresenceOfElement(By.xpath("//td[@aria-label='" + smeDate + "']"));
			clickableElement(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			jsClick(driver.findElement(By.xpath("//td[@aria-label='" + smeDate + "']")));
			pause(1);
			System.out.println("ROw number" + rowNumber);
			PresenceOfElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
					+ rowNumber + "']/div[3]//md-select[@aria-label='Permission']"));
			clickableElement(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
							+ rowNumber + "']/div[3]//md-select[@aria-label='Permission']")));
			jsClick(driver
					.findElement(By.xpath("//td[contains(text(),'" + sectionName + "')]/following-sibling::td/div['"
							+ rowNumber + "']/div[3]//md-select[@aria-label='Permission']")));

			pause(2);
			PresenceOfElement(By.xpath("(//div[text()='" + permission + "'])[4]"));
			jsClick(driver.findElement(By.xpath("(//div[text()='" + permission + "'])[4]")));

			break;
		}
		if (rowNumber != 2)
			PresenceOfElement(By.xpath(
					"//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']"));
		jsClick(driver.findElement(By
				.xpath("//td[contains(text(),'" + sectionName + "')]/parent::tr//button[@aria-label='Add New SME']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage commentBySME(String strUser, String strComment) {
		pause(2);
		if (driver.findElement(By.xpath("//md-icon[contains(@md-font-icon,'icon-comment-text')]")).isDisplayed()) {
			PresenceOfElement(By.xpath("//md-icon[contains(@md-font-icon,'icon-comment-text')]"));
			clickableElement(driver.findElement(By.xpath("//md-icon[contains(@md-font-icon,'icon-comment-text')]")));
			jsClick(driver.findElement(By.xpath("//md-icon[contains(@md-font-icon,'icon-comment-text')]")));

			pause(2);
			PresenceOfElement(By.xpath("//textarea[contains(@ng-model,'pop_comment')]"));
			clickableElement(driver.findElement(By.xpath("//textarea[contains(@ng-model,'pop_comment')]")));
			jsClick(driver.findElement(By.xpath("//textarea[contains(@ng-model,'pop_comment')]")));

			driver.findElement(By.xpath("//textarea[contains(@ng-model,'pop_comment')]")).clear();
			driver.findElement(By.xpath("//textarea[contains(@ng-model,'pop_comment')]")).sendKeys(strComment);

			PresenceOfElement(By.xpath("//md-dialog[@role='dialog']//md-icon[@md-font-icon='icon-send']"));
			clickableElement(
					driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-icon[@md-font-icon='icon-send']")));
			jsClick(driver.findElement(By.xpath("//md-dialog[@role='dialog']//md-icon[@md-font-icon='icon-send']")));

			globalMap.put("givenComment", strComment);
			globalMap.put("user", strUser);
		}
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createButton;

	public TemplateVerificationPage clickOnCreatebutton() {
		PresenceOfElement(By.xpath("//button[text()='Create']"));
		clickableElement(createButton);
		jsClick(createButton);
		pause(2);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement contentName;
	@FindBy(xpath = "//input[@name='price']")
	WebElement contentCredit;

	public TemplateVerificationPage enterContentDetails(String name, String credit) {
		contentName.sendKeys(name);
		contentCredit.sendKeys(credit);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[text()='Import']")
	WebElement importButton;

	public TemplateVerificationPage clickOnImport() {

		pause(5);
		PresenceOfElement(By.xpath("//button[text()='Import']"));
		clickableElement(importButton);
		jsClick(importButton);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'Question Database')]")
	WebElement queDatabaseButton;

	public TemplateVerificationPage clickQueDatabase() {

		pause(5);
		PresenceOfElement(By.xpath("//button[contains(text(),'Question Database')]"));
		clickableElement(queDatabaseButton);
		jsClick(queDatabaseButton);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage checkQueDatabase(String name) {

		pause(5);
		PresenceOfElement(
				By.xpath("//p[contains(text(),'" + name + "')]/..//div[@class='md-container md-ink-ripple']"));
		clickableElement(driver.findElement(
				By.xpath("//p[contains(text(),'" + name + "')]/..//div[@class='md-container md-ink-ripple']")));
		jsClick(driver.findElement(
				By.xpath("//p[contains(text(),'" + name + "')]/..//div[@class='md-container md-ink-ripple']")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//input[@id='upload']")
	WebElement uploadQuestions;

	public TemplateVerificationPage clickOnImportContentLink() {

		pause(5);
		scrollToElement(driver.findElement(By.xpath("//input[@id='upload']")));
		String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/questions.csv";

		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		uploadQuestions.sendKeys(fullpath);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[contains(text(),'IMPORT')]")
	WebElement importBtn;

	public TemplateVerificationPage clickOnImportButton() {

		pause(5);
		visibilityOfElementLocated(By.xpath("//button[contains(text(),'IMPORT')]"));
		scrollToElement(importBtn);
		jsClick(importBtn);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//form[@class='ng-pristine ng-valid']/md-dialog-actions/button[@type='button' and contains(text(),'Done')]")
	WebElement doneBtn;

	public TemplateVerificationPage clickOnDoneButton() {

		pause(2);
		PresenceOfElement(By.xpath(
				"//form[@class='ng-pristine ng-valid']/md-dialog-actions/button[@type='button' and contains(text(),'Done')]"));
		clickableElement(doneBtn);
		jsClick(doneBtn);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//input[@id='importNewQuestion']")
	WebElement importQue;

	public TemplateVerificationPage importQuestion() {

		pause(2);
		String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/Book1.xlsx";
		File datafile = new File(dataFilePath);
		String fullpath = datafile.getAbsolutePath();
		importQue.sendKeys(fullpath);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage deleteSme(String rownumber) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("(//button[@aria-label='Delete SME'])[" + rownumber + "]")));;
		PresenceOfElement(By.xpath("(//button[@aria-label='Delete SME'])[" + rownumber + "]"));
		clickableElement(driver.findElement(By.xpath("(//button[@aria-label='Delete SME'])[" + rownumber + "]")));
		jsClick(driver.findElement(By.xpath("(//button[@aria-label='Delete SME'])[" + rownumber + "]")));
		pause(2);

		return new TemplateVerificationPage();

	}

	@FindBy(xpath = "//button[@ng-click='vm.saveApprovers(false)']")
	WebElement saveApprovers;

	public TemplateVerificationPage saveApprovers() {
		pause(5);
		PresenceOfElement(By.xpath("//button[@ng-click='vm.saveApprovers(false)']"));
		clickableElement(saveApprovers);
		jsClick(saveApprovers);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//iframe)[1]")
	WebElement frameIntro;
	@FindBy(xpath = "(//iframe)[2]")
	WebElement frameObj;
	@FindBy(xpath = "(//iframe)[3]")
	WebElement framePricing;

	public TemplateVerificationPage editDescription1(String sectionName) {
		pause(5);
		switch (sectionName) {
		case "Introduction":
			driver.switchTo().frame(frameIntro);
			break;
		case "Objectives":
			driver.switchTo().frame(frameObj);
			break;

		case "Pricing":
			driver.switchTo().frame(framePricing);
			break;
		}
		WebElement el = driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		driver.findElement(By.xpath("/html/body")).sendKeys("Section is editable");
		pause(2);
		driver.switchTo().defaultContent();
		return new TemplateVerificationPage();
	}
	public TemplateVerificationPage selectLoginAsQAVendor1(String vendor) {
		pause(2);
		type(search, vendor);
		pause(10);
		clickOn(qa_testing_btn);

		return new TemplateVerificationPage();
	}



	public TemplateVerificationPage clickSkipEvaluatorsCheckbox() {
		pause(5);


		scrollToElementTillTrue(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Evaluators']/div[contains(@class,'md-container')]")));
		pause(1);

		if (!hasClass(driver.findElement(By.xpath("//md-checkbox//div[contains(text(),'Skip')]/../..//md-checkbox")),
				"md-checkbox")) {
			clickableElement(driver.findElement(
					By.xpath("//md-checkbox[@aria-label='Skip Evaluators']/div[contains(@class,'md-container')]")));
			jsClick(driver.findElement(
					By.xpath("//md-checkbox[@aria-label='Skip Evaluators']/div[contains(@class,'md-container')]")));
			pause(2);
		}
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage enterNameKIS(String templateName) throws Throwable {
		PresenceOfElement(By.name("name"));
		enterDataIn(name_field, templateName);
		globalMap.put("created_templateName", templateName);
		String path = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/Tamplate.xlsx";
		XLUtils.setCellData(path, "KIS", templateName, 1, 0);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSkipApproverCheckbox() {
		pause(5);
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		pause(1);
		PresenceOfElement(By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]"));
		clickableElement(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		jsClick(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSkipApproverCheckboxrfp() {
		pause(5);
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		pause(1);
		PresenceOfElement(By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]"));
		clickableElement(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		jsClick(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSkipApprovalrfp() {
		pause(5);
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		pause(1);
		PresenceOfElement(By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]"));
		clickableElement(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		jsClick(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='Skip Approvals']/div[contains(@class,'md-container')]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickKISCheckbox() {
		pause(3);
		PresenceOfElement(By.xpath("//md-checkbox[@aria-label='kis']/div[1]"));
		clickableElement(driver.findElement(By.xpath("//md-checkbox[@aria-label='kis']/div[1]")));
		jsClick(driver.findElement(By.xpath("//md-checkbox[@aria-label='kis']/div[1]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickKISokButton() {
		PresenceOfElement(By.xpath("//button[text()='OK']"));
		clickableElement(KIS_OK_btn);
		jsClick(KIS_OK_btn);
		pause(5);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	public TemplateVerificationPage enterDescriptionGRFPADmin() {
		pause(2);
		PresenceOfElement(By.xpath("//textarea[@name='description']"));
		enterDataIn(description, "This is Description");
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnContinueOnNeedsTab(String sectionTab) {
		pause(3);
		scrollToElement(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(1);
		PresenceOfElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
		clickableElement(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'NEW QUESTION')])[1]")
	WebElement ObjNewQueButtonObj;

	public TemplateVerificationPage scrollTillNewQuestionBtnObj() {
		pause(3);
		scrollToElement(ObjNewQueButtonObj);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[contains(text(),'NEW QUESTION')])[2]")
	WebElement ObjNewQueButtonprice;

	public TemplateVerificationPage scrollTillNewQuestionBtnprice() {
		pause(3);
		scrollToElement(ObjNewQueButtonprice);
		return new TemplateVerificationPage();
	}


	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitbutton;

	public TemplateVerificationPage clickOnSubmitButton() {
		pause(3);
		scrollToElement(submitbutton);
		pause(3);
		waitforElementClickable(submitbutton, explicitWait);
		if (isElementEnabled(submitbutton)) {
			PresenceOfElement(By.xpath("//button[contains(text(),'Submit')]"));
			clickableElement(submitbutton);
			jsClick(submitbutton);
			pause(2);
		}
		return new TemplateVerificationPage();
	}


	public TemplateVerificationPage clickOnQANarolavendorButton(String vendor) {
		// Test.pause(5);
		PresenceOfElement(By.xpath("//md-option/div[text()='" + vendor + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + vendor + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + vendor + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectUserAsQAv1sme1(String vendorSme1) {
		pause(2);
		pause(2);
		PresenceOfElement(By.xpath("//md-option/div[text()='" + vendorSme1 + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + vendorSme1 + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + vendorSme1 + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectUserAsQAv1sme2(String vendorSme2) {
		pause(2);
		pause(2);
		PresenceOfElement(By.xpath("//md-option/div[text()='" + vendorSme2 + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + vendorSme2 + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + vendorSme2 + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectQAv1Approver1(String vendorApprover) {
		PresenceOfElement(By.xpath("//md-option/div[text()='" + vendorApprover + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + vendorApprover + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + vendorApprover + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectLoginAsQAVendor2(String vendor) {
		pause(2);
		type(search, vendor);
		// jsClick( qa_testing_btn);
		pause(15);
		clickOn(qa_testing_btn);

		return new TemplateVerificationPage();
	}


	public TemplateVerificationPage selectUserAsQAVendor2(String vendor2) {
		pause(5);
		PresenceOfElement(By.xpath("//md-option/div[text()='" + vendor2 + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + vendor2 + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + vendor2 + "']")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage selectnewUser(String user) {

		type(search, user);
		pause(8);
		clickOn(qa_testing_btn);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickSelectnewUser(String user) {
		PresenceOfElement(By.xpath("//md-option/div[text()='" + user + "']"));
		clickableElement(driver.findElement(By.xpath("//md-option/div[text()='" + user + "']")));
		jsClick(driver.findElement(By.xpath("//md-option/div[text()='" + user + "']")));
		return new TemplateVerificationPage();
	}


	@FindBy(xpath = "//button[@ng-click='vm.startAmendment()' and contains(text(),'Start an amendment')]")
	WebElement amendmentBtn;

	public TemplateVerificationPage clickOnAmendmentBtn() {
		scrollToElementTillTrue(amendmentBtn);
		pause(5);
		PresenceOfElement(
				By.xpath("//button[@ng-click='vm.startAmendment()' and contains(text(),'Start an amendment')]"));
		clickableElement(amendmentBtn);
		jsClick(amendmentBtn);
		pause(5);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnNewQuestion() {

		scrollToElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]"));
		clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//div[contains(text(),'Amendment/Addendum List')]")
	WebElement amendmentListLabel;

	public TemplateVerificationPage scrollTillAmendmentList() {
		pause(3);
		scrollToElement(amendmentListLabel);
		scrollToElementTillTrue(amendmentListLabel);
		pause(2);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//*[@ng-model='vm.send_email']")
	WebElement sendAsEmail;

	public TemplateVerificationPage sendAsEmail(String email) {
		pause(3);
		PresenceOfElement(By.xpath("//*[@ng-model='vm.send_email']"));
		sendAsEmail.sendKeys(email);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-icon[@md-font-icon='icon-plus']")
	WebElement plus_icon;

	public TemplateVerificationPage clickOnPlusButtonInSendasEmail() {
		PresenceOfElement(By.xpath("//md-icon[@md-font-icon='icon-plus']"));
		clickableElement(plus_icon);
		jsClick(plus_icon);
		pause(2);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//button[text()='Send']")
	WebElement send_button;

	public TemplateVerificationPage clickOnSendButtonInSendasEmail() {
		PresenceOfElement(By.xpath("//button[text()='Send']"));
		clickableElement(send_button);
		jsClick(send_button);
		pause(2);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnMail() {
		boolean visibility = visibilityOfElementLocated(
				By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'GreenRFP')]"));
		if (visibility) {
			jsClick(driver.findElement(
					By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'GreenRFP')]")));
		}
		else
		{
			driver.navigate().refresh();
			waitForPageLoaded();
		}
		jsClick(driver
				.findElement(By.xpath("//td[contains(text(),'The Green RFP')]/..//td[contains(text(),'GreenRFP')]")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "(//button[text()='Send'])[2]")
	WebElement send_buttonRfp;

	public TemplateVerificationPage clickOnRFPSendButtonInSendasEmail() {
		PresenceOfElement(By.xpath("(//button[text()='Send'])[2]"));
		clickableElement(send_buttonRfp);
		jsClick(send_buttonRfp);
		pause(2);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnContinueButtonSave(String sectionTab) {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//button[contains(@ng-click,'" + sectionTab + "')]")));
		PresenceOfElement(By.xpath("//button[contains(@ng-click,'" + sectionTab + "')]"));
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'" + sectionTab + "')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage uploadAttachment() throws AWTException {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//*[contains(text(),'Upload Attachment')]")));
		PresenceOfElement(By.xpath("//*[contains(text(),'Upload Attachment')]"));
		WebElement element = driver.findElement(By.xpath("//input[contains(@aria-label,'input')]"));
		String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/nature.jpg";
		element.sendKeys(dataFilePath);
		return new TemplateVerificationPage();

	}

	public TemplateVerificationPage clickSkipApprovalTemplate() {
		pause(5);
		scrollToElementTillTrue(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		pause(1);
		PresenceOfElement(By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]"));
		clickableElement(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		jsClick(driver.findElement(
				By.xpath("//md-checkbox[@aria-label='SKIP APPROVALS']/div[contains(@class,'md-container')]")));
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//md-select[@ng-model='vm.rfp_timezone']")
	WebElement time_zone;

	public TemplateVerificationPage scrollTillTimeZone() {
		pause(5);
		scrollToElement(time_zone);
		pause(3);

		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickOnNeedContinueButton(String sectionTab) {
		pause(3);
		scrollToElement(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		PresenceOfElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]"));
		jsClick(driver.findElement(
				By.xpath("//button[contains(text(),'CONTINUE') and contains(@ng-click,'" + sectionTab + "')]")));
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage scrollTillAcceptedTaskList() {
		pause(3);
		scrollToElement(acceptedTaskListLabel);
		scrollToElementTillTrue(acceptedTaskListLabel);
		pause(2);
		return new TemplateVerificationPage();
	}

	@FindBy(xpath = "//*[(contains(@ng-click,'vm.saveSelfSme'))]/..//button[text()[normalize-space()='SAVE']]")
	WebElement saveBtnn;

	public TemplateVerificationPage clickOnSavebuttonn() {
		scrollToElement(saveBtn);
		waitforElementClickable(saveBtnn, explicitWait);
		pause(3);
		PresenceOfElement(
				By.xpath("//*[(contains(@ng-click,'vm.saveSelfSme'))]/..//button[text()[normalize-space()='SAVE']]"));
		clickableElement(saveBtnn);
		jsClick(saveBtnn);

		return new TemplateVerificationPage();
	}
	@FindBy(xpath = "//div[@md-steppers-template='::step.template']//md-tab-item[@tabindex='-1']")
	WebElement Sections;

	public TemplateVerificationPage scrollTillSections() {
		pause(3);
		scrollToElement(Sections);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage clickNewQuestion() {
		pause(3);
		scrollToElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		PresenceOfElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]"));
		clickableElement(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		jsClick(driver.findElement(By.xpath("(//button[contains(text(),'NEW QUESTION')])[1]")));
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage fillNewQuestion(String answerType, String question, String questionWeight) {
		switch (answerType) {

		case "newQuestion":
			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Free Form']"));
			clickableElement(freeFormOption);
			jsClick(freeFormOption);
			pause(3);
			addquestioninTextArea.sendKeys(question);
			pause(2);
			break;
		case "freeForm":

			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Free Form']"));
			clickableElement(freeFormOption);
			jsClick(freeFormOption);
			pause(3);
			addquestioninTextArea.sendKeys(question);
			pause(2);
			break;
		case "yesNo":
			pause(2);
			PresenceOfElement(By.xpath("//md-select[@aria-label='Answer Type']"));
			clickableElement(answerTypeFiled);
			jsClick(answerTypeFiled);
			pause(2);
			PresenceOfElement(By.xpath("//md-option[@value='Yes/No']"));
			clickableElement(yesNoOption);
			jsClick(yesNoOption);
			pause(3);
			PresenceOfElement(By.xpath("//div[contains(@ng-if,'vm.answer_type')]//md-radio-button[@aria-label='Yes']"));
			clickableElement(yes_radio_btn);
			jsClick(yes_radio_btn);
			enterDataIn(addquestioninTextArea, question);

			PresenceOfElement(By.xpath("//md-select[@placeholder='Select']"));
			clickableElement(select_btn);
			jsClick(select_btn);
			PresenceOfElement(By.xpath("//div[text()='Correct']"));
			clickableElement(correct_btn);
			jsClick(correct_btn);
			pause(2);
			break;
		}
		PresenceOfElement(By.xpath("//md-select[contains(@aria-label,'Question Weight')]"));
		clickableElement(questionWeightField);
		jsClick(questionWeightField);
		pause(2);
		PresenceOfElement(By.xpath("//md-option[@value='Medium']"));
		clickableElement(mediumQuestionWeightOption);
		jsClick(mediumQuestionWeightOption);
		pause(3);
		return new TemplateVerificationPage();
	}

	public TemplateVerificationPage searchUserUnderAdministration(String username) {
		pause(3);
		PresenceOfElement(By.xpath("//md-icon[@aria-label='icon-magnify']"));
		clickableElement(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		pause(3);
		jsClick(driver.findElement(By.xpath("//md-icon[@aria-label='icon-magnify']")));
		PresenceOfElement(By.xpath("//input[contains(@data-ng-model,'search')]"));
		clickableElement(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		jsClick(driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")));
		pause(3);
		driver.findElement(By.xpath("//input[contains(@data-ng-model,'search')]")).sendKeys(username);
		pause(3);
		return new TemplateVerificationPage();
	}
}
