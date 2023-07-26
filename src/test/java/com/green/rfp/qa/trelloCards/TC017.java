package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC017 extends BaseClass {

	@Test
	public void checkProfileUpdateMessage() {

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on administration menu");
		jsClick(driver.findElement(By.xpath("//span[contains(text(),'Administration')]")));
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Scroll to edit company profile button");
		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Edit Company Profile')]")));
		testStepsLog("Step " + (stepCount++), " Click edit company profile button");
		jsClick(driver.findElement(By.xpath("//button[contains(text(),'Edit Company Profile')]")));

		WebElement alternatePhNumber = driver
				.findElement(By.xpath("//input[@ng-model='vm.account_details.alternate_phone_no']"));
		testStepsLog("Step " + (stepCount++), " Scroll to edit alternate phone number field");
		scrollToElement(alternatePhNumber);
		testStepsLog("Step " + (stepCount++), "Edit the phone number");
		alternatePhNumber.clear();
		alternatePhNumber.sendKeys("122434");
		testStepsLog("Step " + (stepCount++), "Click on save button");
		jsClick(driver.findElement(By.xpath("//button[text()='SAVE']")));

		testStepsLog("Step " + (stepCount++), " Verify success message showing correctly");
		try {
			PresenceOfElement(By.xpath("//span[contains(text(),' Account information edited successfully')]"));
			testVerifyLog("Success message showing CORRECTLY");
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
