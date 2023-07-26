package com.green.rfp.qa.bugs.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class DelegatedRfp extends BaseClass {

	@Test(priority = 2)
	public void verifyOnceRfpReaches100PercentThenItShouldRemoveAcceptTask() {
		superAdminloginValid();
		String rfpName = getCurrentTimeStampString();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
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

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

		testStepsLog("Step " + (stepCount++), " Select rfpName checkbox=" + rfpName);
		templateVerificationPage = templateIndexPage.selectTemplateCheckbox(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on Delegate icon from header");
		templateVerificationPage = templateIndexPage.selectActionsFromHeader("Delegate");

		testStepsLog("Step " + (stepCount++), " Select delegate user from 'select delegate user' dropdown");
		rfpVerificationPage = rfpIndexPage.selectDelegateUser(getUsername("Customer RFP owner 2"));

		loginAsFor("Customer RFP owner 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButtonDelegate(rfpName, "Delegate for " + rfpName);

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButton("Rfp");

		testStepsLog("Step " + (stepCount++), " Click on Continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButton("Sections");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnNeedContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalrfp();
		logger.info("Clicked on Skip Approver");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on Continue Button");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		logger.info("Clicked on Skip Evaluators");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");
		logger.info("Clicked on skip Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor(getEmail("Vendor2"));

		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");

		closingSession();

		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, rfpName);
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

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

		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();

		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
//	
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
//		
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();


		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillAcceptedTaskList();

		testStepsLog("Verification", " Verify delegant accepted task remove ");
		Boolean isRFP = rfpVerificationPage.verifyDelegantRfpTaskNotDisplayed("Delegate for " + rfpName, rfpName);
		Assert.assertTrue(isRFP, "RFP type is not selected.");

		loginAsFor("Customer RFP owner 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillAcceptedTaskList();
		testStepsLog("Verification", " Verify delegant accepted task remove ");
		Boolean isRFP1 = rfpVerificationPage.verifyDelegantRfpTaskNotDisplayed("Delegate for " + rfpName, rfpName);
		Assert.assertTrue(isRFP1, "RFP type is not selected.");

	}
}
