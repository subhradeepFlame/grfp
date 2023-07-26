package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateNegative14 extends BaseClass {
	TestUtil testutil = new TestUtil();

	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };

	@Test(priority = 15)
	public void smeDeleteFunctionality() {
		try {
			testStepsLog("Step " + (stepCount++), " Perform login");
			superAdminloginValid();
			testStepsLog("Step " + (stepCount++), " Click on Support left link.");
			dashboardVerificationPage = dashboardIndexPage.clickSupportLeftLink();

			testStepsLog("Step " + (stepCount++), " Click on Content left link.");
			dashboardVerificationPage = dashboardIndexPage.clickContentLeftLink();

			testStepsLog("Step " + (stepCount++), " Click on Create Button.");
			templateVerificationPage = templateIndexPage.clickOnCreatebutton();

			String name = randomStringGenerate();
			testStepsLog("Step " + (stepCount++), " Enter content details such as name and Price.");
			templateVerificationPage = templateIndexPage.enterContentDetails(name, "1");

			testStepsLog("Step " + (stepCount++), " Click on Import button.");
			templateVerificationPage = templateIndexPage.clickOnImport();

			testStepsLog("Step " + (stepCount++), " Click on Import Content link.");
			templateVerificationPage = templateIndexPage.clickOnImportContentLink();

			testStepsLog("Step " + (stepCount++), " Click on Done button.");
			templateVerificationPage = templateIndexPage.clickOnDoneButton();

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
			pause(3);
			testStepsLog("Step " + (stepCount++), " Enter description.");
			templateVerificationPage = templateIndexPage.enterDescription();

			testStepsLog("Step " + (stepCount++), " Enter section name.");
			templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

			testStepsLog("Step " + (stepCount++), " Click on plus button.");
			templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

			testStepsLog("Step " + (stepCount++), " Click on continue button.");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

			testStepsLog("Step " + (stepCount++),
					" Enter SME as qanarolasme1@mailinator.com  for Add Question permission.");
			templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme1@mailinator.com",
					"Add Questions", 1);

			testStepsLog("Step " + (stepCount++), " Click on continue button.");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

			testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
			templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

			testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
			templateVerificationPage = templateIndexPage.clickOnSmesBubble();

			testStepsLog("Step " + (stepCount++), " Click add new SME button.");
			templateVerificationPage = templateIndexPage.clickAddNewSMEButton("Introduction", 1);

			testStepsLog("Step " + (stepCount++),
					" Enter SME as qanarolasme2@mailinator.com for Edit Section Description.");
			templateVerificationPage = templateIndexPage.enterSME("Introduction", "qanarolasme2@mailinator.com",
					"Edit Section Description", 2);

			testStepsLog("Step " + (stepCount++), " Click on Save Button");
			templateVerificationPage = templateIndexPage.clickOnSavebuttonn();

			testStepsLog("Step " + (stepCount++), " Click on continue button.");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

			testStepsLog("Step " + (stepCount++), " Click on help my sme button.");
			templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

			testStepsLog("Step " + (stepCount++), " Verify needs tab displays saved details successfully.");
			Boolean needsTab = templateVerificationPage.verifyNeedsTab("Introduction");
			Assert.assertTrue(needsTab, "Needs tab is not displaying information");

			String userFirstname = "qanarolasme2";
			driver.get(inboxLink + userFirstname + "#/#inboxpane");

			testStepsLog("Step " + (stepCount++), " Verify invitation link for the sme task is present.");
			Boolean invitationMail = templateVerificationPage.verifysmeInvitationMail();
			Assert.assertTrue(invitationMail, "Invitation link for the sme task is not present");

			driver.navigate().back();
			pause(4);

			testStepsLog("Step " + (stepCount++), " Click on smes bubble.");
			templateVerificationPage = templateIndexPage.clickOnSmesBubble();

			testStepsLog("Step " + (stepCount++), " Click on Delete button of CSME 2.");
			templateVerificationPage = templateIndexPage.deleteSme("2");

			testStepsLog("Step " + (stepCount++), " Click on yes button.");
			templateVerificationPage = templateIndexPage.clickOnYesButton();

			testStepsLog("Step " + (stepCount++), " Click on Delete button of CSME 1.");
			templateVerificationPage = templateIndexPage.deleteSme("1");

			testStepsLog("Step " + (stepCount++), " Click on yes button.");
			templateVerificationPage = templateIndexPage.clickOnYesButton();
			// import functionality
			testStepsLog("Step " + (stepCount++), " Click on continue button.");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

			testStepsLog("Step " + (stepCount++), " Click on 'Import' button on Needs tab.");
			templateVerificationPage = templateIndexPage.clickOnImportButton();

			testStepsLog("Step " + (stepCount++), " Import Question.");
			templateVerificationPage = templateIndexPage.importQuestion();

			testStepsLog("Step " + (stepCount++), " Verify Imported question displayed with delete icon.");
			invitationMail = templateVerificationPage.verifyImportedQuestionAndDeleteIcon();
			Assert.assertTrue(invitationMail, "Imported question and delete icon are not present");

			testStepsLog("Step " + (stepCount++), " Click on done button.");
			templateVerificationPage = templateIndexPage.clickOnDoneButton();
			testStepsLog("Step " + (stepCount++), " Click on 'Question database' button.");
			templateVerificationPage = templateIndexPage.clickQueDatabase();

			testStepsLog("Step " + (stepCount++), " Click on 'Question database' checkbox.");
			templateVerificationPage = templateIndexPage.checkQueDatabase(name);

			testStepsLog("Step " + (stepCount++), " Click on 'save' button.");
			templateVerificationPage = templateIndexPage.clickSavebuttonForQueDatabase();

			closingSession();
			testStepsLog("Step " + (stepCount++), " Perform login");
			loginAsFor("Customer SME 2");

			testStepsLog("Step " + (stepCount++), " Scroll");
			templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

			closingSession();
			testStepsLog("Step " + (stepCount++), " Perform login");
			loginAsFor("Customer Admin");

			testStepsLog("Step " + (stepCount++), " Click on Template link.");
			dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

			testStepsLog("Step " + (stepCount++), " Search Template.");
			templateVerificationPage = templateIndexPage.searchTemplate(templateName);

			testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
			templateVerificationPage = templateIndexPage.selectTemplate(templateName);
			// invitation for approver

			testStepsLog("Step " + (stepCount++), " Click on 'Review'");
			templateVerificationPage = templateIndexPage.clickOnReviewBubble();

			testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

			testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers' tab");
			templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover3@mailinator.com");

			testStepsLog("Step " + (stepCount++), " Click on 'Save' button on Approvers tab");
			templateVerificationPage = templateIndexPage.saveApprovers();

			testStepsLog("Step " + (stepCount++), " Verify email icon is in orange color.");
			Boolean icon = templateVerificationPage.verifyOrangeColorForEmailIcon();
			Assert.assertTrue(icon, "Email icon is not having orange color");

			userFirstname = "qanarolaapprover3";
			driver.get(inboxLink + userFirstname + "#/#inboxpane");

			testStepsLog("Step " + (stepCount++), " Verify invitation link for the approver is present.");
			invitationMail = templateVerificationPage.verifyApproverInvitationMail();
			Assert.assertTrue(invitationMail, "Invitation link for the approver is not present");

			driver.navigate().back();
			pause(4);

			closingSession();
			driver.get(baseURl);
			testStepsLog("Step " + (stepCount++), " Click on Support left link.");
			dashboardVerificationPage = dashboardIndexPage.clickSupportLeftLink();

			testStepsLog("Step " + (stepCount++), " Click on Content left link.");
			dashboardVerificationPage = dashboardIndexPage.clickContentLeftLink();
			testStepsLog("Step " + (stepCount++), " Search for content : " + name);

			templateIndexPage.searchContent(name);
			testStepsLog("Step " + (stepCount++), " Click on options");
			adminstrationPage.clickOnDots();
			logger.info("Click on three dots");
			testStepsLog("Step " + (stepCount++), " Click on Delete");

			adminstrationPage.contentClickOnDotsOptions("Delete");
			testStepsLog("Step " + (stepCount++), " Click on Yes Button on alert");

			templateIndexPage.clickOnYesButton();

			pause(3);
			driver.navigate().refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
