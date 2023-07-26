package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC027 extends BaseClass {

	@Test
	public void timeZoneChangeRfpFlow() {

		String rfpName = getCurrentTimeStampString();
		String answerType = "newQuestion";
		String questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");
		superAdminloginValid();
		logger.info("Login Successfully");

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on Summary tab");
		jsClick(driver.findElement(By.xpath("//md-step-label-wrapper[text()='Summary']")));
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Scroll to the select timezone dropdown");
		scrollToElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']")));
		pause(3);
		testStepsLog("Step " + (stepCount++), "Select different timezone");
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']")));
		WebElement easternStandardTimeZone;

		try {
			PresenceOfElement(By.xpath("//div[contains(text(),'Eastern Daylight Time')]"));

			easternStandardTimeZone = driver.findElement(By.xpath("//div[contains(text(),'Eastern Daylight Time')]"));
		} catch (Exception e) {
			PresenceOfElement(By.xpath("//div[contains(text(),'Eastern Standard Time')]"));

			easternStandardTimeZone = driver.findElement(By.xpath("// md-option/div[contains(text(),'Eastern Standard Time') ]"));
		}

		String selectedTimezone = easternStandardTimeZone.getText();
		pause(3);
		clickableElement(easternStandardTimeZone);
		jsClick(easternStandardTimeZone);

		testStepsLog("Step " + (stepCount++), "Click on save' button");
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		pause(3);

		testStepsLog("Step " + (stepCount++), "Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']//span//div")));
		String presentTomezone = driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']//span//div"))
				.getText();
		System.out.println("qqqqq : " + presentTomezone);

		testStepsLog("Step " + (stepCount++), "verify that timezone is changed");
		pause(3);
		Assert.assertEquals(selectedTimezone, presentTomezone);
		testVerifyLog("Timezone changed verified");
		testStepsLog("Step " + (stepCount++), "Click on continue button");
		rfpIndexPage.clickOnContinueButton("Rfp");

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

		String q2 = section1 + " section question 2";
		createQuestion(answerType, questionWeight, section1, q1);
		createQuestion(answerType, questionWeight, section1, q2);

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
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 3.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender12@mailinator.com");
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor 2 & vendor 3");
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

		rfpIndexPage.answeraquestion(q1, section1);
		rfpIndexPage.answeraquestion(q2, section1);
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

		testStepsLog("Step " + (stepCount++), " Login as vendor 3");
		closingSession();
		loginAsFor("Vendor3");

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");

		rfpIndexPage.answeraquestion(q1, section1);
		rfpIndexPage.answeraquestion(q2, section1);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@maiinator.com", "Company1234Description");
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

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor3.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("5", q1, "QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(q1);

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab(q1);

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("6", q1, "QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor3.");
		rfpVerificationPage = rfpIndexPage.clickSaveAllButton(q1);

		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(q2);

		pause(3);

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab(q2);

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor3.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("3", q2, "QaNarola Vendor1");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(q2);

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab(q2);

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("4", q2, "QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.clickSaveAllButton(q2);

	}

}
