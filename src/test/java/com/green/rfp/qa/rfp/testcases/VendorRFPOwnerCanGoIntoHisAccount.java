package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class VendorRFPOwnerCanGoIntoHisAccount extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void RFPOwnerCanGoIntoHisAccountPermissionAndRemoveThemselvesAsRFPOwnerAndChangeThemselvesToAnApproverOrSME() {
		String rfpName = getCurrentTimeStampString();
		testCaselog("RFP POC");
		superAdminloginValid();

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
		logger.info("Create RFP and filled out required fields");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		logger.info("Cliked on Details Pricing");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("vm.saveSelfSme(true)");
		logger.info("Clicked on Continue Button");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("vm.saveQuestions(true)");
		logger.info("Clicked on Continue Button");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("vm.gotoAprrovers(true)");
		logger.info("Clicked on Continue Button");

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
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboardVendor(rfpName);
		logger.info("Clicked and accept");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		// Change Account Permission

		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on close button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on Adminitration Link");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();
		logger.info("Clicked on Adminitration link");

		testStepsLog("Step " + (stepCount++), " Click on User Tab of Adminitration Link");
		rfpVerificationPage = rfpIndexPage.clickOnAdmistrtionUsersTab();
		logger.info("Clicked on User tab of Adminitration link");

		testStepsLog("Step " + (stepCount++), " Search User");
		rfpVerificationPage = rfpIndexPage.clickOnAdmistrtionSearchUser(getEmail("Vendor2"));
		logger.info("Search User");

		testStepsLog("Step " + (stepCount++), " Click on three dot ");
		rfpVerificationPage = rfpIndexPage.clickOnDots();
		logger.info("Clicked on Dots");

		testStepsLog("Step " + (stepCount++), " Click on Edit ");
		rfpVerificationPage = rfpIndexPage.clickOnEditTab();
		logger.info("Edit User");

		pause(15);
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();
		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Yes RFP link");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");
		pause(6);
		driver.navigate().refresh();

	}

}
