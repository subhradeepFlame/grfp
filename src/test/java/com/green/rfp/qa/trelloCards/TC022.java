package com.green.rfp.qa.trelloCards;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC022 extends BaseClass {

	@Test
	public void clarificationFlowOrangeIconVerify() {

		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
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
		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com   for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com  ", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		rfpVerificationPage = rfpIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on Help My SME Button");
		closingSession();

		loginAsFor("Customer SME 1");
		rfpIndexPage.waitForDashboardToBeReady();
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task and accept the task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");
		logger.info("Accept request");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes Button");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		logger.info("Clicked on New Question Button");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Introduction");
		logger.info("Add Question and fill all mandetory information");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Saved Button");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Cliked on Save and Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link");
		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("Select RFP ");
		testStepsLog("Step " + (stepCount++), " Click on 'Needs'");
		jsClick(driver.findElement(By.xpath("//md-step-label-wrapper[@class='Needs']")));

		String section1 = "Introduction";
		String question2 = section1 + " section question 2";
		createQuestion(answerType, questionWeight, section1, question2);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
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

		testStepsLog("Step " + (stepCount++), " Click on Clarification button for question 1");
		jsClick(driver.findElement(
				By.xpath("//td//span[contains(text(),'" + question + "')]/..//button[@aria-label='Clarification']")));
		testStepsLog("Step " + (stepCount++), " Ask clarification needed from CSME.");
		rfpIndexPage.askForClarification();
		logger.info("Ask clerification");
		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on Submmit button");
		testStepsLog("Step " + (stepCount++), " Click on Clarification button for question 2");
		jsClick(driver.findElement(
				By.xpath("//td//span[contains(text(),'" + question2 + "')]/..//button[@aria-label='Clarification']")));
		testStepsLog("Step " + (stepCount++), " Ask clarification needed from CSME.");
		rfpIndexPage.askForClarification();
		logger.info("Ask clerification");
		testStepsLog("Step " + (stepCount++), " Click on Submit button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on Submmit button");

		testStepsLog("Step " + (stepCount++),
				" Click on Answer button to give answer for 'Introduction' section question 1");
		rfpVerificationPage = rfpIndexPage.clickOnAnswer("Introduction section question 1");
		logger.info("Clicked on answer button");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 1");
		logger.info("Answer given");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		pause(3);
		logger.info("Clicked on submmit button");
		testStepsLog("Step " + (stepCount++),
				" Click on Answer button to give answer for 'Introduction' section  question 2");
		jsClick(driver.findElement(By.xpath(
				"//span[contains(text(),'Introduction section question 2')]/../../..//button[contains(text(),'Answer')]")));
		logger.info("Clicked on answer button");
		testStepsLog("Step " + (stepCount++), " Give answer.");
		rfpVerificationPage = rfpIndexPage.giveAnswer("Introduction section Answer 2");
		logger.info("Answer given");
		testStepsLog("Step " + (stepCount++), " Click on 'Submit' button.");
		templateVerificationPage = templateIndexPage.clickOnSubmitButton();
		logger.info("Clicked on submmit button");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Add RFP Helpers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoComapny()");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("Company123", "CompanyTitle123", "25235634",
				"company123@gmail.com", "Company123Description");
		logger.info("Company added");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Company Info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		logger.info("Clicked on save button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Pricing' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoCompanyAudit(true)");
		logger.info("Clicked on continue button");
		testStepsLog("Step " + (stepCount++), " 'Continue' button on 'Review' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorAprrovers(true)");
		logger.info("Clicked on Review button");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " 'Click on skip approver checkbox");
		jsClick(driver.findElement(By.xpath("//div[@class='layout-column']//div[@class='md-icon']")));
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");
		logger.info("Clicked on save button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last Look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on Send tab");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();
		logger.info("Responsed send");

		closingSession();
		loginAsFor("Customer RFP owner 1");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " verifys color status of Review Tab is orange");
		Assert.assertEquals("pending", getStepperTabStatus("Review"));

		closingSession();
		logOut();

		// clarificationFlowGreenIconVerify(
		// con.getconfigdData(env+"TC022RfpName"),"q1", "q2");
		con.setKeyValue(env + "TC022RfpName", rfpName);
	}

	public void clarificationFlowGreenIconVerify(String rfpName, String q1, String q2) {
		// String rfpName=con.getconfigdData(env+"TC022RfpName");

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		loginAsFor("Customer RFP owner 1");

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
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.clickSaveAllButton(q1);

		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(q2);

		pause(3);

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab(q2);

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatingsToQuestions("3", q2, "QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.clickSaveAllButton(q2);

		dashboardVerificationPage = dashboardIndexPage.clickOnLeftMenu("Dashboard");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " verifys color status of Review Tab is green");
		Assert.assertEquals("completed", getStepperTabStatus("Review"));

	}

}
