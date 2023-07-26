package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;
import com.green.rfp.qa.utility.XLUtils;

public class CreateRFPUsingKISTemplate extends BaseClass {

	TestUtil testutil = new TestUtil();
	XLUtils excel;
	int numOfFailure = 0;

	@Test(priority = 2)
	public void createRFPUsingKISTemplate() throws Throwable {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		loginAsFor("Customer RFP owner 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		logger.info("Clicked on Template ");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();
		logger.info("Clicked on create button");
		String templateName = getCurrentTimeStampString();
		String TemplateName = templateName;
		System.out.println("-----comonTemplateName----" + TemplateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterNameKIS(templateName);
		logger.info("Entered name of KIS template");
		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();
		logger.info("Entered Description");
		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");
		logger.info("Created Section as Indroduction");
		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
		logger.info("Clicked on Plus icon");
		// Verification of edit and delete icon
		Boolean isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Introduction");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Introduction' section.");
		logger.info("Edit or delete icon are available");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), "Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com",
				"Add Questions", 1);
		logger.info("Enter sme qanarolasme1@mailinator.com for Add Question permission");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();
		logger.info("Clicked on HelpMySme");
		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();
		logger.info("clicked on Sme Bubble");

		closingSession();

		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");
		logger.info("Clicked on accepted task in Indroduction Section");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes Button");
		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");
		logger.info("Clicked on New Question Button");
		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData("freeForm", "Introduction section question 1",
				"Medium", "Introduction");
		logger.info("Added Question");
		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();
		logger.info("Clicked on Save Button");
		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		rfpVerificationPage = rfpIndexPage.scrollToAssignedQuestions();
		logger.info("Scroll to Assigned question section");
		Boolean isQuestionAdded = templateVerificationPage.verifyQuestionAdded();
		Assert.assertTrue(isQuestionAdded, "Question is added successfully.");
		logger.info("Question added ");
		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();
		logger.info("Clicked on save and submit Button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes Button");

		closingSession();

		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		logger.info("Clicked on Template Button");
		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);
		logger.info("Clicked and template selected");
		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();
		logger.info("Clicked on review bubble Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();
		logger.info("Clicked on approve all  Button");
		testStepsLog("Step " + (stepCount++), "Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on yes Button");
		testStepsLog("Verification", " Verify 'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");
		logger.info("Verified");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		logger.info("Clicked on review bubble Button");
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		logger.info("Clicked on skip");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Make template public.");
		templateVerificationPage = templateIndexPage.makeTemplatePublic();
		logger.info("Clicked on public ");
		testStepsLog("Step " + (stepCount++), " Click checkbox 'Use KIS Template'.");
		templateVerificationPage = templateIndexPage.clickKISCheckbox();
		logger.info("Clicked and select kis ");
		testStepsLog("Step " + (stepCount++), " Click ok button for KIS template.");
		templateVerificationPage = templateIndexPage.clickKISokButton();
		logger.info("Selected kis ");
		testStepsLog("Step " + (stepCount++), " Click template publish button.");
		templateVerificationPage = templateIndexPage.clickTemplatePublishButton();
		logger.info("Clicked on publish Button");

		closingSession();

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP Button");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on create Button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "KIS");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is disable.");
		logger.info("Selected RFP type");
		testStepsLog("Step " + (stepCount++), " Use KIS template.");
		rfpVerificationPage = rfpIndexPage.useCreatedTemplateKIS();
		logger.info("Clicked and selected KIS RFP");
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Fill RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "KIS", rfpName);
		logger.info("Filled out RFP Info");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "KIS", rfpName, "DetailedPricing");
		logger.info("KIS RFP Created");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
		System.out.println("Done KIS template");

	}

}
