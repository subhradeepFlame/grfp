package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class P2TC001EvaluationComemitteeVerifications extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 1)
	public void evaluation() throws Exception {

		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String questionWeight = "Medium";

		superAdminloginValid();

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Introduction section question 1",
				questionWeight, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Objectives");

		answerType = "yesNo";
		questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Objectives section question 1",
				questionWeight, "Objectives");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Pricing");
		// logger.info("Clicked on new questioned");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Pricing section question 1",
				questionWeight, "Pricing");
		// logger.info("Question added");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Edit the section.");

		templateVerificationPage = templateIndexPage.editDescription1("Introduction");

		testStepsLog("Step " + (stepCount++), " Edit the section.");
		templateVerificationPage = templateIndexPage.editDescription1("Objectives");
		testStepsLog("Step " + (stepCount++), " Scroll on Objective section page till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnObj();
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Objectives");

		answerType = "yesNo";
		questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Objectives section question 2",
				questionWeight, "Objectives");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Edit the section.");

		templateVerificationPage = templateIndexPage.editDescription1("Pricing");

		testStepsLog("Step " + (stepCount++), " Scroll on Pricing section page till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtnprice();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Pricing");

		answerType = "yesNo";
		questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, "Pricing section question 2",
				questionWeight, "Pricing");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Verification", " Verify 'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");
		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Objectives");

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Objectives' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Verification", " Verify 'Approved' icon for 'Objectives' section.");
		Boolean sectionObjectivesApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionObjectivesApproved, "Objective section not approved");
		testStepsLog("Step " + (stepCount++), " Go to 'Pricing' tab");
		rfpVerificationPage = rfpIndexPage.clickOnPricingTab("Pricing");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Pricing' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Verification", " Verify 'Approved' icon for 'Pricing' section.");
		Boolean sectionPricingApproved = templateVerificationPage.verifyApprovedIcon("Pricing");
		Assert.assertTrue(sectionPricingApproved, "Pricing section not approved");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckboxrfp();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on PDF icon.");
		rfpVerificationPage = rfpIndexPage.clickOnPDFIcon();

		String RFPname = rfpName.replace(' ', '-');
		testStepsLog("Verification", " Verify downloaded PDF is opened in a new tab.");
		Boolean reportIsGenerated = rfpVerificationPage
				.verifyPDFDownloaded(con.getUrl() + "upload/Rfps/" + RFPname + ".pdf");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender12@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		closingSession();

		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("1");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v1sme1.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1("qanarolav1sme1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();
		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		testStepsLog("Verification", " Verify 'clarification' icon is displayed at Answer section.");
		boolean clarification = rfpVerificationPage.verifyclarificationIcon("Introduction section question 1");
		Assert.assertTrue(clarification, "'clarification' icon is not displayed at Answer section");

		testStepsLog("Step " + (stepCount++), " Click on Clarification button to ask for clarification from v1sme1.");
		rfpVerificationPage = rfpIndexPage.clickOnClarificationbtn("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Ask clarification needed from CSME.");
		String askClarification = rfpIndexPage.askForClarification();

		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Verification", " Verify down arrow is displayed after adding clarification.");
		clarification = rfpVerificationPage.downArrowDisplay("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrow("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Assign Vender1CSME2 for 'Objectives' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("2");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor CSME2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME2("qanarolav2sme2@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Objectives section question 1", "Yes");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Objectives section question 2", "Yes");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Assign Vender1CSME2 for 'Pricing' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("3");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor CSME2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME2("qanarolav2sme2@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Pricing section question 1", "No");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Pricing section question 2", "No");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on Save button.");
		templateVerificationPage = templateIndexPage.clickSavebutton();

		closingSession();

		loginAsFor("Customer SME 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");
		Boolean notification = rfpVerificationPage.verifyClarificationNotificationformMessagecenter(rfpName,
				"Asked for Clarification");
		Assert.assertTrue(notification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		rfpVerificationPage = rfpIndexPage.clickOnRFPlink(rfpName);

		testStepsLog("Step " + (stepCount++), " Go to Introduction Bubble-Tab");
		rfpVerificationPage = rfpIndexPage.gotoIntroductionTab();

		testStepsLog("Step " + (stepCount++), " Scroll assigned questions for introduction.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Verification", " Verify added 'clarification' is displayed under Questions/Response section.");
		clarification = rfpVerificationPage.verifyClarificationisDisplayed(askClarification);
		Assert.assertTrue(clarification, "Added 'clarification' is not displayed under Questions/Response section"); // Remove
																														// comment

		testStepsLog("Step " + (stepCount++), " Click on Reply button.");
		rfpVerificationPage = rfpIndexPage.clickOnReplyBtn(askClarification);

		testStepsLog("Step " + (stepCount++), " Give clarification.");
		String reply = rfpIndexPage.giveClarification();

		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		closingSession();

		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		testStepsLog("Step " + (stepCount++), " Click on down arrow from Add RFP Helpers bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrow("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		closingSession();

		loginAsFor("Vendor2 Sme1");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");

		testStepsLog("Step " + (stepCount++),
				" Click on yes button for accepting the task for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Vendor2 Sme2");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.acceptTaskFromDashboard(rfpName, "2");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'Questions' section.");
		rfpVerificationPage = rfpIndexPage.scrollToQuestions();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.acceptTaskFromDashboard(rfpName, "1");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'Questions' section.");
		rfpVerificationPage = rfpIndexPage.scrollToQuestions();

		testStepsLog("Step " + (stepCount++), " Click on 'Task' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnTaskBubbletab("Task 2");

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'RFP preview' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company1234", "CompanyTitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");

		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");

		testStepsLog("Step " + (stepCount++), " Add Pricing information details.");
		rfpVerificationPage = rfpIndexPage.enterPricingDetails("5.59", "6.79", "10.53");

		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");

		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");

		testStepsLog("Step " + (stepCount++), " Add 'v1 approver' on Approvers tab");
		rfpVerificationPage = rfpIndexPage.addv1Approver("All Approvers in Any Order", "qanarolav1approver1");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		loginAsFor("Vendor2 Approver1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Go to Approvers bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoApproversBubbletab();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last Look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");

		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on Send tab");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		closingSession();

		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("1");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v2sme1.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1("qanarolav2sme1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Objectives' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("2");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v2sme1.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1("qanarolav2sme1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Objectives section question 1", "Yes");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Objectives section question 2", "Yes");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Pricing' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("3");

		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v2sme1.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1("qanarolav2sme1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();

		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();

		pause(2);
		scrollToElement(driver.findElement(By.xpath("(//button[contains(text(),'SAVE')])[1]")));
		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor("Pricing section question 1", "No");

		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on Save button.");
		templateVerificationPage = templateIndexPage.clickSavebutton();

		closingSession();
		loginAsFor("Vendor3 Sme1");
		// task1

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.acceptTaskFromDashboard(rfpName, "3");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'Questions' section.");
		rfpVerificationPage = rfpIndexPage.scrollToQuestions();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.acceptTaskFromDashboard(rfpName, "2");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'Questions' section.");
		rfpVerificationPage = rfpIndexPage.scrollToQuestions();

		testStepsLog("Step " + (stepCount++), " Click on 'Task' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnTaskBubbletab("Task 2");

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		// task3

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.acceptTaskFromDashboard(rfpName, "1");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'Questions' section.");
		rfpVerificationPage = rfpIndexPage.scrollToQuestions();

		testStepsLog("Step " + (stepCount++), " Click on 'Task' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnTaskBubbletab("Task 3");

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button to finish the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();

		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'RFP preview' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		pause(12);
		testStepsLog("Step " + (stepCount++), " Give Answers from Vendor.");
		rfpVerificationPage = rfpIndexPage.giveAnswersFromVendor1("Pricing section question 2", "No");

		pause(10);
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();

		pause(12);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company123", "CompanyTitle123", "25235634",
				"company123@gmail.com", "Company123Description");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Company Info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");

		testStepsLog("Step " + (stepCount++), " Add Pricing information details.");
		rfpVerificationPage = rfpIndexPage.enterPricingDetails("5.59", "6.79", "10.53");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");

		testStepsLog("Step " + (stepCount++), " 'Continue' button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");

		// skip approval end--------------

		testStepsLog("Step " + (stepCount++), " Add 'v1 approver' on Approvers tab");
		rfpVerificationPage = rfpIndexPage.addv2Approver("All Approvers in Any Order", "qanarolav2approver1");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		closingSession();
		loginAsFor("Vendor3 Approver1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Go to Approvers bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoApproversBubbletab();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last Look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");

		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on Send tab");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		closingSession();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();

		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.giveRatings("QaNarola Vendor1", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatings("QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatingsVendorOne("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingsOne("QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

//				objective rating
		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Objectives");

		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.giveRatings2("QaNarola Vendor1", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.saveRatings2("QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");

		rfpVerificationPage = rfpIndexPage.giveRatings4("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.saveRatings4("QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.giveRatings3("QaNarola Vendor1", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.saveRatings3("QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings5("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatings5("QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		// Pricing rating

		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Pricing");

		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings7("QaNarola Vendor", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss7("QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		// logger.info("Note Added");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings8("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss8("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings9("QaNarola Vendor", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss9("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings10("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss10("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		testStepsLog("Step " + (stepCount++), " Go to 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoSendBubbletab();

		testStepsLog("Step " + (stepCount++), " Click on send button to submit the RFP.");
		rfpVerificationPage = rfpIndexPage.clickOnSend();

		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();

	}

}
