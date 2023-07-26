package com.green.rfp.qa.rfp.testcases;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class AAA extends BaseClass {
	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;
	String rfpName = "11122020_21-18-02";

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";

	@Test(priority = 1)
	public void login() {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");

		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");

		testStepsLog("Step " + (stepCount++), " Click on 'Evaluators' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnEvaluatorsBubble();
		logger.info("Clicked on Evaluators tab");

		rfpVerificationPage = rfpIndexPage.enterEvaluatorsDetails("evaluatortest@mailinator.com");

		pause(9);

	}

}
