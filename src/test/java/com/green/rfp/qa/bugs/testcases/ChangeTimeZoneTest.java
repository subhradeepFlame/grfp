package com.green.rfp.qa.bugs.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class ChangeTimeZoneTest extends BaseClass {

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";

	Logger Log = Logger.getLogger(ChangeTimeZoneTest.class);

	@Test(priority = 1)

	public void changeTheTimeZoneWhenRfpHasBeenStarted() {
		superAdminloginValid();
		String rfpName = getCurrentTimeStampString();
		loginAsFor("Customer RFP owner 1");
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
		System.out.println(dateFormat.format(date));
		testStepsLog("Step " + (stepCount++), " Click on 'Summary' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSummaryBubble();
		testStepsLog("Step " + (stepCount++), " Scroll Till TimeZone");
		templateVerificationPage = templateIndexPage.scrollTillTimeZone();
		testStepsLog("Step " + (stepCount++), " Change the Time zone");
		rfpVerificationPage = rfpIndexPage.ChangeTimeZone("Asia/Karachi (+05:00)");
		testStepsLog("Step " + (stepCount++), " Click on Continue Button");
		rfpVerificationPage = rfpIndexPage.ClickOnSummaryContinue("Rfp");
		testStepsLog("Step " + (stepCount++), " Click on 'Summary' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSummaryBubble();
		testStepsLog("Step " + (stepCount++), " Scroll Till TimeZone");
		templateVerificationPage = templateIndexPage.scrollTillTimeZone();
		testStepsLog("Verification", " Verify Timezone Updated.");
		Boolean notification = rfpVerificationPage.verifyTimeZoneUpdated("Asia/Karachi (+05:00)");
		Assert.assertTrue(notification, "Time Zone is not Updated");
		System.out.println("Done Change Time Zone");

	}
}
