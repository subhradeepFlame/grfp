package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC003 extends BaseClass {

	@Test(priority = 1)
	public void timeShouldBeIn12HrsFormatInSummurryandReport() {

		String rfpName = "QA Report RFP";
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on rfp link from left menu");
		dashboardIndexPage.clickOnLeftMenu("Reports");
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);

		WebElement questionCutOffTimeSummary = driver
				.findElement(By.xpath("//*[@ng-model='vm.question_cut_off_time']//span//div"));
		testStepsLog("Step " + (stepCount++), "Verify Question cut off date format is in AM/PM in summary tab");
		System.out.println("test time: " + questionCutOffTimeSummary.getAttribute("value"));
		WebElement summaryDetailstab = driver
				.findElement(By.xpath("//md-tab-item[normalize-space()='Summary Details']"));
		jsClick(summaryDetailstab);
		WebElement datesSubTab = driver.findElement(By.xpath("//md-tab-item[normalize-space()='Dates']"));
		jsClick(datesSubTab);

		testStepsLog("Step " + (stepCount++), "Click on the last look tab");
		WebElement LastLookTab = driver.findElement(By.xpath("//md-step-label-wrapper[@class='Last Look']"));
		jsClick(LastLookTab);
		WebElement questionCutOffTimeLastLook = driver.findElement(By.xpath("//div[@class='generated-pdf']//p[4]"));
		System.out.println("test time: " + questionCutOffTimeLastLook.getText());
		Assert.assertTrue((questionCutOffTimeLastLook.getText().contains("AM"))
				|| (questionCutOffTimeLastLook.getText().contains("PM")));
		testVerifyLog("Verified Question cut off date format is in AM/PM in Last Look page");

		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
		WebElement reportMenu = driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Reports']"));
		jsClick(reportMenu);
		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on download report tab");
		WebElement downloadReportTab = driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
		jsClick(downloadReportTab);
		testStepsLog("Step " + (stepCount++), " Select CheckBox summary details");
		WebElement SummaryDetailsCheckbox = driver
				.findElement(By.xpath("(//div[@class='p-16']//div[@class='md-icon'])[1]"));
		jsClick(SummaryDetailsCheckbox);
		testStepsLog("Step " + (stepCount++), "Click on Generate Report button");
		WebElement generateReportButton = driver.findElement(By.xpath("//button[contains(text(),'Generate Report')]"));
		scrollToElementTillTrue(generateReportButton);
		jsClick(generateReportButton);
		pause(3);

		testStepsLog("Step " + (stepCount++), "click on dashboard from left menu");
		WebElement DashboardMenu = driver
				.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Dashboard']"));
		jsClick(DashboardMenu);
		testStepsLog("Step " + (stepCount++), "scroll to COMPLETED RFP'S/BIDS section");
		scrollToElementTillTrue(
				driver.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]")));
		pause(3);
		testStepsLog("Step " + (stepCount++), "search the rfp");
		WebElement searchCompletedRfpIcon = driver.findElement(By.xpath(
				"//ms-widget[contains(@ng-if,'completed_rfp_permission')]//md-icon[@aria-label='icon-magnify']"));
		searchCompletedRfpIcon.click();
		WebElement CompletedRfpIconSearchField = driver
				.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]//input"));
		CompletedRfpIconSearchField.sendKeys(rfpName);
		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on the searched rfp");
		WebElement searchedRfpname = driver
				.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]//a"));
		jsClick(searchedRfpname);
		pause(5);
		driver.navigate().refresh();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Click on download report tab");
		WebElement downloadReportTab2 = driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
		downloadReportTab2.click();
		testStepsLog("Step " + (stepCount++), "Click on the report download icon ");
		scrollToElementTillTrue(driver.findElement(By.xpath("//tr[@ng-repeat='item in vm.generated_reports']")));
		WebElement ReportDownloadiCON = driver
				.findElement(By.xpath("//tr[@ng-repeat='item in vm.generated_reports'][1]//md-icon"));
		jsClick(ReportDownloadiCON);

	}

}
