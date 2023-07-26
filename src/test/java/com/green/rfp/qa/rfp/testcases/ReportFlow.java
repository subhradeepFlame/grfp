package com.green.rfp.qa.rfp.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class ReportFlow extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void reportsFlow() {
		String rfpName = con.getReportRFP(env);

		System.out.println("===================RFP Name =============" + rfpName);

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("Clicked on Report link button");
		waitFor2mins.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"templates-list\"]//md-card")));

		System.out.println("===================RFP Name =============" + rfpName);
		testStepsLog("Step " + (stepCount++), " Search and select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);
		logger.info("RFP selected");
		testStepsLog("Step " + (stepCount++), "Select Vendors to have graph.");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor1");
		logger.info("Vendor selected as QaNarola Vendor and QaNArola Vendor1");

		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");
		logger.info("Clicked on Requirement Dropdown");
		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");
		logger.info("All Selected");
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Value Indicator");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Value Indicator");
		logger.info("Scroll to Graph");
		testStepsLog("Verification", " Verify Chart is displayed.");
		Boolean reportIsGenerated = rfpVerificationPage.verifyChartIsDisplayed("value-chart");
		Assert.assertTrue(reportIsGenerated, "RFP is not displayed at reports tab");
		logger.info("Chart verifyed");
		testStepsLog("Step " + (stepCount++), "Click on 'save' button to save the graph.");
		rfpVerificationPage = rfpIndexPage.saveGraph();
		logger.info("clicked on save");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.scrollToResultsSection();
		logger.info("Scroll to Result Section");

		testStepsLog("Verification", " Verify Delete Chart icon is displayed.");
		reportIsGenerated = rfpVerificationPage.verifyDeleteChartIconIsDisplayed("Value Indicator");

		Assert.assertTrue(reportIsGenerated, "RFP is not displayed at reports tab");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), " Go to 'Reporting' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Reporting");
		logger.info("Clicked and navigate to Reporting sub section");

		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");
		logger.info("Clicked on Requirement Dropdown");

		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");
		logger.info("Requirement selected");
		testStepsLog("Verification", " Verify 'Section Percentage' button is displayed.");
		reportIsGenerated = rfpVerificationPage.sectionPercentageBtnIsDisplayed();
		Assert.assertTrue(reportIsGenerated, "'Section Percentage' button is not displayed");
		logger.info("Verifyed");

		testStepsLog("Step " + (stepCount++), "Click on 'Section Percentage' button.");
		rfpVerificationPage = rfpIndexPage.clickonPercentageBtn();
		logger.info("Clicked on Percentage button");
		testStepsLog("Step " + (stepCount++), "Change Percentage of 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.changePercentage("Introduction", "30");
		logger.info("Percentage changed");
		testStepsLog("Step " + (stepCount++), "Change Percentage of 'Objectives' section.");
		rfpVerificationPage = rfpIndexPage.changePercentage("Objectives", "20");
		logger.info("Percentage changed of Objective section");
		testStepsLog("Step " + (stepCount++), " Click on Save button to save the changes.");
		rfpVerificationPage = rfpIndexPage.savePercentage();
		logger.info("Save Percentage");
		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");
		logger.info("Clicked on Requirement document");
		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");
		logger.info("Selected requirement form dropdown");
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Value Indicator");
		logger.info("Chart seleted");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Value Indicator");
		logger.info("Scroll till graph");
		testStepsLog("Verification", " Verify Chart is displayed.");
		reportIsGenerated = rfpVerificationPage.verifyChartIsDisplayed("value-chart");
		Assert.assertTrue(reportIsGenerated, "RFP is not displayed at reports tab");
		logger.info("Chart verifyed");
		testStepsLog("Step " + (stepCount++), "Click on 'save' button to save the graph.");
		rfpVerificationPage = rfpIndexPage.saveGraph();
		logger.info("Clicked on Save ");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.scrollToResultsSection();
		logger.info("Scroll to Result section");
		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();
		logger.info("Navigate to Detail section");

		testStepsLog("Step " + (stepCount++), "Scroll to 'SECTION NAME - INTRODUCTION' section.");
		rfpVerificationPage = rfpIndexPage.scrollToSectionName("Section Name - Introduction");
		logger.info("Scroll to section");
		testStepsLog("Verification", " Verify 'Add Questions' and 'Save' buttons display or not.");
		reportIsGenerated = rfpVerificationPage.verifyAddQueAndSavebtnDisplay("Section Name - Introduction");
		Assert.assertTrue(reportIsGenerated, "'Add Questions' and 'Save' buttons are not displaying");
		logger.info("Verifyed");
		testStepsLog("Verification", " Verify down arrow is displayed or not.");
		reportIsGenerated = rfpVerificationPage.verifyDownArrow("Introduction section question 1");
		Assert.assertTrue(reportIsGenerated, "Down arrow is not displaying");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), "Click on Down arrow.");
		rfpVerificationPage = rfpIndexPage.clickonDownArrow("Introduction section question 1");
		logger.info("Clicked on Down Arrow");
		testStepsLog("Verification",
				" Verify 'Validations','Score Changes' and 'Clarification' sections are displayed or not.");
		reportIsGenerated = rfpVerificationPage.verifySectionsDisplay("Introduction section question 1", "Validation",
				"Score Changes", "Clarification");
		Assert.assertTrue(reportIsGenerated, "Down arrow is not displaying");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), "Get Priority given to a perticular question.");
		String Priority = rfpIndexPage.getPriority("Introduction section question 1");
		logger.info("Get priority");
		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 1 for a perticular question.");
		String Vendor1Rating = rfpIndexPage.getVendor1Rating("Introduction section question 1");
		logger.info("Get rating");
		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 2 for a perticular question.");
		String Vendor2Rating = rfpIndexPage.getVendor2Rating("Introduction section question 1");
		logger.info("Rating give");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Results' section.");
		rfpVerificationPage = rfpIndexPage.scrollToResultsSection();
		logger.info("Scroll to Result section");
		String changedReference = "20";

		testStepsLog("Step " + (stepCount++), "Change Reference marks.");
		rfpVerificationPage = rfpIndexPage.changeReferenceMarksFrame(Priority, changedReference);
		logger.info("Refrance mark changed");
		testStepsLog("Step " + (stepCount++), "Click on 'Save' button to save the changes.");
		rfpVerificationPage = rfpIndexPage.saveChangeInReferenceMarks();
		logger.info("Save changes");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), "Scroll to 'SECTION NAME - INTRODUCTION' section.");
		rfpVerificationPage = rfpIndexPage.scrollToSectionName("Section Name - Introduction");
		logger.info("Scroll till Introduction sectioned");
		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 1 for a perticular question.");
		String ChangedVendor1Rating = rfpIndexPage.getVendor1Rating("Introduction section question 1");
		logger.info("Rating fet");
		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 2 for a perticular question.");
		String ChangedVendor2Rating = rfpIndexPage.getVendor2Rating("Introduction section question 1");
		logger.info("Rating given");

		testStepsLog("Step " + (stepCount++), " Switch to 'Download Report' tab.");
		rfpVerificationPage = rfpIndexPage.switchSection("Download Report");
		logger.info("Switched to download section");
		testStepsLog("Step " + (stepCount++), " Check the box to download report of particular item.");
		rfpVerificationPage = rfpIndexPage.checkItemToDownloadReport("Summary Details");
		logger.info("Checkbox clicked of summry details");
		testStepsLog("Step " + (stepCount++), " Check the box to download report of Section item.");
		rfpVerificationPage = rfpIndexPage.checkItemToDownloadReport("Sections");
		logger.info(" Sections Checkbox clicked");
		testStepsLog("Step " + (stepCount++), " Check the box to download report of Results item.");
		rfpVerificationPage = rfpIndexPage.checkItemToDownloadReport("Results");
		logger.info("Results Checkbox clicked");
		testStepsLog("Step " + (stepCount++), " Check the box to download report of Respondents item.");
		rfpVerificationPage = rfpIndexPage.checkItemToDownloadReport("Respondents");
		logger.info("Respondents Checkbox clicked");
		testStepsLog("Step " + (stepCount++), " Check the box to download report of Score Details item.");
		rfpVerificationPage = rfpIndexPage.checkItemToDownloadReport("Score Details");
		logger.info("Score Details Checkbox clicked");
		testStepsLog("Step " + (stepCount++), " Click on Generate  Report button to initiate downloading the report.");
		rfpVerificationPage = rfpIndexPage.clickOnGenerateReportBtn();
		logger.info("Clicked on Generate  Report");
		String RFPname = rfpName.replace(' ', '-');
		System.err.println("RFP pdf name : " + RFPname);
		pause(6);
		driver.navigate().refresh();
		testStepsLog("Step " + (stepCount++), " Switch to 'Download Report' tab.");
		rfpVerificationPage = rfpIndexPage.switchSection("Download Report");
		testStepsLog("Step " + (stepCount++), " Click on download button to download the report.");
		rfpVerificationPage = rfpIndexPage.clickOnDownloadReportIcon();
		logger.info("Clicked on Download Reporticon");
		System.err.println("RFP pdf name : " + RFPname);

		testStepsLog("Verification", " Verify downloaded PDF is opened in a new tab.");
		reportIsGenerated = rfpVerificationPage
				.verifyPDFDownloaded("https://" + env + ".thegreenrfp.com/upload/Reports/" + RFPname + ".pdf");
		Assert.assertTrue(reportIsGenerated, "PDF is not downloaded ");
		logger.info("Downloded");
		pause(11);

		closingSession();
		try {
			loginAsFor("Customer Admin");
		} catch (Exception e) {
			superAdminloginValid();
			loginAsFor("Customer Admin");
		}

		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("Clicked on Report link button");
		waitFor2mins.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"templates-list\"]//md-card")));

		System.out.println("===================RFP Name =============" + rfpName);
		testStepsLog("Step " + (stepCount++), " Search and select RFP.");
		templateIndexPage.searchSelectTemplate(rfpName);
		logger.info("RFP selected");
		testStepsLog("Step " + (stepCount++), "Select Vendors to have graph.");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor1");
		logger.info("Vendor selected as QaNarola Vendor and QaNArola Vendor1");

		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");
		logger.info("Clicked on Requirement Dropdown");
		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");
		logger.info("All Selected");
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Value Indicator");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Value Indicator");
		logger.info("Scroll to Graph");
		testStepsLog("Verification", " Verify Chart is displayed.");
		reportIsGenerated = rfpVerificationPage.verifyChartIsDisplayed("value-chart");
		Assert.assertTrue(reportIsGenerated, "RFP is not displayed at reports tab");
		logger.info("Chart verifyed");

		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Overspend Indicator");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Overspend Indicator");
		logger.info("Scroll to Graph");

		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Requirements Satisfied by %");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Requirements Satisfied by %");
		logger.info("Scroll to Graph");
		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("CapEx, OpEx, and Annual Subscriptions");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("CapEx, OpEx, and Annual Subscriptions");
		logger.info("Scroll to Graph");
		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Perceived Cost vs Actual Cost");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Perceived Cost vs Actual Cost");
		logger.info("Scroll to Graph");
		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Perceived Cost and Overspend in ");
		logger.info("Value selecetd");

		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Scatter Chart");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Scatter Chart");
		logger.info("Scroll to Graph");
		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");
		logger.info("Clicked on Related chart");
		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Pricing");
		logger.info("Value selecetd");
		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Pricing");
		logger.info("Scroll to Graph");
		testStepsLog("Step " + (stepCount++), " Scroll to Save Graph");
		rfpVerificationPage = rfpIndexPage.scrollToSaveGraph();
		logger.info("Scroll to Save Graph");

	}

}
