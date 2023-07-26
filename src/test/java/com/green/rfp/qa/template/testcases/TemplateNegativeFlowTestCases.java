package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.pages.DashboardIndexPage;
import com.green.rfp.qa.pages.DashboardVerificationPage;
import com.green.rfp.qa.pages.TemplateIndexPage;
import com.green.rfp.qa.pages.TemplateVerificationPage;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegativeFlowTestCases extends BaseClass {

	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test(priority = 2)
	public void templateDeleteByAdmin() {
		testCaselog("Template POC");
		deleteCookies();
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), "Click log in as Customer Admin.");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), "Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Objectives");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click on Template link again to delete the created template.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template checkbox=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplateCheckbox(templateName);

		testStepsLog("Step " + (stepCount++), " Click on delete icon from header");
		templateVerificationPage = templateIndexPage.selectActionsFromHeader("Delete");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 3)
	public void templateTaskAcceptBySME() {
		int numOfFailure = 0;

		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";
		String section = "Introduction";
		testCaselog("Template POC");

		pause(3);

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Login  as Customer Admin");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();

		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com   for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com  ", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on Take me to Dashboard button.");
		templateVerificationPage = templateIndexPage.clickOnTakeMeToDashboard();

		testStepsLog("Step " + (stepCount++), " Verify user has redireted to Dashboard page.");
		Boolean isDashboardPageVerified = dashboardVerificationPage.verifyDashboardPage("CustomerAdmin");
		Assert.assertTrue(isDashboardPageVerified, "Dashboard page is not displayed.");
		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Edit option");
		templateVerificationPage = templateIndexPage.selectEditOption("Edit");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.editQuestionData("1. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Verify Edited Question is present.");
		Boolean taskAcceptedIconVisible = templateVerificationPage
				.verifyEditedQuePresent("1. Edited Introduction section question 1");
		Assert.assertTrue(taskAcceptedIconVisible, "Edited question is not present.");

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to delete the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("1. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Delete option");
		templateVerificationPage = templateIndexPage.selectDeleteOption("Delete");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify blue icon for task accepted by SME.");
		taskAcceptedIconVisible = templateVerificationPage.verifyTaskAcceptedIconBySME("Introduction");
		Assert.assertTrue(taskAcceptedIconVisible, "Task accepted blue icon is not visible.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveQuestions(true)");

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestionss();

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Edit option");
		templateVerificationPage = templateIndexPage.selectEditOption("Edit");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.editQuestionData("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Verify Edited Question is present.");
		taskAcceptedIconVisible = templateVerificationPage
				.verifyEditedQuePresentAtReviewTab("2. Edited Introduction section question 1");
		Assert.assertTrue(taskAcceptedIconVisible, "Edited question is not present.");

		testStepsLog("Step " + (stepCount++), " Click on down arrow to see log.");
		templateVerificationPage = templateIndexPage
				.clickOnDownArrowForLog("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Verify Logs are present.");
		taskAcceptedIconVisible = templateVerificationPage.verifyLogDisplayed("QaNarola Sme1");
		Assert.assertTrue(taskAcceptedIconVisible, "logs are not displaying.");

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage
				.clickOnDotsIconAtReviewTab("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Delete option");
		templateVerificationPage = templateIndexPage.selectDeleteOptionAtReviewTab("Delete");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

	@Test(priority = 4)
	public void templateRejectBySME() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		pause(3);

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);
		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Reject from pending task list button.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskRejectButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Insert SME task reject reason.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskRejectReason(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click send button of reject popup button.");
		templateVerificationPage = templateIndexPage.sendRejectReasonButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 5)
	public void templateRejectByOwner() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";
		String section = "Introduction";
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Verify Approve and Reject buttons present for questions.");
		Boolean orangeEmailIconVisible = templateVerificationPage
				.verifyApproveAndRejectButton("Introduction section question 1", "Assigned Questions for Introduction");
		Assert.assertTrue(orangeEmailIconVisible, "Approve and Reject buttons not present for questions.");

		testStepsLog("Step " + (stepCount++), " Click 'Reject' button for the task added by sme.");
		templateVerificationPage = templateIndexPage.clickOnRejectButton("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Give reject reason and click on send button");
		templateVerificationPage = templateIndexPage.giveRejectReason("Reject task");

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify that Reject SME Task Icon changes to Orange colour.");
		Boolean Rejectsmetaskicon = templateVerificationPage.verifyTaskPendingIcon();
		Assert.assertTrue(Rejectsmetaskicon, "Task is still in Pending state");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 6)
	public void templateTaskReassignBySME() {
		testCaselog("Template POC");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++),
				" Select SME as qanarolasme2@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.selectSME("Introduction", "qanarolasme2@mailinator.com", 2);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 2);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 2);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 2);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Reassign from pending task list button.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskReassignButton(templateName, "Introduction",
				"qanarolasme1@mailinator.com", "QaNarola Sme1");

		testStepsLog("Step " + (stepCount++), " Click on Reassign from pending task list button.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskReassignButton(templateName, "Introduction",
				"qanarolasme3@mailinator.com", "QaNarola Sme3");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++),
				" Verify After Reassigning the Template task, task will be removed from the Pending Task.");
		boolean rejecttaskinpendingtab = templateVerificationPage
				.verifyReassignTaskisnotDisplayinPendingTab(templateName);
		Assert.assertTrue(rejecttaskinpendingtab, "Error message is not displaying");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++),
				" Verify After Reassigning the Template task, task will be display in another sme Pending Task.");
		Boolean reassignAnothersmeinpendingtab = templateVerificationPage
				.verifyReassignTaskisDisplayinAnotherSMEPendingTab(templateName);
		Assert.assertTrue(reassignAnothersmeinpendingtab, "Task is not displaying in another sme pending tab.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify Reassign icon and User should be displayy in the SME TAb.");
		Boolean reassignicon = templateVerificationPage.verifyReassignIconPresent("QaNarola Sme2");
		Assert.assertTrue(reassignicon, "Icon or USer name not displayed");

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 7) // approver pending task in dashboard bug is there
	public void templateTaskAcceptByApprover() {
		testCaselog("Template POC");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		pause(3);
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click continue button section tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click continue button sme tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click Continue button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("All Approvers in Any Order",
				"qanarolaapprover1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers' tab");
		templateVerificationPage = templateIndexPage.addQAApprover("All Approvers in Any Order",
				"qanarolaapprover3@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.templateClickDashboardAccBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 3");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.templateClickDashboardAccBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Verify User redirects to Publish Bubble-Tab.");
		Boolean checkPublishScreen = templateVerificationPage.verifycheckPublishScreenDisplay();
		Assert.assertTrue(checkPublishScreen, "User redirects to Publish Bubble-Tab.");

		pause(3);
		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

	@Test(priority = 8) // approver pending task in dashboard bug is there
	public void templateTaskHoldByApprover() {
		testCaselog("Template POC");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		pause(3);
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click continue button section tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click continue button sme tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click Continue button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("All Approvers in Any Order",
				"qanarolaapprover1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.templateClickDashboardAccBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();

		testStepsLog("Step " + (stepCount++), " Click on Hold button.");
		templateVerificationPage = templateIndexPage.clickOnHoldButton();

		testStepsLog("Step " + (stepCount++), " Add Hold Reason.");
		templateVerificationPage = templateIndexPage.enterHoldReason();

		testStepsLog("Step " + (stepCount++), " Click on Send button.");
		templateVerificationPage = templateIndexPage.clickOnSendButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Step " + (stepCount++), " Click on perticular Template.");
		templateVerificationPage = templateIndexPage.ClickontemplateByName(templateName);

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Verify User redirects to Publish Bubble-Tab.");
		Boolean checkPublishScreen = templateVerificationPage.verifycheckPublishScreenDisplay();
		Assert.assertTrue(checkPublishScreen, "User redirects to Publish Bubble-Tab.");

		pause(3);
		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 9) // approver pending task in dashboard bug is there
	public void templateTaskRejectByApprover() {
		testCaselog("Template POC");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click continue button section tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click continue button sme tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click Continue button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Reject button from pending task list.");
		templateVerificationPage = templateIndexPage.dashboardApproverTaskRejectButton(templateName);

		testStepsLog("Step " + (stepCount++), " Insert task reject reason.");
		templateVerificationPage = templateIndexPage.dashboardApproverTaskRejectReason();

		testStepsLog("Step " + (stepCount++), " Click send button of reject popup button.");
		templateVerificationPage = templateIndexPage.sendRejectReasonButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click template approver bubble.");
		templateVerificationPage = templateIndexPage.clickTemplateApproverBubble();

		testStepsLog("Step " + (stepCount++),
				" Verify 'Reject' label on approver tab once task is rejected by approver.");
		Boolean approvertaskRejectedTextVisible = templateVerificationPage.verifyTaskRejectedIconByApprover();
		Assert.assertTrue(approvertaskRejectedTextVisible,
				"'Reject' label is not displayed on approver tab once task is rejected by approver.");

		pause(3);
		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

	@Test(priority = 10) // approver pending task in dashboard bug is there
	public void templateTaskReassignByApprover() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);
		pause(2);
		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click continue button section tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click continue button sme tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click Continue button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Approver 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click Reassign from pending task list button.");
		templateVerificationPage = templateIndexPage.clickDashboardReassignBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Insert Reassign email id and message.");
		templateVerificationPage = templateIndexPage.templateTaskReassignEmailForApprover3(templateName);

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click template approver bubble.");
		templateVerificationPage = templateIndexPage.clickTemplateApproverBubble();

		testStepsLog("Step " + (stepCount++), " Verify task reassigned approver is display.");
		Boolean taskReassignedToOtherApprover = templateVerificationPage.verifyReassinedApprover3IsDisplay();
		Assert.assertTrue(taskReassignedToOtherApprover, "Reassigned approver is not displaying.");

		pause(3);

		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 11)
	public void TaskAcceptBySMEthroughTemplate() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on Accept button.");
		templateVerificationPage = templateIndexPage.clickAcceptButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Verify NewQuestion button is Enabled");
		Boolean newquestionenabled = templateVerificationPage.verifyNewQuestionbuttonEnabled();
		Assert.assertTrue(newquestionenabled, "Button is Disabled");

		testStepsLog("Step " + (stepCount++), " Verify Import button is Enabled");
		Boolean importbutton = templateVerificationPage.verifyImportButtonEnabled();
		Assert.assertTrue(importbutton, "Button is Disabled");

		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickSavebutton();

		testStepsLog("Step " + (stepCount++), " Click on Dashboared Sidepannel");
		templateVerificationPage = templateIndexPage.clickonDashboardLeftSidePannel();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++),
				" Verify that Accept SME Task Icon changes to blue colour from the Orange colour.");
		Boolean acceptsmetaskicon = templateVerificationPage.verifyTaskacceptedIcon(1);
		Assert.assertTrue(acceptsmetaskicon, "Task is still in Pending state");

		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 12)
	public void TaskRejectedBySMEthroughTemplate() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();
		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on Reject button.");
		templateVerificationPage = templateIndexPage.clickRejectButton();

		testStepsLog("Step " + (stepCount++), " Insert SME task reject reason.");
		templateVerificationPage = templateIndexPage.enterrejectReason();

		testStepsLog("Step " + (stepCount++), " Click send button of reject popup button.");
		templateVerificationPage = templateIndexPage.dialogRejectButton();

		testStepsLog("Step " + (stepCount++), " Click on Dashboared Sidepannel");
		templateVerificationPage = templateIndexPage.clickonDashboardLeftSidePannel();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		pause(3);
		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

	@Test(priority = 13)
	public void TaskReassignedBySMEthroughTemplate() {
		testCaselog("Template POC");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on Reassign button.");
		templateVerificationPage = templateIndexPage.clickReassignButton();

		testStepsLog("Step " + (stepCount++), " Assign to another sme.");
		templateVerificationPage = templateIndexPage.inputReassigndialouge("qanarolasme2@mailinator.com",
				"Assign to sme2");

		testStepsLog("Step " + (stepCount++), " Click on Dashboared Sidepannel");
		templateVerificationPage = templateIndexPage.clickonDashboardLeftSidePannel();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++),
				" Verify After Reassigning the Template task, task will be display in another sme Pending Task.");
		Boolean reassignAnothersmeinpendingtab = templateVerificationPage
				.verifyReassignTaskisDisplayinAnotherSMEPendingTab(templateName);
		Assert.assertTrue(reassignAnothersmeinpendingtab, "Task is not displaying in another sme pending tab.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " ");
		Boolean reassignicon = templateVerificationPage.verifyReassignIconPresent("QaNarola Sme2");
		Assert.assertTrue(reassignicon, "Icon or USer name not displayed");

		pause(3);

		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

	@Test(priority = 14)
	public void checkCommentFunctionalityInTemplate() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		String comonTemplateName = templateName;
		System.out.println("-----comonTemplateName----" + comonTemplateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		// Verification of edit and delete icon
		Boolean isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Introduction");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Introduction' section.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qa_csme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData("freeForm", "Introduction section question 1",
				"Medium", "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		Boolean isQuestionAdded = templateVerificationPage.verifyQuestionAdded();
		Assert.assertTrue(isQuestionAdded, "Question is not added successfully.");

		testStepsLog("Step " + (stepCount++), " Comment given by csme1 to CAdmin.");
		templateVerificationPage = templateIndexPage.commentBySME("QaNarola Sme1", "Comment given by csme1.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Verify comment count is same as given.");
		boolean verifyCommentOnTemplateCreation = templateVerificationPage
				.verifyCommentCount("Introduction section question 1");
		Assert.assertTrue(verifyCommentOnTemplateCreation, "Comment count is not same.");

		testStepsLog("Step " + (stepCount++), " Verify comment is visible for CAdmin.");
		verifyCommentOnTemplateCreation = templateVerificationPage.verifyCommentFromTemplateCreated(1);
		Assert.assertTrue(verifyCommentOnTemplateCreation, "Comment is visible at template creation place.");

		testStepsLog("Step " + (stepCount++), " Comment by CAdmin.");
		templateVerificationPage = templateIndexPage.commentBySME("QA-Testing CAdmin", "Comment given by CAdmin.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		pause(3);
		closingSession();

		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();

	}

	@Test(priority = 15)
	public void smeDeleteFunctionality() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Click on Support left link.");
		dashboardVerificationPage = dashboardIndexPage.clickSupportLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on Content left link.");
		dashboardVerificationPage = dashboardIndexPage.clickContentLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on Create Button.");
		templateVerificationPage = templateIndexPage.clickOnCreatebutton();

		String name = randomStringGenerate();
		testStepsLog("Step " + (stepCount++), " Enter content details such as name and Price.");
		templateVerificationPage = templateIndexPage.enterContentDetails(name, "1");

		testStepsLog("Step " + (stepCount++), " Click on Import button.");
		templateVerificationPage = templateIndexPage.clickOnImport();

		testStepsLog("Step " + (stepCount++), " Click on Import Content link.");
		templateVerificationPage = templateIndexPage.clickOnImportContentLink();

		testStepsLog("Step " + (stepCount++), " Click on Done button.");
		templateVerificationPage = templateIndexPage.clickOnDoneButton();

		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		String comonTemplateName = templateName;
		System.out.println("-----comonTemplateName----" + comonTemplateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme2@mailinator.com for Edit Section Description.");
		templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme2@mailinator.com",
				"Edit Section Description", 2);

		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebuttonn();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Verify needs tab displays saved details successfully.");
		Boolean needsTab = templateVerificationPage.verifyNeedsTab("Introduction");
		Assert.assertTrue(needsTab, "Needs tab is not displaying information");

		String userFirstname = "qanarolasme2";
		driver.get(inboxLink + userFirstname + "#/#inboxpane");

		testStepsLog("Step " + (stepCount++), " Verify invitation link for the sme task is present.");
		Boolean invitationMail = templateVerificationPage.verifysmeInvitationMail();
		Assert.assertTrue(invitationMail, "Invitation link for the sme task is not present");

		driver.navigate().back();
		pause(4);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Click on Delete button of CSME 2.");
		templateVerificationPage = templateIndexPage.deleteSme("2");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Delete button of CSME 1.");
		templateVerificationPage = templateIndexPage.deleteSme("1");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		// import functionality
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on 'Import' button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnImportButton();

		testStepsLog("Step " + (stepCount++), " Import Question.");
		templateVerificationPage = templateIndexPage.importQuestion();

		testStepsLog("Step " + (stepCount++), " Verify Imported question displayed with delete icon.");
		invitationMail = templateVerificationPage.verifyImportedQuestionAndDeleteIcon();
		Assert.assertTrue(invitationMail, "Imported question and delete icon are not present");

		testStepsLog("Step " + (stepCount++), " Click on done button.");
		templateVerificationPage = templateIndexPage.clickOnDoneButton();

		testStepsLog("Step " + (stepCount++), " Click on 'Question database' button.");
		templateVerificationPage = templateIndexPage.clickQueDatabase();

		testStepsLog("Step " + (stepCount++), " Click on 'Question database' checkbox.");
		templateVerificationPage = templateIndexPage.checkQueDatabase(name);

		testStepsLog("Step " + (stepCount++), " Click on 'save' button.");
		templateVerificationPage = templateIndexPage.clickSavebuttonForQueDatabase();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);
		// invitation for approver

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers' tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover3@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on Approvers tab");
		templateVerificationPage = templateIndexPage.saveApprovers();

		testStepsLog("Step " + (stepCount++), " Verify email icon is in orange color.");
		Boolean icon = templateVerificationPage.verifyOrangeColorForEmailIcon();
		Assert.assertTrue(icon, "Email icon is not having orange color");

		userFirstname = "qanarolaapprover3";
		driver.get(inboxLink + userFirstname + "#/#inboxpane");

		testStepsLog("Step " + (stepCount++), " Verify invitation link for the approver is present.");
		invitationMail = templateVerificationPage.verifyApproverInvitationMail();
		Assert.assertTrue(invitationMail, "Invitation link for the approver is not present");

		driver.navigate().back();
		pause(4);

	}

}
