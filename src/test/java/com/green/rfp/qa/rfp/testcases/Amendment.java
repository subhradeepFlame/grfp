package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class Amendment extends BaseClass {

	@Test(priority = 1)
	public void amendmentAndAddendument() {
		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));

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
		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com", "Add Questions", 1,
				dateFormat.format(date));
		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		testStepsLog("Step " + (stepCount++), " Click on Take me to Dashboard button.");
		templateVerificationPage = templateIndexPage.clickOnTakeMeToDashboard();

		closingSession();
		loginAsFor("Customer SME 1");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Introduction");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on 'Needs'");
		rfpVerificationPage = rfpIndexPage.gotoNeedsBubbletab();
		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalrfp();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 3");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender12@mailinator.com");
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), " Select rfpName checkbox=" + rfpName);
		templateVerificationPage = templateIndexPage.selectTemplateCheckbox(rfpName);
		pause(6);
		testStepsLog("Step " + (stepCount++), " Click on Delegate icon from header");
		templateVerificationPage = templateIndexPage.selectActionsFromHeader("Delegate");
		pause(6);
		testStepsLog("Step " + (stepCount++), " Select delegate user from 'select delegate user' dropdown");
		rfpVerificationPage = rfpIndexPage.selectDelegateUser("QaNarola RFP2");
		pause(9);

		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 1");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company1", "CompanyTitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Add Pricing information details.");
		rfpVerificationPage = rfpIndexPage.enterPricingDetails("5.59", "6.79", "10.53");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		closingSession();
		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		// Rating functionality
		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();
		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings("QaNarola Vendor", "5");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.saveRatings("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		testStepsLog("Verification", " Verify 'Start an Amendment' button is present and enabled.");
		Boolean amendmentBtn = rfpVerificationPage.verifyStartanAmendmentBtnEnabled();
		Assert.assertTrue(amendmentBtn, "'Start an Amendment' button is not present and enabled.");
		testStepsLog("Step " + (stepCount++), " Click on 'Start an Amendment' button");
		templateVerificationPage = templateIndexPage.clickOnAmendmentBtn();
		testStepsLog("Step " + (stepCount++), " Click on yes button to start amendment.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Verification",
				" Verify 'Publish amendment' and 'Discard changes' buttons are present and enabled.");
		amendmentBtn = rfpVerificationPage.verifyPublishAndDiscardBtnEnabled();
		Assert.assertTrue(amendmentBtn,
				"'Publish amendment' and 'Discard changes' buttons are not present and enabled.");
		testStepsLog("Step " + (stepCount++), " Click on 'Sections'");
		rfpVerificationPage = rfpIndexPage.gotoSectionsBubbletab();
		testStepsLog("Step " + (stepCount++), " Create new RFP - Section as addendment");
		rfpVerificationPage = rfpIndexPage.createRFPSectionAsAddendment("New Section");
		testStepsLog("Verification", " Verify newly added section is displayed.");
		amendmentBtn = rfpVerificationPage.verifyNewAddedSectionDisplayed("New Section");
		Assert.assertTrue(amendmentBtn, "Section is not added successfully.");
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button to save the sections");
		rfpVerificationPage = rfpIndexPage.clickOnSaveButton();
		testStepsLog("Step " + (stepCount++), " Click on 'Needs' bubble tab");
		rfpVerificationPage = rfpIndexPage.gotoNeedsBubbletab();
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestion();
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData("newQuestion", "New section question 1",
				"Medium", "New Section");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveQuestions(true)");
		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment iconto edit the question.");
		rfpVerificationPage = rfpIndexPage.clickOnDotsIcon("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Select Edit option");
		rfpVerificationPage = rfpIndexPage.selectEditOption("Edit");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		rfpVerificationPage = rfpIndexPage.editQuestionData("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();
		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("New Section", "qanarolasme1@mailinator.com ", "Add Questions", 1,
				dateFormat.format(date));
		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();

		closingSession();
		loginAsFor("Customer RFP owner 2");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButtonDelegate(rfpName, "Delegate for " + rfpName);
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on 'Start an Amendment' button");
		templateVerificationPage = templateIndexPage.clickOnAmendmentBtn();
		testStepsLog("Step " + (stepCount++), " Click on yes button to start amendment.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Verification",
				" Verify error message 'Someone else is working on the amendment of this RFP' displayed.");
		amendmentBtn = rfpVerificationPage.verifyErrorMessage("Someone else is working on the amendment of this RFP");
		Assert.assertTrue(amendmentBtn, "error message is not displaying.");

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on 'Publish Amendment' button.");
		rfpVerificationPage = rfpIndexPage.clickOnPublishBtn();
		testStepsLog("Step " + (stepCount++), " Enter Amendment details.");
		rfpVerificationPage = rfpIndexPage.enterAmendmentDetails("Amendment 1",
				"Changes as follow : Added section and assigned sme");

		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Scroll till Amendment task list.");
		templateVerificationPage = templateIndexPage.scrollTillAmendmentList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcknowledgeBtnFromDashboardADDENDUMLIST(rfpName,
				"been made in this RFP");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		// submit RFP again----------------------------------
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'New section' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("New section question 1");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("New section answer 1");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		closingSession();
		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		// verify notification
		testStepsLog("Step " + (stepCount++), " Scroll till Amendment task list.");
		templateVerificationPage = templateIndexPage.scrollTillAmendmentList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcknowledgeBtnFromDashboardADDENDUMLIST(rfpName,
				"been made in this RFP");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section answer 1");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		testStepsLog("Step " + (stepCount++), " Click on Answer button to give answer for 'New section' section.");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("New section question 1");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("New section answer 1");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company1", "Company1Title", "2523563",
				"company@gmail.com", "Company1Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Add Pricing information details.");
		rfpVerificationPage = rfpIndexPage.enterPricingDetails("5.59", "6.79", "10.53");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.savePricing(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		closingSession();
		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		// Rating functionality
		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();
		// Introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings("QaNarola Vendor", "6");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.saveRatings("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
//		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
//		rfpVerificationPage = rfpIndexPage.giveRatingsVendorOne("QaNarola Vendor", "6");
//		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
//		rfpVerificationPage = rfpIndexPage.saveRatingsOne("QaNarola Vendor");
//		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor2.");
//		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		// New Section rating
		testStepsLog("Step " + (stepCount++), " Switch to 'New Section' tab.");
		rfpVerificationPage = rfpIndexPage.switchToNewSection("New Section");
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestionsFornewSection();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatingsForNewSection("QaNarola Vendor", "5");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.saveRatingsForNewSection("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatingsForNewSectionVendorOne("QaNarola Vendor", "5");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingsForNewSectionVendorOne("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		pause(2);

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on 'Summary'");
		testStepsLog("Verification", " Verify 'Start an Amendment' button is present and enabled.");
		amendmentBtn = rfpVerificationPage.verifyStartanAmendmentBtnEnabled();
		Assert.assertTrue(amendmentBtn, "'Start an Amendment' button is not present and enabled.");
		testStepsLog("Step " + (stepCount++), " Click on 'Start an Amendment' button");
		templateVerificationPage = templateIndexPage.clickOnAmendmentBtn();
		testStepsLog("Step " + (stepCount++), " Click on yes button to start amendment.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on 'Sections'");
		rfpVerificationPage = rfpIndexPage.gotoSectionsBubbletab();
		testStepsLog("Step " + (stepCount++), " Create new RFP - Section as addendment");
		rfpVerificationPage = rfpIndexPage.createRFPSectionAsAddendment("Section1");
		testStepsLog("Verification", " Verify newly added section is displayed.");
		amendmentBtn = rfpVerificationPage.verifyNewAddedSectionDisplayed("Section1");
		Assert.assertTrue(amendmentBtn, "Section is not added successfully.");
		testStepsLog("Step " + (stepCount++), " Click on 'Discard Changes' button");
		rfpVerificationPage = rfpIndexPage.clickOnDiscardChangesBtn();
		testStepsLog("Step " + (stepCount++), " Click on yes button to discard amendment.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on 'Sections'");
		rfpVerificationPage = rfpIndexPage.gotoSectionsBubbletab();

	}

}
