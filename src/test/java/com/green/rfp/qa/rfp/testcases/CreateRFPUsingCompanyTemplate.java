package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;
import com.green.rfp.qa.utility.XLUtils;

public class CreateRFPUsingCompanyTemplate extends BaseClass {

	TestUtil testutil = new TestUtil();
	XLUtils excel;
	int numOfFailure = 0;

	@Test(priority = 2)
	public void createRFPUsingCompanyTemplate() {
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		loginAsFor("Customer RFP owner 1");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Click on RFP");
		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "CompanyTemplate");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is disable.");
		logger.info("RFP type selected");

		String templateName = getCurrentTimeStampString();
		String TemplateName = templateName;
		System.out.println("-----comonTemplateName--****--" + TemplateName);
		testStepsLog("Step " + (stepCount++), " Use KIS template.");
		rfpVerificationPage = rfpIndexPage.useCreatedTemplateKIS();
		logger.info("Use Kis Template");
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++), " Fill RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "KIS", rfpName);
		logger.info("Fill Rfp");
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount, "CompanyTemplate", rfpName, "DetailedPricing");
		logger.info("Create RFP ");
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Clicked on RFP left link");
	}

}
