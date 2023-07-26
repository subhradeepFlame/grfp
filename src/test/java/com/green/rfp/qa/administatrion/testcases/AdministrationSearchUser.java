package com.green.rfp.qa.administatrion.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class AdministrationSearchUser extends BaseClass {

	@Test(priority = 1)
	public void verifySearchUserFunctionality() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginValid();
		testStepsLog("Step " + (stepCount++), " Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration Link");

		testStepsLog("Step " + (stepCount++), " Click on 'Users' tab.");
		adminstrationPage.clickOnUsersTab();
		logger.info("Click on 'Users' tab");

		testStepsLog("Step " + (stepCount++), " Click Search Icon");
		adminstrationPage.clickOnSearchIcon();
		logger.info("Clicked on Search icon ");

		testStepsLog("Step " + (stepCount++), " Enter Input For search");
		adminstrationPage.searchUser(getEmail("Customer Admin"));
		logger.info("Enter User for Search ");

		testStepsLog("Verification", " Verify Search User  is present.");

		boolean verifyUser = adminstrationPage.verifySearchUserIsDiaplay();
		Assert.assertTrue(verifyUser, "Search User is not displyed");

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on Rfp");

		testStepsLog("Step " + (stepCount++), " Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration Link");

		testStepsLog("Step " + (stepCount++), " Click on 'Users' tab.");
		adminstrationPage.clickOnUsersTab();
		logger.info("Click on 'Users' tab");

		testStepsLog("Step " + (stepCount++), " Click Search Icon");
		adminstrationPage.clickOnSearchIcon();
		logger.info("Clicked on Search icon ");

		testStepsLog("Step " + (stepCount++), " Search User by Entering invalid user");
		adminstrationPage.inValidsearchUser("Invalid data");
		logger.info("Enter User for Search ");

		testStepsLog("Verification", " Verify 'No User Found' displays.");
		Boolean noUserFound = adminstrationPage.verifyNoUserFoundMessageDisplays();
		Assert.assertTrue(noUserFound, "'No User Found' is not displaying.");

	}

}
