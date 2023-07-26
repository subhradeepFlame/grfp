package com.green.rfp.qa.myprofile.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class MyProfileUploadProfilePhoto extends BaseClass {

	int numOfFailure = 0;
	String validPassword = "Narola@1234";
	String invalidPassword = "narola1234";
	String validConfirmPassword = "Narola@1234";
	String invalidConfirmPassword = "narola1234";

	@Test(priority = 1)
	public void uploadProfilePhoto() throws AWTException {
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Login Successfully");
		testStepsLog("Step " + (stepCount++), " Login as Customer Admin ");
		loginAsFor("Customer Admin");

		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on My Profile Menu .");
		myProfilePage.clickOnMyProfileMenu();
		logger.info("Click on My Profile Menu");
		testStepsLog("Step " + (stepCount++), " Click on My Profile .");
		myProfilePage.clickOnMyProfile();
		logger.info("Click on My Profile");

		testStepsLog("Step " + (stepCount++), " Upload Profile Photo .");
		myProfilePage.uploadPhoto();

		// Upload Invalid Format

		testStepsLog("Step " + (stepCount++), " Click on My Profile Menu .");
		myProfilePage.clickOnMyProfileMenu();
		logger.info("Click on My Profile Menu");
		testStepsLog("Step " + (stepCount++), " Click on My Profile .");
		myProfilePage.clickOnMyProfile();
		logger.info("Click on My Profile");

		testStepsLog("Step " + (stepCount++), " Upload InValid Profile Photo .");
		myProfilePage.inValidFormatuploadPhoto();

	}

}
