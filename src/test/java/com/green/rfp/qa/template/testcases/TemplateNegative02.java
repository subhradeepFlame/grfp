package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative02 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test
	public void templateTaskAcceptBySME() {
		String answerType = "freeForm";
		String question = "Introduction section question 1";
		String questionWeight = "Medium";
		String section = "Introduction";
		testCaselog("Template POC");
		pause(3);
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Login  as Customer Admin");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();

		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++),
				" Enter SME as qanarolasme1@mailinator.com   for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com  ", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on Take me to Dashboard button.");
		templateVerificationPage = templateIndexPage.clickOnTakeMeToDashboard();

		testStepsLog("Step " + (stepCount++), " Verify user has redireted to Dashboard page.");
		Boolean isDashboardPageVerified = dashboardVerificationPage.verifyDashboardPage("CustomerAdmin");
		Assert.assertTrue(isDashboardPageVerified, "Dashboard page is not displayed.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");
		rfpIndexPage.waitForDashboardToBeReady();
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Edit option");
		templateVerificationPage = templateIndexPage.selectEditOption("Edit");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.editQuestionData("1. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Verify Edited Question is present.");
		Boolean taskAcceptedIconVisible = templateVerificationPage
				.verifyEditedQuePresent("1. Edited Introduction section question 1");
		Assert.assertTrue(taskAcceptedIconVisible, "Edited question is not present.");

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to delete the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("1. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Delete option");
		templateVerificationPage = templateIndexPage.selectDeleteOption("Delete");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify blue icon for task accepted by SME.");
		taskAcceptedIconVisible = templateVerificationPage.verifyTaskAcceptedIconBySME("Introduction");
		Assert.assertTrue(taskAcceptedIconVisible, "Task accepted blue icon is not visible.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveQuestions(true)");

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestionss();

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage.clickOnDotsIcon("Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Edit option");
		templateVerificationPage = templateIndexPage.selectEditOption("Edit");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.editQuestionData("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Verify Edited Question is present.");
		taskAcceptedIconVisible = templateVerificationPage
				.verifyEditedQuePresentAtReviewTab("2. Edited Introduction section question 1");
		Assert.assertTrue(taskAcceptedIconVisible, "Edited question is not present.");

		testStepsLog("Step " + (stepCount++), " Click on down arrow to see log.");
		templateVerificationPage = templateIndexPage
				.clickOnDownArrowForLog("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Verify Logs are present.");
		taskAcceptedIconVisible = templateVerificationPage.verifyLogDisplayed("QaNarola Sme1");
		Assert.assertTrue(taskAcceptedIconVisible, "logs are not displaying.");

		testStepsLog("Step " + (stepCount++), " Click on 3 dots next to comment icon to edit the question.");
		templateVerificationPage = templateIndexPage
				.clickOnDotsIconAtReviewTab("2. Edited Introduction section question 1");

		testStepsLog("Step " + (stepCount++), " Select Delete option");
		templateVerificationPage = templateIndexPage.selectDeleteOptionAtReviewTab("Delete");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		pause(3);
		closingSession();
		testStepsLog("Step " + (stepCount++), " Logout");
		logOut();
	}

}
