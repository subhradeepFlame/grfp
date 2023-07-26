package com.green.rfp.qa.template.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.XLUtils;

public class TemplatePulling extends BaseClass {

	String templateName = "TemplatePulling" + getCurrentTimeStampString();
	int numOfFailure = 0;
	String answerType = "freeForm";
	String question = "Introduction section question 1";
	String questionWeight = "Medium";
	String section = "Introduction";
	String[] percentage = { "17%", "67%", "75%", "100%" };
	@FindBy(xpath = "//*[text()='PUBLISH']")
	WebElement temp_publish_btn;

	@Test(priority = 1)
	public void templatePullingAndVerifyTimeZone() throws Exception {
		String path = System.getProperty("user.dir") + "/src/main/java/com/green/rfp/qa/testdata/TamplatePulling.xlsx";
		XLUtils.setCellData(path, "KIS", templateName, 1, 0);

		superAdminloginValid();

		loginAsFor("Customer Admin");

		testStepsLog("Step " + (stepCount++), " Click on Template link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnTemplateLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		templateVerificationPage = templateIndexPage.clickOnCreateButton();

		System.out.println(templateName);
		testStepsLog("Step " + (stepCount++), " Enter name=" + templateName);
		templateVerificationPage = templateIndexPage.enterName(templateName);

		testStepsLog("Step " + (stepCount++), " Enter description.");
		templateVerificationPage = templateIndexPage.enterDescription();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Introduction");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		testStepsLog("Step " + (stepCount++), " Enter section name.");
		templateVerificationPage = templateIndexPage.enterSectionName("Objectives");

		testStepsLog("Step " + (stepCount++), " Click on plus button.");
		templateVerificationPage = templateIndexPage.clickOnPlusButtonInSections();

		// Verification of edit and delete icon
		Boolean isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Introduction");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Introduction' section.");

		isEditIconsForSectionsVerified = templateVerificationPage
				.verifyEditAndDeleteIconForContentSection("Objectives");
		Assert.assertTrue(isEditIconsForSectionsVerified,
				"Edit and Delete icons are not available for 'Objectives' section.");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSections");

		testStepsLog("Step " + (stepCount++), " Click on continue button.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveSelfSme");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoAprrovers");

		testStepsLog("Step " + (stepCount++), " Click on 'Skip Approval' checkbox.");
		templateVerificationPage = templateIndexPage.clickSkipApprovalTemplate();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");

		testStepsLog("Step " + (stepCount++), " Click template publish button.");
		templateVerificationPage = templateIndexPage.clickTemplatePublishButton();

		String pathRfp = System.getProperty("user.dir")
				+ "/src/main/java/com/green/rfp/qa/testdata/TamplatePulling.xlsx";
		String rfpName = XLUtils.getCellValue(pathRfp, "KIS", 1, 0);

		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();
		logger.info("Click on RFP");

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();
		logger.info("Clicked on Create button");
		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		// rfpVerificationPage = rfpIndexPage.selectRFPType(stepCount,"KIS");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "CompanyTemplate");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");
		logger.info("Verifiyed RFP type is selected");

		testStepsLog("Step " + (stepCount++), " Select RFP=" + rfpName);
		rfpVerificationPage = rfpIndexPage.selectTemplateRfp(rfpName);
		logger.info("Select RFP ");

		testStepsLog("Step " + (stepCount++), " Click on yes button.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();

		scrollToElement(driver.findElement(By.xpath("//button[contains(text(),'Continue')]")));

		pause(20);

		System.out.println("Done Template pulling");

	}

}
