package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.streamlining.rating.testcases.Evaluator;

public class TC028 extends BaseClass {

	@Test
	public void addDeleteEvaluators() {

		String rfpName = con.getEvaluatorRfpName("pending");
		String firstname = randomStringGenerate().toLowerCase();
		String lastname = randomStringGenerate().toLowerCase();
		String evaluatorEmail = firstname + lastname + "@mailinator.com";
		Evaluator eva = new Evaluator();

		testStepsLog("Step " + (stepCount++), " Login as Customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);

		testStepsLog("Step " + (stepCount++), " Click on evaluators tab");
		driver.findElement(By.xpath("//md-step-label-wrapper[@class='Evaluators']")).click();
		pause(3);
		testStepsLog("Step " + (stepCount++), "Add evaluator, select date and add section ");
		eva.addEvaluatorWithDateAndSection(evaluatorEmail, "Introduction");
		pause(5);
		clickableElement(driver.findElement(By.xpath("(//button[contains(@ng-click,'saveSelfEvaluators')])[1]")));
		testStepsLog("Step " + (stepCount++), "Delete the evaluator");
		eva.deleteEvaluator(evaluatorEmail);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify the evaluator is deleted");

		try {
			PresenceOfElement(By.xpath("//span[contains(text(),'" + evaluatorEmail
					+ "')]/../../../following-sibling::td//md-icon[@md-font-icon='icon-trash']"));
			Assert.fail();
		} catch (Exception e) {

			testVerifyLog("evaluator deleted verified");
			System.out.println("evaluator deleted verified");

		}

	}

}
