package com.green.rfp.qa.trelloCards;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

import com.opencsv.exceptions.CsvException;

public class TC029 extends BaseClass {

	@Test
	public void dataDumpCsv() throws IOException, CsvException {
		String rfpName = getCurrentTimeStampString();
		String strFile = System.getProperty("user.dir") + "/downloads/" + rfpName + ".csv";
		String answerType = "newQuestion";
		String questionWeight = "Medium";

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

		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
		rfpIndexPage.clickOnReportsLeftLink();
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " click on details");
		jsClick(driver.findElement(By.xpath("//md-tab-item[text()='Details']")));
		testStepsLog("Step " + (stepCount++), " scroll to download icon");
		scrollToElement(driver.findElement(By.xpath("//md-icon[@aria-label='icon-download']")));
		testStepsLog("Step " + (stepCount++), " Click on the download icon");
		jsClick(driver.findElement(By.xpath("//md-icon[@aria-label='icon-download']")));
		pause(5);
		String[] parts = null;
		try {
			// Array for storing values
			ArrayList<String> csvValues = new ArrayList<String>();
			// csv file containing data

			// create BufferedReader to read csv file
			BufferedReader br = new BufferedReader(new FileReader(strFile));
			String strLine = "";
			StringTokenizer st = null;

			// read comma separated file line by line
			while ((strLine = br.readLine()) != null) {

				// break comma separated line using â€œ,â€�
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens()) {
					// store csv values in array
					csvValues.add(st.nextToken());
				}
			}

			System.out.println(csvValues.toString());
			parts = csvValues.toString().split(", ");
			System.out.println("aaaa: " + parts[19]);
		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}

		testStepsLog("Step " + (stepCount++), " Verify questions names are matching");
		Assert.assertEquals("\"" + q1 + "\"", parts[19]);
		Assert.assertEquals("\"" + q2 + "\"", parts[27]);
		testVerifyLog("questions names are matched verified");
		testStepsLog("Step " + (stepCount++), " Verify questions weight");
		Assert.assertEquals(" " + questionWeight, parts[7]);
		Assert.assertEquals(questionWeight, parts[20]);
		testVerifyLog("Verified questions weight");
		testStepsLog("Step " + (stepCount++), " Verify questions answers are matched for vendor 2");
		Assert.assertEquals("\"Answer for" + q1 + "\"", parts[21]);
		Assert.assertEquals("\"Answer for" + q2 + "\"", parts[29]);
		testVerifyLog("Verified questions answers are matched for vendor 2");
		testStepsLog("Step " + (stepCount++), " Verify questions answers are matched for vendor 3");
		Assert.assertEquals("\"Answer for" + q1 + "\"", parts[24]);
		Assert.assertEquals("\"Answer for" + q2 + "\"", parts[32]);
		testVerifyLog("Verified questions answers are matched for vendor 3");
		testStepsLog("Step " + (stepCount++), " Verify vendor2 question answers ratings are matched");
		Assert.assertEquals("6", parts[22]);
		Assert.assertEquals("5", parts[25]);
		testVerifyLog("Verified vendor2 question answers ratings are matched");
		testStepsLog("Step " + (stepCount++), " Verify vendor3 question answers ratings are matched");
		Assert.assertEquals("4", parts[30]);
		Assert.assertEquals("3", parts[33]);
		testVerifyLog("Verified vendor3 question answers ratings are matched");

	}

}
