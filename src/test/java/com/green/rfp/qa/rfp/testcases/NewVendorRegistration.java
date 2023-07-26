package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class NewVendorRegistration extends BaseClass {

	@Test
	public void newVendorRegistration() {
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");
		superAdminloginValid();
		logger.info("Login Successfully");
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link Button");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create Button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		logger.info("Clicked and Selecetd RFP");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		logger.info("Filled Rfp Details");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "Scratch", rfpName, "DetailedPricing");
		logger.info("RFP section Created");
		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click continue button on Needs tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveQuestions");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");
		logger.info("Clicked on Continue Button on review Tab");
		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalrfp();
		logger.info("Clicked and skipp approvaal");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		logger.info("Clicked on Continue Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Get RFP Link' button.");
		rfpVerificationPage = rfpIndexPage.clickOnGetRFPlink();
		logger.info("Clicked on Get RFp link");
		testStepsLog("Step " + (stepCount++), " Get the RFP Link.");
		String Link = rfpIndexPage.getRFPlink();
		logger.info("linked copied");
		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		rfpVerificationPage = rfpIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on close Button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes Button");
		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		// ccsd
		logOut();
		logger.info("logged out");
		testStepsLog("Step " + (stepCount++), " Enter RFP link into the browser.");
		rfpVerificationPage = rfpIndexPage.LoginWithRFPlink(Link);
		logger.info("Login with RFP link");
		testStepsLog("Step " + (stepCount++), " Click on create a new account link.");
		rfpVerificationPage = rfpIndexPage.createNewAccountLink();

		String userFirstname = "super";
		String userLastname = "Admin";

		testStepsLog("Step " + (stepCount++), " Add Vendor details like firstname,lastname and emailid.");
		rfpVerificationPage = rfpIndexPage.enterVendorDetails(userFirstname, userLastname,
				(userFirstname + "@thegreenrfp.com"));
		rfpVerificationPage = rfpIndexPage.acceptTerms();
		logger.info("Clicked on Accept terms Button");
		testStepsLog("Step " + (stepCount++), " Click on 'Create my account' button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateBtn();
		logger.info("Clicked on create Button");
		testStepsLog("Verification", " Verify Login screen is present because user is already registered.");
		Boolean reportIsGenerated = rfpVerificationPage.verifyLoginScreenPresent();
		Assert.assertTrue(reportIsGenerated, "User is not registered.");
		logger.info("Verifyed");
		testStepsLog("Step " + (stepCount++), " Enter RFP link into the browser.");
		rfpVerificationPage = rfpIndexPage.LoginWithRFPlink(Link);

		testStepsLog("Step " + (stepCount++), " Click on create a new account link.");
		rfpVerificationPage = rfpIndexPage.createNewAccountLink();

		userFirstname = randomStringGenerate();
		userLastname = randomStringGenerate();

		// enter invalid emailid
		testStepsLog("Step " + (stepCount++), " Add Vendor details like firstname,lastname and emailid.");
		rfpVerificationPage = rfpIndexPage.enterVendorDetails(userFirstname, userLastname, "asd@test");
		rfpVerificationPage = rfpIndexPage.acceptTerms();
		logger.info("Clicked on Accept terms Button");
		testStepsLog("Verification", " Verify error message 'Username must be a valid e-mail address' displayed.");
		reportIsGenerated = rfpVerificationPage.verifyErrorMessage("Username must be a valid e-mail address");
		Assert.assertTrue(reportIsGenerated, "Error is not displaying for invalid emailID.");
		logger.info("Verify error message");
		testStepsLog("Step " + (stepCount++), " Add Vendor details like firstname,lastname and emailid.");
		rfpVerificationPage = rfpIndexPage.enterVendorDetails(userFirstname, userLastname,
				(userFirstname + "@mailinator.com"));
		logger.info("Entered vendor details");
		testStepsLog("Step " + (stepCount++), " Click on 'Create my account' button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateBtn();
		logger.info("Clicked on create Button");
		pause(1);
		driver.get(inboxLink + userFirstname + "#/#inboxpane");

		testStepsLog("Step " + (stepCount++), " Click on mail to set password for the account.");
		rfpVerificationPage = rfpIndexPage.clickOnMail();
		logger.info("Clicked on mailed ");
		testStepsLog("Step " + (stepCount++), " Click on Set password button.");
		rfpVerificationPage = rfpIndexPage.clickOnSetPasswordBtn();
		logger.info("Clicked on Set Password Button");

		SwitchtoTab(1);

		testStepsLog("Step " + (stepCount++), " Set Password.");
		rfpVerificationPage = rfpIndexPage.setPassword();
		logger.info("Password set");
		testStepsLog("Step " + (stepCount++), " Enter title and phone number.");
		rfpVerificationPage = rfpIndexPage.enterTitleAndPhone("Title", "1234517538");
		logger.info("Enter title and phone");
		String companyname = randomStringGenerate();
		testInfoLog("companyname : " + companyname);
		testStepsLog("Step " + (stepCount++), " Enter company details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails(companyname, "12345", "20", "park streets", "abc", "xyz",
				"opq", "20000", "google.com");
		logger.info("Entered company details");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link Button");

		closeAfterLoginPopup();
		testStepsLog("Step " + (stepCount++), " Logout from the user.");

		logOut();
		testStepsLog("Step " + (stepCount++), " Enter RFP link into the browser.");
		rfpVerificationPage = rfpIndexPage.LoginWithRFPlink("https://" + env + ".thegreenrfp.com/login");
		logger.info("Enter url");
		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");
		superAdminloginValid();
		logger.info("login");
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP link Button");

		closingSession();

		loginAs(companyname, userFirstname + " " + userLastname);
		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		logger.info("Clicked on Scroll to pending task");
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");

	}

}
