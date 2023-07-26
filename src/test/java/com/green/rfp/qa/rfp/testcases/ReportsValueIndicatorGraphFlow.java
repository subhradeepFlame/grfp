package com.green.rfp.qa.rfp.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class ReportsValueIndicatorGraphFlow extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 3)
	public void reportsValueIndicatorGraphFlow() {
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
		

		testStepsLog("Step " + (stepCount++), "Search and select RFP : " + rfpName + " .");
		templateIndexPage.searchSelectTemplate(rfpName);
		logger.info("RFP selected");
		testStepsLog("Step " + (stepCount++), "Select Vendors to have graph.");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor");
		rfpVerificationPage = rfpIndexPage.selectVendors("QaNarola Vendor1");
		logger.info("Vendor selected as QaNarola Vendor and QaNArola Vendor1");

		testStepsLog("Step " + (stepCount++), "Go to 'Details' section.");
		rfpVerificationPage = rfpIndexPage.gotoDetailsSection();

		// Get details vendor1

		testStepsLog("Step " + (stepCount++), "Get Priority given to a perticular question.");
		String IntroductionSectionQuestion1_Priority = rfpIndexPage.getPriority("Introduction section question 1");
		String ObjectiveSectionQuestion1_Priority = rfpIndexPage.getPriority("Objectives section question 1");
		String ObjectiveSectionQuestion2_Priority = rfpIndexPage.getPriority("Objectives section question 2");
		String PricingSectionQuestion1_Priority = rfpIndexPage.getPriority("Pricing section question 1");
		String PricingSectionQuestion2_Priority = rfpIndexPage.getPriority("Pricing section question 2");

		testStepsLog("Step " + (stepCount++), "Get Ratings given to Vendor 1 for a perticular question.");
		String IntroductionSectionQuestion1_Rating = rfpIndexPage.getVendor1Rating("Introduction section question 1");

		String ObjectiveSectionQuestion1_Rating = rfpIndexPage.getVendor1Rating("Objectives section question 1");
		String ObjectiveSectionQuestion2_Rating = rfpIndexPage.getVendor1Rating("Objectives section question 2");
		String PricingSectionQuestion1_Rating = rfpIndexPage.getVendor1Rating("Pricing section question 1");
		String PricingSectionQuestion2_Rating = rfpIndexPage.getVendor1Rating("Pricing section question 2");
		System.out.println(IntroductionSectionQuestion1_Rating);
		System.out.println(ObjectiveSectionQuestion1_Rating);
		System.out.println(ObjectiveSectionQuestion2_Rating);
		System.out.println(PricingSectionQuestion1_Priority);
		System.out.println(PricingSectionQuestion2_Priority);
		System.out.println(PricingSectionQuestion1_Priority);
		System.out.println(PricingSectionQuestion2_Priority);

		// calculation vendor1

		String per1 = rfpIndexPage.percentageCalculation(IntroductionSectionQuestion1_Priority,
				IntroductionSectionQuestion1_Rating);

		String per3 = rfpIndexPage.percentageCalculation(ObjectiveSectionQuestion1_Priority,
				ObjectiveSectionQuestion1_Rating);
		String per4 = rfpIndexPage.percentageCalculation(ObjectiveSectionQuestion2_Priority,
				ObjectiveSectionQuestion2_Rating);
		String avgPer1 = rfpIndexPage.avgpercentageCalculation(per3, per4);
		String per5 = rfpIndexPage.percentageCalculation(PricingSectionQuestion1_Priority,
				PricingSectionQuestion1_Rating);
		String per6 = rfpIndexPage.percentageCalculation(PricingSectionQuestion2_Priority,
				PricingSectionQuestion2_Rating);
		String avgPer2 = rfpIndexPage.avgpercentageCalculation(per5, per6);
		System.out.println(per1);

		System.out.println(per3);
		System.out.println(per4);
		System.out.println(avgPer1);
		System.out.println(per5);
		System.out.println(per6);
		System.out.println(avgPer2);
		testStepsLog("Step " + (stepCount++), " Go to 'Reporting' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Reporting");

		testStepsLog("Step " + (stepCount++), "Click on 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.data_compare");

		testStepsLog("Step " + (stepCount++), "Select requirement from 'Requirements' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectRequirementFromDropdown("All");

		testStepsLog("Step " + (stepCount++), "Click on 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.clickOnDropdown("vm.selected_as_it_relates");

		testStepsLog("Step " + (stepCount++), "Select chart from 'Related Chart' dropdown.");
		rfpVerificationPage = rfpIndexPage.selectChartFromDropdown("Value Indicator");

		testStepsLog("Step " + (stepCount++), "Scroll to 'Graph'.");
		rfpVerificationPage = rfpIndexPage.scrollToGraph("Value Indicator");

		testStepsLog("Step " + (stepCount++), "Click on 'save' button to save the graph.");
		rfpVerificationPage = rfpIndexPage.saveGraph();
	}

}
