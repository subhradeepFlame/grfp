package com.green.rfp.qa.trelloCards;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC033 extends BaseClass {
	@Test
	public void CheckVendorApproveAllButton() {

		String rfpName = getCurrentTimeStampString();
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
		String q2 = section1 + " section question 2";
		String q3 = section1 + " section question 3";
		String q4 = section1 + " section question 4";
		createQuestion(answerType, questionWeight, section1, q1);
		createQuestion(answerType, questionWeight, section1, q2);
		createQuestion(answerType, questionWeight, section1, q3);
		createQuestion(answerType, questionWeight, section1, q4);

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

		testStepsLog("Step " + (stepCount++), " Assign VenderCSME for 'Introduction' section.");
		rfpVerificationPage = rfpIndexPage.AssigntoUser("1");
		testStepsLog("Step " + (stepCount++), " Click on 'Assign' button.");
		rfpVerificationPage = rfpIndexPage.clickOnAssignBtn();
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor v1sme1.");
		rfpVerificationPage = rfpIndexPage.addRFPVendorCSME1("qanarolav1sme1@mailinator.com");
		testStepsLog("Step " + (stepCount++), " Enter Due Date.");
		rfpVerificationPage = rfpIndexPage.enterDueDate();
		testStepsLog("Step " + (stepCount++), " Click on send button to submit the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnSendbtn();
		testStepsLog("Step " + (stepCount++), " Click on Yes button to send the assignment.");
		rfpVerificationPage = rfpIndexPage.clickOnYesbtn();
		waitForPageLoaded();

		closingSession();
		loginAsFor("Vendor2 Sme1");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Scroll to section checkbox");
		scrollToElement(driver.findElement(By.xpath("//thead//div[@class='md-icon']")));
		scrollToElementTillTrue(driver.findElement(By.xpath("//thead//div[@class='md-icon']")));
		testStepsLog("Step " + (stepCount++), " Click on the section checkbox");
		jsClick(driver.findElement(By.xpath("//thead//div[@class='md-icon']")));
		pause(1);
		testStepsLog("Step " + (stepCount++), " Click on the auto answer yes button");
		jsClick(driver.findElement(
				By.xpath("//div[@class='multi-select-actions layout-row']//button[contains(text(),'Yes')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on the submit button");
		jsClick(driver.findElement(By.xpath("//form[@name='giveAnswerDialogForm']//button[text()='Submit']")));

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on the save and submit button");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'SAVE & SUBMIT')]")));
		testStepsLog("Step " + (stepCount++), " Click on yes button for submit the task");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), "Login as vendor2");
		closingSession();
		loginAsFor("Vendor2");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		waitForPageLoaded();

		List<WebElement> totalQuestions = driver
				.findElements(By.xpath("//td//div//span[contains(text(),'QaNarola vendorsme1')]"));

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");

		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoCompanyAudit");
		waitForPageLoaded();
		WebElement approveAllButton = driver.findElement(By.xpath("//md-tab-item//button[text()='Approve All']"));
		testStepsLog("Step " + (stepCount++), " Verify approve all button showing");
		PresenceOfElement(By.xpath("//md-tab-item//button[text()='Approve All']"));
		testVerifyLog("Approve all button showing verified");
		testStepsLog("Step " + (stepCount++), " Click on approve all button");
		jsClick(approveAllButton);
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpIndexPage.clickOnYesButton();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Scroll to approved questions");
		scrollToElement(driver.findElement(By.xpath("//span[text()='Approved']")));
		testStepsLog("Step " + (stepCount++), " Verify all the questions are now approved");
		List<WebElement> approvedQuestions = driver.findElements(By.xpath("//span[text()='Approved']"));
		Assert.assertEquals(approvedQuestions.size(), totalQuestions.size());
		testVerifyLog("All the questions are now approved verified");
		System.out.println("All the questions are now approved verified");

	}
}
