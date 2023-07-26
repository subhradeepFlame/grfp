package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class RFPIndexPageTest extends BaseClass {

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";

	@Test(priority = 1)
	public void createRFP() {
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Perform login");
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
		logger.info("Enter SME 1, Add question and required permission for Introduction section");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme2@mailinator.com  for Edit Section Description.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme2@mailinator.com ",
				"Edit Section Description", 2, dateFormat.format(date));
		logger.info("Enter SME 2, Add question and required permission for Indroduction section");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Questions permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Objectives", "qanarolasme1@mailinator.com", "Add Questions", 1,
				dateFormat.format(date));
		logger.info("Enter SME 1, Add question and required permission for Objective section");
		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme2@mailinator.com for 'Both' Description.");
		rfpVerificationPage = rfpIndexPage.enterSME("Objectives", "qanarolasme2@mailinator.com", "Both", 2,
				dateFormat.format(date));
		logger.info("Enter SME 2, Add question and required permission for Objective section");
		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();
		logger.info("Clicked on Save button");

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");
		logger.info("Verifyed Orange email icon for SME");
		testStepsLog("Verification", " VerifyOrange task icon for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyPendingTaskIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange task icon is not visible.");
		logger.info("Verify Orange email icon for SME");
		testStepsLog("Verification", " VerifyGreen plus icon for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyPlusIconForSME("Introduction", 2);
		Assert.assertTrue(orangeEmailIconVisible, "Green Plus icon is not visible.");
		logger.info("Verifyed Green plus icon for SME");
		testStepsLog("Verification", " VerifyResend,Reassign,Delete icons for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyResendReassignDeleteIcons("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, " Resend,Reassign,Delete icons are not visible.");
		logger.info("Verifyed Resend,Reassign,Delete icons for SME.");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		rfpVerificationPage = rfpIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on Help My SME Button");

		closingSession();
		loginAsFor("Customer SME 1");
		rfpIndexPage.waitForDashboardToBeReady();
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
		pause(3);
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to Pending task section");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Objectives");
		logger.info("Accept Incoming request");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on YEs button");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Objectives");
		logger.info("Clecked on new Question For objective section");
		answerType = "yesNo";
		question = "Objectives section question 1";
		questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Objectives");
		logger.info("Add new question in Objective Section");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on Save and Continue");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes Button");

		closingSession();

		loginAsFor("Customer SME 2");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to Pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		logger.info("Accept request for Introduction Section");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Edit the section.");
		templateVerificationPage = templateIndexPage.editDescription1("Introduction");
		logger.info("Edit Description for Introduction Section");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on Save and submmit ");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes Button");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Objectives");
		logger.info("Accept request for Objective Section");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Cliked on Yes button");
		testStepsLog("Step " + (stepCount++), " Edit the section.");
		templateVerificationPage = templateIndexPage.editDescription1("Objectives");
		logger.info("Edit Section of Objective Section");
		testStepsLog("Step " + (stepCount++), " Scroll on Objective section page till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtn();
		logger.info("Scroll till new Question Button");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Objectives");
		logger.info("Clicked on New Question of Objective Section");
		answerType = "yesNo";
		question = "Objectives section question 2";
		questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Objectives");
		logger.info("Add question for objective section");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save question button");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on Save and Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes button");

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
		logger.info("Clicked on yes button after 'Approve all' for 'Introduction' section");
		testStepsLog("Verification", " Verify'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");
		logger.info("Section Verifyed");
		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Objectives");
		logger.info("Clicked on Objective tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		logger.info("Clicked on aprove all");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Objectives' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Verification", " Verify'Approved' icon for 'Objectives' section.");
		Boolean sectionObjectivesApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionObjectivesApproved, "Objective section not approved");
		logger.info("Objective Section Approved");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		logger.info("Clicked on continue button");
		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover1@mailinator.com");
		logger.info("Approver added");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
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

		closingSession();

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Select RFP");
		testStepsLog("Step " + (stepCount++), " Click on 'Approver' bubble tab");
		rfpVerificationPage = rfpIndexPage.clickOnApproverBubble();
		logger.info("Clicked on Approve Section");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on save approve");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		logger.info("Clicked on Skip Evaluators");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");
		logger.info("Clicked on skip Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on PDF icon.");
		rfpVerificationPage = rfpIndexPage.clickOnPDFIcon();
		logger.info("Clicked on pdf icon");
		String RFPname = rfpName.replace(rfpName.charAt(8), '-');

		testStepsLog("Verification", " Verify downloaded PDF is opened in a new tab.");
		Boolean reportIsGenerated = rfpVerificationPage
				.verifyPDFDownloaded("https://" + env + ".thegreenrfp.com/upload/Rfps/" + RFPname + ".pdf");

		Assert.assertTrue(reportIsGenerated, "PDF is not downloaded ");
		logger.info("PDf downloded");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		logger.info("Clicked on Publish");
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qa-Vend@mailinator.com");
		logger.info("Add Vendor");
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		logger.info("Send RFP to Vendor");
		testStepsLog("Step " + (stepCount++), " Click on Resend button.");
		rfpVerificationPage = rfpIndexPage.clickResendBtn("1");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Verification",
				" Verify success message 'Invitation Mail have been successfully sent.' displayed.");
		reportIsGenerated = rfpVerificationPage.verifyErrorMessage("Invitation Mail have been successfully sent.");
		Assert.assertTrue(reportIsGenerated, "success message is not displaying.");

		testStepsLog("Step " + (stepCount++), " Click on Delete button.");
		rfpVerificationPage = rfpIndexPage.clickDeleteBtn("qa-vend@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qa_vendor1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");

	}

}