package com.green.rfp.qa.bugs.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class EditUserAndVerifyAccount extends BaseClass {
	

	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String userFirstname=randomStringGenerate();
	String userLastname=randomStringGenerate();
	String editEmailId="change"+randomeNum()+"@mailinator.com";

	
	Logger Log = Logger.getLogger(EditUserAndVerifyAccount.class);

	
	@Test(priority=2)
	public void editUserAndVerityItsAccount()
	{
		superAdminloginValid();

		loginAsFor("Customer Admin");
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration link");
		testStepsLog("Step " + (stepCount++)," Click on 'Users' tab.");		
		adminstrationPage.clickOnUsersTab();
		logger.info("Click on 'Users' tab");
		testStepsLog("Step " + (stepCount++)," Click on 'Create' button.");
		adminstrationPage.clickOnCreatebtn();
		logger.info("Click on Create button");
		testStepsLog("Step " + (stepCount++)," Enter user details.");
		adminstrationPage.enterUserdetails(userFirstname,userLastname,(userFirstname+"@mailinator.com"),"RFP Owner","title");
		logger.info("Enter User Details");
		driver.navigate().refresh();
		testStepsLog("Step " + (stepCount++)," Click on 'Users' tab.");		
		adminstrationPage.clickOnUsersTab();
		logger.info("Click on 'Users' tab");
		pause(5);
		testStepsLog("Verification"," Verify created user details displayed successfully or not.");
		pause(2);
		boolean userDetails =adminstrationPage.verifyUser(userFirstname,userLastname,userFirstname+"@mailinator.com","RFP Owner");
		Assert.assertTrue(userDetails, "Created user details is not displayed.");
		logger.info("Created user details is displayed");
		testStepsLog("Step " + (stepCount++)," Account text is");	
	    adminstrationPage.userAccountText(userFirstname, getCompanyName("Customer Admin"));
		
	    testStepsLog("Step " + (stepCount++)," Click on close remote button.");
		templateVerificationPage = templateIndexPage.clickOnCloseRemoteButton();
		logger.info("Clicked on Close Button");
		testStepsLog("Step " + (stepCount++)," Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		logger.info("Clicked on Yes Buuton");
		
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration link");
		testStepsLog("Step " + (stepCount++)," Click on 'Users' tab.");		
		adminstrationPage.clickOnUsersTab();
		logger.info("Click on 'Users' tab");
		pause(8);
		testStepsLog("Step " + (stepCount++)," Click Search Icon");	
		adminstrationPage.clickOnSearchIcon();
		logger.info("Clicked on Search icon ");
		
		testStepsLog("Step " + (stepCount++)," Enter Input For search");	
		adminstrationPage.searchUser(userFirstname);
		logger.info("Enter User for Search ");
		
		testStepsLog("Step " + (stepCount++)," Click on 3 dots at users name.");
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
		boolean editandDeleteButton = adminstrationPage.verifySearchEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		Assert.assertTrue(editandDeleteButton, "Edit and delete button not present.");
		
		testStepsLog("Step " + (stepCount++)," Click on Edit tab.");
		 adminstrationPage.clickOnSearchEditTab();
		 logger.info("Click on Edit button");
		
		testStepsLog("Step " + (stepCount++)," Change Name and click on Save Button");
		//String editName=randomStringGenerate();
		adminstrationPage.editFirstName(userFirstname);
		log("Changed Name :-"+userFirstname);
		
		testStepsLog("Verification"," Verify user account ");
		Boolean userAccount = adminstrationPage.verifyUserAccountText(userFirstname, getCompanyName("Customer Admin"));
		Assert.assertTrue(userAccount, "User account not same");
		
		testStepsLog("Step " + (stepCount++)," Click on 3 dots at users name.");
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
		 editandDeleteButton = adminstrationPage.verifySearchEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		Assert.assertTrue(editandDeleteButton, "Edit and delete button not present.");
		
		testStepsLog("Step " + (stepCount++)," Click on DELETE tab.");
		adminstrationPage.clickSearchDeletetab();
		logger.info("Click on Delete tab");
		testStepsLog("Step " + (stepCount++)," Click on YES button of alert box.");
		alertHelper.isAlertPresent();
		adminstrationPage.clickYesButtonOfAlert();
		logger.info("Click on yes");
		testStepsLog("Verification"," Verify Edited user details are Removed successfully or not.");
		boolean Flag1 = adminstrationPage.verifyEditUser(userFirstname,userLastname,editEmailId,"RFP Owner");
		Assert.assertTrue(Flag1, "Edited user details are not Removed.");
		System.out.println("flag value"+Flag1);
		logger.info("Select association user");
		testStepsLog("Step " + (stepCount++)," Click on user association.");
		adminstrationPage.clickOnUseAssocialtion();
		logger.info("Select Associated User");
		testStepsLog("Step " + (stepCount++)," Click on Assign Button");
		adminstrationPage.clickOnAssign();
		logger.info("Click on Assign");
		testStepsLog("Step " + (stepCount++)," Click on YES button of alert box.");
		adminstrationPage.clickYesButtonOfAlert();
		logger.info("click on Yes");
		pause(2);
		testStepsLog("Verification"," Verify validation message");
		boolean errorMessage = adminstrationPage.verifyErrorMessage("The record has been deleted successfully.");
		Assert.assertTrue(errorMessage, "Error message not displayed");
		logger.info("Delete User");
	}
	
	@Test(priority=3)
	public void done()
	{
		System.out.println("Done Change User account");
	}
}
