package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC024 extends BaseClass {

	@Test
	public void verifyVendorUserTabDisabled() {

		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
		superAdminloginValid();
		loginAsFor("Vendor2");

		testStepsLog("Step " + (stepCount++), " Click on administration");
		dashboardIndexPage.clickOnLeftMenu("Administration");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Verify there is no user tab under administration");

		try {
			pause(5);
			PresenceOfElement(By.xpath("//md-tab-item[text()='USERS']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified there is no user tab under administration");
		}

	}

}
