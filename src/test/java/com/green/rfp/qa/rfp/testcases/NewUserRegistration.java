package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class NewUserRegistration extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	@Test(priority = 2)
	public void newUserRegistartion() {
		stepCount = 1;
		superAdminloginValid();

		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Administartion link.");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on 'Users' tab.");
		rfpVerificationPage = rfpIndexPage.clickOnUsersTab();

		testStepsLog("Step " + (stepCount++), " Click on 'Create' button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreatebtn();

		String userFirstname = "ccqa" + randomStringGenerate(8);
		String userLastname = randomStringGenerate(8);

		testStepsLog("Step " + (stepCount++), " Enter user details.");
		rfpVerificationPage = rfpIndexPage.enterUserdetails(userFirstname, userLastname,
				(userFirstname + "@mailinator.com"), "RFP Owner", "Mr.");
		pause(5);
		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		closingSession();

		logOut();

		driver.get(inboxLink + userFirstname + "#/#inboxpane");
		waitForPageLoaded();
		pause(5);
		maximizeBrowser();

		testStepsLog("Step " + (stepCount++), " Click on mail to set password for the account.");
		rfpVerificationPage = rfpIndexPage.clickOnMail();

		testStepsLog("Step " + (stepCount++), " Click on Set password button.");
		rfpVerificationPage = rfpIndexPage.clickOnSetPasswordBtn();

		SwitchtoTab(1);
		testStepsLog("Step " + (stepCount++), " Set Password.");
		rfpVerificationPage = rfpIndexPage.setPassword();

		testStepsLog("Step " + (stepCount++), " Enter title and phone number.");
		rfpVerificationPage = rfpIndexPage.enterPhone("1234517538");

		testStepsLog("Step " + (stepCount++), " Close help pop-up.");
		closeAfterLoginPopup();
		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		logOut();
		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");

		superAdminloginValid();

		loginAs(getCompanyName("Customer Admin"), userFirstname + " " + userLastname);
		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Verification", " Verify 'No Templates Found' displays.");
		Boolean approvertaskReassigned = templateVerificationPage.verifyNoTemplateFoundMessageDisplays();

		Assert.assertTrue(approvertaskReassigned, "'No Templates Found' is not displaying.");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Verification", " Verify 'Keep it Simple (K.I.S):' option is not enabled.");
		approvertaskReassigned = rfpVerificationPage.verifyRFPTemplateOptionIsDisabled("Keep it Simple (K.I.S):");
		Assert.assertFalse(approvertaskReassigned, "'Keep it Simple (K.I.S):' option is enabled.");

		testStepsLog("Verification", " Verify 'Your Company Templates:' option is not enabled.");
		approvertaskReassigned = rfpVerificationPage.verifyRFPTemplateOptionIsDisabled("Your Company Templates:");
		Assert.assertFalse(approvertaskReassigned, "'Your Company Templates:' option is enabled.");

	}

}
