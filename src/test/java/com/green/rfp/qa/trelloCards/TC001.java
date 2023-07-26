package com.green.rfp.qa.trelloCards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
public class TC001 extends BaseClass {
	
	
	
	@Test
	public void DateTimeOfTheReportRequestAreNotAccurate() {
		
		testInfoLog("Requirement changed,Report generation time from dashboard Completed task has been removed. ");
		
//		String rfpName =con.getReportRFP(env);
//		testStepsLog("Step " + (stepCount++), " Login as customer admin");
//		superAdminloginValid();
//		loginAsFor("Customer Admin");
//		waitForPageLoaded();
//		
//		testStepsLog("Step " + (stepCount++), " Click on report from left menu");
//		WebElement reportMenu= driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Reports']"));
//		jsClick( reportMenu);
//		pause(5);
//		testStepsLog("Step " + (stepCount++), " search and select the rfp");
//		templateIndexPage.searchSelectTemplate(rfpName);
//		testStepsLog("Step " + (stepCount++), " Click on download report tab");
//		WebElement downloadReportTab= driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
//		jsClick( downloadReportTab);
//		testStepsLog("Step " + (stepCount++), " Select CheckBox summary details");
//		WebElement SummaryDetailsCheckbox= driver.findElement(By.xpath("(//div[@class='p-16']//div[@class='md-icon'])[1]"));
//		jsClick( SummaryDetailsCheckbox);
//		testStepsLog("Step " + (stepCount++), "Click on Generate Report button");
//		WebElement generateReportButton= driver.findElement(By.xpath("//button[contains(text(),'Generate Report')]"));
//		scrollToElementTillTrue( generateReportButton);
//		jsClick( generateReportButton);
//		pause(3);
//		testStepsLog("Step " + (stepCount++), "Verify the generated report status showing pending");
//		WebElement generatedReportStatus= driver.findElement(By.xpath("//table[@class='dataTable pd-8 no-footer row-border']/tbody/tr[1]//span[@class='pl-40']"));
//		scrollToElementTillTrue( generatedReportStatus);
//		Assert.assertEquals("Pending", generatedReportStatus.getText());
//		
//		testStepsLog("Step " + (stepCount++), "click on dashboard from left menu");
//		WebElement DashboardMenu= driver.findElement(By.xpath("//div[@ng-if='!vm.isHidden()']//span[text()='Dashboard']"));
//		jsClick( DashboardMenu);
//		testStepsLog("Step " + (stepCount++), "scroll to COMPLETED RFP'S/BIDS section");
//		scrollToElementTillTrue( driver.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]")));
//		pause(3);
//		testStepsLog("Step " + (stepCount++), "search the rfp");
//		WebElement searchCompletedRfpIcon = driver.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]//md-icon[@aria-label='icon-magnify']"));
//		searchCompletedRfpIcon.click();
//		WebElement CompletedRfpIconSearchField = driver.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]//input"));
//		CompletedRfpIconSearchField.sendKeys(rfpName);
//		pause(5);
//		testStepsLog("Step " + (stepCount++), "Click on the searched rfp");
//		String lastGeneratedAtTime = driver.findElement(By.xpath("(//ms-widget[contains(@ng-if,'completed_rfp_permission')]//td[@class='ng-binding'])[2]")).getText();
//		WebElement searchedRfpname = driver.findElement(By.xpath("//ms-widget[contains(@ng-if,'completed_rfp_permission')]//a"));
//		jsClick( searchedRfpname);
//		pause(5);
//		driver.navigate().refresh();
//		waitForPageLoaded();
//		testStepsLog("Step " + (stepCount++), "Click on download report tab");
//		WebElement downloadReportTab2= driver.findElement(By.xpath("//md-tab-item[text()='Download Report']"));
//		downloadReportTab2.click();
//		testStepsLog("Step " + (stepCount++), "Verify dashboard report generate showing time matches with current report generate time");
//		scrollToElementTillTrue( driver.findElement(By.xpath("//tr[@ng-repeat='item in vm.generated_reports']")));
//		WebElement generatedReportTime = driver.findElement(By.xpath("//tr[@ng-repeat='item in vm.generated_reports'][1]//td[3]"));
//		Assert.assertEquals(lastGeneratedAtTime, generatedReportTime.getText());
	}

}