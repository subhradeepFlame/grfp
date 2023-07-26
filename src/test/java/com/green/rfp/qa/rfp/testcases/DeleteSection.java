package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class DeleteSection extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void verifyDeletedSection() {
		int numOfFailure = 0;
		superAdminloginValid();

		String rfpName = con.getReportRFP(env);
		System.out.println("rfp name: " + rfpName);
		System.out.println("===================RFP Name =============" + rfpName); //
		String question = "Introduction section question 1";

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("Clicked on Report link button");
		System.out.println("===================RFP Name =============" + rfpName);
		testStepsLog("Step " + (stepCount++), " Search and select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);

		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();
		logger.info("Navigate to Detail section");

		testStepsLog("Step " + (stepCount++), "Scroll to 'Add New Section'.");
		rfpVerificationPage = rfpIndexPage.scrollToAddNewSection("Add New Section");
		logger.info("Scroll till new section");
		testStepsLog("Step " + (stepCount++), "Add New section from 'ADD NEW SECTION' section textbox.");
		rfpVerificationPage = rfpIndexPage.addRuntimeSection("New Section");
		logger.info("New sectioned added");
		testStepsLog("Step " + (stepCount++), "Click on 'Add Section' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAddSectionBtn();
		logger.info("section added");

		testStepsLog("Step " + (stepCount++), "Refresh the page");
		driver.navigate().refresh();
		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();

		testStepsLog("Verification", " Verify new runtime section is added.");
		pause(5);
		boolean reportIsGenerated = rfpVerificationPage.verifySectionAdded("Section Name - new section");
		Assert.assertTrue(reportIsGenerated, "New Runtime section is not added.");
		logger.info("Verifyed");

		testStepsLog("Verification", " Verify 'Delete' icon is displayed at newly added section.");
		reportIsGenerated = rfpVerificationPage.verifyDeleteIconDisplay("Section Name - new section");
		Assert.assertTrue(reportIsGenerated, "'Delete' icon is not displayed at newly added section.");
		logger.info("Verify edit button");

		testStepsLog("Step " + (stepCount++), " Delete Section");
		rfpVerificationPage = rfpIndexPage.deleteRunTimeSection("Section Name - new section");
		logger.info("Section Deleted");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on YEs button");

		testStepsLog("Verification", " Verify Newly added section not displayed");
		reportIsGenerated = rfpVerificationPage.verifyNewlyAddedSectionNotDisplayed("Section Name - new section");
		Assert.assertTrue(reportIsGenerated, "New Runtime section is not added.");
		logger.info("Verifyed");

	}

}
