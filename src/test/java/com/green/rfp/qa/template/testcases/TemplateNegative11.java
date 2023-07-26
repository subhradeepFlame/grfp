package com.green.rfp.qa.template.testcases;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative11 extends BaseClass{
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };
	
	@Test
	public void TaskRejectedBySMEthroughTemplate() {

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

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();
		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer SME 1");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on Reject button.");
		templateVerificationPage = templateIndexPage.clickRejectButton();

		testStepsLog("Step " + (stepCount++), " Insert SME task reject reason.");
		templateVerificationPage = templateIndexPage.enterrejectReason();

		testStepsLog("Step " + (stepCount++), " Click send button of reject popup button.");
		templateVerificationPage = templateIndexPage.dialogRejectButton();

		testStepsLog("Step " + (stepCount++), " Click on Dashboared Sidepannel");
		templateVerificationPage = templateIndexPage.clickonDashboardLeftSidePannel();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		closingSession();
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);
		testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		pause(3);
		closingSession();

	}
	
	
	
}
