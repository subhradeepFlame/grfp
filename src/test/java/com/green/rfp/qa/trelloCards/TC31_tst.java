package com.green.rfp.qa.trelloCards;


import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;


public class TC31_tst extends BaseClass {

	@Test
	public void amandmentEmailFiringCheck() {

		String rfpName = getCurrentTimeStampString();
		String answerType = "newQuestion";
		String questionWeight = "Medium";
		String vendor2mail= "https://www.mailinator.com/v4/public/inboxes.jsp?to=qanarolavender11";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
//		loginAsFor("Customer Admin");
//		waitForPageLoaded();
//		pause(3);
//		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
//		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
//
//		testStepsLog("Step " + (stepCount++), " Click on create button.");
//		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
//
//		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
//		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
//		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
//
//		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
//		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
//		logger.info("Rfp created");
//		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
//		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");
//
//		testStepsLog("Step " + (stepCount++), "Select pricing = Don't Request Pricing");
//		rfpIndexPage.selectRFPPricingType("NoPricing");
//		pause(2);
//		testStepsLog("Step " + (stepCount++), " Click on yes button.");
//		rfpIndexPage.clickOnYesButton();
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
//		rfpIndexPage.clickOnContinueButton("Sections");
//		stepCount++;
//
//		waitForPageLoaded();
//		pause(5);
//		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
//		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
//		waitForPageLoaded();
//
//		String section1 = "Introduction";
//		String q1 = section1 + " section question 1";
//		String q2 = section1 + " section question 2";
//		createQuestion(answerType, questionWeight, section1, q1);
//
//		pause(3);
//		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
//		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
//		logger.info("Clicked on Continue");
//		waitForPageLoaded();
//		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
//		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
//		logger.info("Clicked on Continue");
//		waitForPageLoaded();
//
//		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
//		pause(3);
//		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
//				.click();
//		pause(3);
//
//		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
//		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
//		waitForPageLoaded();
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
//		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
//
//		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2.");
//		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
//		waitForPageLoaded();
//		testStepsLog("Step " + (stepCount++), " Send RFP to Vendor 2");
//		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
//		waitForPageLoaded();
//
//		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
//		closingSession();
		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
//		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
//		templateVerificationPage = templateIndexPage.clickOnYesButton();

		waitForPageLoaded();
		rfpIndexPage.stpcnt();
//		
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
//		testStepsLog("Step " + (stepCount++), " Give answers");
//		rfpIndexPage.answeraquestion(q1, section1);
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");
//
//		testStepsLog("Step " + (stepCount++), " Add Company information details.");
//		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
//				"company1234@gmail.com", "Company1234Description");
//		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
//		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoCompanyAudit");
//		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");
//
//		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
//		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
//		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
//		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();
//
//		testStepsLog("Step " + (stepCount++), " Login as customer admin");
//		closingSession();
//		loginAsFor("Customer Admin");
//
//		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
//		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
//
//		testStepsLog("Step " + (stepCount++), " search and select the rfp");
//		templateIndexPage.searchSelectTemplate(rfpName);
//		pause(2);
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Start an Amendment' button");
//		templateVerificationPage = templateIndexPage.clickOnAmendmentBtn();
//
//		testStepsLog("Step " + (stepCount++), " Click on yes button to start amendment.");
//		templateVerificationPage = templateIndexPage.clickOnYesButton();
//
//		testStepsLog("Step " + (stepCount++), " Click on 'Needs' bubble tab");
//		rfpVerificationPage = rfpIndexPage.gotoNeedsBubbletab();
//
//		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
//		templateVerificationPage = templateIndexPage.clickOnNewQuestion();
//
//		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
//		createQuestion(answerType, questionWeight, section1, q2);
//		
//		testStepsLog("Step " + (stepCount++)," Click on 'Publish Amendment' button.");
//		rfpVerificationPage = rfpIndexPage.clickOnPublishBtn();
//		
//		testStepsLog("Step " + (stepCount++)," Enter Amendment details.");
//		rfpVerificationPage = rfpIndexPage.enterAmendmentDetails("Amendment 1","Changes as follow : Added question");
//		waitForPageLoaded();
//		
//		testStepsLog("Step " + (stepCount++)," Open vendor 2 mail");
//		driver.get(vendor2mail);
//		waitForPageLoaded();
//		pause(10);
//		testStepsLog("Step " + (stepCount++),"Verify amandment email is showing to the mail inbox");
//		PresenceOfElement(By.xpath("//td[contains(text(),'Amendment')]/.."));
//		testVerifyLog("Verified amandment email is showing to the mail inbox");
//
//		
//		
//		
//		
//		

		

	}

}
