package com.green.rfp.qa.rfp.testcases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class A extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	private PrintWriter m_out;

	int passCount = 0;
	static String name = "";

	public void ssss(String outdir) throws IOException {
		createWriter(outdir);
	}

	protected static PrintWriter createWriter(String outdir) throws IOException { // 2.1
		// java.util.Date now = new Date();
		new File(outdir).mkdirs();
		System.out.println(new File(outdir).mkdirs());

		System.out.println(new PrintWriter(
				new BufferedWriter(new FileWriter(new File(outdir, "CustomReporterBuildSummary" + ".html")))));
		new File(outdir).mkdirs();
		return new PrintWriter(
				new BufferedWriter(new FileWriter(new File(outdir, "CustomReporterBuildSummary" + ".html"))));
	}

	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) { // 1
		try {
			m_out = createWriter(outdir); // 2
		} catch (IOException e) {
			logger.error("output file", e);
			return;
		}

		m_out.flush();
		m_out.close();
	}

	@Test(priority = 1)
	public void login() {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");

	}

	public void vendorRFPFlow() throws Exception {
		loginAsFor("Customar Admin");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP("11072020_10-26-13");
		logger.info("RFp selected");
		// Rating functionality

		testStepsLog("Step " + (stepCount++), " Go to 'Review' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();
		logger.info("Clicked on review button");
		// introduction rating
		testStepsLog("Step " + (stepCount++), " Scroll to GiveRatings section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll till assigned questioned");

		pause(15);
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
		pause(8);
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

//		objective rating
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

//	@Test(priority=3)
	public void aa() {
		// Login as Approver and complete the approver task.

		String rfpName = "10072020_09-53-21";
		testStepsLog("Step " + (stepCount++), " Click on log in as button.");
		templateVerificationPage = templateIndexPage.clickOnLogInAsButton();
		logger.info("Clicked on login as button");
		testStepsLog("Step " + (stepCount++), " Click on QA Vendor2 button.");
		templateVerificationPage = templateIndexPage.selectLoginAsQAVendor2("QaNarola Vendor1");
		logger.info("Clicked and select vendor2");
		testStepsLog("Step " + (stepCount++), " Click on select user button.");
		templateVerificationPage = templateIndexPage.clickOnSelectUserButton();
		logger.info("vendor2 selected");
		testStepsLog("Step " + (stepCount++), " Click on qa QA v2approver button.");
		templateVerificationPage = templateIndexPage.selectUserAsQAVendor2("QaNarola vendor2approver1");
		logger.info("selected");
		testStepsLog("Step " + (stepCount++), " Click on go button.");
		templateVerificationPage = templateIndexPage.clickOnGoButton();
		logger.info("Clicked on Go button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll till pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.rfpClickDashboardAccBtnForApprover(rfpName);
		logger.info("Accept task");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();
		logger.info("Clicked on Approve button");
		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on close button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click log in as button.");
		rfpVerificationPage = rfpIndexPage.clickOnLogInAsButton();
		logger.info("Clicked on login as button");
		testStepsLog("Step " + (stepCount++), " Click on QA Vendor2 button.");
		templateVerificationPage = templateIndexPage.selectLoginAsQAVendor2("QaNarola Vendor1");
		logger.info("Clicked and select vendor2");
		testStepsLog("Step " + (stepCount++), " Click on select user button.");
		templateVerificationPage = templateIndexPage.clickOnSelectUserButton();
		logger.info("Selected");
		testStepsLog("Step " + (stepCount++), " Click on QA Vendor2 button.");
		templateVerificationPage = templateIndexPage.selectUserAsQAVendor2("QaNarola Vendor1");
		logger.info("Selected");
		testStepsLog("Step " + (stepCount++), " Click on go button.");
		templateVerificationPage = templateIndexPage.clickOnGoButton();
		logger.info("Clicked on Go button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFp link button");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		logger.info("RFp selected");
		testStepsLog("Step " + (stepCount++), " Go to Approvers bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoApproversBubbletab();
		logger.info("Clicked on Approve button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveApprovers(true)");
		logger.info("Clicked on save button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Last Look tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.gotoVendorSendStep(true)");
		logger.info("Clicked on Continue button");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on Send tab");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();
		logger.info("Responsed send");
		// RFPowner

		testStepsLog("Verification", " Verify RFP is displayed at reports tab.");
		boolean reportIsGenerated = rfpVerificationPage.verifyDisplayatReportsTab(rfpName);
		Assert.assertTrue(reportIsGenerated, "RFP is not displayed at reports tab");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP("11072020_10-26-13");
		logger.info("RFP selected");
		testStepsLog("Step " + (stepCount++), " Go to 'Pricing' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Pricing");
		logger.info("Cliked on go");
		testStepsLog("Step " + (stepCount++), " Switch to 'QA Vebdor2' tab.");
		rfpVerificationPage = rfpIndexPage.switchSectionToVendor("QaNarola Vendor1", "2");
		logger.info("Switched to vendor tab");

		testStepsLog("Step " + (stepCount++), " Go to 'Respondents' sub-section.");
		rfpVerificationPage = rfpIndexPage.switchSection("Respondents");
		logger.info("Go to Respondents' sub-section");
		testStepsLog("Step " + (stepCount++), " Switch to 'QA Vendor2' tab.");
		rfpVerificationPage = rfpIndexPage.switchSectionToVendor("QaNarola Vendor", "1");
		logger.info("Switched to vendor tab");
		testStepsLog("Verification", " Verify added implementation diagram is displayed.");
		boolean logoDisplay = rfpVerificationPage.verifyDiagramDisplayAtReportsTab();
		Assert.assertTrue(logoDisplay, "Implementation diagram is not displayed");
		logger.info("Verifyed");

	}

	public void aaa()

	{
		testStepsLog("Step " + (stepCount++), " Click on log in as button.");
		templateVerificationPage = templateIndexPage.clickOnLogInAsButton();
		logger.info("Clicked on login as button");

		testStepsLog("Step " + (stepCount++), " Click on QA Vendor2 button.");
		templateVerificationPage = templateIndexPage.selectLoginAsQAVendor2("QaNarola Vendor1");
		logger.info("Clicked and select QA NArola Vendor");
		testStepsLog("Step " + (stepCount++), " Click on select user button.");
		templateVerificationPage = templateIndexPage.clickOnSelectUserButton();
		logger.info("Selected");
		testStepsLog("Step " + (stepCount++), " Click on QA Vendor2 button.");
		templateVerificationPage = templateIndexPage.selectUserAsQAVendor2("QaNarola Vendor1");
		logger.info("Clicked and selected");
		testStepsLog("Step " + (stepCount++), " Click on go button.");
		templateVerificationPage = templateIndexPage.clickOnGoButton();
		logger.info("Clicked on Go button");
	}
}
