package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC015 extends BaseClass {

	@Test
	public void verifyTimeZoneChanged() {

		String rfpName = getCurrentTimeStampString();

		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");
		superAdminloginValid();
		logger.info("Login Successfully");

		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		// rfpVerificationPage = rfpIndexPage.selectRFPType(stepCount,"KIS");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on Summary tab");
		jsClick(driver.findElement(By.xpath("//md-step-label-wrapper[text()='Summary']")));
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Scroll to the select timezone dropdown");
		scrollToElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']")));
		pause(3);
		testStepsLog("Step " + (stepCount++), "Select different timezone");
		jsClick(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']")));
		WebElement easternStandardTimeZone;

		try {
			PresenceOfElement(By.xpath("//div[contains(text(),'Eastern Daylight Time')]"));

			easternStandardTimeZone = driver.findElement(By.xpath("//div[contains(text(),'Eastern Daylight Time')]"));
		} catch (Exception e) {
			PresenceOfElement(By.xpath("//div[contains(text(),'Eastern Standard Time')]"));

			easternStandardTimeZone = driver.findElement(By.xpath("// md-option/div[contains(text(),'Eastern Standard Time') ]"));
		}

		String selectedTimezone = easternStandardTimeZone.getText();
		pause(3);
		clickableElement(easternStandardTimeZone);
		jsClick(easternStandardTimeZone);

		testStepsLog("Step " + (stepCount++), "Click on save' button");
		scrollToElement(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		jsClick(driver.findElement(By.xpath("//button[@ng-click='vm.updateRfp(false)']")));
		pause(3);

		testStepsLog("Step " + (stepCount++), "Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		pause(3);
		scrollToElement(driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']//span//div")));
		String presentTomezone = driver.findElement(By.xpath("//md-select[@ng-model='vm.rfp_timezone']//span//div"))
				.getText();
		System.out.println("qqqqq : " + presentTomezone);

		testStepsLog("Step " + (stepCount++), "verify that timezone is changed");
		pause(3);
		Assert.assertEquals(selectedTimezone, presentTomezone);
		testVerifyLog("Timezone changed verified");

	}

}
