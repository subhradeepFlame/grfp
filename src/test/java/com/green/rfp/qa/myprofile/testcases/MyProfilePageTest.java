package com.green.rfp.qa.myprofile.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class MyProfilePageTest extends BaseClass {

	int numOfFailure = 0;
	String validPassword = "Narola@1234";
	String invalidPassword = "narola1234";
	String validConfirmPassword = "Narola@1234";
	String invalidConfirmPassword = "narola1234";

	@Test(priority = 1)
	public void login() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		loginValid();
	}

	@Test(priority = 2)
	public void removeValueFromTitleFilesAndVerifyUpdateButtonStatus() throws IOException {

		testStepsLog("Step " + (stepCount++),
				"Remove the value from the \"Title\" field and verify Update button is disabled.");
		pause(3);
		myProfilePage.clickOnMyProfileMenu();
		logger.info("Click on My Profile Menu");
		myProfilePage.clickOnMyProfile();
		logger.info("Click on My Profile");

		myProfilePage.clearTitleText();
		logger.info("Remove Text from Title Field");
		if (myProfilePage.verifyUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Update Button Disabled test passed");
			pause(3);

		} else {
			add_screenShot("RemoveTitle");
			Assert.assertTrue(false);
			logger.info("Verify Update Button Disabled test Failed");
		}
	}

	@Test(priority = 3)
	public void removeValueFromFirstNameFieldAndVerifyUpdateButtonStatus() throws IOException

	{
		testStepsLog("Step " + (stepCount++),
				" Remove the value from the \"First Name\" field and verify Update button is disabled.");
		pause(5);
		myProfilePage.enterTitle();
		myProfilePage.clearFirstName();
		logger.info("Remove Text from First Name Field");
		if (myProfilePage.verifyUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Update Button Disabled test passed");
			pause(3);
		} else {
			add_screenShot("RemoveFirstName");
			Assert.assertTrue(false);
			logger.info("Verify Update Button Disabled test Failed");
		}
	}

	@Test(priority = 4)
	public void removeValueFromLastNameFieldAndVerifyUpdateButtonStatus() throws IOException {
		pause(6);
		testStepsLog("Step " + (stepCount++),
				" Remove the value from the \"Last Name\" field and verify Update button is disabled.");
		pause(3);
		myProfilePage.enterFirstName();
		logger.info("Enter First Name");
		myProfilePage.clearLastName();
		logger.info("Remove Text from Last Name Field");
		if (myProfilePage.verifyUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Update Button Disabled test passed");
			pause(2);
		} else {
			add_screenShot("RemoveLastName");
			Assert.assertTrue(false);
			logger.info("Verify Update Button Disabled test Failed");
		}
	}

	@Test(priority = 5)
	public void removeValueFromPhoneFieldAndVerifyUpdateButtonStatus() throws IOException {
		testStepsLog("Step " + (stepCount++),
				" Remove the value from the \"Phone\" field and verify Update button is disabled.");
		pause(3);
		myProfilePage.enterLastName();
		logger.info("Enter Last Name");
		myProfilePage.clearPhone();
		logger.info("Remove Text from Phone Field");
		if (myProfilePage.verifyUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Update Button Disabled test passed");
			pause(2);
		} else {
			add_screenShot("RemovePhone");
			Assert.assertTrue(false);
			logger.info("Verify Update Button Disabled test Failed");
		}
	}

	@Test(priority = 6)
	public void removeValueFromEmailFieldAndVerifyUpdateButtonStatus() throws IOException {
		testStepsLog("Step " + (stepCount++),
				"Remove the value from the \"Phone\" field and verify Update button is disabled.");
		pause(3);
		myProfilePage.enterPhone();
		logger.info("Enter Phone");
		myProfilePage.clearEmail();
		logger.info("Remove Text from Email Field");
		if (myProfilePage.verifyUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Update Button Disabled test passed");
			pause(2);
			myProfilePage.clickOnCancelButton();
		} else {
			add_screenShot("RemoveEmail");
			Assert.assertTrue(false);
			logger.info("Verify Update Button Disabled test Failed");
		}
	}

	@Test(priority = 7)
	public void clickOnUpdateAndVerifyVaidationMessage() {

		testStepsLog("Step " + (stepCount++), " Click on Update and verify validation message");
		myProfilePage.clickOnMyProfileMenu();
		myProfilePage.clickOnMyProfile();
		myProfilePage.clickOnUpdate();
		pause(2);

		PresenceOfElement(By.xpath("//span[contains(text(),'Profile update succcessfully')]"));
		Assert.assertEquals("Profile update succcessfully",
				driver.findElement(By.xpath("//span[contains(text(),'Profile update succcessfully')]")).getText());

	}

	@Test(priority = 8)
	public void verifyChangePassword() throws IOException {
		pause(2);
		testStepsLog("Verification", " Verify password button is diasable or not");
		myProfilePage.clickOnChangePassword();
		pause(5);
		if (myProfilePage.verifyPasswordUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Password Update Button Disabled test passed");
			pause(3);

		} else {
			add_screenShot("passwordUpdate");
			Assert.assertTrue(false);
			logger.info("Verify Password Update Button Disabled test Failed");
		}

		testStepsLog("Verification", " Verify password button is diasable or not by entering password mismatch");
		myProfilePage.enterPassword(validPassword);
		myProfilePage.enterPasswordConfirmation(invalidConfirmPassword);

		if (myProfilePage.verifyPasswordUpdateButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Password Update Button Disabled test passed");
			pause(3);

		} else {
			add_screenShot("passwordUpdate");
			Assert.assertTrue(false);
			logger.info("Verify Password Update Button Disabled test Failed");
		}

		testStepsLog("Verification", " Verify password by entering weak password");
		myProfilePage.enterPassword(invalidPassword);
		WebElement aa = driver.findElement(By.id("dialogContent_set-password-form"));
		System.out.println(aa.getText());

	}

}
