package com.green.rfp.qa.trelloCards;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC002 extends BaseClass {

	@Test(priority = 1)
	public void verifyPendingEvaluatorsTabColor() {
		String rfpName = con.getEvaluatorRfpName("pending");
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);

		testStepsLog("Step " + (stepCount++), " verifys color status of Evaluators Tab");
		Assert.assertEquals("pending", getStepperTabStatus("Evaluators"));
		System.out.println("Evaluator status is : pending ");
		closingSession();
		logOut();

	}

	@Test(priority = 2)
	public void verifyCompletedEvaluatorsTabColor() {
		String rfpName = con.getEvaluatorRfpName("completed");
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);

		testStepsLog("Step " + (stepCount++), " verifys color status of Evaluators Tab");
		Assert.assertEquals("completed", getStepperTabStatus("Evaluators"));
		System.out.println("Evaluator status is : pending ");

	}

}
