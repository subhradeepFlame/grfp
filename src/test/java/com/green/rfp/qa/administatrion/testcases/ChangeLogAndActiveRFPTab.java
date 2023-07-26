package com.green.rfp.qa.administatrion.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class ChangeLogAndActiveRFPTab extends BaseClass {

	@Test(priority=1)
	public void changeLogAndActiveRFPTab()
	{
		testStepsLog("Step " + (stepCount++)," Perform login");
		loginValid();
		
		testStepsLog("Step " + (stepCount++)," Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		
		testStepsLog("Step " + (stepCount++)," Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		
		testStepsLog("Step " + (stepCount++)," Select RFP Type to create.");
		//rfpVerificationPage = rfpIndexPage.selectRFPType(stepCount,"KIS");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount,"Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is disable.");
		
		String rfpName = getCurrentTimeStampString();
		testStepsLog("Step " + (stepCount++)," Fill RFP - Summary");
		//administrationVerificationPage = administrationIndexPage.fillRFPSummary(stepCount,"Scratch",rfpName);
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount,"Scratch",rfpName);
		
		/*testStepsLog("Step " + (stepCount++)," Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createRFPSections(stepCount,"Scratch",rfpName,"DetailedPricing");*/
		//Assert.assertTrue(isRFPCreatedSuccessfully, "RFP sections not created successfully.");
		
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();
		
		testStepsLog("Step " + (stepCount++)," Click on Active RFP tab.");
		 adminstrationPage.clickOnActiveRFPTab();
		 waitForPageLoaded();
		 pause(3);
		
		testStepsLog("Verification"," Verify Recent created RFP does show in Active RFP.");
		boolean flag =  adminstrationPage.verifyActiveRFP(rfpName);
		Assert.assertTrue(flag, "Created RFP doesnt show in Active RFP tab.");
		
		testStepsLog("Step " + (stepCount++)," Click on 'CHANGE LOG' tab.");
		 adminstrationPage.clickOnChangeLogTab();
		
		testStepsLog("Verification"," Verify In Change Log, Created RFP is displayed with 'Created' Label in green color.");
		boolean flag1 = adminstrationPage.verifyCreateLabel();
		Assert.assertTrue(flag1, "Created RFP is not displayed with 'Created' Label in green color.");
				
		testStepsLog("Step " + (stepCount++)," Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		
		testStepsLog("Step " + (stepCount++)," Select RFP="+rfpName);
		rfpVerificationPage = rfpIndexPage.selectRFP(rfpName);
		
		/*testStepsLog("Step " + (stepCount++)," Click on Section Bubble.");
		rfpVerificationPage = rfpIndexPage.clickOnSectionBubble();*/
		
		testStepsLog("Step " + (stepCount++)," Change Discription in RFP");
		adminstrationPage.changeValueInDiscription("Discription of change"+rfpName);
		
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();
		
		testStepsLog("Step " + (stepCount++)," Click on 'CHANGE LOG' tab.");
		adminstrationPage.clickOnChangeLogTab();
		
		testStepsLog("Verification"," Verify In Change Log, Update label shows in green.");
		boolean flag3 = adminstrationPage.verifyUpdateLabel();
		Assert.assertTrue(flag3, "Update label doesnt shows in green.");
		
		testStepsLog("Step " + (stepCount++)," Click on View Change icon at first row.");
		adminstrationPage.clickOnViewChangeIconAtFirstRow();
		
		testStepsLog("Verification"," Verify User is able to see updated changes in Change popup..");
		boolean flag2=adminstrationPage.verifyChangesInPopup("Discription of change"+rfpName);
		Assert.assertTrue(flag2, "Changes are not updated successfully in Changes pop-up.");
		
		testStepsLog("Step " + (stepCount++)," Click on Got It");
		adminstrationPage.clickOnGotIt();
		
		
		//===========================
		testStepsLog("Step " + (stepCount++)," User logged out");
		logOut();
	}
}
