package com.green.rfp.qa.template.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateIndexPageTest extends BaseClass {

	TestUtil testutil = new TestUtil();
	String templateName = "DemoTemplate" + getCurrentTimeStampString();

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "84%", "100%" };

	@Test(priority = 1)
	public void createTemplate() {

		superAdminloginValid();

		loginAsFor("Customer Admin");
		testStepsLog("Verification", " Verify Dashboard sidenavigation of CAdmin.");
		boolean isSidenavigation = templateVerificationPage.verifySidenavigation();
		Assert.assertTrue(isSidenavigation, "Side navigation verification failed");
		// Verification of dashboard page
		testStepsLog("Verification", " Verify Dashboard page.");
		Boolean isDashboardPageVerified = dashboardVerificationPage.verifyDashboardPage("CustomerAdmin");
		System.out.println("Dsshboard" + isDashboardPageVerified);
		Assert.assertTrue(isDashboardPageVerified, "Dashboard page is not verified.");

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

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Introduction", "qanarolasme1@mailinator.com ",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), "Enter SME as qanarolasme2@mailinator.com for Edit Section Description.");
		templateVerificationPage = templateIndexPage.enterSMENew("Introduction", "qanarolasme2@mailinator.com ",
				"Edit Section Description", 2);

		testStepsLog("Step " + (stepCount++), "Enter SME as qanarolasme1@mailinator.com for Add Questions permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Objectives", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++), " Enter SME as qanarolasme2@mailinator.com for 'Both' Description.");
		templateVerificationPage = templateIndexPage.enterSMENew("Objectives", "qanarolasme2@mailinator.com", "Both",
				2);

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
		Boolean orangeEmailIconVisible1 = templateVerificationPage.verifyEmailIconForSME("Introduction", 2);
		Assert.assertTrue(orangeEmailIconVisible1, "Orange email icon is not visible.");

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible2 = templateVerificationPage.verifyEmailIconForSME("Objectives", 1);
		Assert.assertTrue(orangeEmailIconVisible2, "Orange email icon is not visible.");

		testStepsLog("Verification", " Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible3 = templateVerificationPage.verifyEmailIconForSME("Objectives", 2);
		Assert.assertTrue(orangeEmailIconVisible3, "Orange email icon is not visible.");

		// Verification of Completion Percentage after adding one CSME

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		Boolean checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[0]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

	}

	@Test(priority = 3, dependsOnMethods = { "createTemplate" })
	public void acceptTaskAndEditSectionBySme1User() {
		pause(5);

		closingSession();
		loginAsFor("Customer SME 1");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");
		boolean verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring

		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		String count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from csme1 for getting assigned to a task

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");
		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "assigned",
				"Assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Assigned");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");
		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Verification", " Verify notification count decrease to one from bell-icon.");
		verifyNotification = templateVerificationPage.verifyNotificationcount(count);
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");
		// Objective
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

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

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

	}

	@Test(priority = 4, dependsOnMethods = { "createTemplate" })
	public void acceptTaskAndEditSectionBySmeUser2() {
		pause(5);

		closingSession();
		loginAsFor("Customer SME 2");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");

		boolean verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring

		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		String count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from csme1 for getting assigned to a task

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "assigned",
				"Assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Assigned");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");
		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Verification", " Verify notification count decrease to one from bell-icon.");
		verifyNotification = templateVerificationPage.verifyNotificationcount(count);
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");
		// Objective
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

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
		question = "Objectives section question by sme user2";
		questionWeight = "Medium";
		section = "Objectives";

		testStepsLog("Step " + (stepCount++), " Add new question with answer type,question,question weight,section");
		templateVerificationPage = templateIndexPage.fillNewQuestionData(answerType, question, questionWeight, section);

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

		testStepsLog("Step " + (stepCount++), " Click on 'Save Question' button");
		templateVerificationPage = templateIndexPage.clickOnSaveQuestionButton();

		testStepsLog("Step " + (stepCount++), " Click on Save and submit button");
		templateVerificationPage = templateIndexPage.clickOnSaveAndSubmitButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		// verify admin dashboard

	}

	@Test(priority = 5, dependsOnMethods = { "createTemplate", "acceptTaskAndEditSectionBySme1User",
			"acceptTaskAndEditSectionBySmeUser2" })

	public void verifyAdminDashboard() {
		pause(5);

		closingSession();
		loginAsFor("Customer Admin");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");

		boolean verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"completed");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring
		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		String count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "completed");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from message Center after completing task from sme

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "completed",
				"Finished");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Finished");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");

		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "completed");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Verification", " Verify notification count decrease to one from bell-icon.");
		verifyNotification = templateVerificationPage.verifyNotificationcount(count);
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		// Verification of Completion Percentage after completing task from two CSMEs.

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		boolean checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[0]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Review'");
		templateVerificationPage = templateIndexPage.clickOnReviewBubble();

		testStepsLog("Step " + (stepCount++), " Click on 'Approve all'");
		templateVerificationPage = templateIndexPage.clickOnApproveAll();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve all' for 'Introduction' section.");
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

		// Verification of Completion Percentage after approving tasks from Review tab
		// of QACAdmin.

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[1]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers' tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover1@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Add 'QA approver' on 'Approvers' tab");
		templateVerificationPage = templateIndexPage.addQAApprover("In Sequence", "qanarolaapprover3@mailinator.com");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[1]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		testStepsLog("Step " + (stepCount++), " Click on Template link again.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Select template=" + templateName);
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		// Verification of Completion Percentage after adding QA approvers from Approver
		// tab of QACAdmin.

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[1]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		closingSession();
		loginAsFor("Customer Approver 1");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");
		verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring
		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from approver1 for getting task for approval

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "assigned",
				"Assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Assigned");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");

		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.templateClickDashboardAccBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer Admin");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");

		verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring

		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "approved");

		// Verify notification from message Center after approving task from approver1

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "approved",
				"Approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Approved");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");

		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Verification", " Verify notification count decrease to one from bell-icon.");
		verifyNotification = templateVerificationPage.verifyNotificationcount(count);
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		// Verification of Completion Percentage after approving tasks by Approvers
		// added by QACAdmin.

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		testStepsLog("Step " + (stepCount++), "Search and select Template : " + templateName);
		templateIndexPage.searchSelectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on 'Approvers'");
		templateVerificationPage = templateIndexPage.clickOnApproversBubble();

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[2]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		closingSession();
		loginAsFor("Customer Approver 3");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");

		verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring
		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from approver2 for getting task for approval
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "assigned",
				"Assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Assigned");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");

		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "assigned");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();

		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		templateVerificationPage = templateIndexPage.templateClickDashboardAccBtnForApprover(templateName);

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click Got it button.");
		templateVerificationPage = templateIndexPage.clickGotitButton();

		testStepsLog("Step " + (stepCount++), " Click on Approve button.");
		templateVerificationPage = templateIndexPage.clickOnApproveButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button after 'Approve' the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		closingSession();
		loginAsFor("Customer Admin");

		// Verify notification from Notification link
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();

		testStepsLog("Verification", " Verify notification from Notifications link.");

		verifyNotification = templateVerificationPage.verifyNotificationfromNotificationslinkNew(templateName,
				"approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Notifications link");

		// Verify notification from Bell-Ring
		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");
		count = templateIndexPage.getNotificationCount();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Verification", " Verify notification displayed at Bell-Ring.");

		verifyNotification = templateVerificationPage.verifyNotificationfromBellRingNew(templateName, "approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Bell-Ring");

		// Verify notification from message Center after approving task from approver2
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillMessageCenter();

		testStepsLog("Verification", " Verify notification displayed at Message Center.");

		verifyNotification = templateVerificationPage.verifyNotificationformMessagecenterNew(templateName, "approved",
				"Approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on the notifiction.");
		templateVerificationPage = templateIndexPage.clickOnNotification("Approved");

		testStepsLog("Verification", " Verify notification displayed at PopUp.");

		verifyNotification = templateVerificationPage.verifyNotificationformPopupNew(templateName, "approved");
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		testStepsLog("Step " + (stepCount++), " Click on ok button.");
		templateVerificationPage = templateIndexPage.clickOnOk();

		testStepsLog("Verification", " Verify notification count decrease to one from bell-icon.");
		verifyNotification = templateVerificationPage.verifyNotificationcount(count);
		Assert.assertTrue(verifyNotification, "Notification is not displayed at Message Center");

		// Verification of Completion Percentage after approving tasks by Approvers
		// added by QACAdmin.
		testStepsLog("Step " + (stepCount++), " Click on Dashboard link.");
		templateVerificationPage = templateIndexPage.clickOnDashboardLeftLink();

		testStepsLog("Verification", " Verify template's percentage of completion.");
		checkPercentage = templateVerificationPage.verifyCompletionPercentage(templateName, percentage[3]);
		Assert.assertTrue(checkPercentage, "Percentage is not correct.");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click particular template.");
		templateVerificationPage = templateIndexPage.selectTemplate(templateName);

		testStepsLog("Step " + (stepCount++), " Click on publish bubble.");
		templateVerificationPage = templateIndexPage.clickOnPublishBubble();

		testStepsLog("Step " + (stepCount++), " Click on public-private toggle to make template public.");
		templateVerificationPage = templateIndexPage.makeTemplatePublic();

		testStepsLog("Step " + (stepCount++), " Click template publish button.");
		templateVerificationPage = templateIndexPage.clickTemplatePublishButton();

		// Verification of Completion Percentage after Publishing Template by QACAdmin.
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		System.out.println("Done template");

	}

}
