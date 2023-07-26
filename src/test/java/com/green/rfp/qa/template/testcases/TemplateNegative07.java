package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative07 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test
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

	}

}
