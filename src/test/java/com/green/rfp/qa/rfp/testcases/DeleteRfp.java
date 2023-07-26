package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class DeleteRfp extends BaseClass {
	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void deleteRFP() {
		int numOfFailure = 0;
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		// loginValid();
		logger.info("Valid Login");

		loginAsFor("Customer RFP owner 1");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create Button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is disable.");
		logger.info("Select Rfp type");
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Fill RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		logger.info("Filled rfp summary information");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		logger.info("Created RFP section");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP linked");

		testStepsLog("Step " + (stepCount++), " Select rfp checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(rfpName);
		logger.info("Select RFP for Deleting");
		testStepsLog("Step " + (stepCount++), " Click on delete icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Delete");
		logger.info("Clicked on Delete");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Verification", " Verify rfp deleted successfully");

		System.out.println("Deleted Rfp");
	}

}
