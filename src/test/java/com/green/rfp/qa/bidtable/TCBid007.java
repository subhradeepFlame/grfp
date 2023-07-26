package com.green.rfp.qa.bidtable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class TCBid007 extends BaseClass {

	@Test
	public void CheckBidtableFlow() {
		String rfpName = getCurrentTimeStampString();
		System.out.println(rfpName);
		String prchaserColumneName1 = "name";
		String prchaserColumneName2 = "unit";
		String Vendorcolumnname1 = "price";
		String Vendorcolumnname2 = "item type";
		String calculatedColumn = "double price";
		String containerName1 = "container 1";
		String containerName2 = "container 2";
		String bidtableName1 = "bid1";
		String vendorColumnDropdownOptionName = "type";

		testStepsLog("Step " + (stepCount++), " Login as customer admin");
		superAdminloginValid();
		loginAsFor("Customer Admin");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on RFP link.");
		dashboardVerificationPage = dashboardIndexPage.clickOnRFPLeftLink();

		testStepsLog("Step " + (stepCount++), " Click on create button.");
		rfpVerificationPage = rfpIndexPage.clickOnCreateButton();

		testStepsLog("Step " + (stepCount++), " Select RFP Type to create.");
		Boolean isRFPTypeSelected = rfpIndexPage.selectRFPType(stepCount, "Scratch");
		Assert.assertTrue(isRFPTypeSelected, "RFP type is not selected.");

		testStepsLog("Step " + (stepCount++), " Create RFP - Summary");
		rfpVerificationPage = rfpIndexPage.fillRFPSummaryWithCurrentDate(stepCount, "Scratch", rfpName);
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");
		testStepsLog("Step " + (stepCount++), "Select pricing = Line item Pricing");
		rfpIndexPage.selectRFPPricingType("Bidtable");
		pause(2);
		testStepsLog("Step " + (stepCount++), "Create 1st bidtable");
		bidTablePage.createNewBidtable(bidtableName1, true);
		pause(5);
		testStepsLog("Step " + (stepCount++), "Click on the view icon of 1st bidtable");
		bidTablePage.clickOnBidtableViewIconRfpOwner("bid1");
		testStepsLog("Step " + (stepCount++), "Add 1st container");
		bidTablePage.addContainer(containerName1);
		testStepsLog("Step " + (stepCount++), "Add 2nd container");
		bidTablePage.addContainer(containerName2);
		testStepsLog("Step " + (stepCount++), "Add 1st purchaser column with text format");
		bidTablePage.addPurchaserColumn(prchaserColumneName1, "Text", false);
		testStepsLog("Step " + (stepCount++), "Add 2nd purchaser column with number format");
		bidTablePage.addPurchaserColumn(prchaserColumneName2, "Number", false);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with number format");
		bidTablePage.addVendorColumn(Vendorcolumnname1, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with dropdown format");
		bidTablePage.addVendorColumn(Vendorcolumnname2, "Dropdown", "type", 3);
		testStepsLog("Step " + (stepCount++), "Add calculated column");
		bidTablePage.addCalculatedColumn(calculatedColumn, false);
		testStepsLog("Step " + (stepCount++), "Update Extended cost column formula");
		bidTablePage.updateFormulaForExtendedColumn("Extended Cost", prchaserColumneName2, Vendorcolumnname1);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Update added calculated column formula");
		bidTablePage.updateFormulaForExtendedColumnWithMultiply(calculatedColumn, Vendorcolumnname1, 2);
		testStepsLog("Step " + (stepCount++), "Add 3 items to container 1");
		for (int i = 1; i <= 3; i++) {
			bidTablePage.addItemWith2PurchaserColumn(containerName1, " item " + i, prchaserColumneName1,
					prchaserColumneName2);
		}
		testStepsLog("Step " + (stepCount++), "Add 1 item to container 2");
		for (int i = 4; i < 5; i++) {
			bidTablePage.addItemWith2PurchaserColumn(containerName2, " item " + i, prchaserColumneName1,
					prchaserColumneName2);
		}

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Sections");
		waitForPageLoaded();
		pause(5);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		waitForPageLoaded();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Add 1 question to the section");
		String section1 = "Introduction";
		String q1 = section1 + " section question 1";
		String answerType = "newQuestion";
		String questionWeight = "Medium";
		createQuestion(answerType, questionWeight, section1, q1);

		testStepsLog("Step " + (stepCount++), " Click on continue button on Needs page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveQuestions");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("gotoAprrovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on skip approval checkbox");
		pause(3);
		driver.findElement(By.xpath("//div[@class='layout-column']//md-checkbox[@aria-label='Skip Approvals']"))
				.click();
		pause(3);

		testStepsLog("Step " + (stepCount++), " Click on continue button on Approvers page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveApprovers");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");

		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 3");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender12@mailinator.com");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 1");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("vendor1@vendor.com");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Send RFP to Vendors");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Login as vendor 3");
		closingSession();
		loginAsFor("Vendor3");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Answer the questions");
		rfpIndexPage.answeraquestion(q1, section1);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Scroll to the bidtable");
		scrollToElement(driver.findElement(By.xpath("//td[text()='bid1']")));
		testStepsLog("Step " + (stepCount++), "Click on the view icon of the bidtable");
		bidTablePage.clickOnBidtableViewIconVendor(bidtableName1);
		testStepsLog("Step " + (stepCount++), "Expand 2nd container");
		bidTablePage.expandContainer("01");

		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponceHigh(containerName1, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponceHigh(containerName2, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName1, "item " + i, vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName2, "item " + i, vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		bidTablePage.clickOnVendorResponceBidtableSaveButton();
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		bidTablePage.clickOnContinueButtonOnPricingTab();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");
		pause(3);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		testStepsLog("Step " + (stepCount++), " Login as vendor 2");
		closingSession();
		loginAsFor("Vendor2");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Answer the questions");
		rfpIndexPage.answeraquestion(q1, section1);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Scroll to the bidtable");
		scrollToElement(driver.findElement(By.xpath("//td[text()='bid1']")));
		testStepsLog("Step " + (stepCount++), "Click on the view icon of the bidtable");
		bidTablePage.clickOnBidtableViewIconVendor(bidtableName1);
		testStepsLog("Step " + (stepCount++), "Expand 2nd container");
		bidTablePage.expandContainer("01");

		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName1, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName2, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName1, "item " + i, vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName2, "item " + i, vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		bidTablePage.clickOnVendorResponceBidtableSaveButton();
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		bidTablePage.clickOnContinueButtonOnPricingTab();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");
		pause(3);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		testStepsLog("Step " + (stepCount++), " Login as vendor 1");
		closingSession();
		loginAsFor("Vendor1");
		testStepsLog("Step " + (stepCount++), " Scroll till pending task list.");
		templateVerificationPage = templateIndexPage.scrollTillPendingTaskList();
		testStepsLog("Step " + (stepCount++), " Click on Accept from pending task list button.");
		rfpVerificationPage = rfpIndexPage.selectVendorAcceptBtnFromDashboard(rfpName, "Introduction");
		testStepsLog("Step " + (stepCount++), " Click on yes button for accepting the task.");
		templateVerificationPage = templateIndexPage.clickOnYesButton();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on RFP preview tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vendorRfpModifyStep");
		testStepsLog("Step " + (stepCount++), " Answer the questions");
		rfpIndexPage.answeraquestion(q1, section1);
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on add RFP helper page");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoComapny");
		testStepsLog("Step " + (stepCount++), " Add Company information details.");
		rfpVerificationPage = rfpIndexPage.enterCompanyDetails("company1234", "companytitle1234", "252356345",
				"company1234@gmail.com", "Company1234Description");
		testStepsLog("Step " + (stepCount++), " Click on continue button on 'Company info' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("vm.saveCompanyInfo(true)");
		testStepsLog("Step " + (stepCount++), " Scroll to the bidtable");
		scrollToElement(driver.findElement(By.xpath("//td[text()='bid1']")));
		testStepsLog("Step " + (stepCount++), "Click on the view icon of the bidtable");
		bidTablePage.clickOnBidtableViewIconVendor(bidtableName1);
		testStepsLog("Step " + (stepCount++), "Expand 2nd container");
		bidTablePage.expandContainer("01");

		testStepsLog("Step " + (stepCount++), "Click on additional responce of container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.clickOnAdditionalResponse(containerName1, "item " + i);
		}

		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName1, "item " + i);
			bidTablePage.addNumericAdditionalVendorResponce(containerName1, "item " + i, "2");
		}
		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName2, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName1, "item " + i, vendorColumnDropdownOptionName);
			bidTablePage.addAdditionalDropdownVendorResponce(containerName1, "item " + i,
					vendorColumnDropdownOptionName, "2");
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 2 items");
		for (int i = 4; i < 5; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName2, "item " + i, vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Add note for container 1 items");
		for (int i = 1; i < 3; i++) {
			bidTablePage.addNoteForItem(containerName1, "item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Click on save button");
		bidTablePage.clickOnVendorResponceBidtableSaveButton();
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on pricing tab");
		bidTablePage.clickOnContinueButtonOnPricingTab();
		testStepsLog("Step " + (stepCount++), " Click on continue button on review tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorAprrovers");
		pause(3);
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Click the checkbox to skip approver.");
		templateVerificationPage = templateIndexPage.clickSkipApproverCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Save' button on 'Approvers' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("saveApprovers");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on 'Last Look' bubble tab.");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("gotoVendorSendStep");
		testStepsLog("Step " + (stepCount++), " Click on 'Send Response' button on 'Send' bubble tab.");
		rfpVerificationPage = rfpIndexPage.clickOnSendResponseButton();

		try {
			com.green.rfp.qa.utility.XLUtils.setCellData(datafile, "testdata", rfpName, 1, 1);
			LocalDate dateObj = LocalDate.now();
			DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			com.green.rfp.qa.utility.XLUtils.setCellData(datafile, "testdata", dateObj.format(sdf), 1, 2);
			com.green.rfp.qa.utility.XLUtils.setCellData(datafile, "testdata", "1", 1, 3);
		} catch (Exception e) {
			System.out.println("File not updated");
			e.printStackTrace();
		}
	}
}
