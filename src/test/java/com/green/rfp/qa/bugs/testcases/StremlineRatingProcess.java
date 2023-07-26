package com.green.rfp.qa.bugs.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class StremlineRatingProcess extends BaseClass {
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
		closingSession();
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

		closingSession();
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

		closingSession();
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
		closingSession();
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
		loginAsFor("Customer RFP owner 1");

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
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v1sme1.");
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
		boolean clarification = rfpVerificationPage.verifyclarificationIcon("Introduction section question 1");
		Assert.assertTrue(clarification, "'clarification' icon is not displayed at Answer section");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), " Click on Clarification button to ask for clarification from v1sme1.");
		rfpVerificationPage = rfpIndexPage.clickOnClarificationbtn("Introduction section question 1");
		logger.info("Clicked on Clearification button");
		testStepsLog("Step " + (stepCount++), " Ask clarification needed from CSME.");
		String askClarification = rfpIndexPage.askForClarification();
		logger.info("Ask clerification");
		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on Submmit button");
		testStepsLog("Verification", " Verify down arrow is displayed after adding clarification.");
		clarification = rfpVerificationPage.downArrowDisplay("Introduction section question 1");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrow("Introduction section question 1");
		logger.info("Clicked on down arrow button");

		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();
		logger.info("Scroll to messager tab");
		testStepsLog("Verification", " Verify notification displayed at Message Center.");
		Boolean notification = rfpVerificationPage.verifyClarificationNotificationformMessagecenter(rfpName,
				"Asked for Clarification");
		Assert.assertTrue(notification, "Notification is not displayed at Message Center");
		logger.info("verifyed");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		rfpVerificationPage = rfpIndexPage.clickOnRFPlink(rfpName);
		logger.info("Clicked on RFP link  button");

		testStepsLog("Step " + (stepCount++), " Go to Introduction Bubble-Tab");
		rfpVerificationPage = rfpIndexPage.gotoIntroductionTab();
		logger.info("Clicked on Indroduction  Tab");

		testStepsLog("Step " + (stepCount++), " Scroll assigned questions for introduction.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll to assigned question");
		testStepsLog("Verification", " Verify added 'clarification' is displayed under Questions/Response section.");
		clarification = rfpVerificationPage.verifyClarificationisDisplayed(askClarification);
		Assert.assertTrue(clarification, "Added 'clarification' is not displayed under Questions/Response section"); // Remove
																														// comment
		logger.info("verifyed");
		testStepsLog("Step " + (stepCount++), " Click on Reply button.");
		rfpVerificationPage = rfpIndexPage.clickOnReplyBtn(askClarification);
		logger.info("Clicked on reply button");
		testStepsLog("Step " + (stepCount++), " Give clarification.");
		String reply = rfpIndexPage.giveClarification();
		logger.info("clearification given : "+reply);
		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on submit button");
		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link button");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Clicked and RFp selected");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Click on down arrow from Add RFP Helpers bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrow("Introduction section question 1");
		logger.info("Clicked on down arrow button");

		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");
		logger.info("Clicked on answer button");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 1");
		logger.info("Answer given");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on submmit button");
		closingSession();
		loginAsFor("Vendor2 Sme1");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to Pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++),
				" Click on yes button for accepting the task for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on submmit button");
		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link button");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Clicked and selected RFP");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'RFP preview' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");
		logger.info("Clicked on Continue button");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company1234", "CompanyTitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		logger.info("Added company details");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Add Pricing information details.");
		rfpVerificationPage = rfpIndexPage.enterPricingDetails("5.59", "6.79", "10.53");
		logger.info("Added prize");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");
		logger.info("Clicked on prize bubble");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");
		logger.info("Clicked on Review bubble");

		rfpVerificationPage = rfpIndexPage.addv1Approver("All Approvers in Any Order", "qanarolav1approver1");
		logger.info("Add approver");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on Continue button");

		loginAsFor("Vendor2 Approver1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll till pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);
		logger.info("Clicked and accept task");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();
		logger.info("Clicked on Approve button");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Clicked on RFp link button");
		testStepsLog("Step " + (stepCount++), " Go to Approvers bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoApproversBubbletab();
		logger.info("Clicked on Approve button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");
		logger.info("Clicked on continue button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last Look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on Send tab");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();
		logger.info("Send response");

		closingSession();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link button");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");
		// Rating functionality

		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();
		logger.info("Clicked on review button");
		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll till assigned questioned");

		testStepsLog("Verification", " Verify question is expanded");
		rfpVerificationPage = rfpIndexPage.verifyExpandedorNot("Introduction section question 1");
		logger.info("verifyed");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");
		logger.info("Clicked on Down arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();
		logger.info("Clicked on Go button");
		pause(7);
		testStepsLog("Verification", " Verify Save All Button is Diplsay.");
		boolean saveAll = rfpVerificationPage.verifySaveAllButtonIsDisplay("Introduction section question 1");
		Assert.assertTrue(saveAll, "Save all Button is not Dispalyed.");

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings("QaNarola Vendor", "6");
		logger.info("Rating given");

		testStepsLog("Step " + (stepCount++), " Save all Rating");
		rfpVerificationPage = rfpIndexPage.RateAll("Introduction section question 1");
		logger.info("Rating given");
		pause(8);

		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("Clicked on Report link button");

	}

}
