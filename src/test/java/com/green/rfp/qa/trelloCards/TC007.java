package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;

public class TC007 extends BaseClass {
	

	
	@Test(priority=1)
	public void unableToDownloadReporrCircleJustSpins() {
		
		String rfpName =con.getReportRFP(env);
		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		
		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
		WebElement reportMenu= driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Reports']"));
		jsClick( reportMenu);
		waitFor2mins.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"templates-list\"]//md-card")));

		testStepsLog("Step " + (stepCount++), " search and select the rfp");
		templateIndexPage.searchSelectTemplate(rfpName);
		testStepsLog("Step " + (stepCount++), " Click on download report tab");
		WebElement downloadReportTab= driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
		jsClick( downloadReportTab);
		testStepsLog("Step " + (stepCount++), " Select CheckBox summary details");
		WebElement SummaryDetailsCheckbox= driver.findElement(By.xpath("(//div[@class='p-16']//div[@class='md-icon'])[1]"));
		jsClick( SummaryDetailsCheckbox);
		testStepsLog("Step " + (stepCount++), "Click on Generate Report button");
		WebElement generateReportButton= driver.findElement(By.xpath("//button[contains(text(),'Generate Report')]"));
		scrollToElementTillTrue(generateReportButton);
		jsClick(generateReportButton);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Verify the generated report status showing pending");
		WebElement generatedReportStatus= driver.findElement(By.xpath("//table[@class='dataTable pd-8 no-footer row-border']/tbody/tr[1]//span[@class='pl-40']"));
		scrollToElementTillTrue( generatedReportStatus);
		Assert.assertEquals("Pending", generatedReportStatus.getText());
		
		testStepsLog("Step " + (stepCount++), "click on dashboard from left menu");
		WebElement DashboardMenu= driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Dashboard']"));
		jsClick( DashboardMenu);
		rfpIndexPage.waitForDashboardToBeReady();
		testStepsLog("Step " + (stepCount++), "Scroll to Completed task list");
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'Completed RFP')]")));
		pause(5);
		testStepsLog("Step " + (stepCount++), "Search the rfp");
		rfpVerificationPage = rfpIndexPage.searchRfpFromDashboardTaskList("Completed RFP",rfpName);
		testStepsLog("Step " + (stepCount++), "click on rfp name");
		WebElement searchedRfpName= driver.findElement(By.xpath("//tr[contains( normalize-space(),'"+rfpName+"')]//a"));
		jsClick( searchedRfpName);		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on download report tab");
		WebElement downloadReportTab2= driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
		jsClick( downloadReportTab2);
		testStepsLog("Step " + (stepCount++), " Scroll to the download icon");
		WebElement reportDownloadIcon= driver.findElement(By.xpath("//button[contains(@ng-click,'downloadGeneratedReport')]//md-icon[@aria-label='icon-download']"));
		scrollToElement(reportDownloadIcon);
		testStepsLog("Step " + (stepCount++), "click on download icon");
		jsClick( reportDownloadIcon);
		testInfoLog(" Verify downloaded PDF is opened in a new tab.");

		String RFPname = rfpName.replace(" ", "-");
		rfpVerificationPage.verifyPDFDownloaded("https://"+env+".thegreenrfp.com/upload/Reports/"+RFPname+".pdf");
		testVerifyLog( " Verified - PDF downloaded  is opened in a new tab.");

	}

}