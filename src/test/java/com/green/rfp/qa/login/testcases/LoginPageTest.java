package com.green.rfp.qa.login.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.XLUtils;

public class LoginPageTest extends BaseClass {
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
		System.out.println("validUsername :-" + validUsername);
		waitForPageLoaded();

		pause(5);
		String title = loginPage.varifyPageTitle();
		Assert.assertEquals(title, exceptedTitle, "Home Page Title is not Matched");

		logger.info("Login test passed");

	}

	@Test(priority = 2)
	public void loginWithoutEnteringPassword() throws IOException {
		testStepsLog("Step " + (stepCount++),
				"Perform login without entering password and Verify Log In Button is Disabled");
		driver.get(con.getUrl());
		waitForPageLoaded();
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
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

	@Test(priority = 3)
	public void verifyDisableLoginButtonColor() {
		testStepsLog("Verification", " Verify button of color of Log in button when it in diseable state");
		pause(2);
		String actualColor = loginPage.verifyColorOfLogInButton();
		logger.info("Capture Login button Color");
		if (actualColor.equals(diasableActualColor)) {
			Assert.assertTrue(true);
			logger.info("Log in Button is in diseable state and color is also matched");
		} else {
			Assert.assertTrue(false);
			logger.info("Log in Button is in diseable state and color is not matched");
		}
	}

	@Test(priority = 4)
	public void verifyenbleLoginButtonColor() {
		testStepsLog("Verification", " Verify button of color of Log in button when it in enable state");
		pause(2);
		loginPage.enterPassword(correcrPassword);

		pause(2);
		String actualColor = loginPage.verifyColorOfLogInButton();
		logger.info("Capture Login button Color");
		System.out.println(actualColor);
		if (actualColor.equals(enableActualColor)) {
			Assert.assertTrue(true);
			logger.info("Log in Button is in enable state and color is also matched");
		} else {
			Assert.assertTrue(false);
			logger.info("Log in Button is in enable state and color is not matched");
		}
	}

	@Test(priority = 5)
	public void loginByEnteringInvalidUserId() {
		testStepsLog("Step " + (stepCount++), " Perform login with invalid ID and Verify error message.");
		loginPage.enterEmail(invalidUsername);
		logger.info("Entered invalid user id");
		loginPage.enterPassword(correcrPassword);
		logger.info("Entered Valid Password");
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		boolean errorMessage = loginPage.verifyErrorMessage("No User Found.");
		Assert.assertTrue(errorMessage, "Error message not displayed");
	}

	@Test(priority = 6)
	public void loginByEnteringInvalidPassword() {
		testStepsLog("Step " + (stepCount++), " Perform login with invalid password and Verify error message.");
		loginPage.enterEmail(validUsername);
		testStepsLog("Step " + (stepCount++), "Entered valid user id : " + validUsername);
		loginPage.enterPassword(incorrectPassword);
		testStepsLog("Step " + (stepCount++), "Entered invalid Password : " + incorrectPassword);
		loginPage.clickOnLogin();
		testStepsLog("Step " + (stepCount++), "Click on Login");
		pause(2);
		String errMsg = null;
		try {
			errMsg = driver.findElement(By.xpath("//md-toast//span")).getText();
		} catch (Exception e) {

		}
		boolean errorMessage = errMsg.equalsIgnoreCase("Credentials do not match.");
		System.out.println("status: " + errorMessage);
		Assert.assertTrue(errorMessage, "Credentials do not match.");

	}

	@Test(priority = 7, alwaysRun = true)
	public void loginByWithoutEnteringPassword() {
		testStepsLog("Step " + (stepCount++), " Perform login by entering blank password and Verify error message.");
		loginPage.enterEmail(validUsername);
		logger.info("Entered Valid User name");
		loginPage.enterPassword(" ");
		logger.info("Entered Blank Password");
	}

	@Test(priority = 8, alwaysRun = true)
	public void validLogin() throws IOException {
		testStepsLog("Step " + (stepCount++), " Perform login using valid Input.");
		pause(2);
		driver.get(baseURl);
		pause(4);
		loginPage.enterEmail(userName);
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword(passWord);
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
	}

}
