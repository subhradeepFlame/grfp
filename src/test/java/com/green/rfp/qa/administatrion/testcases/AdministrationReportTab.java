package com.green.rfp.qa.administatrion.testcases;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class AdministrationReportTab extends BaseClass {
	

	
	@Test(priority=1)
	public void verifyTaskCountInReportTab()
	{testStepsLog("Step " + (stepCount++)," Perform login");
	loginValid();
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration Link");
		
		testStepsLog("Step " + (stepCount++)," Click on Reports link.");
		adminstrationPage.clickOnReportsab();
		logger.info("Click on Report Link");
		
		testStepsLog("Step " + (stepCount++)," RFPs Report count.");
		adminstrationPage.rfpDetailsCount();
		logger.info("counted");
		
		
		testStepsLog("Step " + (stepCount++)," Templates Report count.");
		adminstrationPage.templateDetailsCount();
		logger.info("counted");
		
		
				testStepsLog("Step " + (stepCount++)," Tasks Report count.");
				adminstrationPage.tasksDetailsCount();
				logger.info("counted");
		
				testStepsLog("Step " + (stepCount++)," User logged out");
				logOut();
	}

}
