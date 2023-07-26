package com.green.rfp.qa.login.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.XLUtils;

public class LoginPageTestbk extends BaseClass {
	public String exceptedTitle = "Green RFP";

	String dataFilePath = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/login.xlsx";
	String diasableActualColor = "#000000";
	String enableActualColor = "#ffffff";
	String exceptedUrl = con.getUrl() + "myaccount/dashboard";

	String invalidUsername = XLUtils.getCellValue(dataFilePath, "Sheet1", 1, 0);
	String correcrPassword = getPassword("Customer Admin");
	String validUsername = getEmail("Customer Admin");
	String incorrectPassword = XLUtils.getCellValue(dataFilePath, "Sheet1", 2, 1);

	@Test(priority = 1)
	public void verifyTitle() throws IOException {
		

		waitForPageLoaded();
		pause(5);
		String title = loginPage.varifyPageTitle();
		Assert.assertEquals("", exceptedTitle, "Home Page Title is not Matched");

		logger.info("Login test passed");

	}

	@Test(priority = 2)
	public void loginWithoutEnteringPassword() throws IOException {
		testStepsLog("Step " + (stepCount++),"Perform login without entering password and Verify Log In Button is Disabled");
		loginPage.enterEmail(userName);
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.verifyLoginButtonDisabled();
		if (loginPage.verifyLoginButtonDisabled()) {
			Assert.assertTrue(true);
			logger.info("Verify Log in Button Disabled test passed");
		} else {
			add_screenShot("verifyLoginButtonDisabled");
			Assert.assertTrue(false);
			logger.info("Verify Log in Button Disabled test Failed");
		}
	}
}
