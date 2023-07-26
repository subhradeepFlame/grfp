package com.green.rfp.qa.bugs.testcases;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class NoInlineAddendums extends BaseClass {

	@Test(priority = 2)
	public void verifyQuestionSectionIfRatingNotGiven() {
		superAdminloginValid();
		String rfpName = getCurrentTimeStampString();

		String answerType = "freeForm";
		String questionWeight = "Medium";

		loginAsFor("Customer Admin");

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

		logger.info("Rfp created");

		testStepsLog("Step " + (stepCount++), " Click on Summary Bubble");
		rfpVerificationPage = rfpIndexPage.clickOnSummaryBubble();
		logger.info("Clicked On summary ");

		testStepsLog("Step " + (stepCount++), " Deseable inline");
		rfpVerificationPage = rfpIndexPage.deseableInlineAddendums();
		logger.info("desable ");

		testStepsLog("Step " + (stepCount++), " Click on Continue");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButton("Rfp");
		logger.info("continue ");

		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		logger.info("Section created");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		logger.info("Selected date");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as " + getEmail("Customer SME 1") + " for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", getEmail("Customer SME 1"), "Add Questions", 1,
				dateFormat.format(date));
		logger.info("Entered SME as " + getEmail("Customer SME 1") + " for Indroduction section");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as " + getEmail("Customer SME 2") + " for Edit Section Description.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", getEmail("Customer SME 2"),
				"Edit Section Description", 2, dateFormat.format(date));
		logger.info("Entered SME as " + getEmail("Customer SME 2") + " for Indroduction section");

		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		rfpVerificationPage = rfpIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on Help My Sme Button");
		pause(6);
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		logger.info("Clicked and accept pending task ");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		logger.info("Clicked on New Question");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Introduction section question 1",
				questionWeight, "Introduction");
		logger.info("Added question");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save Question");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on Save and Submit");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes");
		loginAsFor("Customer SME 2");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes");
		testStepsLog("Step " + (stepCount++), " Edit the section.");
		// templateVerificationPage = templateIndexPage.editDescription("Introduction");
		templateVerificationPage = templateIndexPage.editDescription1("Introduction");
		logger.info("Edited Section");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on save");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Yes RFP link");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");
		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();
		logger.info("Clicked on review tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		logger.info("Clicked on Aprove all");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Verification", " Verify 'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");
		logger.info("Approved");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		logger.info("Clicked on continue button");
		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", getEmail("Customer Approver 1"));
		logger.info("Clicked on Approve tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on save  button");
		loginAsFor("Customer Approver 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();
		logger.info("Clicked on Go button");
		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();
		logger.info("Clicked on Approve");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		closingSession();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Rfp link Button");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Rfp selected");
		testStepsLog("Step " + (stepCount++), " Click on 'Approvers' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnApproverBubble();
		logger.info("Clicked on Approve bubble");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");
		logger.info("Clicked on approve tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		logger.info("Clicked on publish Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Evaluators' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnEvaluatorsBubble();
		logger.info("Clicked on Evaluators tab");

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
		logger.info("Verified");

		Assert.assertTrue(reportIsGenerated, "PDF is not downloaded ");
		logger.info("PDf downloded");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		logger.info("Clicked on Publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor(getEmail("Vendor2"));
		logger.info("Rfp vender added");
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		logger.info("Clicked on Send");
		closingSession();
		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		logger.info("Clicked on continue button");
		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("1");
		logger.info("Clicked on Assigned to Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();
		logger.info("Clicked on Assign button");
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor sme: " + getUsername("Vendor2 Sme1"));
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1(getEmail("Vendor2 Sme1"));
		logger.info("Added vender sme1");
		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();
		logger.info("Clicked and entered due date");
		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();
		logger.info("Clicked on Send button");
		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();
		logger.info("Clicked on Yes button");

		testStepsLog("Verification", " Verify 'clarification' icon is displayed at Answer section.");
		boolean clarification = rfpVerificationPage.verifyclarificationIconNot("Introduction section question 1");
		assertTrue(clarification);

	}

}
