package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class VerifyRFPApproverNotification extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";

	@Test(priority = 2)
	public void verifyRFPApproverNotificationToApproveBeforeSMEHasCompletedTheirWork() throws Exception {
		String rfpName = getCurrentTimeStampString();

		testCaselog("RFP POC");
		superAdminloginValid();

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");

		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		logger.info("Verifiyed RFP type is selected");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		logger.info("Create RFP and filled out required fields");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");

		logger.info("Cliked on Details Pricing");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com ", "Add Questions", 1,
				dateFormat.format(date));
		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();
		logger.info("Clicked on Save button");
		// Verify icons

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");
		logger.info("Verifyed Orange email icon for SME");

		testStepsLog("Verification", " Verify Orange task icon for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyPendingTaskIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange task icon is not visible.");
		logger.info("Verify Orange email icon for SME");

		testStepsLog("Verification", " Verify Resend,Reassign,Delete icons for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyResendReassignDeleteIcons("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, " Resend,Reassign,Delete icons are not visible.");
		logger.info("Verifyed Resend,Reassign,Delete icons for SME.");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		rfpVerificationPage = rfpIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on Help My SME Button");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("vm.saveQuestions(true)");
		logger.info("Clicked on Continue Button");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("vm.gotoAprrovers(true)");
		logger.info("Clicked on Continue Button");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover1@mailinator.com");
		logger.info("Approver added");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButtonSave("saveApprovers");
		logger.info("Clicked on continue button");

		closingSession();
		loginAsFor("Customer Approver 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");

		testStepsLog("Verification", " Verify approver getting task or not");
		Boolean task = rfpVerificationPage.verifyApproverTask();
		Assert.assertTrue(task, "Task is still in Pending state");

		closingSession();
		loginAsFor("Customer SME 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task and accept the task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		logger.info("Accept request");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes Button");

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		logger.info("Clicked on New Question Button");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Introduction");
		logger.info("Add Question and fill all mandetory information");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Saved Button");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Cliked on Save and Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes Button");

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Select RFP ");
		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();
		logger.info("Click on Review Section");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		logger.info("Click on Approve all");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		pause(3);
		logger.info("Clicked on yes button after 'Approve all' for 'Introduction' section");
		testStepsLog("Verification", " Verify 'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");
		logger.info("Section Verifyed");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		logger.info("Clicked on continue button");

		closingSession();
		loginAsFor("Customer Approver 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);
		logger.info("Clicked on accept request");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();
		logger.info("Clicked on Got it");
		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();
		logger.info("Clicked on approve button");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on Close");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on YEs");

	}

}
