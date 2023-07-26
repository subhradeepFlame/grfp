package com.green.rfp.qa.forgotpassword.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class ForgotPasswordTest extends BaseClass {

	int numOfFailure = 0;

	@Test(priority = 1)
	public void verifySendResentLinkButton() {
		loginPage.enterEmail(userName);
		logger.info("Enter Email");
		testStepsLog("Steps " + stepCount++, "Click on Arrow");
		driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
		logger.info("Click on Arrow");
		forgotPasswordPage.clickOnForgotPasswordLink();
		loginPage.enterEmail("ab@");
		logger.info("Enter Partial email");
		testStepsLog("Verification", " Verify Reset Link button is disabled.");
		boolean errorMessage = forgotPasswordPage.verifyResetLinkBtnDisabled();
		Assert.assertTrue(errorMessage, "Reset Link button is not disabled");
		logger.info("Verify Reset link button");

	}

	@Test(priority = 2)
	public void enterInvalidEmail() {
		loginPage.enterEmail("invalid@gmail.com");
		testStepsLog("steps" + stepCount++, "Enter invalid email");
		forgotPasswordPage.clickOnResetLink();
		logger.info("click on reset link");
		testStepsLog("Verification", " Verify error message.");
		logger.info("verify error message");

	}
}
