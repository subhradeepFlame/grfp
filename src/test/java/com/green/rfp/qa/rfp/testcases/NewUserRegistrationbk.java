package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class NewUserRegistrationbk extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 1)
	public void login() {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");

	}

	@Test(priority = 2)
	public void newUserRegistartion() {

		testStepsLog("Step " + (stepCount++), " Click on Administartion link.");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on 'Users' tab.");
		rfpVerificationPage = rfpIndexPage.clickOnUsersTab();

		testStepsLog("Step " + (stepCount++), " Click on 'Create' button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreatebtn();

		String userFirstname = randomStringGenerate();
		String userLastname = randomStringGenerate();

		testStepsLog("Step " + (stepCount++), " Enter user details.");
		rfpVerificationPage = rfpIndexPage.enterUserdetails(userFirstname, userLastname,
				(userFirstname + "@mailinator.com"), "Customer RFP Owner", "title");

		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		logOut();
		driver.get(inboxLink + userFirstname + "#/#inboxpane");

		testStepsLog("Step " + (stepCount++), " Click on mail to set password for the account.");
		rfpVerificationPage = rfpIndexPage.clickOnMail();

		testStepsLog("Step " + (stepCount++), " Click on Set password button.");
		rfpVerificationPage = rfpIndexPage.clickOnSetPasswordBtn();

		SwitchtoTab(1);
		testStepsLog("Step " + (stepCount++), " Set Password.");
		rfpVerificationPage = rfpIndexPage.setPassword();

		testStepsLog("Step " + (stepCount++), " Enter title and phone number.");
		rfpVerificationPage = rfpIndexPage.enterPhone("1234517538");

		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		logOut();
		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");

		superAdminloginValid();

		testStepsLog("Step " + (stepCount++), " Click log in as button.");
		rfpVerificationPage = rfpIndexPage.clickOnLogInAsButton();

		testStepsLog("Step " + (stepCount++), " Select Codeclouds user.");
		templateVerificationPage = templateIndexPage.selectnewUser("Codeclouds");

		testStepsLog("Step " + (stepCount++), " Click on select user button.");
		templateVerificationPage = templateIndexPage.clickOnSelectUserButton();

		testStepsLog("Step " + (stepCount++), " Select new user.");

		templateVerificationPage = templateIndexPage.clickSelectnewUser((userFirstname + " " + userLastname));

		testStepsLog("Step " + (stepCount++), " Click on go button.");
		templateVerificationPage = templateIndexPage.clickOnGoButton();

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Verification", " Verify 'Keep it Simple (K.I.S):' option is not enabled.");
		boolean approvertaskReassigned = rfpVerificationPage
				.verifyRFPTemplateOptionIsDisabled("Keep it Simple (K.I.S):");
		Assert.assertFalse(approvertaskReassigned, "'Keep it Simple (K.I.S):' option is enabled.");

		testStepsLog("Verification", " Verify 'Your Company Templates:' option is not enabled.");
		approvertaskReassigned = rfpVerificationPage.verifyRFPTemplateOptionIsDisabled("Your Company Templates:");
		Assert.assertFalse(approvertaskReassigned, "'Your Company Templates:' option is enabled.");

	}

}
