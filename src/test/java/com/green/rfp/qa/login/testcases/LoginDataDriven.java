package com.green.rfp.qa.login.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class LoginDataDriven extends BaseClass {

	public String exceptedTitle = "Green RFP";

	@Test(dataProvider = "getData")
	public void loginDataDrivenTest(String userNameForLogin, String passwordForLogin)

	{
		if (userNameForLogin != null || passwordForLogin != null) {
			driver.get(con.getUrl());
			waitForPageLoaded();
			testStepsLog("Steps " + stepCount++, "Enter user name");
			driver.findElement(By.name("email")).sendKeys(userNameForLogin);
			testStepsLog("Steps " + stepCount++, "Click on Arrow");
			driver.findElement(By.cssSelector("div#login-form>form>div>md-icon")).click();
			testStepsLog("Steps " + stepCount++, "Enter Password");
			loginPage.enterPassword(passwordForLogin);

			testStepsLog("Steps " + stepCount++, "Click on  Login");
			jsClick(driver.findElement(By.xpath("//button[@aria-label='LOG IN']")));
			testStepsLog("Steps " + stepCount++, "Logout");
			logOut();
			testStepsLog("", userNameForLogin + " / " + "Logged in successfully");

		} else
			testStepsLog("", "Data missing in  data file");

	}

	@DataProvider
	public Object[][] getData() {
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		Object[][] data = new Object[6][2];

		// 1st row
		data[0][0] = getEmail("Customer SME 1");
		data[0][1] = getPassword("Customer SME 1");

		// 2nd row
		data[1][0] = getEmail("Customer SME 2");
		data[1][1] = getPassword("Customer SME 2");

		// 3rd row
		data[2][0] = getEmail("Customer Approver 1");
		data[2][1] = getPassword("Customer Approver 1");

		// 4th row
		data[3][0] = getEmail("Customer Approver 3");
		data[3][1] = getPassword("Customer Approver 3");

		// 5th row
		data[4][0] = getEmail("Customer RFP owner 1");
		data[4][1] = getPassword("Customer RFP owner 1");

		// 6th row
		data[5][0] = getEmail("Customer RFP owner 2");
		data[5][1] = getPassword("Customer RFP owner 2");

		return data;
	}

}
