package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC013 extends BaseClass {

	@Test
	public void checkRfpFirstPageLoadingTime() {

		String rfpName = getCurrentTimeStampString();
		String typeOfRFP = "Scratch";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		PresenceOfElement(By.xpath("//input[@ng-model='vm.name']"));
		driver.findElement(By.xpath("//input[@ng-model='vm.name']")).clear();
		globalMap.put("vendorRFPName", rfpName);
		rfpIndexPage.enterRFAData(rfpName, "Description of " + rfpName, "123456", typeOfRFP);

		testStepsLog("Step " + (stepCount++), "Click on save' button");
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		pause(5);

		testStepsLog("Step " + (stepCount++), "Click on 'Continue' button");
		stepCount++;
		rfpIndexPage.clickOnContinueButton("Rfp");
		testStepsLog("Step " + (stepCount++), "Check page redirected to sections tab");
		PresenceOfElement(By.xpath("//div[contains(text(),'Define Your Content Sections')]"));
		testVerifyLog("first time save button loading time checked");

	}

}
