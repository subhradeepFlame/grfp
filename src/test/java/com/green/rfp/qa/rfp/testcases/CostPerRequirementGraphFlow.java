package com.green.rfp.qa.rfp.testcases;

import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class CostPerRequirementGraphFlow extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 1)
	public void login() {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");

	}

	@Test(priority = 2)
	public void costPerRequirementGraphFlow() {
		String path = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/Vendor.xlsx";
		String rfpName = con.getReportRFP(env);
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);

		testStepsLog("Step " + (stepCount++), "Select Vendors to have graph.");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Switch to 'Pricing' tab.");
		rfpVerificationPage = rfpIndexPage.switchSection("Pricing");

		testStepsLog("Step " + (stepCount++), " Click on 'Edit Pricing' button.");
		rfpVerificationPage = rfpIndexPage.clickOnEditPricingBtn("1");

		testStepsLog("Step " + (stepCount++), " Change Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.changePricingValue("vendor.capex", "15");

		testStepsLog("Step " + (stepCount++), " Save Changed Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), "Scroll to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.scrollToResultsSection();
		testStepsLog("Step " + (stepCount++), "Switch to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.switchToResultsSection();
		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();

		// Get details vendor1

		testStepsLog("Step " + (stepCount++), "Get Priority given to a perticular question.");
		String IntroductionSectionQuestion1_Priority = rfpIndexPage.getPriority("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 1 for a perticular question.");
		String IntroductionSectionQuestion1_Rating = rfpIndexPage.getVendor1Rating("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), "Get total number of question each section is having.");
		String totalNumberOfQue = rfpIndexPage.getTotalNumberOfque("Section Name - Introduction");

		testStepsLog("Step " + (stepCount++), " Go to 'Reporting' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Reporting");

		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");

		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");

		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");

		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Pricing");

		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Pricing");

	}

}
