package com.green.rfp.qa.bugs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class AccessNotificationMenu extends BaseClass {
	String exceptedUrl = baseURl + "myaccount/notifications";

	@Test(priority = 1)
	public void verifyUserAccessNotificationMenu() {
		superAdminloginValid();

		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();
		pause(5);
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		System.out.println(exceptedUrl);
		if (actualUrl.equals(exceptedUrl)) {
			System.out.println("User managed to access notification menu");
			Assert.assertTrue(true);
		}

		else {
			System.out.println("User Not managed to access notification menu");
			Assert.assertTrue(false);
		}

		testStepsLog("Step " + (stepCount++), " Get the total number of notification's count.");

		testStepsLog("Step " + (stepCount++), " Scroll");
		templateVerificationPage = templateIndexPage.scrollTillbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on Bell-Ring icon.");
		templateVerificationPage = templateIndexPage.clickOnbellringIcon();

		testStepsLog("Step " + (stepCount++), " Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on close button");
		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes button");

		testStepsLog("Step " + (stepCount++), " Click on Notifications link.");
		templateVerificationPage = templateIndexPage.clickOnNotificationLeftLink();
		pause(5);
		String actualUrlSuper = driver.getCurrentUrl();
		System.out.println(actualUrlSuper);
		System.out.println(exceptedUrl);
		if (actualUrlSuper.equals(exceptedUrl)) {
			System.out.println("User managed to access notification menu");
			Assert.assertTrue(true);
		} else {
			System.out.println("User Not managed to access notification menu");
			Assert.assertTrue(false);
		}
		testStepsLog("Step " + (stepCount++), " User logged out");
		closingSession();
		logOut();
		System.out.println("Done Accessing Notification Menu");
	}

}
