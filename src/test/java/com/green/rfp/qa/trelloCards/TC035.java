package com.green.rfp.qa.trelloCards;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC035 extends BaseClass {

	@Test
	public void verifyVendorFlowQuestionAndAnswers() throws ParseException {

		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String questionWeight = "Medium";
		String section1 = "Introduction";
		String section2 = "Objectives";

		testStepsLog("Step " + (stepCount++), " Login as Super admin");
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
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, section1);
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, section2);
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
		testStepsLog("Step " + (stepCount++), " Add 5 questions to each section");
		ArrayList<String> introductionQuestions = new ArrayList<String>();
		ArrayList<String> objectivesQuestions = new ArrayList<String>();
		for (int i = 1; i <= 5; i++) {
			String section1Question = section1 + " section question" + i;
			String section2Question = section2 + " section question" + i;
			jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'addNewQuestionPop')]")));
			templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, section1Question,
					questionWeight, section1);
			templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
			introductionQuestions.add(section1Question);
			pause(3);
			jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'addNewQuestionPop')]")));
			templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, section2Question,
					questionWeight, section2);
			templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
			objectivesQuestions.add(section2Question);
			pause(3);
		}

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
		closingSession();
		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Answer all questions of introduction section");
		for (String s : introductionQuestions) {
			rfpIndexPage.answeraquestion(s, section1, "v1");
		}
		testStepsLog("Step " + (stepCount++), " Answer all questions of Objective section");
		for (String s : objectivesQuestions) {
			rfpIndexPage.answeraquestion(s, section2, "v1");
		}

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
		pause(3);
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
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Answer some questions of introduction section");
		rfpIndexPage.answeraquestion(introductionQuestions.get(0), section1, "v2");
		rfpIndexPage.answeraquestion(introductionQuestions.get(1), section1, "v2");
		testStepsLog("Step " + (stepCount++), " Answer some questions of Objective section");
		rfpIndexPage.answeraquestion(objectivesQuestions.get(3), section2, "v2");
		rfpIndexPage.answeraquestion(objectivesQuestions.get(4), section2, "v2");

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
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.saveApprovers(false)']")));
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify the error message showing :PLEASE COMPLETE THE REVIEW STEP");
		try {
			pause(3);
			PresenceOfElement(By.xpath("//h4[text()='Please complete the Review Step to continue.']"));
			testVerifyLog("Error message showing Verified");
			testStepsLog("Step " + (stepCount++), " Verify that Last Look tab is not clikable");
			try {
				clickableElement(
						driver.findElement(By.xpath("//md-step-item//md-step-label-wrapper[@class='Last Look']")));
				Assert.fail();
			} catch (Exception e1) {
				testVerifyLog("Verified that Last Look tab is not clikable");
			}
		} catch (Exception e) {
			Assert.fail();
		}
		closingSession();
		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		pause(2);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		jsClick(driver.findElement(By.xpath("//button[contains(@ng-click,'vendorRfpModifyStep ')]")));
		testStepsLog("Step " + (stepCount++), " Scroll to Introduction section");
		scrollToElement(driver.findElement(By.xpath("//th[text()='Introduction']")));

		List<WebElement> introductionSectionQuestions = driver.findElements(By
				.xpath("//th[text()='" + section1 + "']//..//../following-sibling::tbody//span[@class='ng-binding']"));

		List<String> allIntroductionSectionsQuestion = new ArrayList<String>();
		for (WebElement e : introductionSectionQuestions) {
			allIntroductionSectionsQuestion.add(e.getText());
		}
		List<WebElement> introductionSectionAnswers = driver.findElements(By.xpath("//th[text()='" + section1
				+ "']//..//../following-sibling::tbody//span[@class='ng-binding ng-scope']"));
		List<String> introductionSectionsAnswer = new ArrayList<String>();
		for (WebElement f : introductionSectionAnswers) {
			introductionSectionsAnswer.add(f.getText());
		}
		List<String> introductionSectionsActualAnswer = new ArrayList<String>();
		for (WebElement f : introductionSectionQuestions) {
			introductionSectionsActualAnswer.add("v1 Answer for" + f.getText());
		}
		testStepsLog("Step " + (stepCount++), "Verify introduction section questions and answers are matched");
		Assert.assertTrue(allIntroductionSectionsQuestion.equals(introductionQuestions));
		Assert.assertTrue(introductionSectionsActualAnswer.equals(introductionSectionsAnswer));
		testVerifyLog("Verified Introduction section question and answers are matched ");
		testStepsLog("Step " + (stepCount++), " Scroll to Objectives section");
		scrollToElement(driver.findElement(By.xpath("//th[text()='Objectives']")));

		List<WebElement> objectiveSectionQuestions = driver.findElements(By
				.xpath("//th[text()='" + section2 + "']//..//../following-sibling::tbody//span[@class='ng-binding']"));
		List<String> allObjectiveSectionQuestion = new ArrayList<String>();
		for (WebElement g : objectiveSectionQuestions) {
			allObjectiveSectionQuestion.add(g.getText());
		}
		List<WebElement> objectivesSectionAnswers = driver.findElements(By.xpath("//th[text()='" + section2
				+ "']//..//../following-sibling::tbody//span[@class='ng-binding ng-scope']"));
		testStepsLog("Step " + (stepCount++), "Verify all the section's questions and answers are matched");
		List<String> objectiveSectionAnswer = new ArrayList<String>();
		for (WebElement h : objectivesSectionAnswers) {
			objectiveSectionAnswer.add(h.getText());
		}
		List<String> objectivesSectionsActualAnswer = new ArrayList<String>();
		for (WebElement f : objectiveSectionQuestions) {
			objectivesSectionsActualAnswer.add("v1 Answer for" + f.getText());
		}

		testStepsLog("Step " + (stepCount++), "Verify objectives section questions and answers are matched");
		Assert.assertTrue(allObjectiveSectionQuestion.equals(objectivesQuestions));
		Assert.assertTrue(objectivesSectionsActualAnswer.equals(objectiveSectionAnswer));
		testVerifyLog("Verified objectives section question and answers are matched ");

	}
}
