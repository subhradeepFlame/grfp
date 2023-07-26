package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC014 extends BaseClass {

	@Test
	public void checkinLineAddendumsWorking() {

		String rfpName = getCurrentTimeStampString();
		String typeOfRFP = "Scratch";
		String answerType = "yesNo";
		String questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		PresenceOfElement(By.xpath("//input[@ng-model='vm.name']"));
		driver.findElement(By.xpath("//input[@ng-model='vm.name']")).clear();
		globalMap.put("vendorRFPName", rfpName);
		rfpIndexPage.enterRFAData(rfpName, "Description of " + rfpName, "123456", typeOfRFP);

		testStepsLog("Step " + (stepCount++), "Click on Disable Inline Questions checkbox");
		scrollToElement(driver.findElement(
				By.xpath("//div[@class='layout-align-start-center layout-row'][3]//div[@class='md-icon']")));
		jsClick(driver.findElement(
				By.xpath("//div[@class='layout-align-start-center layout-row'][3]//div[@class='md-icon']")));
		testStepsLog("Step " + (stepCount++), "Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Rfp");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");

		testStepsLog("Step " + (stepCount++), "Select pricing = Don't Request Pricing");
		rfpIndexPage.selectRFPPricingType("NoPricing");
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Sections");
		stepCount++;

		waitForPageLoaded();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		waitForPageLoaded();

		String section1 = "Introduction";
		String q1 = section1 + " section question 1";
		createQuestion(answerType, questionWeight, section1, q1);
		pause(3);

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		logger.info("Clicked on Continue");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
		logger.info("Clicked on Continue");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
		pause(3);
		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
				.click();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
		closingSession();
		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Check that FINAL DATE TO ASK QUESTIONS text is not showing ");
		try {
			PresenceOfElement(By.xpath("//div[@ng-if='!vm.clarification_enabled']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog(
					"FINAL DATE TO ASK QUESTIONS this text is now showing as Disable Inline Questions is checked");
		}

	}

}
