package com.green.rfp.qa.trelloCards;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC019 extends BaseClass {

	@Test
	public void checkSmeAddProcess() {
		String rfpName = getCurrentTimeStampString();

		testStepsLog("Step " + (stepCount++), " Perform customer admin login");
		superAdminloginValid();
		loginAsFor("Customer RFP owner 1");
		waitForPageLoaded();

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

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com ", "Add Questions", 1,
				dateFormat.format(date));
		logger.info("Enter SME 1, Add question and required permission for Introduction section");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme2@mailinator.com  for Edit Section Description.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme2@mailinator.com ",
				"Edit Section Description", 2, dateFormat.format(date));
		logger.info("Enter SME 2, Add question and required permission for Indroduction section");
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com  for Add Questions permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Objectives", "qanarolasme1@mailinator.com", "Add Questions", 1,
				dateFormat.format(date));
		logger.info("Enter SME 1, Add question and required permission for Objective section");
		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme2@mailinator.com for 'Both' Description.");
		rfpVerificationPage = rfpIndexPage.enterSME("Objectives", "qanarolasme2@mailinator.com", "Both", 2,
				dateFormat.format(date));
		logger.info("Enter SME 2, Add question and required permission for Objective section");
		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();
		logger.info("Clicked on Save button");

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");
		logger.info("Verifyed Orange email icon for SME");
		testStepsLog("Verification", " VerifyOrange task icon for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyPendingTaskIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange task icon is not visible.");
		logger.info("Verify Orange email icon for SME");
		testStepsLog("Verification", " VerifyGreen plus icon for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyPlusIconForSME("Introduction", 2);
		Assert.assertTrue(orangeEmailIconVisible, "Green Plus icon is not visible.");
		logger.info("Verifyed Green plus icon for SME");
		testStepsLog("Verification", " VerifyResend,Reassign,Delete icons for SME.");
		orangeEmailIconVisible = templateVerificationPage.verifyResendReassignDeleteIcons("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, " Resend,Reassign,Delete icons are not visible.");
		logger.info("Verifyed Resend,Reassign,Delete icons for SME.");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		rfpVerificationPage = rfpIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on Help My SME Button");

	}

}
