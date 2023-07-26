package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC009 extends BaseClass{

	@Test
	public void checkReportingSectionPdfPercentage() {
		String completedRfp="QA Report RFP";
		String nonCompletedRfp="QA NON REPORT RFP";
		
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		
		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
		WebElement reportMenu= driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Reports']"));
		jsClick( reportMenu);
		waitFor2mins.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"templates-list\"]//md-card")));

		testStepsLog("Step " + (stepCount++), " search a completed rfp");
		templateIndexPage.searchTemplate(completedRfp);
		
		testStepsLog("Step " + (stepCount++), "Verify completed rfp showing in report section");
		PresenceOfElement(By.xpath("//a[contains(text(),'"+completedRfp+"') and @aria-label='"+completedRfp+"']"));
		testVerifyLog("Complered rfp showing in report page verified");
		
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog("Step " + (stepCount++), " search a non-completed rfp");
		templateIndexPage.searchTemplate(nonCompletedRfp);
		testStepsLog("Step " + (stepCount++), "Verify No report found text showing");
		PresenceOfElement(By.xpath("//p[text()='No Reports Found']"));
		testVerifyLog("Non Completed rfp not showing in report page verified");
		
	}
	
}
