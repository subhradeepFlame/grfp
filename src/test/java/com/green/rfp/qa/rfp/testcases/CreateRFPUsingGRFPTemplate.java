package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class CreateRFPUsingGRFPTemplate extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void createRFPUsingGRFPTemplate() {
		if (!env.equalsIgnoreCase("dashboard")) {
			superAdminloginValid();

			loginAs("Codeclouds", "Narola GrfpAdmin");
			testStepsLog("Step " + (stepCount++), " Click on Support left link.");
			dashboardVerificationPage = dashboardIndexPage.clickSupportLeftLink();
			logger.info("Clicked on Support link Button");
			testStepsLog("Step " + (stepCount++), " Click on Templates link from Support left link.");
			dashboardVerificationPage = dashboardIndexPage.clickTemplateLinkFromSupportLeftLink();
			logger.info("Clicked on template link Button");
			waitForPageLoaded();
			testStepsLog("Step " + (stepCount++), " Click on create button.");
			rfpVerificationPage = rfpIndexPage.clickGRFPTemplateCreateButton();
			logger.info("Clicked on create template Button");
			String grfpTempName = getCurrentTimeStampString();
			String constant_grfpTemplateName = grfpTempName;
			System.out.println("-----constant_grfpTemplateName----" + constant_grfpTemplateName);
			testStepsLog("Step " + (stepCount++), " Enter name=" + grfpTempName);
			templateVerificationPage = templateIndexPage.enterName(grfpTempName);
			logger.info("Entered template name");
			testStepsLog("Step " + (stepCount++), " Enter description.");
			templateVerificationPage = templateIndexPage.enterDescriptionGRFPADmin();
			logger.info("Entered description");
			testStepsLog("Step " + (stepCount++), " Enter section name.");
			templateVerificationPage = templateIndexPage.enterSectionName("Introduction");
			logger.info("Enterred section Name");
			testStepsLog("Step " + (stepCount++), " Click on plus button.");
			templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
			logger.info("Clicked on plus Button");
			// Verification of edit and delete icon
			Boolean isEditIconsForSectionsVerified = templateVerificationPage
					.verifyEditAndDeleteIconForContentSection("Introduction");
			Assert.assertTrue(isEditIconsForSectionsVerified,
					"Edit and Delete icons are not available for 'Introduction' section.");
			logger.info("Verifyed");

			testStepsLog("Step " + (stepCount++), " Click on continue button on Sections tab.");
			templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");
			logger.info("Clicked on Continue Button");
			testStepsLog("Step " + (stepCount++), " Scroll to 'UNASSIGNED QUESTIONS' section.");
			templateVerificationPage = templateIndexPage.scrollToUnAssignedQuestions();
			logger.info("Scroll to Unassigned question");
			testStepsLog("Step " + (stepCount++), " Click on continue button on Needs tab.");
			templateVerificationPage = templateIndexPage.clickOnContinueOnNeedsTab("vm.saveQuestions(true)");
			logger.info("Clicked on Continue Button");
			testStepsLog("Step " + (stepCount++), " Click template publish button.");
			templateVerificationPage = templateIndexPage.clickTemplatePublishButton();
			logger.info("Clicked on publish Button");
			testStepsLog("Step " + (stepCount++), " Click on Templates link from Support left link.");
			dashboardVerificationPage = dashboardIndexPage.clickTemplateLinkFromSupportLeftLink();
			logger.info("Clicked on trmplate link Button");

			testStepsLog("Step " + (stepCount++), " Click on close remote button.");
			rfpVerificationPage = rfpIndexPage.clickOnCloseRemoteButton();
			logger.info("Clicked on close Button");

			testStepsLog("Step " + (stepCount++), " Click on yes button.");
			rfpVerificationPage = rfpIndexPage.clickOnYesButton();
			logger.info("Clicked on Yes Button");
			testStepsLog("Step " + (stepCount++), " Click on log in as button.");
			rfpVerificationPage = rfpIndexPage.clickOnLogInAsButton();
			logger.info("Clicked on Log in as  Button");
			testStepsLog("Step " + (stepCount++), " Click on qa testing button.");
			rfpVerificationPage = rfpIndexPage.clickOnQATestingButton("Narola Infotech");
			logger.info("Clicked and select narola infotech");
			testStepsLog("Step " + (stepCount++), " Click on select user button.");
			rfpVerificationPage = rfpIndexPage.clickOnSelectUserButton();
			logger.info("Clicked");
			testStepsLog("Step " + (stepCount++), " Click on QA RFP Owner button.");
			rfpVerificationPage = rfpIndexPage.selectUser("QaNarola RFP");
			logger.info("Clicked and select QaNArola Rfp");
			testStepsLog("Step " + (stepCount++), " Click on go button.");
			templateVerificationPage = templateIndexPage.clickOnGoButton();
			logger.info("Clicked on Go Button");
			testStepsLog("Step " + (stepCount++), " Click on yes button.");
			templateVerificationPage = templateIndexPage.clickOnYesButton();
			logger.info("Clicked on Yes Button");
			testStepsLog("Step " + (stepCount++), " Click on RFP link.");
			dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
			logger.info("Clicked on RFP link Button");
			testStepsLog("Step " + (stepCount++), " Click on create button.");
			rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
			logger.info("Clicked on Create Button");
			testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
			Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "GRFP");
			Assert.assertTrue(isRFPTypeSelected, "RFP type is disable.");
			logger.info("verified");
			testStepsLog("Step " + (stepCount++), " Select GRFP template.");
			rfpVerificationPage = rfpIndexPage.useCreatedTemplate();
			logger.info("Select GRFP template");
			String rfpName = getCurrentTimeStampString();
			testStepsLog("Step " + (stepCount++), " Fill RFP - Summary");
			rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "GRFP", rfpName);
			logger.info("Fill RFP information");
			testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
			rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "GRFP", rfpName, "DetailedPricing");
			logger.info("Create RFP Section");
			testStepsLog("Step " + (stepCount++), " Click on RFP link.");
			dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
			logger.info("Clicked on RFP left link");
		} else {
			testSkipLog("We are not creating FRFP template in " + env + " environment");
		}
	}

	@Test(priority = 3)
	public void done() {
		System.out.println("Done Grfp template");
	}

}
