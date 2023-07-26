package com.green.rfp.qa.rfp.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;
import com.green.rfp.qa.utility.XLUtils;

public class MenualbidFunctionality extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void menualbidFunctionality() throws Exception {
		int numOfFailure = 0;

		String rfpName = getCurrentTimeStampString();
		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
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

		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		rfpVerificationPage = rfpIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com", "Add Questions", 1,
				dateFormat.format(date));

		testStepsLog("Step " + (stepCount++), " Click on Save Button");
		templateVerificationPage = templateIndexPage.clickOnSavebutton();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on Take me to Dashboard button.");
		templateVerificationPage = templateIndexPage.clickOnTakeMeToDashboard();

		closingSession();
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.clickOnAcceptButton(rfpName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight,
				"Introduction");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on 'Needs'");
		rfpVerificationPage = rfpIndexPage.gotoNeedsBubbletab();

		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalrfp();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Go to 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoSendBubbletab();

		// ============Started Menual Bid code==========================

		testStepsLog("Step " + (stepCount++), " Click on menual big button.");
		rfpVerificationPage = rfpIndexPage.clickMenualBidBtn();

		String compName = randomStringGenerate(5);
		String path = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/Vendor.xlsx";
		XLUtils.setCellData(path, "MenualBid", compName, 1, 0);
		testStepsLog("Step " + (stepCount++), " Enter Company name.");
		rfpVerificationPage = rfpIndexPage.enterCompanyname(compName);

		testStepsLog("Step " + (stepCount++), " Enter number of employee.");
		rfpVerificationPage = rfpIndexPage.enterNumberOfEmp("10");

		testStepsLog("Step " + (stepCount++), " Enter web address.");
		rfpVerificationPage = rfpIndexPage.enterWebAddress("www.www.www");

		testStepsLog("Step " + (stepCount++), " Enter web address.");
		rfpVerificationPage = rfpIndexPage.enterStreetAdd("street address");

		testStepsLog("Step " + (stepCount++), " Enter city.");
		rfpVerificationPage = rfpIndexPage.entercity("city");

		testStepsLog("Step " + (stepCount++), " Enter State.");
		rfpVerificationPage = rfpIndexPage.enterState("state");

		testStepsLog("Step " + (stepCount++), " Enter Zip.");
		rfpVerificationPage = rfpIndexPage.enterZip("12345");

		testStepsLog("Step " + (stepCount++), " Enter country.");
		rfpVerificationPage = rfpIndexPage.enterCountry("country");

		testStepsLog("Step " + (stepCount++), " Enter Anual Revenue.");
		rfpVerificationPage = rfpIndexPage.enterAnualRevenue("100");

		testStepsLog("Step " + (stepCount++), " Select Industry : Retailer/Distributor/Wholesaler(Computer-related)");
		rfpVerificationPage = rfpIndexPage.selectIndustry();

		testStepsLog("Step " + (stepCount++), " Select Ownership : Public");
		rfpVerificationPage = rfpIndexPage.selectOwnership();

		testStepsLog("Step " + (stepCount++), " Enter Primary contact");
		rfpVerificationPage = rfpIndexPage.enterPrimaryContact("1234567890");

		testStepsLog("Step " + (stepCount++), " Enter Primary Phone number");
		rfpVerificationPage = rfpIndexPage.enterPrimaryTitle("title");

		testStepsLog("Step " + (stepCount++), " Enter Primary Title");
		rfpVerificationPage = rfpIndexPage.enterPrimaryPhoneNumber("1234567890");

		testStepsLog("Step " + (stepCount++), " Select Business Type.");
		rfpVerificationPage = rfpIndexPage.selectBussinessType();

		testStepsLog("Step " + (stepCount++), " Click on view NAIC Button.");
		rfpVerificationPage = rfpIndexPage.clickOnViewNAICSBtn();

		testStepsLog("Step " + (stepCount++), " Select First Three Options :- 11,111,1111");
		rfpVerificationPage = rfpIndexPage.clickOn11and111and1111();

		testStepsLog("Step " + (stepCount++), " Click on Done Button.");
		rfpVerificationPage = rfpIndexPage.clickOnDone();

		testStepsLog("Step " + (stepCount++), " Click on save Button.");
		rfpVerificationPage = rfpIndexPage.clickOnSaveButtonOfvendor();

		testStepsLog("Step " + (stepCount++), " Enter Capx amount.");
		rfpVerificationPage = rfpIndexPage.enterCapEx();

		testStepsLog("Step " + (stepCount++), " Enter Opx amount.");
		rfpVerificationPage = rfpIndexPage.enterOpEx();

		testStepsLog("Step " + (stepCount++), " Enter Annual main amount.");
		rfpVerificationPage = rfpIndexPage.enterAnualMain();

		testStepsLog("Step " + (stepCount++), " Click on save Button.");
		rfpVerificationPage = rfpIndexPage.clickOnSaveButtonOfBId();

		testStepsLog("Step " + (stepCount++), " Go to 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoSendBubbletab();

		String Vendor = XLUtils.getCellValue(path, "MenualBid", 1, 0);

		closingSession();

		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), "Select RFP.");
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on Review bubble tab.");
		rfpVerificationPage = rfpIndexPage.gotoReviewBubbletab();

		testStepsLog("Step " + (stepCount++), " Click on down arrow.");
		rfpVerificationPage = rfpIndexPage.clickOnDownArrowForRating(question);
		logger.info("Clicked on down arrow button");

		testStepsLog("Step " + (stepCount++), " Click Rating tab.");
		rfpVerificationPage = rfpIndexPage.gotoRatingTab();

		testStepsLog("Step " + (stepCount++), " Click Rating tab.");
		rfpVerificationPage = rfpIndexPage.giveRatings(Vendor, "5");

		testStepsLog("Step " + (stepCount++), " Save rating.");
		rfpVerificationPage = rfpIndexPage.saveRatings(Vendor);

		testStepsLog("Step " + (stepCount++), " Add evalution note.");
		rfpVerificationPage = rfpIndexPage.addEvaluationNote();
	}

}
