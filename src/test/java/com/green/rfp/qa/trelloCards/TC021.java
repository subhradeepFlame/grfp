package com.green.rfp.qa.trelloCards;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC021 extends BaseClass {

	@Test
	public void checkAssignedQuestionAutoAnswer() {

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
		String q5 = section1 + " section question 5";
		String q6 = section1 + " section question 6";

		createQuestion(answerType, questionWeight, section1, q1);
		createQuestion(answerType, questionWeight, section1, q2);
		createQuestion(answerType, questionWeight, section1, q3);
		createQuestion(answerType, questionWeight, section1, q4);
		createQuestion(answerType, questionWeight, section1, q5);
		createQuestion(answerType, questionWeight, section1, q6);

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		waitForPageLoaded();
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
		scrollToElement(driver.findElement(By.xpath("//div[@class='p-16 layout-column']")));
		pause(1);

		List<WebElement> question = driver.findElements(By.xpath("//td//div[@class='md-icon']"));
		testStepsLog("Step " + (stepCount++), "Click on the first 3 questions checkbox");
		for (int i = 0; i < 3; i++) {
			jsClick(question.get(i));
		}
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
		pause(3);
		question = driver.findElements(By.xpath("//td//div[@class='md-icon']"));

		testStepsLog("Step " + (stepCount++), "Click on the next 3 questions checkbox");
		for (int j = 0; j < 3; j++) {

			jsClick(question.get(j));
			pause(3);
		}
		testStepsLog("Step " + (stepCount++), " Click on the auto answer yes button");
		jsClick(driver.findElement(
				By.xpath("//div[@class='multi-select-actions layout-row']//button[contains(text(),'Yes')]")));
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on the submit button");
		jsClick(driver.findElement(By.xpath("//form[@name='giveAnswerDialogForm']//button[text()='Submit']")));

		waitForPageLoaded();
		List<WebElement> ans = driver.findElements(By.xpath("//div[@class='ms-responsive-table-wrapper']//label"));

		testStepsLog("Step " + (stepCount++), " Verify first 3 question are assigned with vendor sme1");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text(),'" + q1
						+ "')]//..//..//..//span[contains(text(),'QaNarola vendorsme1')]")).getText(),
				"QaNarola vendorsme1");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text(),'" + q2
						+ "')]//..//..//..//span[contains(text(),'QaNarola vendorsme1')]")).getText(),
				"QaNarola vendorsme1");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text(),'" + q3
						+ "')]//..//..//..//span[contains(text(),'QaNarola vendorsme1')]")).getText(),
				"QaNarola vendorsme1");

		testStepsLog("Step " + (stepCount++), " Verify last 3 questions answer are showign yes");
		Assert.assertEquals(driver
				.findElement(By.xpath("//span[contains(text(),'" + q4 + "')]//..//../following-sibling::td//label"))
				.getText(), "YES");
		Assert.assertEquals(driver
				.findElement(By.xpath("//span[contains(text(),'" + q5 + "')]//..//../following-sibling::td//label"))
				.getText(), "YES");
		Assert.assertEquals(driver
				.findElement(By.xpath("//span[contains(text(),'" + q6 + "')]//..//../following-sibling::td//label"))
				.getText(), "YES");

	}

}
