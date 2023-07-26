package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TrelloTest extends BaseClass {

	@Test(priority = 1)
	public void handlepdf() {

		String rfpName = "QA Report RFP";
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on rfp link from left menu");
		dashboardIndexPage.clickOnLeftMenu("RFP");
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);

		WebElement questionCutOffTimeSummary = driver
				.findElement(By.xpath("//*[@ng-model='vm.question_cut_off_time']//span//div"));
		testStepsLog("Step " + (stepCount++), "Verify Question cut off date format is in AM/PM in summary tab");
		System.out.println("test time: " + questionCutOffTimeSummary.getText());
		Assert.assertTrue((questionCutOffTimeSummary.getText().contains("AM"))
				|| (questionCutOffTimeSummary.getText().contains("PM")));
		testVerifyLog("Verified Question cut off date format is in AM/PM in summary page");

	}

}