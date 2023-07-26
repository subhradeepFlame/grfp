package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative08 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test
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
	}

}
