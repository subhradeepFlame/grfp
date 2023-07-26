package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC023 extends BaseClass {

	@Test
	public void summaryOnPricingTab() {

		String rfpName = con.getReportRFP(env);

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
		WebElement reportMenu = driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Reports']"));
		jsClick(reportMenu);
		pause(5);
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on pricing");
		jsClick(driver.findElement(By.xpath("//md-tab-item[text()='Pricing']")));

		testStepsLog("Step " + (stepCount++), "Check PRICE CHANGE SUMMARY tab name");
		String priceChangeSumaaryName = driver.findElement(By.xpath("//md-tab-item[text()='Price Change Summary']"))
				.getText();
		testStepsLog("Step " + (stepCount++), "Verify PRICE CHANGE SUMMARY tab name");
		Assert.assertEquals("PRICE CHANGE SUMMARY", priceChangeSumaaryName);
		testVerifyLog("Verified PRICE CHANGE SUMMARY tab name");
	}

}