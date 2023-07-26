package com.green.rfp.qa.template.testcases;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class AttachmentViewInFinalViewOfTemplate extends BaseClass {

	String templateName = "DemoAttachmentTest" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };
	@FindBy(xpath = "//*[text()='PUBLISH']")
	WebElement temp_publish_btn;

	@Test(priority = 2)
	public void AttachmentsNotShowingUpInFinalViewOfTemplate() throws AWTException {
		superAdminloginValid();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		System.out.println(templateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Objectives");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		// Verification of edit and delete icon
		Boolean isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Introduction");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Introduction' section.");

		isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Objectives");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Objectives' section.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), "Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Introduction", "qanarolasme1@mailinator.com ",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), "Enter SME as qanarolasme1@mailinator.com for Add Questions permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Objectives", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible2 = templateVerificationPage.verifyEmailIconForSME("Objectives", 1);
		Assert.assertTrue(orangeEmailIconVisible2, "Orange email icon is not visible.");

		closingSession();
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Objectives");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Edit the section.");
		templateVerificationPage = templateIndexPage.editDescription("Objectives");

		testStepsLog("Step " + (stepCount++), " Scroll on Objective section page till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtn();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Objectives");

		answerType = "yesNo";
		question = "Objectives section question 2";
		questionWeight = "Medium";
		section = "Objectives";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Upload Attachment");
		templateVerificationPage = templateIndexPage.uploadAttachment();

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		// Indroduction

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.clickOnAcceptButton(templateName, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Edit the section.");
		templateVerificationPage = templateIndexPage.editDescription("Introduction");

		testStepsLog("Step " + (stepCount++), " Scroll on Introduction section page till New Question button.");
		templateVerificationPage = templateIndexPage.scrollTillNewQuestionBtn();

		testStepsLog("Step " + (stepCount++), " Click on 'New Question' button");
		templateVerificationPage = templateIndexPage.clickOnNewQuestionButton("Introduction");

		answerType = "yesNo";
		question = "Introduction section question 2";
		questionWeight = "Medium";
		section = "Introduction";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

		testStepsLog("Step " + (stepCount++), " Upload Attachment");
		templateVerificationPage = templateIndexPage.uploadAttachment();

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), "Click on yes button after 'Approve all' for 'Introduction' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Verification", " Verify 'Approved' icon for 'Introduction section.");
		Boolean sectionIntroductionApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionIntroductionApproved, "Introduction section not approved");

		testStepsLog("Step " + (stepCount++), " Go to 'Objectives' tab");
		templateVerificationPage = templateIndexPage.clickOnTabUnderReview("Objectives");

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Objectives' section.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Verification", " Verify 'Approved' icon for 'Objectives' section.");
		Boolean sectionObjectivesApproved = templateVerificationPage.verifyApprovedIcon("Introduction");
		Assert.assertTrue(sectionObjectivesApproved, "Objective section not approved");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalTemplate();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		pause(3);
		scrollToElement(driver.findElement(By.xpath("//*[text()='PUBLISH']")));

	}

	@Test(priority = 3)
	public void done() {
		System.out.println("Done Attachment");
	}

}
