package com.green.rfp.qa.rfp.testcases;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class VendorRFPFlow2 extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void vendorRFPFlow() throws Exception {

		String rfpName = "23012022_12-23-01";

		superAdminloginValid();
		// RFPowner
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link button");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");
		// Rating functionality

		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();
		logger.info("Clicked on review button");
		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll till assigned questioned");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");
		logger.info("Clicked on Down arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();
		logger.info("Clicked on Go button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings("QaNarola Vendor1", "6");
		logger.info("Rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatings("QaNarola Vendor1");
		logger.info("save Rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Introduction section question 1");
		logger.info("Clicked on Down arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();
		logger.info("Clicked on Go button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatingsVendorOne("QaNarola Vendor", "5");
		logger.info("Rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingsOne("QaNarola Vendor");
		logger.info("save rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note added");

//				objective rating
		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Objectives");
		logger.info("Clicked on Objective");
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll till Assigned Questioned");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 1");
		logger.info("Clicked on Down Arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();
		logger.info("Clicked on Rating button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.giveRatings2("QaNarola Vendor1", "6");
		logger.info("Rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.saveRatings2("QaNarola Vendor1");
		logger.info("Save rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 1");
		logger.info("Clicked on Down Arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();
		logger.info("Clicked on Rating button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");

		rfpVerificationPage = rfpIndexPage.giveRatings4("QaNarola Vendor", "5");
		logger.info("Rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.saveRatings4("QaNarola Vendor");
		logger.info("save Rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 2");
		logger.info("Clicked on Down Arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();
		logger.info("Clicked on rating button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.giveRatings3("QaNarola Vendor1", "6");
		logger.info("rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");

		rfpVerificationPage = rfpIndexPage.saveRatings3("QaNarola Vendor1");
		logger.info("Save rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Objectives section question 2");
		logger.info("Clicked on Down Arrow button");
		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");

		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();
		logger.info("Clicked on rating button");
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings5("QaNarola Vendor", "5");
		logger.info("Rating given");
		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatings5("QaNarola Vendor");
		logger.info("Save rating");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");

		// Pricing rating

		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Pricing");
		logger.info("Clicked on Objective");

		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings7("QaNarola Vendor", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss7("QaNarola Vendor");

		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 1");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab1();
		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings8("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss8("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");
		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.giveRatings9("QaNarola Vendor", "6");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss9("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating("Pricing section question 2");

		testStepsLog("Step " + (stepCount++), " Go to 'Rating' tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab2();

		testStepsLog("Step " + (stepCount++), " Give rating for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.giveRatings10("QaNarola Vendor", "5");

		testStepsLog("Step " + (stepCount++), " Save rating for QA Vendor2.");
		rfpVerificationPage = rfpIndexPage.saveRatingss10("QaNarola Vendor");
		testStepsLog("Step " + (stepCount++), " Add evaluation note for QA Vendor1.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
		logger.info("Note Added");

		testStepsLog("Step " + (stepCount++), " Go to 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoSendBubbletab();
		logger.info("Clicked on go");
		testStepsLog("Step " + (stepCount++), " Click on send button to submit the RFP.");
		rfpVerificationPage = rfpIndexPage.clickOnSend();
		logger.info("Clicked on send");
		testStepsLog("Step " + (stepCount++), " Click on Reports link.");
		rfpVerificationPage = rfpIndexPage.clickOnReportsLeftLink();
		logger.info("clicked on report");

	}

}
