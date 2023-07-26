package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative13 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test
	public void checkCommentFunctionalityInTemplate() {

		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		String templateName = getCurrentTimeStampString();
		String comonTemplateName = templateName;
		System.out.println("-----comonTemplateName----" + comonTemplateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		// Verification of edit and delete icon
		Boolean isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Introduction");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Introduction' section.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Enter SME as qa_csme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
		templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData("freeForm", "Introduction section question 1",
				"Medium", "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		Boolean isQuestionAdded = templateVerificationPage.verifyQuestionAdded();
		Assert.assertTrue(isQuestionAdded, "Question is not added successfully.");

		testStepsLog("Step " + (stepCount++), " Comment given by csme1 to CAdmin.");
		templateVerificationPage = templateIndexPage.commentBySME("QaNarola Sme1", "Comment given by csme1.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Scroll to 'ASSIGNED QUESTIONS FOR INTRODUCTION' section.");
		templateVerificationPage = templateIndexPage.scrollToAssignedQuestions();

		testStepsLog("Step " + (stepCount++), " Verify comment count is same as given.");
		boolean verifyCommentOnTemplateCreation = templateVerificationPage
				.verifyCommentCount("Introduction section question 1");
		Assert.assertTrue(verifyCommentOnTemplateCreation, "Comment count is not same.");

		testStepsLog("Step " + (stepCount++), " Verify comment is visible for CAdmin.");
		verifyCommentOnTemplateCreation = templateVerificationPage.verifyCommentFromTemplateCreated(1);
		Assert.assertTrue(verifyCommentOnTemplateCreation, "Comment is visible at template creation place.");

		testStepsLog("Step " + (stepCount++), " Comment by CAdmin.");
		templateVerificationPage = templateIndexPage.commentBySME("QA-Testing CAdmin", "Comment given by CAdmin.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Search Template.");
		templateVerificationPage = templateIndexPage.searchTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		pause(3);
		closingSession();

	}

}
