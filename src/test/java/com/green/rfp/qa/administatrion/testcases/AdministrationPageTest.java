package com.green.rfp.qa.administatrion.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class AdministrationPageTest extends BaseClass {

	String userFirstname=randomStringGenerate();
	String userLastname=randomStringGenerate();
	String editEmailId="change"+randomeNum()+"@mailinator.com";

	
	@Test(priority=1)
	public void verifyCompanyAdministrationRFPOwnerCanMakeModificationToTheTemplate()
	{
		testStepsLog("Step " + (stepCount++)," Perform login");
		loginValid();
		testStepsLog("Step " + (stepCount++)," Click on Administartion link.");
		adminstrationPage.clickOnAdmnitrationLink();
		logger.info("Click on Administration Link");
		testStepsLog("Step " + (stepCount++)," Click on Company tab.");
		adminstrationPage.clickOnCompanyTab();
		logger.info("Click on Company Tab");
		testStepsLog("Verification"," Verify 'RFP Owner can make modifications to the template that has been copied into their RFP' checkbox is available.");
		boolean sectionIntroductionApproved = adminstrationPage.verifyChecbox("RFP Owner can make modifications to the template that has been copied into their RFP");
		logger.info("Verify RFP Owner  check box is avilable or not");
		Assert.assertTrue(sectionIntroductionApproved, "'RFP Owner can make modifications to the template that has been copied into their RFP' checkbox is not available. ");
		logger.info(" RFP Owner  check box is avilable");
	}	
  @Test(priority=3)
	public void verifyKISCheckBoxIsAvailable()
	{
		testStepsLog("Verification"," Verify 'All users must use K.I.S Template.' checbox is available.");
		logger.info("Verify K.I.S Template.  check box is avilable or not");
		boolean sectionIntroductionApproved = adminstrationPage.verifyKISChecbox("All users must use K.I.S Template.");
		Assert.assertTrue(sectionIntroductionApproved, "'All users must use K.I.S Template.' checbox is not available. ");
		logger.info("Verify K.I.S Template.  check box is avilable.");

	}
	@Test(priority=4)
	public void editCompanyProfile()
	{	
		testStepsLog("Verification"," Verify 'Edit Company Profile' button is available.");
		boolean sectionIntroductionApproved = adminstrationPage.verifyEditCompanyProfileBtn();
		Assert.assertTrue(sectionIntroductionApproved, "'Edit Company Profile' button is not available. ");
		adminstrationPage.clickOnEditProfile();
		logger.info("Edit Comapny Profile button is available");
		testStepsLog("Step " + (stepCount++)," Edit phone number.");
		adminstrationPage.editPhoneNumber("122424");
        logger.info("Emter Alter Phone Number");
		//testStepsLog("Step " + (stepCount++)," Click on Save button.");
		//adminstrationPage.clickSavebutton();
		testStepsLog("Verification"," Verify success message 'Account information edited successfully.' displayed.");
		Boolean reportIsGenerated = adminstrationPage.verifyErrorMessage("Account information edited successfully.");
		Assert.assertTrue(reportIsGenerated, "Success message for account information updated is not displaying.");
		logger.info("Account information edited successfully.");
	}
	
	@Test(priority=5)
	public void createNewUser()
	{
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
		waitForPageLoaded();
		logger.info("Click on 'Users' tab");
		testStepsLog("Verification"," Verify created user details displayed successfully or not.");
		pause(5);
		boolean userDetails =adminstrationPage.verifyUser(userFirstname,userLastname,userFirstname+"@mailinator.com","RFP Owner");
		Assert.assertTrue(userDetails, "Created user details is not displayed.");
		logger.info("Created user details is displayed");

	}	
	
	@Test(priority=6)
	public void removeValueFromFirstNameAndVarifySaveButtonIsDisabled() throws IOException
	{
		testStepsLog("Step " + (stepCount++)," Remove Value from the \"FirstName\" and verify Save button is disabled" );
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		//testStepsLog("Verification"," Verify edit and delete button present or not.");
	//	boolean editandDeleteButton = adminstrationPage.verifyEditAndDeleteBtn();
		//logger.info("Edit and delete button is displayes");
		 adminstrationPage.clickOnEditTab();
		 logger.info("Click on Edit button");
		 adminstrationPage.removeFirstNameValue();
		 boolean status = adminstrationPage.verifySaveButtonDisabled();
		 log("Status of Save Button is" + status);
		 if(status)
			{
				Assert.assertTrue(true);
				logger.info("Verify Save  Button Disabled test passed");
				adminstrationPage.clickOnCancelButton();
				logger.info("Click on Cancel Button ");
			}
			else {
			add_screenShot("verifySaveButtonDisabled");
			Assert.assertTrue(false);
			logger.info("Verify Save Button Disabled test Failed");
			}
	}
	
	@Test(priority=7)
	public void removeValueFromLastNameAndVarifySaveButtonIsDisabled() throws IOException
	{
		testStepsLog("Step " + (stepCount++)," Remove Value from the \"LastName\" and verify Save button is disabled" );
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
	//	boolean editandDeleteButton = adminstrationPage.verifyEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		 adminstrationPage.clickOnEditTab();
		 logger.info("Click on Edit button");
		 adminstrationPage.removeLastNameValue();
		 boolean status = adminstrationPage.verifySaveButtonDisabled();
		 log("Status of Save Button is" + status);
		 if(status)
			{
				Assert.assertTrue(true);
				logger.info("Verify Save  Button Disabled test passed");
				adminstrationPage.clickOnCancelButton();
				logger.info("Click on Cancel Button ");
			}
			else {
			add_screenShot("verifySaveButtonDisabled");
			Assert.assertTrue(false);
			logger.info("Verify Save Button Disabled test Failed");
			}
	}
	
	@Test(priority=8)
	public void removeValueFromEmailAndVarifySaveButtonIsDisabled() throws IOException
	{
		testStepsLog("Step " + (stepCount++)," Remove Value from the \"Email\" and verify Save button is disabled" );
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
	//	boolean editandDeleteButton = adminstrationPage.verifyEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		 adminstrationPage.clickOnEditTab();
		 logger.info("Click on Edit button");
		 adminstrationPage.removeEmail();
		 boolean status = adminstrationPage.verifySaveButtonDisabled();
		 log("Status of Save Button is" + status);
		 if(status)
			{
				Assert.assertTrue(true);
				logger.info("Verify Save  Button Disabled test passed");
				adminstrationPage.clickOnCancelButton();
				logger.info("Click on Cancel Button ");
			}
			else {
			add_screenShot("verifySaveButtonDisabled");
			Assert.assertTrue(false);
			logger.info("Verify Save Button Disabled test Failed");
			}
	}
	
	@Test(priority=9)
	public void removeValueFromTitleAndVarifySaveButtonIsDisabled() throws IOException
	{
		testStepsLog("Step " + (stepCount++)," Remove Value from the \"Email\" and verify Save button is disabled" );
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
	//	boolean editandDeleteButton = adminstrationPage.verifyEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		 adminstrationPage.clickOnEditTab();
		 logger.info("Click on Edit button");
		 adminstrationPage.clearTitle();
		 boolean status = adminstrationPage.verifySaveButtonDisabled();
		 log("Status of Save Button is" + status);
		 if(status)
			{
				Assert.assertTrue(true);
				logger.info("Verify Save  Button Disabled test passed");
				adminstrationPage.clickOnCancelButton();
				logger.info("Click on Cancel Button ");
			}
			else {
			add_screenShot("verifySaveButtonDisabled");
			Assert.assertTrue(false);
			logger.info("Verify Save Button Disabled test Failed");
			}
	}
	
	
	 //  @Test(priority=10)
		public void editUser()
		{
		testStepsLog("Step " + (stepCount++)," Click on 3 dots at users name.");
		adminstrationPage.clickOnDots();
		logger.info("Click on three dots");
		testStepsLog("Verification"," Verify edit and delete button present or not.");
		boolean editandDeleteButton = adminstrationPage.verifyEditAndDeleteBtn();
		logger.info("Edit and delete button is displayes");
		Assert.assertTrue(editandDeleteButton, "Edit and delete button not present.");
		
		testStepsLog("Step " + (stepCount++)," Click on Edit tab.");
		 adminstrationPage.clickOnEditTab();
		 logger.info("Click on Edit button");
		
		testStepsLog("Step " + (stepCount++)," Change Name and click on Save Button");
		String editName=randomStringGenerate();
		adminstrationPage.editFirstName(editName);
		log("Changed Name :-"+editName);
		
		testStepsLog("Verification"," Verify created user details displayed successfully or not.");
		boolean Flag = adminstrationPage.verifyEditEmail(editName);
		Assert.assertTrue(Flag, "Email is not changed after edit user.");
		}	
		/*
		 * @Test(priority=11) public void deleteUser() { testStepsLog("Step " +
		 * (stepCount++)," Click on 3 dots at users name.");
		 * adminstrationPage.clickOnDots(); logger.info("Click on Three dots");
		 * testStepsLog("Step " + (stepCount++)," Click on DELETE tab.");
		 * adminstrationPage.clickDeletetab(); logger.info("Click on Delete tab");
		 * testStepsLog("Step " + (stepCount++)," Click on YES button of alert box.");
		 * alertHelper.isAlertPresent(); adminstrationPage.clickYesButtonOfAlert();
		 * logger.info("Click on yes"); testStepsLog("Step " +
		 * (stepCount++)," Verify Edited user details are Removed successfully or not."
		 * ); boolean Flag1 =
		 * adminstrationPage.verifyEditUser(userFirstname,userLastname,
		 * editEmailId,"RFP Owner"); Assert.assertTrue(Flag1,
		 * "Edited user details are not Removed.");
		 * System.out.println("flag value"+Flag1);
		 * logger.info("Select association user"); testStepsLog("Step " +
		 * (stepCount++)," Click on user association.");
		 * adminstrationPage.clickOnUseAssocialtion();
		 * logger.info("Select Associated User"); testStepsLog("Step " +
		 * (stepCount++)," Click on Assign Button"); adminstrationPage.clickOnAssign();
		 * logger.info("Click on Assign"); testStepsLog("Step " +
		 * (stepCount++)," Click on YES button of alert box.");
		 * adminstrationPage.clickYesButtonOfAlert(); logger.info("click on Yes");
		 * pause(2); testStepsLog("Step " +
		 * (stepCount++)," Verify validation message"); boolean errorMessage =
		 * adminstrationPage.
		 * verifyErrorMessage("The record has been deleted successfully.");
		 * Assert.assertTrue(errorMessage, "Error message not displayed");
		 * logger.info("Delete User"); }
		 */


		

}
