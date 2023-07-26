package com.green.rfp.qa.trelloCards;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TC020 extends BaseClass{
	
	@Test
	public void checkTemplateSmeAdd() {
		
		String templateName = "DemoTemplate" + getCurrentTimeStampString();
		
		superAdminloginValid();
		loginAsFor("Customer Admin");
		testStepsLog("Verification"," Verify Dashboard sidenavigation of CAdmin.");
		boolean isSidenavigation = templateVerificationPage.verifySidenavigation();
		Assert.assertTrue(isSidenavigation, "Side navigation verification failed");
		// Verification of dashboard page
		testStepsLog("Verification"," Verify Dashboard page.");
		Boolean isDashboardPageVerified = dashboardVerificationPage.verifyDashboardPage("CustomerAdmin");
		System.out.println("Dsshboard" + isDashboardPageVerified);
		Assert.assertTrue(isDashboardPageVerified, "Dashboard page is not verified.");
    
		testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
        
		testStepsLog("Step " + (stepCount++)," Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();
		
		System.out.println(templateName);
		testStepsLog("Step " + (stepCount++)," Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);
     
		testStepsLog("Step " + (stepCount++)," Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();
        
		testStepsLog("Step " + (stepCount++)," Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");
        
		testStepsLog("Step " + (stepCount++)," Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
        
		testStepsLog("Step " + (stepCount++)," Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Objectives");
       
		testStepsLog("Step " + (stepCount++)," Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
		
		testStepsLog("Step " + (stepCount++)," Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");
		
		testStepsLog("Step " + (stepCount++) ," Enter SME as qanarolasme1@mailinator.com for Add Question permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Introduction", "qanarolasme1@mailinator.com ",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++),"Enter SME as qanarolasme2@mailinator.com for Edit Section Description.");
		templateVerificationPage = templateIndexPage.enterSMENew("Introduction", "qanarolasme2@mailinator.com ",
				"Edit Section Description", 2);

		testStepsLog("Step " + (stepCount++) ,"Enter SME as qanarolasme1@mailinator.com for Add Questions permission.");
		templateVerificationPage = templateIndexPage.enterSMENew("Objectives", "qanarolasme1@mailinator.com",
				"Add Questions", 1);

		testStepsLog("Step " + (stepCount++)," Enter SME as qanarolasme2@mailinator.com for 'Both' Description.");
		templateVerificationPage = templateIndexPage.enterSMENew("Objectives", "qanarolasme2@mailinator.com", "Both",
				2);

		testStepsLog("Step " + (stepCount++)," Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++)," Click on help my sme button.");
		templateVerificationPage = templateIndexPage.clickOnHelpMySmes();

		testStepsLog("Step " + (stepCount++)," Click on smes bubble.");
		templateVerificationPage = templateIndexPage.clickOnSmesBubble();

		testStepsLog("Verification"," Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible = templateVerificationPage.verifyEmailIconForSME("Introduction", 1);
		Assert.assertTrue(orangeEmailIconVisible, "Orange email icon is not visible.");

		testStepsLog("Verification"," Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible1 = templateVerificationPage.verifyEmailIconForSME("Introduction", 2);
		Assert.assertTrue(orangeEmailIconVisible1, "Orange email icon is not visible.");

		testStepsLog("Verification"," Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible2 = templateVerificationPage.verifyEmailIconForSME("Objectives", 1);
		Assert.assertTrue(orangeEmailIconVisible2, "Orange email icon is not visible.");

		testStepsLog("Verification"," Verify Orange email icon for SME.");
		Boolean orangeEmailIconVisible3 = templateVerificationPage.verifyEmailIconForSME("Objectives", 2);
		Assert.assertTrue(orangeEmailIconVisible3, "Orange email icon is not visible.");

		
	}

}
