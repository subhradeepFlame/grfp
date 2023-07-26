package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class RfpOperation extends BaseClass {

	TestUtil testutil = new TestUtil();
	String rfpName = getCurrentTimeStampString();
	int numOfFailure = 0;

	@Test
	public void login() {
		testCaselog("Template POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");

	}

	@Test(dependsOnMethods = {"login" })
	public void createDuplicateRfp() {
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		logger.info("Verifiyed RFP type is selected");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);

		logger.info("Create RFP and filled out required fields");
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

		testStepsLog("Step " + (stepCount++), " Select rfp checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(rfpName);

		testStepsLog("Step " + (stepCount++), " Click on duplicate icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Duplicate");
		logger.info("Clicked on Duplicate icon");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

	}

	@Test(dependsOnMethods = { "createDuplicateRfp" })
	public void downloadRfp() {

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");

		testStepsLog("Step " + (stepCount++), " Select Template checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(rfpName);
		logger.info("selected");

		testStepsLog("Step " + (stepCount++), " Click on Download icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Download");
		logger.info("Clicked on Download icon");

		testInfoLog(" Verify downloaded PDF is opened in a new tab.");
		Boolean reportIsGenerated = rfpVerificationPage
				.verifyPDFDownloaded("https://" + env + ".thegreenrfp.com/upload/Rfps/" + rfpName + ".pdf");
		testVerifyLog( " Verify downloaded PDF is opened in a new tab.");

	}

	@Test(dependsOnMethods = { "downloadRfp" })
	public void sendTemplateOnEmail() {

		String sendEmail = "sendasemail";
		testStepsLog("Step " + (stepCount++), " Click on Rfp link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("clicked on Rfp link");

		testStepsLog("Step " + (stepCount++), " Select Rfp checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(rfpName);
		logger.info("Selected");

		testStepsLog("Step " + (stepCount++), " Click on Send as Email icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("SendAsEmail");
		logger.info("Clicked on send as Email icon");

		testStepsLog("Step " + (stepCount++), " Enter invalid format of email ");
		templateVerificationPage = templateIndexPage.sendAsEmail("sendasemail");
		logger.info("Clicked on send as Email icon");

		testStepsLog("Step " + (stepCount++), " Click on plus icon");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSendasEmail();
		logger.info("Clicked on plus button");

		testStepsLog("Step " + (stepCount++), " Click on send as email icon from header");
		templateVerificationPage = templateIndexPage.sendAsEmail("sendasemail@mailinator.com");
		logger.info("Clicked on send as Email icon");

		testStepsLog("Step " + (stepCount++), " Click on plus icon");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSendasEmail();
		logger.info("Clicked on plus button");

		testStepsLog("Step " + (stepCount++), " Click on send button");
		templateVerificationPage = templateIndexPage.clickOnRFPSendButtonInSendasEmail();
		logger.info("Clicked on send button");

		driver.get(inboxLink + sendEmail + "#/#inboxpane");

		testStepsLog("Step " + (stepCount++), " Click on Email");
		templateVerificationPage = templateIndexPage.clickOnMail();
		logger.info("Clicked on send button");
		pause(10);

	}

	@Test(dependsOnMethods = { "sendTemplateOnEmail" })
	public void deleteTemplate() {
		driver.get(baseURl);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on Rfp link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Rfp link");

		testStepsLog("Step " + (stepCount++), " Select Template checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(rfpName);
		logger.info("Select RFp for Deleting");

		testStepsLog("Step " + (stepCount++), " Click on delete icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Delete");
		logger.info("Clicked on Delete");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		// Delete Duplicate Template

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFp link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Rfp link");

		testStepsLog("Step " + (stepCount++), " Select Template checkbox=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox("<Duplicate RFP>");
		logger.info("Select Rfp for Deleting");

		testStepsLog("Step " + (stepCount++), " Click on delete icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Delete");
		logger.info("Clicked on Delete");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");
		System.out.println("Done Rfp Operation");

	}

}
