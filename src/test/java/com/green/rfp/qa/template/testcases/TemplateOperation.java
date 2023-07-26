package com.green.rfp.qa.template.testcases;

import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class TemplateOperation extends BaseClass {
	
	TestUtil testutil = new TestUtil();
	
	String templateName = "DemoTemplate" + getCurrentTimeStampString();
	int numOfFailure = 0;
	
	@Test(priority=1)
	public void createDuplicateTemplate()
	{
		superAdminloginValid();
		loginAsFor("Customer Admin");
		
		testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		logger.info("Clicked on Template link");
		
		testStepsLog("Step " + (stepCount++)," Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create Button");
		
		System.out.println(templateName);
		testStepsLog("Step " + (stepCount++)," Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);
		logger.info("Entered template name");
        
		testStepsLog("Step " + (stepCount++)," Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");
		logger.info("Enter Section name");
		
		testStepsLog("Step " + (stepCount++)," Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
		logger.info("Clicked on Plus Button");
		
		testStepsLog("Step " + (stepCount++)," Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Objectives");
		logger.info("Enter Section name");
		
		testStepsLog("Step " + (stepCount++)," Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();
		logger.info("Clicked on Plus Button");
		
		testStepsLog("Step " + (stepCount++)," Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");
		logger.info("Clicked on Continue Button");
		
		testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		logger.info("Clicked on Template link");
		
		testStepsLog("Step " + (stepCount++)," Select Template checkbox="+templateName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(templateName);
		logger.info("Select template");
		
		testStepsLog("Step " + (stepCount++)," Click on duplicate icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Duplicate");
	    logger.info("Clicked on Duplicate icon");
	    
		testStepsLog("Step " + (stepCount++)," Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
	    logger.info("Clicked on Yes button");
	    
	    testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
		logger.info("clicked on template link");
	}
	
	@Test(priority=2)
	public void downloadTemplate()
	{
		
		 testStepsLog("Step " + (stepCount++)," Click on Template link.");
			dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
			logger.info("clicked on template link");
			
			testStepsLog("Step " + (stepCount++)," Select Template checkbox="+templateName);
			rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(templateName);
			logger.info("Select template");
			
			testStepsLog("Step " + (stepCount++)," Click on download icon from header");
			rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Download");
		    logger.info("Clicked on Download icon");
		
		testStepsLog("Verification"," Verify downloaded PDF is opened in a new tab.");
	    Boolean reportIsGenerated = rfpVerificationPage.verifyPDFDownloaded("https://"+env+".thegreenrfp.com/upload/Templates/"+templateName+".pdf");
				
	}
	
	@Test(priority=3)
	public void sendTemplateOnEmail()
	{
		
		String sendEmail ="test"+getCurrentTimeStampString("dd");
		 testStepsLog("Step " + (stepCount++)," Click on Template link.");
			dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();
			logger.info("clicked on template link");
			
			testStepsLog("Step " + (stepCount++)," Select Template checkbox="+templateName);
			rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(templateName);
			logger.info("Select template");
			
			testStepsLog("Step " + (stepCount++)," Click on Send as icon from header");
			rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("SendAsEmail");
		    logger.info("Clicked on send as Email icon");
		    
		    // Enter invalid format email
		    
		    testStepsLog("Step " + (stepCount++)," Enter invalid format of email ");
			templateVerificationPage = templateIndexPage.sendAsEmail("sendasemail");
		    logger.info("Clicked on send as Email icon");
		    
		    testStepsLog("Step " + (stepCount++)," Click on plus icon");
			templateVerificationPage = templateIndexPage.clickOnPlusButtonInSendasEmail();
		    logger.info("Clicked on plus button");
		    
		    testStepsLog("Step " + (stepCount++)," Click on send as email icon from header");
			templateVerificationPage = templateIndexPage.sendAsEmail(sendEmail+"@mailinator.com");
		    logger.info("Clicked on send as Email icon");
		    
		    testStepsLog("Step " + (stepCount++)," Click on plus icon");
			templateVerificationPage = templateIndexPage.clickOnPlusButtonInSendasEmail();
		    logger.info("Clicked on plus button");
		    
		    testStepsLog("Step " + (stepCount++)," Click on send button");
			templateVerificationPage = templateIndexPage.clickOnSendButtonInSendasEmail();
		    logger.info("Clicked on send button");
		    pause(6);
		    driver.get(inboxLink+sendEmail+"#/#inboxpane");
		    
		    testStepsLog("Step " + (stepCount++)," Click on Email");
			templateVerificationPage = templateIndexPage.clickOnMail();
		    logger.info("Clicked on send button"); 
		    pause(10);
			
			
	}

	@Test(priority = 4)
	public void deleteTemplate() {	
		driver.get(baseURl);
		pause(3);
		testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();  
		logger.info("Clicked on template link");
		
		testStepsLog("Step " + (stepCount++)," Select Template checkbox="+templateName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox(templateName);
	    logger.info("Select Template for Deleting");
	    
		testStepsLog("Step " + (stepCount++)," Click on delete icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Delete");
	    logger.info("Clicked on Delete");
	    
		testStepsLog("Step " + (stepCount++)," Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
	    logger.info("Clicked on Yes button");
	    // Delete Duplicate Template
	    driver.navigate().refresh();
	    pause(3);
	    testStepsLog("Step " + (stepCount++)," Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink(); 
		logger.info("Clicked on Template link");
		
	    testStepsLog("Step " + (stepCount++)," Select Template checkbox="+templateName);
		rfpVerificationPage = rfpIndexPage.selectRFPCheckbox("<Duplicate Template>");
	    logger.info("Select Template for Deleting");
	    
		testStepsLog("Step " + (stepCount++)," Click on delete icon from header");
		rfpVerificationPage = rfpIndexPage.selectActionsFromHeader("Delete");
	    logger.info("Clicked on Delete");
	    
		testStepsLog("Step " + (stepCount++)," Click on yes button.");
		rfpVerificationPage = rfpIndexPage.clickOnYesButton();
	    logger.info("Clicked on Yes button");
	    	   
	}

}
