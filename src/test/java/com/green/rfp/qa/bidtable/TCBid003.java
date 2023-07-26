package com.green.rfp.qa.bidtable;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.green.rfp.qa.base.BaseClass;
import com.green.rfp.qa.utility.csvHelper;
import com.opencsv.exceptions.CsvValidationException;

public class TCBid003 extends BaseClass {

	@Test
	public void checkVendorBidtableSubmissionFlow() throws CsvValidationException, IOException {
		String rfpName = getCurrentTimeStampString();
		String bidtableName1 = "bid1";
		String containerName1 = "container 1";
		String containerName2 = "container 2";
		String prchaserColumneName1 = "Item name";
		String prchaserColumneName2 = "unit";
		String prchaserColumneName3 = "Item size";
		String Vendorcolumnname1 = "price";
		String Vendorcolumnname2 = "item type";
		String calculatedColumn = "double price";
		String vendorColumnDropdownOptionName = "type";
		String answerType = "freeForm";
		String questionWeight = "Medium";

		testStepsLog("Step " + (stepCount++), "Clear download folder");
		csvHelper.deleteDownloadedFiles();

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
		rfpVerificationPage = rfpIndexPage.fillRFPSummary(stepCount, "Scratch", rfpName);
		testStepsLog("Step " + (stepCount++), "Select pricing = Line item Pricing");
		rfpIndexPage.selectRFPPricingType("Bidtable");
		pause(2);
		testStepsLog("Step " + (stepCount++), "Create 1st bidtable with allow no bids functionality");
		bidTablePage.createNewBidtable(bidtableName1, true);
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
		testStepsLog("Step " + (stepCount++),
				"Add 3rd purchaser column with text format as hidden from vendor option selected");
		bidTablePage.addPurchaserColumn(prchaserColumneName3, "Number", true);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with number format");
		bidTablePage.addVendorColumn(Vendorcolumnname1, "Number", "", 1);
		testStepsLog("Step " + (stepCount++), "Add Vendor column with dropdown format");
		bidTablePage.addVendorColumn(Vendorcolumnname2, "Dropdown", vendorColumnDropdownOptionName, 3);
		testStepsLog("Step " + (stepCount++), "Add 2nd calculated column with hidden from vendor checkbox selected");
		bidTablePage.addCalculatedColumn(calculatedColumn, true);
		testStepsLog("Step " + (stepCount++), "Update Extended cost column formula");
		bidTablePage.updateFormulaForExtendedColumn("Extended Cost", prchaserColumneName2, Vendorcolumnname1);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Update added calculated column formula");
		bidTablePage.updateFormulaForExtendedColumnWithMultiply(calculatedColumn, Vendorcolumnname1, 2);
		pause(3);
		testStepsLog("Step " + (stepCount++), "Add 3 items to container 1");
		for (int i = 1; i <= 3; i++) {
			bidTablePage.addItemWith3PurchaserColumn(containerName1, containerName1 + " item " + i,
					prchaserColumneName1, prchaserColumneName2, prchaserColumneName3);
		}
		testStepsLog("Step " + (stepCount++), "Add 2 items to container 2");
		for (int i = 1; i <= 2; i++) {
			bidTablePage.addItemWith3PurchaserColumn(containerName2, containerName2 + " item " + i,
					prchaserColumneName1, prchaserColumneName2, prchaserColumneName3);
		}
		testStepsLog("Step " + (stepCount++), "Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), "Click on Section tab");
		dashboardIndexPage.clickOnRFPTemplateTab("Sections");
		waitForPageLoaded();
		testStepsLog("Step " + (stepCount++), " Create RFP - Sections");
		rfpVerificationPage = rfpIndexPage.createSection(stepCount, "Introduction");

		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button");
		rfpIndexPage.clickOnContinueButton("Sections");
		waitForPageLoaded();
		pause(3);
		testStepsLog("Step " + (stepCount++), " Click on continue button on sme page");
		rfpVerificationPage = rfpIndexPage.clickOnContinueButtonOnSMETab("saveSelfSme");
		testStepsLog("Step " + (stepCount++), " Click on help my sme button.");

		String section1 = "Introduction";
		String q1 = section1 + " section question 1";
		String q2 = section1 + " section question 2";

		createQuestion(answerType, questionWeight, section1, q1);
		createQuestion(answerType, questionWeight, section1, q2);
		pause(3);
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
		testStepsLog("Step " + (stepCount++), " Click on 'Skip Evaluators' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickSkipEvaluatorsCheckbox();
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Evaluators tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("Evaluators");
		testStepsLog("Step " + (stepCount++), " Click on 'Continue' button on Approver tab");
		templateVerificationPage = templateIndexPage.clickOnContinueButton("publish");
		testStepsLog("Step " + (stepCount++), " Add RFP Vendor 2.");
		rfpVerificationPage = rfpIndexPage.addRFPVendor("qanarolavender11@mailinator.com");
		waitForPageLoaded();

		testStepsLog("Step " + (stepCount++), " Send RFP to Vendors");
		rfpVerificationPage = rfpIndexPage.clickRFPVendorSendBtn("saveVendors");
		waitForPageLoaded();

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
		testStepsLog("Step " + (stepCount++), " Answer the questions");
		rfpIndexPage.answeraquestion(q2, section1);

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
		testStepsLog("Step " + (stepCount++), "Verify that hidden purchaser column not showing");
		try {
			PresenceOfElement(By.xpath("//div[text()='" + prchaserColumneName3 + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that hidden purchaser column is not showing");
		}
		testStepsLog("Step " + (stepCount++), "Verify that hidden calculated column not showing");
		try {
			PresenceOfElement(By.xpath("//div[text()='" + calculatedColumn + "']"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("Verified that hidden calculated column is not showing");
		}

		testStepsLog("Step " + (stepCount++), "Click on additional responce of 1st 2 items of container 1");
		for (int i = 1; i < 3; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.clickOnAdditionalResponse(containerName1, containerName1 + " item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Delete 2nd item additional responce");
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
		bidTablePage.deleteAdditionalResponse(containerName1, containerName1 + " item 2");
		testStepsLog("Step " + (stepCount++), "Click on no bid for 1st container 1st item");
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
		bidTablePage.clickOnNoBid(containerName1, containerName1 + " item 1");
		testStepsLog("Step " + (stepCount++), "Verify that user can't bid for the item");
		try {
			PresenceOfElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName1
					+ "')]//text()[2]/../../following-sibling::tr//p[text()='container 1 item 1']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"));
			Assert.fail();
		} catch (Exception e) {
			testVerifyLog("User can't bid for that specific item");
		}
		testStepsLog("Step " + (stepCount++), "Click on Clear No Bid for that item");
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
		bidTablePage.clickOnClearNoBid(containerName1, containerName1 + " item 1");
		testStepsLog("Step " + (stepCount++), "Verify that user can now bid for the item");
		try {
			PresenceOfElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName1
					+ "')]//text()[2]/../../following-sibling::tr//p[text()='container 1 item 1']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"));
			testVerifyLog("User can bid for that specific item");
		} catch (Exception e) {
			Assert.fail();
		}
		testStepsLog("Step " + (stepCount++), "Select 1st container all items");
		bidTablePage.SelectContainerCheckbox("00");
		testStepsLog("Step " + (stepCount++), "Click on No Bid button");
		bidTablePage.clickOnBulkNoBidButton();
		testStepsLog("Step " + (stepCount++), "Verify that user can't bid for the container 1 items");
		for (int i = 1; i < 4; i++) {
			try {
				PresenceOfElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName1
						+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + containerName1 + " item " + i
						+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"));
				Assert.fail();
			} catch (Exception e) {
				testVerifyLog("User can't bid for container 1 items");
			}
		}
		testStepsLog("Step " + (stepCount++), "Select 1st container all items");
		bidTablePage.SelectContainerCheckbox("00");
		testStepsLog("Step " + (stepCount++), "Click on Clear No Bid button");
		bidTablePage.clickOnBulkClearNoBidButton();
		testStepsLog("Step " + (stepCount++), "Verify that user can now bid for container 1 items");
		for (int i = 1; i < 4; i++) {
			try {
				PresenceOfElement(By.xpath("//table/tbody/tr/td[contains(.,'" + containerName1
						+ "')]//text()[2]/../../following-sibling::tr//p[text()='" + containerName1 + " item " + i
						+ "']/../following-sibling::td//input[contains(@ng-model,'vm.items')]"));
				testVerifyLog("User can bid for container 1 items");
			} catch (Exception e) {
				Assert.fail();
			}
		}
		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName1, containerName1 + " item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup numeric values for all container 2 items");
		for (int i = 1; i < 3; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addNumericVendorResponce(containerName2, containerName2 + " item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 1 items");
		for (int i = 1; i < 4; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName1, containerName1 + " item " + i,
					vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Fillup all dropdown values for container 2 items");
		for (int i = 1; i < 3; i++) {
			scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'bid1 listing here')]")));
			bidTablePage.addDropdownVendorResponce(containerName2, containerName2 + " item " + i,
					vendorColumnDropdownOptionName);
		}
		testStepsLog("Step " + (stepCount++), "Add note for container 1 items");
		for (int i = 1; i < 3; i++) {
			bidTablePage.addNoteForItem(containerName1, containerName1 + " item " + i);
		}
		testStepsLog("Step " + (stepCount++), "Edit note for container 1 item 1");
		bidTablePage.editNoteForItem(containerName1, containerName1 + " item 1");
		testStepsLog("Step " + (stepCount++), "Click on save button");
		bidTablePage.clickOnVendorResponceBidtableSaveButton();
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

	}

}
