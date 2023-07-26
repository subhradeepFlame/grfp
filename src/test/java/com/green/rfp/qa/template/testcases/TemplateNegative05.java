package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative05 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test
	public void templateTaskReassignBySME() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Perform login");
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

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMEName("Introduction", "qanarolasme1@mailinator.com", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 1);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 0);

		testStepsLog("Step " + (stepCount++), " Click add new SME button.");
		templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

		testStepsLog("Step " + (stepCount++),
				" Select SME as qanarolasme2@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.selectSME("Introduction", "qanarolasme2@mailinator.com", 2);

		testStepsLog("Step " + (stepCount++), " Enter SME date.");
		templateVerificationPage = templateIndexPage.selectSMEDate("Introduction", 2);

		testStepsLog("Step " + (stepCount++), " Click SME permission.");
		templateVerificationPage = templateIndexPage.clickSMEPermission("Introduction", "Add Questions", 2);

		testStepsLog("Step " + (stepCount++), " Select SME permission.");
		templateVerificationPage = templateIndexPage.selectSMEPermission("Introduction", "Add Questions", 2);

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Reassign from pending task list button.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskReassignButton(templateName, "Introduction",
				"qanarolasme1@mailinator.com", "QaNarola Sme1");

		testStepsLog("Step " + (stepCount++), " Click on Reassign from pending task list button.");
		templateVerificationPage = templateIndexPage.dashboardSMETaskReassignButton(templateName, "Introduction",
				"qanarolasme3@mailinator.com", "QaNarola Sme3");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++),
				" Verify After Reassigning the Template task, task will be removed from the Pending Task.");
		boolean rejecttaskinpendingtab = templateVerificationPage
				.verifyReassignTaskisnotDisplayinPendingTab(templateName);
		Assert.assertTrue(rejecttaskinpendingtab, "Error message is not displaying");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 2");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++),
				" Verify After Reassigning the Template task, task will be display in another sme Pending Task.");
		Boolean reassignAnothersmeinpendingtab = templateVerificationPage
				.verifyReassignTaskisDisplayinAnotherSMEPendingTab(templateName);
		Assert.assertTrue(reassignAnothersmeinpendingtab, "Task is not displaying in another sme pending tab.");

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Step " + (stepCount++), " Verify Reassign icon and User should be displayy in the SME TAb.");
		Boolean reassignicon = templateVerificationPage.verifyReassignIconPresent("QaNarola Sme2");
		Assert.assertTrue(reassignicon, "Icon or USer name not displayed");

		pause(3);
		closingSession();

	}

}
