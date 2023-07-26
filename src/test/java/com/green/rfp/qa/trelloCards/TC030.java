package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC030 extends BaseClass {
	@Test
	public void deligateRfpUserDashboardCheck() {

		String rfpName = getCurrentTimeStampString();
		String answerType = "newQuestion";
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

		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		logger.info("Rfp created");
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
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor 2");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " Select rfpName checkbox=" + rfpName);
		templateVerificationPage = templateIndexPage.selectTemplateCheckbox(rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on Delegate icon from header");
		templateVerificationPage = templateIndexPage.selectActionsFromHeader("Delegate");
		pause(3);
		testStepsLog("Step " + (stepCount++), " Select delegate user from 'select delegate user' dropdown");
		rfpVerificationPage = rfpIndexPage.selectDelegateUser("QaNarola RFP2");
		pause(3);

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
		testStepsLog("Step " + (stepCount++), " Give answers");
		rfpIndexPage.answeraquestion(q1, section1);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoCompanyAudit");
		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");

		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();

		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");

		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		closingSession();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(2);

		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();

		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(q1);

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab(q1);

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("6", q1, "QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2");
		rfpVerificationPage = rfpIndexPage.clickSaveAllButton(q1);

		testStepsLog("Step " + (stepCount++), " Login as Customer RFP owner 2");
		closingSession();
		loginAsFor("Customer RFP owner 2");

		testStepsLog("Step " + (stepCount++), " scroll to COMPLETED RFP'S/BIDS");
		scrollToElement(driver.findElement(By.xpath("//ms-widget[@ng-if='vm.completed_rfp_permission']")));

		testStepsLog("Step " + (stepCount++),
				" Verify that rfp is showing to the COMPLETED RFP'S/BIDS section in the dashboard");
		PresenceOfElement(
				By.xpath("//ms-widget[@ng-if='vm.completed_rfp_permission']//a[contains(text(),'" + rfpName + "')]"));

		testVerifyLog("RFP is showing to the deligate user dashboard verified");
		System.out.println("RFP is showing to the deligate user dashboard verified");
	}

}
