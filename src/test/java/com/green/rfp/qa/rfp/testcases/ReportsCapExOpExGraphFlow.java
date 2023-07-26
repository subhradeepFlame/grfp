package com.green.rfp.qa.rfp.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class ReportsCapExOpExGraphFlow extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 3)
	public void reportsCapExOpExGraphFlow() {

		String path = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/Vendor.xlsx";
		String rfpName = con.getReportRFP(env);

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("Clikced Report link");
		waitFor2mins.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"templates-list\"]//md-card")));


		System.out.println("===================RFP Name =============" + rfpName);
		testStepsLog("Step " + (stepCount++), " Search and select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);
		logger.info("RFP selected");
		testStepsLog("Step " + (stepCount++), "Select Vendors to have graph.");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor1");
		logger.info("Vendor selected");
		testStepsLog("Step " + (stepCount++), " Switch to 'Pricing' tab.");
		rfpVerificationPage = rfpIndexPage.switchSection("Pricing");
		logger.info("Switched Pricing tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Edit Pricing' button.");
		rfpVerificationPage = rfpIndexPage.clickOnEditPricingBtn("1");
		logger.info("Clickede on edit prizing button");
		testStepsLog("Step " + (stepCount++), " Change Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.changePricingValue("vendor.capex", "15");
		logger.info("Changed value to 15");
		testStepsLog("Step " + (stepCount++), " Save Changed Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on yes button");
		testStepsLog("Step " + (stepCount++), " Click on 'Edit Pricing' button.");
		rfpVerificationPage = rfpIndexPage.clickOnEditPricingBtn("1");
		logger.info("Clicked on edit prizing button");
		testStepsLog("Step " + (stepCount++), " Change Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.changePricingValue("vendor.opex", "10");
		logger.info("Changed value to 10");
		testStepsLog("Step " + (stepCount++), " Save Changed Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on yes button");

		testStepsLog("Step " + (stepCount++), " Click on 'Edit Pricing' button.");
		rfpVerificationPage = rfpIndexPage.clickOnEditPricingBtn("1");
		logger.info("Clicked on edit prizing button");
		testStepsLog("Step " + (stepCount++), " Change Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.changePricingValue("vendor.annual_maintainence", "5");
		logger.info("Changed value to 5");
		testStepsLog("Step " + (stepCount++), " Save Changed Pricing value of Vendor1.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on yes button");
		testStepsLog("Step " + (stepCount++), "Switch to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.switchToResultsSection();
		logger.info("Switched to Result");
		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();
		logger.info("Clicked on details");
		// Get details vendor1

		testStepsLog("Step " + (stepCount++), "Get Priority given to a perticular question.");
		String IntroductionSectionQuestion1_Priority = rfpIndexPage.getPriority("Introduction section question 1");
		logger.info("Captured priority");
		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 1 for a perticular question.");
		String IntroductionSectionQuestion1_Rating = rfpIndexPage.getVendor1Rating("Introduction section question 1");
		logger.info("captured rating");
		testStepsLog("Step " + (stepCount++), "Get total number of question each section is having.");
		String totalNumberOfQue = rfpIndexPage.getTotalNumberOfque("Section Name - Introduction");
		logger.info("capture all question");
		testStepsLog("Step " + (stepCount++), " Go to 'Reporting' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Reporting");
		logger.info("Switched to reporting yab");
		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");
		logger.info("Clicked on all requirement");
		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");
		logger.info("All selected");
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("CapEx, OpEx, and Annual Subscriptions");
		logger.info("Selected given graph");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("CapEx, OpEx, and Annual Subscriptions");
		logger.info("Scroll to graph");
		testStepsLog("Step " + (stepCount++), "Click on 'save' button to save the graph.");
		rfpVerificationPage = rfpIndexPage.saveGraph();
		logger.info("saved garaph");

	}

}
