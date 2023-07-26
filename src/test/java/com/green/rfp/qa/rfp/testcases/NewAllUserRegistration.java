package com.green.rfp.qa.rfp.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.TestUtil;

public class NewAllUserRegistration extends BaseClass {

	TestUtil testutil = new TestUtil();
	int numOfFailure = 0;

	String exceptedUrl = "https://" + env + ".thegreenrfp.com/myaccount/dashboard";

	@Test(priority = 1)
	public void login() {
		testCaselog("RFP POC");
		testStepsLog("Step " + (stepCount++), " Perform login");
		superAdminloginValid();
		logger.info("Valid Login");
		logOut();

	}

	@Test(priority = 2)
	public void addRfpUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using RFP User.");
		pause(2);

		driver.get(baseURl);
		pause(4);
		loginPage.enterEmail("qanarolarfp1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
		System.out.println("Rfp User Added");
		logOut();
	}

	@Test(priority = 3)
	public void addApprover() {
		testStepsLog("Step " + (stepCount++), " Perform login using Approver User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolaapprover1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
		System.out.println("Rfp User Added");
		logOut();
		System.out.println("Approver User Added");
	}

	@Test(priority = 4)
	public void addSmeUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using SME User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolasme1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
		System.out.println("Rfp User Added");
		logOut();

		System.out.println("Sme User Added");
	}

	@Test(priority = 5)
	public void addVendorUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using Vendor User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolavender1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
		System.out.println("Rfp User Added");
		logOut();

		System.out.println("Vendor User Added");
	}

	@Test(priority = 6)
	public void addAdminUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using Admin User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("super@thegreenrfp.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Dev@1234");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");

		logOut();

		System.out.println("Admin User Added");
	}

	@Test(priority = 7)
	public void addEvaluatorUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using Evalutor User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolarfp2@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");
		logOut();

		System.out.println("Evaluator User Added");
	}

	@Test(priority = 8)
	public void addVendorApproverUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using Vendor Approver User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolav1approver1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");

		logOut();

		System.out.println("Vendor User User Added");
	}

	@Test(priority = 9)
	public void addCustomerApproverUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using  Approver User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolaapprover1@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");

		logOut();

		System.out.println("Customer User User Added");
	}

	@Test(priority = 10)
	public void rfpApproverApproverUser() {
		testStepsLog("Step " + (stepCount++), " Perform login using  Approver User.");
		pause(2);
		pause(4);
		loginPage.enterEmail("qanarolaapprover3@mailinator.com");
		logger.info("Entred Valid Username");
		loginPage.clickOnArrow();
		logger.info("Click On Arrow");
		loginPage.enterPassword("Password123#");
		logger.info("Enter valid password");
		pause(2);
		loginPage.clickOnLogin();
		logger.info("Click on Login");
		pause(5);
		Assert.assertEquals(driver.getCurrentUrl(), exceptedUrl, "After login Url Not matched ");
		logger.info("Login test passed");

		logOut();

		System.out.println("RFP User User Added");
	}

	public void allUserRegistration(String user) {

		String userFirstname = randomStringGenerate();
		String userLastname = randomStringGenerate();

		testStepsLog("Step " + (stepCount++), " Click on Administartion link.");
		rfpVerificationPage = rfpIndexPage.clickOnAdministartionLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on 'Users' tab.");
		rfpVerificationPage = rfpIndexPage.clickOnUsersTab();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on 'Create' button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreatebtn();

		testStepsLog("Step " + (stepCount++), " Enter user details.");
		rfpVerificationPage = rfpIndexPage.enterUserdetails(userFirstname, userLastname,
				(userFirstname + "@mailinator.com"), user, "title");
		pause(8);
		testStepsLog("Step " + (stepCount++), " Logout from the user.");
		// rfpVerificationPage = rfpIndexPage.Logout("Super1 Admin");
		logOut();
		pause(10);
		driver.get(inboxLink + userFirstname + "#/#inboxpane");

		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on mail to set password for the account.");
		rfpVerificationPage = rfpIndexPage.clickOnMail();

		testStepsLog("Step " + (stepCount++), " Click on Set password button.");
		rfpVerificationPage = rfpIndexPage.clickOnSetPasswordBtn();

		SwitchtoTab(1);
		testStepsLog("Step " + (stepCount++), " Set Password.");
		rfpVerificationPage = rfpIndexPage.setPassword();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Enter title and phone number.");
		rfpVerificationPage = rfpIndexPage.enterPhone("1234517538");

		pause(5);
		testStepsLog("Step " + (stepCount++), " Logout from the user.");

		logOut();
		testStepsLog("Step " + (stepCount++), " Perform login with valid credentials payment.");
		pause(5);
		superAdminloginValid();
		loginAs(getCompanyName("Customer Admin"), userFirstname + " " + userLastname);

		closingSession();

	}

	// @DataProvider
	public Object[] getData() {
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		Object[] data = new Object[6];

		// 1st row
		data[0] = "Customer Approver";
		data[1] = "Customer SME";

		// 2nd row
		data[2] = "Developer";
		data[3] = "Evaluator";

		// 3rd row
		data[4] = "GRFP Admin";
		data[5] = "GRFP Support Engineer";

		return data;
	}

}
